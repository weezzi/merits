package com.merits.modules.base.site.components;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.CashiersHomeDefinition;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> CashiersHome<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class CashiersHome extends CashiersHomeDefinition {


	// CONSTANTS ---------------------------------------------------------------

	
	// INITIALIZATION ----------------------------------------------------------
	
	
	public void customComponentInitialization() {
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
		map.addAttribute("NAME", getSiteUserDisplayName());
		map.addAttribute("CODE", getSession().getSiteUserCustomId());
		if (getSiteUserPhotoId() != null) {
			map.addAttribute("PHOTO", getImage(getSiteUserPhotoId(), 400, 400));
		}
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

