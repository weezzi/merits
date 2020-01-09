package com.merits.modules.base.site.components;

import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.ShopCashiersDAO;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.ShopCashiersDetailsDefinition;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> ShopCashiersDetails<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class ShopCashiersDetails extends ShopCashiersDetailsDefinition {


	// CONSTANTS ---------------------------------------------------------------

	
	// INITIALIZATION ----------------------------------------------------------
	
	
	public void customComponentInitialization() {
		addScript("Scripts");
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
		ShopCashiersDAO cashier;
		Long cashierId = null;
		// Get Expression
		expr = getHTMLExpression("Default");
		map = expr.getAttributeMapper();
		// Add attributes
		try {
			cashierId = getParameterEncryptedAsLong("Id");
		} catch (Exception e1) {
			Console.error("Error getting cashier id", e1);
		}
		map.addAttribute("ID", getParameter("Id"));
		if (cashierId != null) {
			try {
				cashier = BaseContainer.getShopCashier(cashierId);
				if (cashier == null) {
					sendRedirect(getPageLink("Shops_Cashiers"));
					return "";
				}
				map.addAttribute("FIRST_NAME", cashier.getFirstName());
				map.addAttribute("LAST_NAME", cashier.getLastName());
				map.addAttribute("PHONE", cashier.getPhone());
				map.addAttribute("USERNAME", cashier.getLoginUsername());
			} catch (Exception e) {
				// Catch Exception
				Console.error("Error getting cashier \"" + cashierId + "\"");
			}
		}
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

