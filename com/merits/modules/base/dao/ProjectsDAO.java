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
 * <b>Title: </b>Project Data Access Object<br/>
 * <b>Description: </b>Project DAO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
public class ProjectsDAO extends SingleRecordDAO {


	// CONSTANTS --------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "D17#";
	private static final long serialVersionUID = 1l;


    // MULTI-LANGUAGE ---------------------------------------------------------


    /**
     *  Multi-Language
     */
    public enum MultiLanguageFields {
        Name("SMALL_TEXT1"),
        Headline("MEDIUM_TEXT1"),
        Description("LARGE_TEXT1"),
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

    // Projects Identifier
    private long id;
    // Projects Name
    private String name;
    // Projects Headline
    private String headline;
    // Projects Description
    private String description;
    // Projects Has Donations
    private boolean hasDonations;
    // Projects Has Volunteers
    private boolean hasVolunteers;
    // Projects Volunteers Actual
    private long volunteersActual;
    // Projects Volunteers Wanted
    private long volunteersWanted;
    // Projects Donations Actual
    private long donationsActual;
    // Projects Donations Wanted
    private long donationsWanted;
    // Projects Photo
    private Image photo;
    // Projects Images List
    private ImageList imagesList;
    // Projects Publish Info
    private PublishInfo publishInfo;
    // Projects Edit Info
    private EditInfo editInfo;
    // Projects Order Number
    private long orderNumber;
    // Projects Trashable
    private TrashableInfo trashable;
    // Multilanguage identifier
    private long multilangKeyId;
    // Multilanguage Translated Languages
    private String multilangKeyTranslations;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public ProjectsDAO() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}


	/**
	 * Type Constructor
	 **/
	public ProjectsDAO(SearchType type) {
        // Set DAO Search type
        this.setSearchType(type);
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
	}
	
	
    /**
     * Project Bean Field Constructor
     * @param id long Projects Identifier
     */
    public ProjectsDAO(long id) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Projects Identifier
        setId(id);
    }


    /**
     * Project Bean Field Constructor
     * @param id long Projects Identifier
     * @param name String Projects Name
     * @param headline String Projects Headline
     * @param description String Projects Description
     * @param hasDonations boolean Projects Has Donations
     * @param hasVolunteers boolean Projects Has Volunteers
     * @param volunteersActual long Projects Volunteers Actual
     * @param volunteersWanted long Projects Volunteers Wanted
     * @param donationsActual long Projects Donations Actual
     * @param donationsWanted long Projects Donations Wanted
     * @param publishInfo PublishInfo Projects Publish Info
     * @param editInfo EditInfo Projects Edit Info
     * @param trashable TrashableInfo Projects Trashable
     */
    public ProjectsDAO(long id, String name, String headline
                    , String description, boolean hasDonations, boolean hasVolunteers
                    , long volunteersActual, long volunteersWanted, long donationsActual
                    , long donationsWanted, PublishInfo publishInfo, EditInfo editInfo
                    , TrashableInfo trashable) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Projects Identifier
        setId(id);
        // Set Projects Name
        setName(name);
        // Set Projects Headline
        setHeadline(headline);
        // Set Projects Description
        setDescription(description);
        // Set Projects Has Donations
        setHasDonations(hasDonations);
        // Set Projects Has Volunteers
        setHasVolunteers(hasVolunteers);
        // Set Projects Volunteers Actual
        setVolunteersActual(volunteersActual);
        // Set Projects Volunteers Wanted
        setVolunteersWanted(volunteersWanted);
        // Set Projects Donations Actual
        setDonationsActual(donationsActual);
        // Set Projects Donations Wanted
        setDonationsWanted(donationsWanted);
        // Set Projects Publish Info
        setPublishInfo(publishInfo);
        // Set Projects Edit Info
        setEditInfo(editInfo);
        // Set Projects Trashable
        setTrashable(trashable);
    }


    /**
     * Project Bean Field Constructor
     * @param id long Projects Identifier
     * @param name String Projects Name
     * @param headline String Projects Headline
     * @param description String Projects Description
     * @param hasDonations boolean Projects Has Donations
     * @param hasVolunteers boolean Projects Has Volunteers
     * @param volunteersActual long Projects Volunteers Actual
     * @param volunteersWanted long Projects Volunteers Wanted
     * @param donationsActual long Projects Donations Actual
     * @param donationsWanted long Projects Donations Wanted
     * @param photo Image Projects Photo
     * @param imagesList ImageList Projects Images List
     * @param publishInfo PublishInfo Projects Publish Info
     * @param editInfo EditInfo Projects Edit Info
     * @param trashable TrashableInfo Projects Trashable
     */
    public ProjectsDAO(long id, String name, String headline
                    , String description, boolean hasDonations, boolean hasVolunteers
                    , long volunteersActual, long volunteersWanted, long donationsActual
                    , long donationsWanted, Image photo, ImageList imagesList
                    , PublishInfo publishInfo, EditInfo editInfo, TrashableInfo trashable) {
        // Set cache object type
        this.setCacheObjectType(WeezziCacheObjectType.SingleRecord);
        // Set Projects Identifier
        setId(id);
        // Set Projects Name
        setName(name);
        // Set Projects Headline
        setHeadline(headline);
        // Set Projects Description
        setDescription(description);
        // Set Projects Has Donations
        setHasDonations(hasDonations);
        // Set Projects Has Volunteers
        setHasVolunteers(hasVolunteers);
        // Set Projects Volunteers Actual
        setVolunteersActual(volunteersActual);
        // Set Projects Volunteers Wanted
        setVolunteersWanted(volunteersWanted);
        // Set Projects Donations Actual
        setDonationsActual(donationsActual);
        // Set Projects Donations Wanted
        setDonationsWanted(donationsWanted);
        // Set Projects Photo
        setPhoto(photo);
        // Set Projects Images List
        setImagesList(imagesList);
        // Set Projects Publish Info
        setPublishInfo(publishInfo);
        // Set Projects Edit Info
        setEditInfo(editInfo);
        // Set Projects Trashable
        setTrashable(trashable);
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
     * Get Projects Identifier
     * @return long Projects Identifier
     */
    public long getId() {
        return this.id;
    }


    /**
     * Get Projects Name
     * @return String Projects Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Get Projects Headline
     * @return String Projects Headline
     */
    public String getHeadline() {
        return this.headline;
    }


    /**
     * Get Projects Description
     * @return String Projects Description
     */
    public String getDescription() {
        return this.description;
    }


    /**
     * Get Projects Has Donations
     * @return boolean Projects Has Donations
     */
    public boolean getHasDonations() {
        return this.hasDonations;
    }


    /**
     * Get Projects Has Volunteers
     * @return boolean Projects Has Volunteers
     */
    public boolean getHasVolunteers() {
        return this.hasVolunteers;
    }


    /**
     * Get Projects Volunteers Actual
     * @return long Projects Volunteers Actual
     */
    public long getVolunteersActual() {
        return this.volunteersActual;
    }


    /**
     * Get Projects Volunteers Wanted
     * @return long Projects Volunteers Wanted
     */
    public long getVolunteersWanted() {
        return this.volunteersWanted;
    }


    /**
     * Get Projects Donations Actual
     * @return long Projects Donations Actual
     */
    public long getDonationsActual() {
        return this.donationsActual;
    }


    /**
     * Get Projects Donations Wanted
     * @return long Projects Donations Wanted
     */
    public long getDonationsWanted() {
        return this.donationsWanted;
    }


    /**
     * Get Projects Photo
     * @return Image Projects Photo
     */
    public Image getPhoto() {
        return this.photo;
    }


    /**
     * Get Projects Images List
     * @return ImageList Projects Images List
     */
    public ImageList getImagesList() {
        return this.imagesList;
    }


    /**
     * Get Projects Publish Info
     * @return PublishInfo Projects Publish Info
     */
    public PublishInfo getPublishInfo() {
        return this.publishInfo;
    }


    /**
     * Get Projects Edit Info
     * @return EditInfo Projects Edit Info
     */
    public EditInfo getEditInfo() {
        return this.editInfo;
    }


    /**
     * Get Projects Order Number
     * @return long Projects Order Number
     */
    public long getOrderNumber() {
        return this.orderNumber;
    }


    /**
     * Get Projects Trashable
     * @return TrashableInfo Projects Trashable
     */
    public TrashableInfo getTrashable() {
        return this.trashable;
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
     * Set Projects Identifier
     * @param id long Projects Identifier
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Set Projects Name
     * @param name String Projects Name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set Projects Headline
     * @param headline String Projects Headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }


    /**
     * Set Projects Description
     * @param description String Projects Description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Set Projects Has Donations
     * @param hasDonations boolean Projects Has Donations
     */
    public void setHasDonations(boolean hasDonations) {
        this.hasDonations = hasDonations;
    }


    /**
     * Set Projects Has Volunteers
     * @param hasVolunteers boolean Projects Has Volunteers
     */
    public void setHasVolunteers(boolean hasVolunteers) {
        this.hasVolunteers = hasVolunteers;
    }


    /**
     * Set Projects Volunteers Actual
     * @param volunteersActual long Projects Volunteers Actual
     */
    public void setVolunteersActual(long volunteersActual) {
        this.volunteersActual = volunteersActual;
    }


    /**
     * Set Projects Volunteers Wanted
     * @param volunteersWanted long Projects Volunteers Wanted
     */
    public void setVolunteersWanted(long volunteersWanted) {
        this.volunteersWanted = volunteersWanted;
    }


    /**
     * Set Projects Donations Actual
     * @param donationsActual long Projects Donations Actual
     */
    public void setDonationsActual(long donationsActual) {
        this.donationsActual = donationsActual;
    }


    /**
     * Set Projects Donations Wanted
     * @param donationsWanted long Projects Donations Wanted
     */
    public void setDonationsWanted(long donationsWanted) {
        this.donationsWanted = donationsWanted;
    }


    /**
     * Set Projects Photo
     * @param photo Image Projects Photo
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }


    /**
     * Set Projects Images List
     * @param imagesList ImageList Projects Images List
     */
    public void setImagesList(ImageList imagesList) {
        this.imagesList = imagesList;
    }


    /**
     * Set Projects Publish Info
     * @param publishInfo PublishInfo Projects Publish Info
     */
    public void setPublishInfo(PublishInfo publishInfo) {
        this.publishInfo = publishInfo;
    }


    /**
     * Set Projects Edit Info
     * @param editInfo EditInfo Projects Edit Info
     */
    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }


    /**
     * Set Projects Order Number
     * @param orderNumber long Projects Order Number
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }


    /**
     * Set Projects Trashable
     * @param trashable TrashableInfo Projects Trashable
     */
    public void setTrashable(TrashableInfo trashable) {
        this.trashable = trashable;
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
        return new MultiLanguageFields[] {MultiLanguageFields.Name, MultiLanguageFields.Headline, MultiLanguageFields.Description};
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
    	return "PROJECTS";
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
    	return "INSERT INTO PROJECTS (`HAS_DONATIONS`, `HAS_VOLUNTEERS`, `VOLUNTEERS_ACTUAL`, `VOLUNTEERS_WANTED`, `DONATIONS_ACTUAL`, `DONATIONS_WANTED`, `PHOTO`, `IMAGES_LIST`, `PUBLISH_INFO_DATE`, `PUBLISH_INFO_USER`, `EDIT_INFO_CREATE_DATE`, `EDIT_INFO_CREATE_USER`, `EDIT_INFO_UPDATE_DATE`, `EDIT_INFO_UPDATE_USER`, `ORDER_NUMBER`, `TRASHABLE_IN_TRASH`, `TRASHABLE_IN_USE`, `TRASHABLE_DELETED`, `MLK_ID`, `MLK_LANGS`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT coalesce(MAX(ORDER_NUMBER) + 1,1) FROM (SELECT ORDER_NUMBER FROM PROJECTS) AS SUBQRY), ?, ?, ?, ?, ?)";
    }

    
    /**
     * Gets Insert procedure
     */
    public String getInsertProcedureName() {
    	return "PROJECTS_PROC(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }


	// RESULTSETS & STATEMENTS ------------------------------------------------
	    
    
    /**
     * Fills insert fields
     * @param statement
     */
    public void fillStatementFieldsForInsert(CallableStatement statement) throws Exception {
        // Set Projects Has Donations
        statement.setBoolean(1, hasDonations);
        // Set Projects Has Volunteers
        statement.setBoolean(2, hasVolunteers);
        // Set Projects Volunteers Actual
        statement.setLong(3, volunteersActual);
        // Set Projects Volunteers Wanted
        statement.setLong(4, volunteersWanted);
        // Set Projects Donations Actual
        statement.setLong(5, donationsActual);
        // Set Projects Donations Wanted
        statement.setLong(6, donationsWanted);
        // Check If Null
        if (photo == null) {
            statement.setNull(7, java.sql.Types.VARCHAR);
        } else {
            statement.setString(7, photo.serialize());
        }
        // Check If Null
        if (imagesList == null) {
            statement.setNull(8, java.sql.Types.VARCHAR);
        } else {
            statement.setString(8, imagesList.serialize());
        }
        // Check if publish info is not null
        if (publishInfo != null) {
            // Check if publish info create date is Null
            if (publishInfo.getPublishDate() == null) {
                statement.setNull(9, java.sql.Types.TIMESTAMP);
            } else {
                // Set publish date
                statement.setTimestamp(9, publishInfo.getPublishDate());
            } 
            // Check if publish info create user is Null
                if (publishInfo.getPublishUserId() == null) {
                statement.setNull(10, java.sql.Types.NUMERIC);
            } else {
                // Set publish user
                statement.setLong(10, publishInfo.getPublishUserId());
            } 
        } else {
            statement.setNull(9, java.sql.Types.TIMESTAMP);
            statement.setNull(10, java.sql.Types.NUMERIC);
        }
        // Check if edit info create date is Null
        if (editInfo.getCreateDate() == null) {
            statement.setNull(11, java.sql.Types.TIMESTAMP);
        } else {
            // Set create date
            statement.setTimestamp(11, editInfo.getCreateDate());
        } 
        // Check if edit info create user is Null
        if (editInfo.getCreateUserId() == null) {
            statement.setNull(12, java.sql.Types.NUMERIC);
        } else {
            // Set create user
            statement.setLong(12, editInfo.getCreateUserId());
        } 
        // Check if edit info update date is Null
        if (editInfo.getUpdateDate() == null) {
            statement.setNull(13, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(13, editInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (editInfo.getUpdateUserId() == null) {
            statement.setNull(14, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(14, editInfo.getUpdateUserId());
        } 
        // Check if trashable info is not null
        if (trashable == null) {
            statement.setNull(15, java.sql.Types.NUMERIC);
            statement.setNull(16, java.sql.Types.NUMERIC);
            statement.setNull(17, java.sql.Types.NUMERIC);
        } else {
            statement.setBoolean(15, trashable.isInTrash());
            statement.setBoolean(16, trashable.isInUse());
            statement.setBoolean(17, trashable.isDeleted());
        } 
        // Set Multilanguage key
        statement.setLong(18, multilangKeyId);
        // Set Multilanguage Translations
        statement.setString(19, multilangKeyTranslations);
    }


    /**
     * Sets DAO values from a resultset 
     * @param resultset
     */
    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Projects Identifier
        this.setId(resultset.getLong("ID"));
        this.setName(resultset.getString("NAME"));
        this.setHeadline(resultset.getString("HEADLINE"));
        this.setDescription(resultset.getString("DESCRIPTION"));
        // Set Projects Has Donations
        this.setHasDonations(resultset.getBoolean("HAS_DONATIONS"));
        // Set Projects Has Volunteers
        this.setHasVolunteers(resultset.getBoolean("HAS_VOLUNTEERS"));
        // Set Projects Volunteers Actual
        this.setVolunteersActual(resultset.getLong("VOLUNTEERS_ACTUAL"));
        // Set Projects Volunteers Wanted
        this.setVolunteersWanted(resultset.getLong("VOLUNTEERS_WANTED"));
        // Set Projects Donations Actual
        this.setDonationsActual(resultset.getLong("DONATIONS_ACTUAL"));
        // Set Projects Donations Wanted
        this.setDonationsWanted(resultset.getLong("DONATIONS_WANTED"));
        // Set Projects Photo
        this.setPhoto(Image.deserialize(resultset.getString("PHOTO")));
        // Set Projects Images List
        this.setImagesList(ImageList.deserialize(resultset.getString("IMAGES_LIST")));
        // Set Projects Publish Info
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
        // Set Projects Edit Info
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
        // Set Projects Order Number
        this.setOrderNumber(resultset.getLong("ORDER_NUMBER"));
        // Set Projects Trashable
        this.trashable = new TrashableInfo();
        trashable.setInTrash(resultset.getBoolean("TRASHABLE_IN_TRASH"));
        trashable.setInUse(resultset.getBoolean("TRASHABLE_IN_USE"));
        trashable.setDeleted(resultset.getBoolean("TRASHABLE_DELETED"));
        // Set Projects Multi Lang Key Id
        this.setMultiLangKeyId(resultset.getLong("MLK_ID"));
        // Set Projects Multi Lang Key Translations
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
