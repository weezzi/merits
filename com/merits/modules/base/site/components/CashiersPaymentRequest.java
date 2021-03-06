package com.merits.modules.base.site.components;

import com.merits.core.MeritsUtils;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.PaymentsRequestsDAO;
import com.merits.modules.base.dao.VolunteersDAO;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.site.components.definitions.CashiersPaymentRequestDefinition;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> CashiersPaymentRequest<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class CashiersPaymentRequest extends CashiersPaymentRequestDefinition {


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
		String[] values;
		Expression expr;
		AttributeMapper map;
		PaymentsRequestsDAO request;
		VolunteersDAO volunteer;
		// Get Expression
		expr = getHTMLExpression("Default");
		map = expr.getAttributeMapper();
		// Get request
		try {
			request = BaseContainer.getPaymentsRequest(getParameterEncryptedAsLong("Id"));
			volunteer = BaseContainer.getVolunteer(request.getIdVolunteer());
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error getting payment request", e);
			sendRedirect(getPageLink("Cashiers_MakePayment"));
			return "";
		}
		// Add attributes
		map.addAttribute("NAME", MeritsUtils.getPersonName(volunteer.getFirstName(), volunteer.getLastName()));
		if (volunteer.getPhoto() != null) {
			map.addAttribute("PHOTO", getImage(volunteer.getPhoto(), 500, 500));
		}
		values = MeritsUtils.getWalletValue(request.getTransactionValue());
		map.addAttribute("VALUE_INT", values[0]);
		map.addAttribute("VALUE_DEC", values[1]);
		// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

