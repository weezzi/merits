package com.merits.modules.base.backoffice.forms.definitions;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.servlets.base.WeezziServletAction;

/**
 * <b>Title: </b> AddCountry Auto-Complete Actions<br/>
 * <b>Description: </b> AddCountry Auto-Complete Actions<br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public enum AddCountryFormAutoCompleteActions implements WeezziServletAction {


	// ENUMERATIONS -----------------------------------------------------------

;


    // PROPERTIES -------------------------------------------------------------

    
    private String urlPrefix;
    
    
    // CONSTRUCTOR ------------------------------------------------------------
    
    
    AddCountryFormAutoCompleteActions(String urlPrefix) {
    	this.urlPrefix = urlPrefix;
    }

    
	// METHODS ----------------------------------------------------------------
	
	
	public String getName() {
		// Local Variables
		return name();
	}


	/**
	 * Gets urlPrefix
	 * @return the urlPrefix
	 */
	public String getUrlPrefix() {
		return urlPrefix;
	}


}