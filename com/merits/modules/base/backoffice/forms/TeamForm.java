package com.merits.modules.base.backoffice.forms;

import com.merits.modules.base.backoffice.forms.definitions.TeamFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.TeamDAO;
import com.weezzi.core.data.PublishInfo;


/**
 * <b>Title: </b> Team Form<br/>
 * <b>Description: </b> Team Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class TeamForm extends TeamFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		TeamDAO team;
		// Check if is a edit
		if (parameters.getId() != null) {
			team = BaseContainer.getTeam(parameters.getId(), getSiteDefaultLanguage());
			name.setValue(team.getName());
			position.setValue(team.getPosition());
			photo.setImage(team.getPhoto());
			description.setValue(team.getDescription());
			linkFacebook.setValue(team.getFacebookUrl());
			linkTwitter.setValue(team.getTwitterUrl());
			linkInstagram.setValue(team.getInstagramUrl());
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
		TeamDAO team;
		// Check if is edit or create
		if (parameters.getId() != null) {
			// EDIT
			team = BaseContainer.getTeam(parameters.getId(), getSiteDefaultLanguage());
			BaseContainer.updateTeamByAll(
					parameters.getId(), 
					name.getValue(), 
					position.getValue(), 
					description.getValue(), 
					photo.getImageAndReleaseUnused(team.getPhoto()), 
					linkInstagram.getValue(), 
					linkTwitter.getValue(), 
					linkFacebook.getValue(), 
					getLanguageCode(), 
					getUpdateInfo());
		} else {
			// CREATE
			BaseContainer.createTeam(getLanguageCode(), 
					name.getValue(), 
					position.getValue(), 
					description.getValue(), 
					photo.getImage(), 
					linkInstagram.getValue(), 
					linkTwitter.getValue(), 
					linkFacebook.getValue(), 
					getEditInfo(), 
					new PublishInfo());
		}
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
