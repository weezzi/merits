package com.merits.modules.base.backoffice.forms;

import java.sql.Timestamp;
import com.merits.core.MeritsUtils;
import com.merits.modules.base.backoffice.forms.definitions.TopupUserFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.BulkOrganizationsDAO;
import com.merits.modules.base.dao.OrganizationsDAO;
import com.merits.modules.base.dao.VolunteersDAO;
import com.merits.modules.base.dao.WalletRecordsGetBalanceSPQ;
import com.merits.modules.base.uobjects.enums.WalletOperation;
import com.merits.modules.base.uobjects.enums.WalletType;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.data.ListItem;
import com.weezzi.utils.extras.console.Console;


/**
 * <b>Title: </b> TopupUser Form<br/>
 * <b>Description: </b> TopupUser Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class TopupUserForm extends TopupUserFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		List list = new List();
		BulkOrganizationsDAO orgs = BaseContainer.getOrganizationsFindByAll();
		for(OrganizationsDAO org : orgs.data) {
			list.addItem(new ListItem(org.getName(), org.getId()));
		}
		organization.setValue(list);
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		float value;
		Long senderRecord = null;
		Long receiverRecord = null;
		WalletRecordsGetBalanceSPQ balance;
		Timestamp date = new Timestamp(System.currentTimeMillis());
		VolunteersDAO volunteer = BaseContainer.getVolunteer(parameters.getId());
		OrganizationsDAO org = BaseContainer.getOrganization(organization.getLongValue());
		// Check wallet balance
		balance = BaseContainer.getWalletRecordsFindByGetBalanceSPQ(org.getIdWallet());
		value = amount.getValueAsFloat();
		// Check if has balance
		if (balance.getBalance() < amount.getValueAsFloat()) {
			showErrorDialog("Not enough balance!");
			return;
		}
    	// Create record in volunteer wallet
    	try {
    		// Organization
			senderRecord = BaseContainer.createWalletRecord(
					org.getIdWallet(), 
					WalletType.Organization, 
					date, 
					WalletOperation.TransferSend, 
					-1*value, 
					volunteer.getIdWallet(), 
					WalletType.Volunteer, 
					MeritsUtils.getPersonName(volunteer));
			// Volunteer
			receiverRecord = BaseContainer.createWalletRecord(
					volunteer.getIdWallet(), 
					WalletType.Volunteer, 
					date, 
					WalletOperation.TransferReceive, 
					value, 
					org.getIdWallet(), 
					WalletType.Organization, 
					org.getName()
					);
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error creating organization transfer transaction", e);
			// Cancel all records
			try {
				//
				if (senderRecord != null) {
					BaseContainer.removeWalletRecord(senderRecord);
				}
				if (receiverRecord != null) {
					BaseContainer.removeWalletRecord(receiverRecord);
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
