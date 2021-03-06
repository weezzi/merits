package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.SingleRecordDAO;
import com.weezzi.utils.StringUtilities;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.weezzi.utils.extras.console.Console;


import java.sql.CallableStatement;
import java.sql.ResultSet;



/**
 * <b>Title: </b>Sponsor Data Access Object<br/>
 * <b>Description: </b>Sponsor DAO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
public class SponsorsDAO extends SingleRecordDAO {


	// CONSTANTS --------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "D15#";
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

    // Sponsors Identifier
    private long id;
    // Sponsors Name
    private String name;
    // Sponsors Photo
    private Image photo;
    // Sponsors Url
    private String url;
    // Sponsors Edit Info
    private EditInfo editInfo;
    // Sponsors Publish Info
    private PublishInfo publishInfo;
    // Sponsors Order Number
    private long orderNumber;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public SponsorsDAO() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}


	/**
	 * Type Constructor
	 **/
	public SponsorsDAO(SearchType type) {
        // Set DAO Search type
        this.setSearchType(type);
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}
	
	
    /**
     * Sponsor Bean Field Constructor
     * @param id long Sponsors Identifier
     */
    public SponsorsDAO(long id) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Sponsors Identifier
        setId(id);
    }


    /**
     * Sponsor Bean Field Constructor
     * @param id long Sponsors Identifier
     * @param name String Sponsors Name
     * @param editInfo EditInfo Sponsors Edit Info
     * @param publishInfo PublishInfo Sponsors Publish Info
     */
    public SponsorsDAO(long id, String name, EditInfo editInfo
                    , PublishInfo publishInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Sponsors Identifier
        setId(id);
        // Set Sponsors Name
        setName(name);
        // Set Sponsors Edit Info
        setEditInfo(editInfo);
        // Set Sponsors Publish Info
        setPublishInfo(publishInfo);
    }


    /**
     * Sponsor Bean Field Constructor
     * @param id long Sponsors Identifier
     * @param name String Sponsors Name
     * @param photo Image Sponsors Photo
     * @param url String Sponsors Url
     * @param editInfo EditInfo Sponsors Edit Info
     * @param publishInfo PublishInfo Sponsors Publish Info
     */
    public SponsorsDAO(long id, String name, Image photo
                    , String url, EditInfo editInfo, PublishInfo publishInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Sponsors Identifier
        setId(id);
        // Set Sponsors Name
        setName(name);
        // Set Sponsors Photo
        setPhoto(photo);
        // Set Sponsors Url
        setUrl(url);
        // Set Sponsors Edit Info
        setEditInfo(editInfo);
        // Set Sponsors Publish Info
        setPublishInfo(publishInfo);
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
     * Get Sponsors Identifier
     * @return long Sponsors Identifier
     */
    public long getId() {
        return this.id;
    }


    /**
     * Get Sponsors Name
     * @return String Sponsors Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get Sponsors Photo
     * @return Image Sponsors Photo
     */
    public Image getPhoto() {
        return this.photo;
    }


    /**
     * Get Sponsors Url
     * @return String Sponsors Url
     */
    public String getUrl() {
        return this.url;
    }


    /**
     * Get Sponsors Edit Info
     * @return EditInfo Sponsors Edit Info
     */
    public EditInfo getEditInfo() {
        return this.editInfo;
    }


    /**
     * Get Sponsors Publish Info
     * @return PublishInfo Sponsors Publish Info
     */
    public PublishInfo getPublishInfo() {
        return this.publishInfo;
    }


    /**
     * Get Sponsors Order Number
     * @return long Sponsors Order Number
     */
    public long getOrderNumber() {
        return this.orderNumber;
    }



	// SETTERS -----------------------------------------------------------------


    /**
     * Set Sponsors Identifier
     * @param id long Sponsors Identifier
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Set Sponsors Name
     * @param name String Sponsors Name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set Sponsors Photo
     * @param photo Image Sponsors Photo
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }


    /**
     * Set Sponsors Url
     * @param url String Sponsors Url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * Set Sponsors Edit Info
     * @param editInfo EditInfo Sponsors Edit Info
     */
    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }


    /**
     * Set Sponsors Publish Info
     * @param publishInfo PublishInfo Sponsors Publish Info
     */
    public void setPublishInfo(PublishInfo publishInfo) {
        this.publishInfo = publishInfo;
    }


    /**
     * Set Sponsors Order Number
     * @param orderNumber long Sponsors Order Number
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
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
    	return "SPONSORS";
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
    	return "INSERT INTO SPONSORS (`NAME`, `PHOTO`, `URL`, `EDIT_INFO_CREATE_DATE`, `EDIT_INFO_CREATE_USER`, `EDIT_INFO_UPDATE_DATE`, `EDIT_INFO_UPDATE_USER`, `PUBLISH_INFO_DATE`, `PUBLISH_INFO_USER`, `ORDER_NUMBER`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT coalesce(MAX(ORDER_NUMBER) + 1,1) FROM (SELECT ORDER_NUMBER FROM SPONSORS) AS SUBQRY))";
    }

    
    /**
     * Gets Insert procedure
     */
    public String getInsertProcedureName() {
    	return "SPONSORS_PROC(?, ?, ?, ?, ?, ?, ?)";
    }


	// RESULTSETS & STATEMENTS ------------------------------------------------
	    
    
    /**
     * Fills insert fields
     * @param statement
     */
    public void fillStatementFieldsForInsert(CallableStatement statement) throws Exception {
        // Set Sponsors Name
        statement.setString(1, StringUtilities.capString(name,100));
        // Check If Null
        if (photo == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setString(2, photo.serialize());
        }
        // Check If Sponsors Url Is Null
        if (url == null) {
            statement.setNull(3, java.sql.Types.VARCHAR);
        } else {
            // Set Sponsors Url
            statement.setString(3, StringUtilities.capString(url,100));
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
        // Check if publish info is not null
        if (publishInfo != null) {
            // Check if publish info create date is Null
            if (publishInfo.getPublishDate() == null) {
                statement.setNull(8, java.sql.Types.TIMESTAMP);
            } else {
                // Set publish date
                statement.setTimestamp(8, publishInfo.getPublishDate());
            } 
            // Check if publish info create user is Null
                if (publishInfo.getPublishUserId() == null) {
                statement.setNull(9, java.sql.Types.NUMERIC);
            } else {
                // Set publish user
                statement.setLong(9, publishInfo.getPublishUserId());
            } 
        } else {
            statement.setNull(8, java.sql.Types.TIMESTAMP);
            statement.setNull(9, java.sql.Types.NUMERIC);
        }
    }


    /**
     * Sets DAO values from a resultset 
     * @param resultset
     */
    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Sponsors Identifier
        this.setId(resultset.getLong("ID"));
        // Set Sponsors Name
        this.setName(resultset.getString("NAME"));
        // Set Sponsors Photo
        this.setPhoto(Image.deserialize(resultset.getString("PHOTO")));
        // Set Sponsors Url
        this.setUrl(resultset.getString("URL"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setUrl(null);
        }
        // Set Sponsors Edit Info
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
        // Set Sponsors Publish Info
        this.publishInfo = new PublishInfo();
        publishInfo.setPublishDate(resultset.getTimestamp("PUBLISH_INFO_DATE"));
        // Check if was null
        if (resultset.wasNull()) {
            publishInfo.setPublishDate(null);
        }
        publishInfo.setPublishUserId(resultset.getLong("PUBLISH_INFO_USER"));
        // Check if was null
        if (resultset.wasNull()) {
            publishInfo.setPublishUserId(null);
        }
        // Set Sponsors Order Number
        this.setOrderNumber(resultset.getLong("ORDER_NUMBER"));
    }

    
    // ------------------------------------------------------------------------
    // PARAMETERS CLASSES -----------------------------------------------------
    // ------------------------------------------------------------------------


}
