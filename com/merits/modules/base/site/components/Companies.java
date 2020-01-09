package com.merits.modules.base.site.components;

import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.BulkCompaniesDAO;
import com.merits.modules.base.dao.BulkTeamDAO;
import com.merits.modules.base.dao.CompaniesDAO;
import com.merits.modules.base.dao.TeamDAO;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.CompaniesDefinition;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> Companies<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class Companies extends CompaniesDefinition {


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
		setDefaultMapProperties(map, getPropertiesDefinition());
		// Add attributes
		map.addAttribute("COMPANIES", renderCompanies());
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------

	private String renderCompanies() {
		// Local Variables
		Expression expr;
		AttributeMapper map;
		StringBuilder buffer = new StringBuilder();
		BulkCompaniesDAO companies;
		// Get Expression
		expr = getHTMLExpression("Company");
		map = expr.getAttributeMapper();		
		try {
			companies = BaseContainer.getCompaniesFindByAll(getSiteLanguage(), null);
			for(CompaniesDAO company : companies.data) {
				if (company.getPublishInfo().isPublished()) {
					map.addAttribute("NAME", company.getName());
					map.addAttribute("PHOTO", getImage(company.getPhoto(), 500, 500));
					map.addAttribute("URL", company.getUrl());
					buffer.append(expr.render(map));
				}
			}
		} catch (Exception e) {
			// Cacth error
			Console.error("Error rendering companies members", e);
		}
		// Return buffer
		return buffer.toString();
	}

}
