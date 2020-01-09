package com.merits.modules.base.site.servlets.definitions;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.servlets.base.WeezziServletAction;

/**
 * <b>Title: </b> Login AutoComplete Actions<br/>
 * <b>Description: </b> Login AutoComplete Actions<br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public enum LoginServletAutoCompleteActions implements WeezziServletAction {


	// ENUMERATIONS -----------------------------------------------------------

;


    // PROPERTIES -------------------------------------------------------------

    
    private String urlPrefix;
    
    
    // CONSTRUCTOR ------------------------------------------------------------
    
    
    LoginServletAutoCompleteActions(String urlPrefix) {
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