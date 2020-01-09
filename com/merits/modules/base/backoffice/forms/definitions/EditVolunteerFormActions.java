package com.merits.modules.base.backoffice.forms.definitions;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.servlets.base.WeezziServletAction;

/**
 * <b>Title: </b> EditVolunteer Servlet Actions<br/>
 * <b>Description: </b> EditVolunteer Servlet Actions<br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public enum EditVolunteerFormActions implements WeezziServletAction {


	// ENUMERATIONS -----------------------------------------------------------

;


    // PROPERTIES -------------------------------------------------------------

    
    private String urlPrefix;
    
    
    // CONSTRUCTOR ------------------------------------------------------------
    
    
    EditVolunteerFormActions(String urlPrefix) {
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