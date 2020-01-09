package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.SecurityUtilities;


/**
 * <b>Title: </b>Shop Updater Object<br/>
 * <b>Description: </b>Shop Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class ShopsUpdaterByAll implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private String name;
    private Image photo;
    private String ownerFirstName;
    private String ownerLastName;
    private Phone ownerMobile;
    private String ownerEmail;
    private String bankIban;
    private String bankSwift;
    private String address;
    private String notes;
    private String shopUrl;
    private String shopPhone;
    private String shopEmail;
    private String ownerLogin;
    private UpdateInfo _updateInfo;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public ShopsUpdaterByAll(long id, String name, Image photo, String ownerFirstName, String ownerLastName, Phone ownerMobile, String ownerEmail, String bankIban, String bankSwift, String address, String notes, String shopUrl, String shopPhone, String shopEmail, String ownerLogin, UpdateInfo updateInfo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerMobile = ownerMobile;
        this.ownerEmail = ownerEmail;
        this.bankIban = bankIban;
        this.bankSwift = bankSwift;
        this.address = address;
        this.notes = notes;
        this.shopUrl = shopUrl;
        this.shopPhone = shopPhone;
        this.shopEmail = shopEmail;
        this.ownerLogin = ownerLogin;
        this._updateInfo = updateInfo;
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
		return "UPDATE SHOPS " +
               " SET NAME = ? , PHOTO = ? , OWNER_FIRST_NAME = ? , OWNER_LAST_NAME = ? , OWNER_MOBILE = ? , OWNER_EMAIL = ? , BANK_IBAN = ? , BANK_SWIFT = ? , SHOP_URL = ? , SHOP_EMAIL = ? , SHOP_PHONE = ? , OWNER_LOGIN = ? , ADDRESS = ? , NOTES = ? , EDIT_INFO_UPDATE_DATE  = ? , EDIT_INFO_UPDATE_USER  = ?  " +
               " WHERE  ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        statement.setString(1, StringUtilities.capString(name, 100));
        // Check If Null
        if (photo == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setString(2, photo.serialize());
        }
        // Check If Null
        if (ownerFirstName == null) {
            statement.setNull(3, java.sql.Types.VARCHAR);
        } else {
            statement.setString(3, StringUtilities.capString(ownerFirstName, 100));
        }
        // Check If Null
        if (ownerLastName == null) {
            statement.setNull(4, java.sql.Types.VARCHAR);
        } else {
            statement.setString(4, StringUtilities.capString(ownerLastName, 100));
        }
        // Check If Null
        if (ownerMobile == null) {
            statement.setNull(5, java.sql.Types.VARCHAR);
        } else {
            statement.setString(5, ownerMobile.serialize());
        }
        // Check If Null
        if (ownerEmail == null) {
            statement.setNull(6, java.sql.Types.VARCHAR);
        } else {
            statement.setString(6, StringUtilities.capString(ownerEmail, 50));
        }
        // Check If Null
        if (bankIban == null) {
            statement.setNull(7, java.sql.Types.VARCHAR);
        } else {
            statement.setString(7, StringUtilities.capString(bankIban, 100));
        }
        // Check If Null
        if (bankSwift == null) {
            statement.setNull(8, java.sql.Types.VARCHAR);
        } else {
            statement.setString(8, StringUtilities.capString(bankSwift, 25));
        }
        // Check If Null
        if (shopUrl == null) {
            statement.setNull(9, java.sql.Types.VARCHAR);
        } else {
            statement.setString(9, StringUtilities.capString(shopUrl, 250));
        }
        // Check If Null
        if (shopEmail == null) {
            statement.setNull(10, java.sql.Types.VARCHAR);
        } else {
            statement.setString(10, StringUtilities.capString(shopEmail, 250));
        }
        // Check If Null
        if (shopPhone == null) {
            statement.setNull(11, java.sql.Types.VARCHAR);
        } else {
            statement.setString(11, StringUtilities.capString(shopPhone, 50));
        }
        statement.setString(12, SecurityUtilities.encrypt(ownerLogin, "SHOPS", "OWNER_LOGIN"));
        // Check If Null
        if (address == null) {
            statement.setNull(13, java.sql.Types.VARCHAR);
        } else {
            statement.setString(13, StringUtilities.capString(address, 250));
        }
        // Check If Null
        if (notes == null) {
            statement.setNull(14, java.sql.Types.VARCHAR);
        } else {
            statement.setString(14, StringUtilities.capString(notes, 500));
        }
        // Check if edit info update date is Null
        if (_updateInfo.getUpdateDate() == null) {
            statement.setNull(15, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(15,  _updateInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (_updateInfo.getUpdateUserId() == null) {
            statement.setNull(16, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(16, _updateInfo.getUpdateUserId());
        } 
        statement.setLong(17, id);
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
