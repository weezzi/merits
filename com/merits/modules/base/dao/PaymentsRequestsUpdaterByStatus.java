package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.merits.modules.base.uobjects.enums.PaymentRequestStatus;


/**
 * <b>Title: </b>Payments Request Updater Object<br/>
 * <b>Description: </b>Payments Request Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class PaymentsRequestsUpdaterByStatus implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private PaymentRequestStatus paymentStatus;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public PaymentsRequestsUpdaterByStatus(long id, PaymentRequestStatus paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
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
		return "UPDATE PAYMENTS_REQUESTS " +
               " SET PAYMENT_STATUS = ?  " +
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
        if (paymentStatus == null) {
            statement.setNull(1, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(1, paymentStatus.getValue());
        }
        statement.setLong(2, id);
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