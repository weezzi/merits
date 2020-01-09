package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.merits.modules.base.uobjects.enums.IdcardType;
import com.weezzi.utils.SecurityUtilities;


/**
 * <b>Title: </b>Volunteer Updater Object<br/>
 * <b>Description: </b>Volunteer Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class VolunteersUpdater implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private long idWallet;
    private Long idOrganization;
    private String firstName;
    private String lastName;
    private Image photo;
    private String address;
    private String mobile;
    private Long country;
    private IdcardType idCardType;
    private String cardNumber;
    private String preferredLanguage;
    private String loginEmail;
    private String loginPassword;
    private boolean isBlocked;
    private EditInfo editInfo;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public VolunteersUpdater(long id, long idWallet, Long idOrganization, String firstName, String lastName, Image photo, String address, String mobile, Long country, IdcardType idCardType, String cardNumber, String preferredLanguage, String loginEmail, String loginPassword, boolean isBlocked, UpdateInfo updateInfo) {
        this.id = id;
        this.idWallet = idWallet;
        this.idOrganization = idOrganization;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.address = address;
        this.mobile = mobile;
        this.country = country;
        this.idCardType = idCardType;
        this.cardNumber = cardNumber;
        this.preferredLanguage = preferredLanguage;
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.isBlocked = isBlocked;
        this.editInfo = editInfo;
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
		return "UPDATE VOLUNTEERS " +
               " SET ID_WALLET = ? , ID_ORGANIZATION = ? , FIRST_NAME = ? , LAST_NAME = ? , PHOTO = ? , ADDRESS = ? , MOBILE = ? , COUNTRY = ? , ID_CARD_TYPE = ? , CARD_NUMBER = ? , PREFERRED_LANGUAGE = ? , LOGIN_EMAIL = ? , LOGIN_PASSWORD = ? , IS_BLOCKED = ? , EDIT_INFO_UPDATE_DATE  = ? , EDIT_INFO_UPDATE_USER  = ?  " +
               " WHERE  ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        statement.setLong(1, idWallet);
        // Check If Null
        if (idOrganization == null) {
            statement.setNull(2, java.sql.Types.NUMERIC);
        } else {
            statement.setLong(2, idOrganization);
        }
        statement.setString(3, StringUtilities.capString(firstName, 50));
        statement.setString(4, StringUtilities.capString(lastName, 50));
        // Check If Null
        if (photo == null) {
            statement.setNull(5, java.sql.Types.VARCHAR);
        } else {
            statement.setString(5, photo.serialize());
        }
        // Check If Null
        if (address == null) {
            statement.setNull(6, java.sql.Types.VARCHAR);
        } else {
            statement.setString(6, StringUtilities.capString(address, 350));
        }
        // Check If Null
        if (mobile == null) {
            statement.setNull(7, java.sql.Types.VARCHAR);
        } else {
            statement.setString(7, StringUtilities.capString(mobile, 50));
        }
        // Check If Null
        if (country == null) {
            statement.setNull(8, java.sql.Types.NUMERIC);
        } else {
            statement.setLong(8, country);
        }
        // Check If Null
        if (idCardType == null) {
            statement.setNull(9, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(9, idCardType.getValue());
        }
        // Check If Null
        if (cardNumber == null) {
            statement.setNull(10, java.sql.Types.VARCHAR);
        } else {
            statement.setString(10, StringUtilities.capString(cardNumber, 25));
        }
        // Check If Null
        if (preferredLanguage == null) {
            statement.setNull(11, java.sql.Types.VARCHAR);
        } else {
            statement.setString(11, StringUtilities.capString(preferredLanguage, 3));
        }
        statement.setString(12, SecurityUtilities.encrypt(loginEmail, "VOLUNTEERS", "LOGIN_EMAIL"));
        statement.setString(13, SecurityUtilities.encryptSalted(loginPassword, "VOLUNTEERS", "LOGIN_PASSWORD", id));
        statement.setBoolean(14, isBlocked);
        // Check if edit info create date is Null
        if (editInfo.getCreateDate() == null) {
            statement.setNull(15, java.sql.Types.TIMESTAMP);
        } else {
            // Set create date
            statement.setTimestamp(15,  editInfo.getCreateDate());
        } 
        // Check if edit info create user is Null
        if (editInfo.getCreateUserId() == null) {
            statement.setNull(16, java.sql.Types.NUMERIC);
        } else {
            // Set create user
            statement.setLong(16, editInfo.getCreateUserId());
        } 
        // Check if edit info update date is Null
        if (editInfo.getUpdateDate() == null) {
            statement.setNull(17, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(17,  editInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (editInfo.getUpdateUserId() == null) {
            statement.setNull(18, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(18, editInfo.getUpdateUserId());
        } 
        statement.setLong(19, id);
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
