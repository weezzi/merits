package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.data.PublishInfo;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.merits.modules.base.backoffice.forms.definitions.AddCountryFormDefinition;
import com.merits.modules.base.container.BaseContainer;


/**
 * <b>Title: </b> AddCountry Form<br/>
 * <b>Description: </b> AddCountry Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AddCountryForm extends AddCountryFormDefinition {


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
		BaseContainer.createCountry(name.getValue(), new PublishInfo(), getEditInfo());
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
