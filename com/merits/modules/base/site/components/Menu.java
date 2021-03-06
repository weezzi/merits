package com.merits.modules.base.site.components;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.MenuDefinition;
import com.weezzi.core.sites.components.ComponentPropertiesDefinition;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> Menu<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class Menu extends MenuDefinition {


	// CONSTANTS ---------------------------------------------------------------

	
	// INITIALIZATION ----------------------------------------------------------
	
	
	public void customComponentInitialization() {
		addGlobalStyle("MeritsV2");
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
		ComponentPropertiesDefinition props = getPropertiesDefinition();
		// Get Expression
		expr = getHTMLExpression("Default");
		map = expr.getAttributeMapper();
		setDefaultMapProperties(map, props);
		// Add attributes
		if (props.getBooleanPropertyValue("White").getValue()) {
			map.addAttribute("LOGO","Logo");
			map.addAttribute("CLASS", getObfuscatedStyle("MenuWhite"));
		} else {
			map.addAttribute("LOGO","LogoB");
			map.addAttribute("CLASS", getObfuscatedStyle("MenuBlack"));
		}
		for(int i=1;i<=10;i++) {
			map.addAttribute("INDEX"+i, getObfuscatedStyle("MenuItem"));
		}
		map.addAttribute("INDEX"+props.getIntegerPropertyValue("SelectedIndex").getValue(), getObfuscatedStyle("MenuItemSelected"));
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

