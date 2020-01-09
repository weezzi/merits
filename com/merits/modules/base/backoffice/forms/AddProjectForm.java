package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.data.PublishInfo;
import com.weezzi.core.data.TrashableInfo;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.merits.modules.base.backoffice.forms.definitions.AddProjectFormDefinition;
import com.merits.modules.base.container.BaseContainer;


/**
 * <b>Title: </b> AddProject Form<br/>
 * <b>Description: </b> AddProject Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AddProjectForm extends AddProjectFormDefinition {


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
		BaseContainer.createProject(
				getSiteDefaultLanguage(), 
				name.getValue(), 
				null, // headline, 
				null, // description, 
				false, // hasDonations, 
				false, //  hasVolunteers, 
				0, // volunteersActual, 
				0, // volunteersWanted, 
				0, // donationsActual, 
				0, // donationsWanted
				new PublishInfo(),
				getEditInfo(),
				new TrashableInfo()
				);
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
