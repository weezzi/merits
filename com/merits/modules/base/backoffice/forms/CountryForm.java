package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.merits.modules.base.backoffice.forms.definitions.CountryFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.CountriesDAO;


/**
 * <b>Title: </b> Country Form<br/>
 * <b>Description: </b> Country Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class CountryForm extends CountryFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		CountriesDAO country = BaseContainer.getCountry(parameters.getId());
		name.setValue(country.getName());
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		BaseContainer.updateCountryByName(parameters.getId(), name.getValue(), getUpdateInfo());
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
