package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.extras.console.Console;
import java.sql.Timestamp;
import com.merits.core.MeritsUtils;
import com.merits.modules.base.backoffice.forms.definitions.RedeemShopFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.OrganizationsDAO;
import com.merits.modules.base.dao.ShopsDAO;
import com.merits.modules.base.dao.VolunteersDAO;
import com.merits.modules.base.dao.WalletRecordsGetBalanceSPQ;
import com.merits.modules.base.uobjects.enums.WalletOperation;
import com.merits.modules.base.uobjects.enums.WalletType;


/**
 * <b>Title: </b> RedeemShop Form<br/>
 * <b>Description: </b> RedeemShop Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class RedeemShopForm extends RedeemShopFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables

	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		float value;
		Long senderRecord = null;
		Long receiverRecord = null;
		Long redeemRecord = null;
		Long burnRecord = null;
		WalletRecordsGetBalanceSPQ balance;
		Timestamp date = new Timestamp(System.currentTimeMillis());
		ShopsDAO shop = BaseContainer.getShop(parameters.getId());
		// Check wallet balance
		balance = BaseContainer.getWalletRecordsFindByGetBalanceSPQ(shop.getIdWallet());
		value = amount.getValueAsFloat();
		// Check if has balance
		if (balance.getBalance() < amount.getValueAsFloat()) {
			showErrorDialog("Not enough balance!");
			return;
		}
    	// Create record in volunteer wallet
    	try {
    		// Shop - Transfer to master wallet
			senderRecord = BaseContainer.createWalletRecord(
					shop.getIdWallet(), 
					WalletType.Shop, 
					date, 
					WalletOperation.TransferSend, 
					-1*value, 
					MeritsUtils.getMasterWallet(), 
					WalletType.MasterWallet, 
					null);
			// Master wallet receive record
			receiverRecord = BaseContainer.createWalletRecord(
					MeritsUtils.getMasterWallet(), 
					WalletType.MasterWallet, 
					date, 
					WalletOperation.TransferReceive, 
					value, 
					shop.getIdWallet(), 
					WalletType.Shop, 
					shop.getName()
					);
			// Master wallet burn record
			burnRecord = BaseContainer.createWalletRecord(
					MeritsUtils.getMasterWallet(), 
					WalletType.MasterWallet, 
					date, 
					WalletOperation.Burned, 
					-1*value, 
					MeritsUtils.getMasterWallet(), 
					WalletType.MasterWallet, 
					null
					);
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error creating redeem transaction", e);
			// Cancel all records
			try {
				//
				if (senderRecord != null) {
					BaseContainer.removeWalletRecord(senderRecord);
				}
				if (receiverRecord != null) {
					BaseContainer.removeWalletRecord(receiverRecord);
				}
				if (burnRecord != null) {
					BaseContainer.removeWalletRecord(burnRecord);
				}
			} catch (Exception e1) {
				// Catch Exception
				Console.error("Error deleting records", e1);
			}
			// Send error 
		}
    	closeDialog();
    	reloadTable();
    	showInfoDialog("Transfer Sucessfull of " + String.format("%.2f", value));
		
	}


	// MULTI-LANGUAGE ---------------------------------------------------------

	
	/**
	 * 
	 */
	public void multiLanguageRequestHandler(String langCode, String previousLangCode, boolean savePrevious) throws Exception {
		// Local Variables
		
	}


	// ACTIONS ----------------------------------------------------------------



	// AUTO-COMPLETE ACTIONS --------------------------------------------------





}
