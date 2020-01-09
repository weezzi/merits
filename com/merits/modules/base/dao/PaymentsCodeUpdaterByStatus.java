package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.merits.modules.base.uobjects.enums.PaymentCodeStatus;


/**
 * <b>Title: </b>Payments Code Updater Object<br/>
 * <b>Description: </b>Payments Code Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class PaymentsCodeUpdaterByStatus implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private PaymentCodeStatus codeStatus;
    private String paymentCode;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public PaymentsCodeUpdaterByStatus(long id, PaymentCodeStatus codeStatus, String paymentCode) {
        this.id = id;
        this.codeStatus = codeStatus;
        this.paymentCode = paymentCode;
	}


	// PUBLIC -----------------------------------------------------------------

	
    /**
     * Gets DB Connection name
     * @return project database connection name;
     */
	public String getDBConnectionName() {
		return "Merits_Merits";
	}


	/**
	 * Gets update SQL
	 * @return query
	 */
	public String getQuerySQL() {
		return "UPDATE PAYMENTS_CODE " +
               " SET CODE_STATUS = ? , PAYMENT_CODE = ?  " +
               " WHERE  ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        // Check If Null
        if (codeStatus == null) {
            statement.setNull(1, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(1, codeStatus.getValue());
        }
        // Check If Null
        if (paymentCode == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setString(2, StringUtilities.capString(paymentCode, 10));
        }
        statement.setLong(3, id);
	}


	/**
	 * Gets extended update SQL
	 * @return query
	 */
	public String getExtendedQuerySQL() {
		return null;
	}
	
	
	/**
	 * Updates Extended Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateExtendedQueryFields(CallableStatement statement) throws Exception {
	}
	
	
}
