package com.merits.modules.base.site.components;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.BannerDefinition;
import com.weezzi.core.sites.components.ComponentPropertiesDefinition;
import com.weezzi.core.sites.enums.ContentAreas;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> Banner<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class Banner extends BannerDefinition {


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
		ComponentPropertiesDefinition props;
		// Get props
		props = getPropertiesDefinition();
		// Get Expression
		switch(props.getStyle().getId()) {
			case 0:
				expr = getHTMLExpression("Left");
				break;
			default:
				expr = getHTMLExpression("Right");
				break;
		}
		map = expr.getAttributeMapper();
		// Sets default properties
		setDefaultMapProperties(map, props);
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

