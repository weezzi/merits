package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.SecurityUtilities;


/**
 * <b>Title: </b>Shop Cashier Updater Object<br/>
 * <b>Description: </b>Shop Cashier Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class ShopCashiersUpdaterByAll implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String loginUsername;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public ShopCashiersUpdaterByAll(long id, String firstName, String lastName, String phone, String loginUsername) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.loginUsername = loginUsername;
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
		return "UPDATE SHOP_CASHIERS " +
               " SET FIRST_NAME = ? , LAST_NAME = ? , PHONE = ? , LOGIN_USERNAME = ?  " +
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
        if (firstName == null) {
            statement.setNull(1, java.sql.Types.VARCHAR);
        } else {
            statement.setString(1, StringUtilities.capString(firstName, 100));
        }
        // Check If Null
        if (lastName == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setString(2, StringUtilities.capString(lastName, 100));
        }
        // Check If Null
        if (phone == null) {
            statement.setNull(3, java.sql.Types.VARCHAR);
        } else {
            statement.setString(3, StringUtilities.capString(phone, 50));
        }
        statement.setString(4, SecurityUtilities.encrypt(loginUsername, "SHOP_CASHIERS", "LOGIN_USERNAME"));
        statement.setLong(5, id);
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
