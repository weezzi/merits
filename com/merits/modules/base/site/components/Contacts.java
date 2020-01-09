package com.merits.modules.base.site.components;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.ContactsDefinition;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> Contacts<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class Contacts extends ContactsDefinition {


	// CONSTANTS ---------------------------------------------------------------

	
	// INITIALIZATION ----------------------------------------------------------
	
	
	public void customComponentInitialization() {
		addGlobalStyle("MeritsV2");
		addGlobalScript("ScriptsV2");
	};


	// BROWSER OUTPUT ----------------------------------------------------------


	/**
	 * Generate Start Output
	 * @return String
	 */
	public String getStartOutput() {
		// Local Variables
		Expression expr;
		AttributeMapper map;
		// Get Expression
		expr = getHTMLExpression("Default");
		map = expr.getAttributeMapper();
		// Add attributes
		setDefaultMapProperties(map, getPropertiesDefinition());
		map.addAttribute("", "");
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}
