package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.SecurityUtilities;
import com.merits.modules.base.backoffice.forms.definitions.AddShopFormDefinition.OwnerUsernameField;
import com.merits.modules.base.backoffice.forms.definitions.EditShopFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.ShopsDAO;


/**
 * <b>Title: </b> EditShop Form<br/>
 * <b>Description: </b> EditShop Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class EditShopForm extends EditShopFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		long id = parameters.getId();
		ShopsDAO shop = BaseContainer.getShop(id);
		name.setValue(shop.getName());
		shopUrl.setValue(shop.getShopUrl());
		shopEmail.setValue(shop.getShopEmail());
		shopPhone.setValue(shop.getShopPhone());
		ownerFirstName.setValue(shop.getOwnerFirstName());
		ownerLastName.setValue(shop.getOwnerLastName());
		ownerEmail.setValue(shop.getOwnerEmail());
		media.setImage(shop.getPhoto());
		bankIban.setValue(shop.getBankIban());
		bankSwift.setValue(shop.getBankSwift());
		loginUsername.setValue(shop.getOwnerLogin());
		address.setValue(shop.getAddress());
		notes.setValue(shop.getNotes());
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		long id = parameters.getId();
		BaseContainer.updateShopByAll(
				id, 
				name.getValue(), 
				media.getImage(), 
				ownerFirstName.getValue(), 
				ownerLastName.getValue(), 
				null, 
				ownerEmail.getValue(), 
				bankIban.getValue(), 
				bankSwift.getValue(), 
				address.getValue(),
				notes.getValue(),
				shopUrl.getValue(), 
				shopPhone.getValue(), 
				shopEmail.getValue(),
				loginUsername.getValue(),
				getUpdateInfo());
		// Check if password was given
		if (loginPassword.getValue() != null) {
			BaseContainer.updateShopByPassword(id, SecurityUtilities.getMD5(loginPassword.getValue()), getUpdateInfo());
		}
		showDataUpdatedDialog();
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
