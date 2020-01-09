package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.SecurityUtilities;
import com.merits.modules.base.backoffice.forms.definitions.EditVolunteerFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.VolunteersDAO;
import com.merits.modules.base.uobjects.enums.IdcardType;


/**
 * <b>Title: </b> EditVolunteer Form<br/>
 * <b>Description: </b> EditVolunteer Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class EditVolunteerForm extends EditVolunteerFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		VolunteersDAO volunteer = BaseContainer.getVolunteer(parameters.getId());
		if (volunteer == null) {
			return;
		}
		organization.setValue(BaseContainer.getOrganizationsOrganizationsList(), volunteer.getIdOrganization());
		firstName.setValue(volunteer.getFirstName());
		lastName.setValue(volunteer.getLastName());
		userName.setValue(volunteer.getLoginEmail());
		blocked.setSelected(volunteer.getIsBlocked());
		cardType.setValue(IdcardType.getAsList(), volunteer.getIdCardType());
		cardNumber.setValue(volunteer.getCardNumber());
		mobile.setValue(volunteer.getMobile());
		address.setValue(volunteer.getAddress());
		photo.setImage(volunteer.getPhoto());
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		BaseContainer.updateVolunteerByAll(
				parameters.getId(), 
				organization.getLongValue(), 
				firstName.getValue(), 
				lastName.getValue(), 
				photo.getImage(), 
				address.getValue(), 
				mobile.getValue(), 
				null, 
				IdcardType.getByValue(cardType.getIntegerValue()), 
				cardNumber.getValue(), 
				userName.getValue(), 
				blocked.isSelected(), 
				getUpdateInfo());
		// Check if password was given
		if (userPassword.getValue() != null) {
			BaseContainer.updateVolunteerByPassword(parameters.getId(), SecurityUtilities.getMD5(userPassword.getValue()), getUpdateInfo());
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
