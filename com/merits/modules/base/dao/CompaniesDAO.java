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
 * <b>Title: </b>Company Data Access Object<br/>
 * <b>Description: </b>Company DAO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
public class CompaniesDAO extends SingleRecordDAO {


	// CONSTANTS --------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "D16#";
	private static final long serialVersionUID = 1l;


    // MULTI-LANGUAGE ---------------------------------------------------------


    /**
     *  Multi-Language
     */
    public enum MultiLanguageFields {
        Description("MEDIUM_TEXT1"),
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

    // Companies Identifier
    private long id;
    // Companies Name
    private String name;
    // Companies Description
    private String description;
    // Companies Photo
    private Image photo;
    // Companies Url
    private String url;
    // Companies Edit Info
    private EditInfo editInfo;
    // Companies Publish Info
    private PublishInfo publishInfo;
    // Companies Order Number
    private long orderNumber;
    // Multilanguage identifier
    private long multilangKeyId;
    // Multilanguage Translated Languages
    private String multilangKeyTranslations;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public CompaniesDAO() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}


	/**
	 * Type Constructor
	 **/
	public CompaniesDAO(SearchType type) {
        // Set DAO Search type
        this.setSearchType(type);
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}
	
	
    /**
     * Company Bean Field Constructor
     * @param id long Companies Identifier
     */
    public CompaniesDAO(long id) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Companies Identifier
        setId(id);
    }


    /**
     * Company Bean Field Constructor
     * @param id long Companies Identifier
     * @param name String Companies Name
     * @param description String Companies Description
     * @param editInfo EditInfo Companies Edit Info
     * @param publishInfo PublishInfo Companies Publish Info
     */
    public CompaniesDAO(long id, String name, String description
                    , EditInfo editInfo, PublishInfo publishInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Companies Identifier
        setId(id);
        // Set Companies Name
        setName(name);
        // Set Companies Description
        setDescription(description);
        // Set Companies Edit Info
        setEditInfo(editInfo);
        // Set Companies Publish Info
        setPublishInfo(publishInfo);
    }


    /**
     * Company Bean Field Constructor
     * @param id long Companies Identifier
     * @param name String Companies Name
     * @param description String Companies Description
     * @param photo Image Companies Photo
     * @param url String Companies Url
     * @param editInfo EditInfo Companies Edit Info
     * @param publishInfo PublishInfo Companies Publish Info
     */
    public CompaniesDAO(long id, String name, String description
                    , Image photo, String url, EditInfo editInfo
                    , PublishInfo publishInfo) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Companies Identifier
        setId(id);
        // Set Companies Name
        setName(name);
        // Set Companies Description
        setDescription(description);
        // Set Companies Photo
        setPhoto(photo);
        // Set Companies Url
        setUrl(url);
        // Set Companies Edit Info
        setEditInfo(editInfo);
        // Set Companies Publish Info
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
     * Get Companies Identifier
     * @return long Companies Identifier
     */
    public long getId() {
        return this.id;
    }


    /**
     * Get Companies Name
     * @return String Companies Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get Companies Description
     * @return String Companies Description
     */
    public String getDescription() {
        return this.description;
    }


    /**
     * Get Companies Photo
     * @return Image Companies Photo
     */
    public Image getPhoto() {
        return this.photo;
    }


    /**
     * Get Companies Url
     * @return String Companies Url
     */
    public String getUrl() {
        return this.url;
    }


    /**
     * Get Companies Edit Info
     * @return EditInfo Companies Edit Info
     */
    public EditInfo getEditInfo() {
        return this.editInfo;
    }


    /**
     * Get Companies Publish Info
     * @return PublishInfo Companies Publish Info
     */
    public PublishInfo getPublishInfo() {
        return this.publishInfo;
    }


    /**
     * Get Companies Order Number
     * @return long Companies Order Number
     */
    public long getOrderNumber() {
        return this.orderNumber;
    }


    /**
     * Get Multi-Language Identifier
     * @return long Multi-Language Identifier
     */
    public long getMultiLangKeyId() {
        return this.multilangKeyId;
    }


    /**
     * Get Multi-Language Translated Languages
     * @return long Multi-Language Translated Languages
     */
    public String getMultiLangKeyTranslations() {
        return this.multilangKeyTranslations;
    }



	// SETTERS -----------------------------------------------------------------


    /**
     * Set Companies Identifier
     * @param id long Companies Identifier
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Set Companies Name
     * @param name String Companies Name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set Companies Description
     * @param description String Companies Description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Set Companies Photo
     * @param photo Image Companies Photo
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }


    /**
     * Set Companies Url
     * @param url String Companies Url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * Set Companies Edit Info
     * @param editInfo EditInfo Companies Edit Info
     */
    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }


    /**
     * Set Companies Publish Info
     * @param publishInfo PublishInfo Companies Publish Info
     */
    public void setPublishInfo(PublishInfo publishInfo) {
        this.publishInfo = publishInfo;
    }


    /**
     * Set Companies Order Number
     * @param orderNumber long Companies Order Number
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }


    /**
     * Set Multi Language Identifier
     * @return long Multi Language Identifier
     */
    public void setMultiLangKeyId(long multilangKeyId) {
        this.multilangKeyId = multilangKeyId;
    }


    /**
     * Set Multi Language Translated Languages
     * @return String Multi Language Translated Languages
     */
    public void setMultiLangKeyTranslations(String languages) {
        this.multilangKeyTranslations = languages;
    }



    // MULTI-LANGUAGE ---------------------------------------------------------


    /**
     * Gets the default non-nullable multi-language fields
     * @return
     **/
    public MultiLanguageFields[] getMultiLangKeyDefaultTranslationFields() {
        return new MultiLanguageFields[] {MultiLanguageFields.Description};
    }


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
    	return "COMPANIES";
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
    	return "INSERT INTO COMPANIES (`NAME`, `PHOTO`, `URL`, `EDIT_INFO_CREATE_DATE`, `EDIT_INFO_CREATE_USER`, `EDIT_INFO_UPDATE_DATE`, `EDIT_INFO_UPDATE_USER`, `PUBLISH_INFO_DATE`, `PUBLISH_INFO_USER`, `ORDER_NUMBER`, `MLK_ID`, `MLK_LANGS`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT coalesce(MAX(ORDER_NUMBER) + 1,1) FROM (SELECT ORDER_NUMBER FROM COMPANIES) AS SUBQRY), ?, ?)";
    }

    
    /**
     * Gets Insert procedure
     */
    public String getInsertProcedureName() {
    	return "COMPANIES_PROC(?, ?, ?, ?, ?, ?, ?)";
    }


	// RESULTSETS & STATEMENTS ------------------------------------------------
	    
    
    /**
     * Fills insert fields
     * @param statement
     */
    public void fillStatementFieldsForInsert(CallableStatement statement) throws Exception {
        // Set Companies Name
        statement.setString(1, StringUtilities.capString(name,100));
        // Check If Null
        if (photo == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setString(2, photo.serialize());
        }
        // Check If Companies Url Is Null
        if (url == null) {
            statement.setNull(3, java.sql.Types.VARCHAR);
        } else {
            // Set Companies Url
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
        // Set Multilanguage key
        statement.setLong(10, multilangKeyId);
        // Set Multilanguage Translations
        statement.setString(11, multilangKeyTranslations);
    }


    /**
     * Sets DAO values from a resultset 
     * @param resultset
     */
    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Companies Identifier
        this.setId(resultset.getLong("ID"));
        // Set Companies Name
        this.setName(resultset.getString("NAME"));
        this.setDescription(resultset.getString("DESCRIPTION"));
        // Set Companies Photo
        this.setPhoto(Image.deserialize(resultset.getString("PHOTO")));
        // Set Companies Url
        this.setUrl(resultset.getString("URL"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setUrl(null);
        }
        // Set Companies Edit Info
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
        // Set Companies Publish Info
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
        // Set Companies Order Number
        this.setOrderNumber(resultset.getLong("ORDER_NUMBER"));
        // Set Companies Multi Lang Key Id
        this.setMultiLangKeyId(resultset.getLong("MLK_ID"));
        // Set Companies Multi Lang Key Translations
        this.setMultiLangKeyTranslations(resultset.getString("MLK_LANGS"));
        // Check if was null
        if (resultset.wasNull()) {
            this.setMultiLangKeyTranslations(null);
        }
    }

    
    // ------------------------------------------------------------------------
    // PARAMETERS CLASSES -----------------------------------------------------
    // ------------------------------------------------------------------------


}