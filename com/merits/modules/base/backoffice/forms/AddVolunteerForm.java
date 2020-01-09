package com.merits.modules.base.backoffice.forms;

import com.weezzi.core.data.Image;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.SecurityUtilities;
import com.merits.modules.base.backoffice.forms.definitions.AddVolunteerFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.VolunteersDAO;
import com.merits.modules.base.uobjects.enums.WalletType;


/**
 * <b>Title: </b> AddVolunteer Form<br/>
 * <b>Description: </b> AddVolunteer Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AddVolunteerForm extends AddVolunteerFormDefinition {


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
		long volunteerId;
		long walletId = BaseContainer.createWallet(WalletType.Volunteer);
		// Check if login already exists
		if (BaseContainer.getVolunteerFindByLogin(VolunteersDAO.getEncryptedLoginEmail(volunteerUsername.getValue())) != null) {
			showErrorDialog("Username already exists!");
			return;
		}
		// Create shop
		volunteerId = BaseContainer.createVolunteer(
				walletId, 
				firstName.getValue(), 
				lastName.getValue(), 
				volunteerUsername.getValue(), 
				SecurityUtilities.getMD5(volunteePassword.getValue()), 
				false, 
				getUpdateInfo());
		// Check if has image
		if (image.getImage() != null) {
			BaseContainer.updateVolunteerByPhoto(volunteerId, image.getImage(), getUpdateInfo());
		}
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
