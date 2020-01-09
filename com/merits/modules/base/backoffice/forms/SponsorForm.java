package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.data.PublishInfo;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.merits.modules.base.backoffice.forms.definitions.SponsorFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.SponsorsDAO;


/**
 * <b>Title: </b> Sponsor Form<br/>
 * <b>Description: </b> Sponsor Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class SponsorForm extends SponsorFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		SponsorsDAO sponsor;
		// Check if is a edit or a add
		if (parameters.getId() != null) {
			sponsor = BaseContainer.getSponsor(parameters.getId());
			name.setValue(sponsor.getName());
			url.setValue(sponsor.getUrl());
			photo.setImage(sponsor.getPhoto());
			setCustomTitle("Edit");
		} else {
			setCustomTitle("Add");
		}
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		SponsorsDAO sponsor;
		// Get parameters
		if (parameters.getId() != null) {
			// UPDATE
			// Get sponsor
			sponsor = BaseContainer.getSponsor(parameters.getId());
			// Update data
			BaseContainer.updateSponsorByAll(
					parameters.getId(), 
					name.getValue(), 
					photo.getImageAndReleaseUnused(sponsor.getPhoto()), 
					url.getValue(), 
					getUpdateInfo());
		} else {
			// CREATE
			BaseContainer.createSponsor(name.getValue(), photo.getImage(), url.getValue(), getEditInfo(), new PublishInfo());
		}
		// Close dialog and update table
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
