package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.SecurityUtilities;
import com.merits.modules.base.backoffice.forms.definitions.AddShopFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.uobjects.enums.WalletType;


/**
 * <b>Title: </b> AddShop Form<br/>
 * <b>Description: </b> AddShop Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AddShopForm extends AddShopFormDefinition {


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
		long walletId = BaseContainer.createWallet(WalletType.Shop);
		// Create shop
		BaseContainer.createShop(
				walletId, 
				null, // City Id
				name.getValue(), 
				media.getImage(), 
				null, // location, 
				null, // ownerFirstName, 
				null, // ownerLastName, 
				null, // ownerMobile, 
				null, // ownerEmail, 
				null, // bankIban, 
				null, // bankSwift, 
				null, // Address
				null, // Notes
				shopUrl.getValue(), 
				shopPhone.getValue(), 
				shopEmail.getValue(),
				"en",
				ownerUsername.getValue(),
				SecurityUtilities.getMD5(ownerPassword.getValue()),
				getUpdateInfo());
		// Close dialog
		closeDialog();
		reloadTable();
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
