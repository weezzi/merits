package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.SingleRecordDAO;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.core.dbmanager.dao.DAOParameters;
import com.weezzi.utils.SecurityUtilities;


import java.sql.CallableStatement;
import java.sql.ResultSet;



/**
 * <b>Title: </b>Shop Data Access Object<br/>
 * <b>Description: </b>Shop DAO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
public class ShopsDAO extends SingleRecordDAO {


	// CONSTANTS --------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "D4#";
	private static final long serialVersionUID = 1l;


    // MULTI-LANGUAGE ---------------------------------------------------------


    /**
     *  Multi-Language
     */
    public enum MultiLanguageFields {
        ;

        private String column;

        MultiLanguageFields(String column) {
        	this.column = column;
        }

        public String getColumnName() {
        	return column;
        }
	}


    // DATA TYPE ENUMERATION --------------------------------------------------


    /**
     *  DAO Search Type
     */
    public enum SearchType {

    	// Single Record Queries
        Wallet("Q1"),

		;
    	
        private String cachePrefix;
        
        SearchType(String cachePrefix) {
        	this.cachePrefix = cachePrefix;
        }

        /**
         * Gets cache prefix
         **/
        public String toString() {
        	return cachePrefix;
        }
    }


    // PROPERTIES --------------------------------------------------------------

    // Shops Identifier
    private long id;
    // Shops Wallet Identifier
    private long idWallet;
    // Shops City Identifier
    private Long idCity;
    // Shops Name
    private String name;
    // Shops Photo
    private Image photo;
    // Shops Location
    private MapInfo location;
    // Shops Owner First Name
    private String ownerFirstName;
    // Shops Owner Last Name
    private String ownerLastName;
    // Shops Owner Mobile
    private Phone ownerMobile;
    // Shops Owner Email
    private String ownerEmail;
    // Shops Bank Iban
    private String bankIban;
    // Shops Bank Swift
    private String bankSwift;
    // Shops Address
    private String address;
    // Shops Notes
    private String notes;
    // Shops Shop Url
    private String shopUrl;
    // Shops Shop Phone
    private String shopPhone;
    // Shops Shop Email
    private String shopEmail;
    // Shops Preferred Language
    private String preferredLanguage;
    // Shops Owner Login
    private String ownerLogin;
    // Shops Owner Password
    private String ownerPassword;
    // Shops Edit Info
    private EditInfo editInfo;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public ShopsDAO() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}


	/**
	 * Type Constructor
	 **/
	public ShopsDAO(SearchType type) {
        // Set DAO Search type
        this.setSearchType(type);
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}
	
	
    /**
     * Shop Bean Field Constructor
     * @param id long Shops Identifier
     */
    public ShopsDAO(long id) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Shops Identifier
        setId(id);
    }


    /**
     * Shop Bean Field Constructor
     * @param id long Shops Identifier
     * @param idWallet long Shops Wallet Identifier
     * @param name String Shops Name
     * @param editInfo EditInfo Shops Edit Info
     */
    public ShopsDAO(long id, long idWallet, String name
                    , EditInfo editInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Shops Identifier
        setId(id);
        // Set Shops Wallet Identifier
        setIdWallet(idWallet);
        // Set Shops Name
        setName(name);
        // Set Shops Edit Info
        setEditInfo(editInfo);
    }


    /**
     * Shop Bean Field Constructor
     * @param id long Shops Identifier
     * @param idWallet long Shops Wallet Identifier
     * @param idCity Long Shops City Identifier
     * @param name String Shops Name
     * @param photo Image Shops Photo
     * @param location MapInfo Shops Location
     * @param ownerFirstName String Shops Owner First Name
     * @param ownerLastName String Shops Owner Last Name
     * @param ownerMobile Phone Shops Owner Mobile
     * @param ownerEmail String Shops Owner Email
     * @param bankIban String Shops Bank Iban
     * @param bankSwift String Shops Bank Swift
     * @param address String Shops Address
     * @param notes String Shops Notes
     * @param shopUrl String Shops Shop Url
     * @param shopPhone String Shops Shop Phone
     * @param shopEmail String Shops Shop Email
     * @param preferredLanguage String Shops Preferred Language
     * @param ownerLogin String Shops Owner Login
     * @param ownerPassword String Shops Owner Password
     * @param editInfo EditInfo Shops Edit Info
     */
    public ShopsDAO(long id, long idWallet, Long idCity
                    , String name, Image photo, MapInfo location
                    , String ownerFirstName, String ownerLastName, Phone ownerMobile
                    , String ownerEmail, String bankIban, String bankSwift
                    , String address, String notes, String shopUrl
                    , String shopPhone, String shopEmail, String preferredLanguage
                    , String ownerLogin, String ownerPassword, EditInfo editInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Shops Identifier
        setId(id);
        // Set Shops Wallet Identifier
        setIdWallet(idWallet);
        // Set Shops City Identifier
        setIdCity(idCity);
        // Set Shops Name
        setName(name);
        // Set Shops Photo
        setPhoto(photo);
        // Set Shops Location
        setLocation(location);
        // Set Shops Owner First Name
        setOwnerFirstName(ownerFirstName);
        // Set Shops Owner Last Name
        setOwnerLastName(ownerLastName);
        // Set Shops Owner Mobile
        setOwnerMobile(ownerMobile);
        // Set Shops Owner Email
        setOwnerEmail(ownerEmail);
        // Set Shops Bank Iban
        setBankIban(bankIban);
        // Set Shops Bank Swift
        setBankSwift(bankSwift);
        // Set Shops Address
        setAddress(address);
        // Set Shops Notes
        setNotes(notes);
        // Set Shops Shop Url
        setShopUrl(shopUrl);
        // Set Shops Shop Phone
        setShopPhone(shopPhone);
        // Set Shops Shop Email
        setShopEmail(shopEmail);
        // Set Shops Preferred Language
        setPreferredLanguage(preferredLanguage);
        // Set Shops Owner Login
        setOwnerLogin(ownerLogin);
        // Set Shops Owner Password
        setOwnerPassword(ownerPassword);
        // Set Shops Edit Info
        setEditInfo(editInfo);
    }


    

    
    // TYPE -------------------------------------------------------------------

    
    /**
     * Sets DAO search type
     * @param type
     */
    public void setSearchType(SearchType type) {
    	// Sets DAO type
    	super.setSearchType(type);
    }


	// GETTERS -----------------------------------------------------------------


    /**
     * Get Shops Identifier
     * @return long Shops Identifier
     */
    public long getId() {
        return this.id;
    }


    /**
     * Get Shops Wallet Identifier
     * @return long Shops Wallet Identifier
     */
    public long getIdWallet() {
        return this.idWallet;
    }


    /**
     * Get Shops City Identifier
     * @return Long Shops City Identifier
     */
    public Long getIdCity() {
        return this.idCity;
    }


    /**
     * Get Shops Name
     * @return String Shops Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get Shops Photo
     * @return Image Shops Photo
     */
    public Image getPhoto() {
        return this.photo;
    }


    /**
     * Get Shops Location
     * @return MapInfo Shops Location
     */
    public MapInfo getLocation() {
        return this.location;
    }


    /**
     * Get Shops Owner First Name
     * @return String Shops Owner First Name
     */
    public String getOwnerFirstName() {
        return this.ownerFirstName;
    }


    /**
     * Get Shops Owner Last Name
     * @return String Shops Owner Last Name
     */
    public String getOwnerLastName() {
        return this.ownerLastName;
    }


    /**
     * Get Shops Owner Mobile
     * @return Phone Shops Owner Mobile
     */
    public Phone getOwnerMobile() {
        return this.ownerMobile;
    }


    /**
     * Get Shops Owner Email
     * @return String Shops Owner Email
     */
    public String getOwnerEmail() {
        return this.ownerEmail;
    }


    /**
     * Get Shops Bank Iban
     * @return String Shops Bank Iban
     */
    public String getBankIban() {
        return this.bankIban;
    }


    /**
     * Get Shops Bank Swift
     * @return String Shops Bank Swift
     */
    public String getBankSwift() {
        return this.bankSwift;
    }


    /**
     * Get Shops Address
     * @return String Shops Address
     */
    public String getAddress() {
        return this.address;
    }


    /**
     * Get Shops Notes
     * @return String Shops Notes
     */
    public String getNotes() {
        return this.notes;
    }


    /**
     * Get Shops Shop Url
     * @return String Shops Shop Url
     */
    public String getShopUrl() {
        return this.shopUrl;
    }


    /**
     * Get Shops Shop Phone
     * @return String Shops Shop Phone
     */
    public String getShopPhone() {
        return this.shopPhone;
    }


    /**
     * Get Shops Shop Email
     * @return String Shops Shop Email
     */
    public String getShopEmail() {
        return this.shopEmail;
    }


    /**
     * Get Shops Preferred Language
     * @return String Shops Preferred Language
     */
    public String getPreferredLanguage() {
        return this.preferredLanguage;
    }


    /**
     * Get Shops Owner Login
     * @return String Shops Owner Login
     */
    public String getOwnerLogin() {
        return this.ownerLogin;
    }


    /**
     * Get Shops Owner Password
     * @return String Shops Owner Password
     */
    public String getOwnerPassword() {
        return this.ownerPassword;
    }


    /**
     * Get Shops Edit Info
     * @return EditInfo Shops Edit Info
     */
    public EditInfo getEditInfo() {
        return this.editInfo;
    }



	// SETTERS -----------------------------------------------------------------


    /**
     * Set Shops Identifier
     * @param id long Shops Identifier
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Set Shops Wallet Identifier
     * @param idWallet long Shops Wallet Identifier
     */
    public void setIdWallet(long idWallet) {
        this.idWallet = idWallet;
    }


    /**
     * Set Shops City Identifier
     * @param idCity Long Shops City Identifier
     */
    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }


    /**
     * Set Shops Name
     * @param name String Shops Name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set Shops Photo
     * @param photo Image Shops Photo
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }


    /**
     * Set Shops Location
     * @param location MapInfo Shops Location
     */
    public void setLocation(MapInfo location) {
        this.location = location;
    }


    /**
     * Set Shops Owner First Name
     * @param ownerFirstName String Shops Owner First Name
     */
    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }


    /**
     * Set Shops Owner Last Name
     * @param ownerLastName String Shops Owner Last Name
     */
    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }


    /**
     * Set Shops Owner Mobile
     * @param ownerMobile Phone Shops Owner Mobile
     */
    public void setOwnerMobile(Phone ownerMobile) {
        this.ownerMobile = ownerMobile;
    }


    /**
     * Set Shops Owner Email
     * @param ownerEmail String Shops Owner Email
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    /**
     * Set Shops Bank Iban
     * @param bankIban String Shops Bank Iban
     */
    public void setBankIban(String bankIban) {
        this.bankIban = bankIban;
    }


    /**
     * Set Shops Bank Swift
     * @param bankSwift String Shops Bank Swift
     */
    public void setBankSwift(String bankSwift) {
        this.bankSwift = bankSwift;
    }


    /**
     * Set Shops Address
     * @param address String Shops Address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Set Shops Notes
     * @param notes String Shops Notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }


    /**
     * Set Shops Shop Url
     * @param shopUrl String Shops Shop Url
     */
    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }


    /**
     * Set Shops Shop Phone
     * @param shopPhone String Shops Shop Phone
     */
    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }


    /**
     * Set Shops Shop Email
     * @param shopEmail String Shops Shop Email
     */
    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }


    /**
     * Set Shops Preferred Language
     * @param preferredLanguage String Shops Preferred Language
     */
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }


    /**
     * Set Shops Owner Login
     * @param ownerLogin String Shops Owner Login
     */
    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }


    /**
     * Set Shops Owner Password
     * @param ownerPassword String Shops Owner Password
     */
    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }


    /**
     * Set Shops Edit Info
     * @param editInfo EditInfo Shops Edit Info
     */
    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }



    // MULTI-LANGUAGE ---------------------------------------------------------



	// DAO ID -----------------------------------------------------------------

    
    /**
     * Checks if has Id Field
     */
    public boolean hasIdField() {
    	return true;
    }

    
    /**
     * Sets Id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }


    // CACHING ----------------------------------------------------------------
    
    
	/**
	 * Gets cachePrefix
	 * @return The cachePrefix of this object
	 */
	public String getCachePrefix() {
		return CACHE_PREFIX;
	}
	
	
	/**
	 * Gets the object cache keys
	 * @return cacheKeys
	 */
	public String[] getCacheKeys() {
		if (getParameters() != null) {
			return getParameters().getCacheKeys();
		}
		return null;
	}
	

    // DATABASE MANAGER SPECIFIC ----------------------------------------------

    
    /**
     * Gets table name
     */
    public String getTableName() {
    	return "SHOPS";
    }

    
    /**
     * Gets DB Connection name
     * @return project database connection name;
     */
    public String getDBConnectionName() {
    	return "Merits_Merits";
    }

    
    /**
     * Gets Insert query SQL
     * @return Insert SQL
     */
    public String getInsertSQL() {
    	// SQL
    	return "INSERT INTO SHOPS (`ID_WALLET`, `ID_CITY`, `NAME`, `PHOTO`, `LOCATION`, `OWNER_FIRST_NAME`, `OWNER_LAST_NAME`, `OWNER_MOBILE`, `OWNER_EMAIL`, `BANK_IBAN`, `BANK_SWIFT`, `ADDRESS`, `NOTES`, `SHOP_URL`, `SHOP_PHONE`, `SHOP_EMAIL`, `PREFERRED_LANGUAGE`, `OWNER_LOGIN`, `OWNER_PASSWORD`, `EDIT_INFO_CREATE_DATE`, `EDIT_INFO_CREATE_USER`, `EDIT_INFO_UPDATE_DATE`, `EDIT_INFO_UPDATE_USER`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    
    /**
     * Gets Insert procedure
     */
    public String getInsertProcedureName() {
    	return "SHOPS_PROC(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }


	// RESULTSETS & STATEMENTS ------------------------------------------------
	    
    
    /**
     * Fills insert fields
     * @param statement
     */
    public void fillStatementFieldsForInsert(CallableStatement statement) throws Exception {
        // Set Shops Wallet Identifier
        statement.setLong(1, idWallet);
        // Check If Shops City Identifier Is Null
        if (idCity == null) {
            statement.setNull(2, java.sql.Types.NUMERIC);
        } else {
            // Set Shops City Identifier
            statement.setLong(2, idCity);
        }
        // Set Shops Name
        statement.setString(3, StringUtilities.capString(name,100));
        // Check If Null
        if (photo == null) {
            statement.setNull(4, java.sql.Types.VARCHAR);
        } else {
            statement.setString(4, photo.serialize());
        }
        // Check If Null
        if (location == null) {
            statement.setNull(5, java.sql.Types.VARCHAR);
        } else {
            statement.setString(5, location.serialize());
        }
        // Check If Shops Owner First Name Is Null
        if (ownerFirstName == null) {
            statement.setNull(6, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Owner First Name
            statement.setString(6, StringUtilities.capString(ownerFirstName,100));
        }
        // Check If Shops Owner Last Name Is Null
        if (ownerLastName == null) {
            statement.setNull(7, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Owner Last Name
            statement.setString(7, StringUtilities.capString(ownerLastName,100));
        }
        // Check If Null
        if (ownerMobile == null) {
            statement.setNull(8, java.sql.Types.VARCHAR);
        } else {
            statement.setString(8, ownerMobile.serialize());
        }
        // Check If Shops Owner Email Is Null
        if (ownerEmail == null) {
            statement.setNull(9, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Owner Email
            statement.setString(9, StringUtilities.capString(ownerEmail,50));
        }
        // Check If Shops Bank Iban Is Null
        if (bankIban == null) {
            statement.setNull(10, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Bank Iban
            statement.setString(10, StringUtilities.capString(bankIban,100));
        }
        // Check If Shops Bank Swift Is Null
        if (bankSwift == null) {
            statement.setNull(11, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Bank Swift
            statement.setString(11, StringUtilities.capString(bankSwift,25));
        }
        // Check If Shops Address Is Null
        if (address == null) {
            statement.setNull(12, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Address
            statement.setString(12, StringUtilities.capString(address,250));
        }
        // Check If Shops Notes Is Null
        if (notes == null) {
            statement.setNull(13, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Notes
            statement.setString(13, StringUtilities.capString(notes,500));
        }
        // Check If Shops Shop Url Is Null
        if (shopUrl == null) {
            statement.setNull(14, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Shop Url
            statement.setString(14, StringUtilities.capString(shopUrl,250));
        }
        // Check If Shops Shop Phone Is Null
        if (shopPhone == null) {
            statement.setNull(15, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Shop Phone
            statement.setString(15, StringUtilities.capString(shopPhone,50));
        }
        // Check If Shops Shop Email Is Null
        if (shopEmail == null) {
            statement.setNull(16, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Shop Email
            statement.setString(16, StringUtilities.capString(shopEmail,250));
        }
        // Check If Shops Preferred Language Is Null
        if (preferredLanguage == null) {
            statement.setNull(17, java.sql.Types.VARCHAR);
        } else {
            // Set Shops Preferred Language
            statement.setString(17, StringUtilities.capString(preferredLanguage,3));
        }
        // Set Shops Owner Login (dummy value for later update)
        statement.setString(18, "-");
        // Set Shops Owner Password (dummy value for later update)
        statement.setString(19, "-");
        // Check if edit info create date is Null
        if (editInfo.getCreateDate() == null) {
            statement.setNull(20, java.sql.Types.TIMESTAMP);
        } else {
            // Set create date
            statement.setTimestamp(20, editInfo.getCreateDate());
        } 
        // Check if edit info create user is Null
        if (editInfo.getCreateUserId() == null) {
            statement.setNull(21, java.sql.Types.NUMERIC);
        } else {
            // Set create user
            statement.setLong(21, editInfo.getCreateUserId());
        } 
        // Check if edit info update date is Null
        if (editInfo.getUpdateDate() == null) {
            statement.setNull(22, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(22, editInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (editInfo.getUpdateUserId() == null) {
            statement.setNull(23, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(23, editInfo.getUpdateUserId());
        } 
    }


    /**
     * Sets DAO values from a resultset 
     * @param resultset
     */
    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Shops Identifier
        this.setId(resultset.getLong("ID"));
        // Set Shops Wallet Identifier
        this.setIdWallet(resultset.getLong("ID_WALLET"));
        // Set Shops City Identifier
        this.setIdCity(getRSLong(resultset, "ID_CITY"));
        // Set Shops Name
        this.setName(resultset.getString("NAME"));
        // Set Shops Photo
        this.setPhoto(Image.deserialize(resultset.getString("PHOTO")));
        // Set Shops Location
        this.setLocation(MapInfo.deserialize(resultset.getString("LOCATION")));
        // Set Shops Owner First Name
        this.setOwnerFirstName(resultset.getString("OWNER_FIRST_NAME"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setOwnerFirstName(null);
        }
        // Set Shops Owner Last Name
        this.setOwnerLastName(resultset.getString("OWNER_LAST_NAME"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setOwnerLastName(null);
        }
        // Set Shops Owner Mobile
        this.setOwnerMobile(Phone.deserialize(resultset.getString("OWNER_MOBILE")));
        // Set Shops Owner Email
        this.setOwnerEmail(resultset.getString("OWNER_EMAIL"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setOwnerEmail(null);
        }
        // Set Shops Bank Iban
        this.setBankIban(resultset.getString("BANK_IBAN"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setBankIban(null);
        }
        // Set Shops Bank Swift
        this.setBankSwift(resultset.getString("BANK_SWIFT"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setBankSwift(null);
        }
        // Set Shops Address
        this.setAddress(resultset.getString("ADDRESS"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setAddress(null);
        }
        // Set Shops Notes
        this.setNotes(resultset.getString("NOTES"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setNotes(null);
        }
        // Set Shops Shop Url
        this.setShopUrl(resultset.getString("SHOP_URL"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setShopUrl(null);
        }
        // Set Shops Shop Phone
        this.setShopPhone(resultset.getString("SHOP_PHONE"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setShopPhone(null);
        }
        // Set Shops Shop Email
        this.setShopEmail(resultset.getString("SHOP_EMAIL"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setShopEmail(null);
        }
        // Set Shops Preferred Language
        this.setPreferredLanguage(resultset.getString("PREFERRED_LANGUAGE"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setPreferredLanguage(null);
        }
        // Set Shops Owner Login
        this.setOwnerLogin(SecurityUtilities.decrypt(resultset.getString("OWNER_LOGIN"), "SHOPS", "OWNER_LOGIN"));
        // Set Shops Owner Password
        this.setOwnerPassword(SecurityUtilities.decryptSalted(resultset.getString("OWNER_PASSWORD"), "SHOPS", "OWNER_PASSWORD", this.getId()));
        // Set Shops Edit Info
        this.editInfo = new EditInfo();
        editInfo.setCreateDate(resultset.getTimestamp("EDIT_INFO_CREATE_DATE"));
        // Check if was null
        if (resultset.wasNull()) {
            editInfo.setCreateDate(null);
        }
        editInfo.setCreateUserId(resultset.getLong("EDIT_INFO_CREATE_USER"));
        // Check if was null
        if (resultset.wasNull()) {
            editInfo.setCreateUserId(null);
        }
        editInfo.setUpdateDate(resultset.getTimestamp("EDIT_INFO_UPDATE_DATE"));
        // Check if was null
        if (resultset.wasNull()) {
            editInfo.setUpdateDate(null);
        }
        editInfo.setUpdateUserId(resultset.getLong("EDIT_INFO_UPDATE_USER"));
        // Check if was null
        if (resultset.wasNull()) {
            editInfo.setUpdateUserId(null);
        }
    }



	// ENCRYPTION METHODS -----------------------------------------------------


	/**
	 * Checks if has encryption
	 * @return
	 */
	public boolean hasEncryption() {
    	return true;
    }

    
    /**
     * Gets Encryption Update SQL
     * @return
     */
	public String getEncryptionUpdateSQL() {
        return "UPDATE SHOPS " +
               " SET OWNER_LOGIN = ? , OWNER_PASSWORD = ?  " +
               " WHERE ID = ?";
	}


    /**
     * Updates the encryption columns
     * @param statement
     * @param rowId
     */
    public void updateEncryptionColumns(CallableStatement statement, long rowId) throws Exception {
        // Set Fields
        statement.setString(1, SecurityUtilities.encrypt(ownerLogin, "SHOPS", "OWNER_LOGIN"));
        statement.setString(2, SecurityUtilities.encryptSalted(ownerPassword, "SHOPS", "OWNER_PASSWORD", rowId));
        statement.setLong(3, rowId);
    }


    /**
     * Gets a encrypted value for the ownerLogin field
     * @param ownerLogin
     * @return
     * @throws Exception
     */
    public static String getEncryptedOwnerLogin(String ownerLogin) throws Exception {
        return SecurityUtilities.encrypt(ownerLogin, "SHOPS", "OWNER_LOGIN");
    }


    /**
     * Gets a encrypted value for the ownerPassword field
     * @param ownerPassword
     * @param salt
     * @return
     * @throws Exception
     */
    public static String getEncryptedOwnerPassword(String ownerPassword, long salt) throws Exception {
        return SecurityUtilities.encrypt(ownerPassword, "SHOPS", "OWNER_PASSWORD", salt);
    }
    
    // ------------------------------------------------------------------------
    // PARAMETERS CLASSES -----------------------------------------------------
    // ------------------------------------------------------------------------



	// Wallet Parameters Class -----------------------------------------------


	/**
	 * Wallet
	 */
	public class WalletParameters extends DAOParameters {

		
		// Properties .........................................................

		
        // Shops Wallet Identifier
        private long idWallet;
        

		// Constructors .......................................................

		
		public WalletParameters(long idWallet) {
            this.idWallet = idWallet;
		}


        // DAO Parameters .....................................................


        /**
         * Gets the search fields
         * @return
         */
		public Object[] getSearchFields() {
			// Local Variables
			return new Object[] {idWallet};
		}
	
	
		/**
		 * Gets the object cache keys
		 * @return cacheKeys
		 */
		public String[] getCacheKeys() {
			return null;
		}

		
	}

}