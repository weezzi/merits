package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.SingleRecordDAO;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.core.dbmanager.dao.DAOParameters;


import java.sql.CallableStatement;
import java.sql.ResultSet;



/**
 * <b>Title: </b>Organization Data Access Object<br/>
 * <b>Description: </b>Organization DAO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
public class OrganizationsDAO extends SingleRecordDAO {


	// CONSTANTS --------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "D8#";
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
        WalletId("Q1"),

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

    // Organizations Identifier
    private long id;
    // Organizations Wallet Identifier
    private long idWallet;
    // Organizations Name
    private String name;
    // Organizations Logo
    private Image logo;
    // Organizations Edit Info
    private EditInfo editInfo;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public OrganizationsDAO() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}


	/**
	 * Type Constructor
	 **/
	public OrganizationsDAO(SearchType type) {
        // Set DAO Search type
        this.setSearchType(type);
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}
	
	
    /**
     * Organization Bean Field Constructor
     * @param id long Organizations Identifier
     */
    public OrganizationsDAO(long id) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Organizations Identifier
        setId(id);
    }


    /**
     * Organization Bean Field Constructor
     * @param id long Organizations Identifier
     * @param idWallet long Organizations Wallet Identifier
     * @param name String Organizations Name
     * @param editInfo EditInfo Organizations Edit Info
     */
    public OrganizationsDAO(long id, long idWallet, String name
                    , EditInfo editInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Organizations Identifier
        setId(id);
        // Set Organizations Wallet Identifier
        setIdWallet(idWallet);
        // Set Organizations Name
        setName(name);
        // Set Organizations Edit Info
        setEditInfo(editInfo);
    }


    /**
     * Organization Bean Field Constructor
     * @param id long Organizations Identifier
     * @param idWallet long Organizations Wallet Identifier
     * @param name String Organizations Name
     * @param logo Image Organizations Logo
     * @param editInfo EditInfo Organizations Edit Info
     */
    public OrganizationsDAO(long id, long idWallet, String name
                    , Image logo, EditInfo editInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Organizations Identifier
        setId(id);
        // Set Organizations Wallet Identifier
        setIdWallet(idWallet);
        // Set Organizations Name
        setName(name);
        // Set Organizations Logo
        setLogo(logo);
        // Set Organizations Edit Info
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
     * Get Organizations Identifier
     * @return long Organizations Identifier
     */
    public long getId() {
        return this.id;
    }


    /**
     * Get Organizations Wallet Identifier
     * @return long Organizations Wallet Identifier
     */
    public long getIdWallet() {
        return this.idWallet;
    }


    /**
     * Get Organizations Name
     * @return String Organizations Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get Organizations Logo
     * @return Image Organizations Logo
     */
    public Image getLogo() {
        return this.logo;
    }


    /**
     * Get Organizations Edit Info
     * @return EditInfo Organizations Edit Info
     */
    public EditInfo getEditInfo() {
        return this.editInfo;
    }



	// SETTERS -----------------------------------------------------------------


    /**
     * Set Organizations Identifier
     * @param id long Organizations Identifier
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Set Organizations Wallet Identifier
     * @param idWallet long Organizations Wallet Identifier
     */
    public void setIdWallet(long idWallet) {
        this.idWallet = idWallet;
    }


    /**
     * Set Organizations Name
     * @param name String Organizations Name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set Organizations Logo
     * @param logo Image Organizations Logo
     */
    public void setLogo(Image logo) {
        this.logo = logo;
    }


    /**
     * Set Organizations Edit Info
     * @param editInfo EditInfo Organizations Edit Info
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
    	return "ORGANIZATIONS";
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
    	return "INSERT INTO ORGANIZATIONS (`ID_WALLET`, `NAME`, `LOGO`, `EDIT_INFO_CREATE_DATE`, `EDIT_INFO_CREATE_USER`, `EDIT_INFO_UPDATE_DATE`, `EDIT_INFO_UPDATE_USER`) values (?, ?, ?, ?, ?, ?, ?)";
    }

    
    /**
     * Gets Insert procedure
     */
    public String getInsertProcedureName() {
    	return "ORGANIZATIONS_PROC(?, ?, ?, ?, ?)";
    }


	// RESULTSETS & STATEMENTS ------------------------------------------------
	    
    
    /**
     * Fills insert fields
     * @param statement
     */
    public void fillStatementFieldsForInsert(CallableStatement statement) throws Exception {
        // Set Organizations Wallet Identifier
        statement.setLong(1, idWallet);
        // Set Organizations Name
        statement.setString(2, StringUtilities.capString(name,100));
        // Check If Null
        if (logo == null) {
            statement.setNull(3, java.sql.Types.VARCHAR);
        } else {
            statement.setString(3, logo.serialize());
        }
        // Check if edit info create date is Null
        if (editInfo.getCreateDate() == null) {
            statement.setNull(4, java.sql.Types.TIMESTAMP);
        } else {
            // Set create date
            statement.setTimestamp(4, editInfo.getCreateDate());
        } 
        // Check if edit info create user is Null
        if (editInfo.getCreateUserId() == null) {
            statement.setNull(5, java.sql.Types.NUMERIC);
        } else {
            // Set create user
            statement.setLong(5, editInfo.getCreateUserId());
        } 
        // Check if edit info update date is Null
        if (editInfo.getUpdateDate() == null) {
            statement.setNull(6, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(6, editInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (editInfo.getUpdateUserId() == null) {
            statement.setNull(7, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(7, editInfo.getUpdateUserId());
        } 
    }


    /**
     * Sets DAO values from a resultset 
     * @param resultset
     */
    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Organizations Identifier
        this.setId(resultset.getLong("ID"));
        // Set Organizations Wallet Identifier
        this.setIdWallet(resultset.getLong("ID_WALLET"));
        // Set Organizations Name
        this.setName(resultset.getString("NAME"));
        // Set Organizations Logo
        this.setLogo(Image.deserialize(resultset.getString("LOGO")));
        // Set Organizations Edit Info
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

    
    // ------------------------------------------------------------------------
    // PARAMETERS CLASSES -----------------------------------------------------
    // ------------------------------------------------------------------------



	// WalletId Parameters Class -----------------------------------------------


	/**
	 * WalletId
	 */
	public class WalletIdParameters extends DAOParameters {

		
		// Properties .........................................................

		
        // Organizations Wallet Identifier
        private long idWallet;
        

		// Constructors .......................................................

		
		public WalletIdParameters(long idWallet) {
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