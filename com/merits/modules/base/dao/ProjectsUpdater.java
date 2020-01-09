package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;


/**
 * <b>Title: </b>Project Updater Object<br/>
 * <b>Description: </b>Project Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class ProjectsUpdater implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private String name;
    private String headline;
    private String description;
    private boolean hasDonations;
    private boolean hasVolunteers;
    private long volunteersActual;
    private long volunteersWanted;
    private long donationsActual;
    private long donationsWanted;
    private Image photo;
    private ImageList imagesList;
    private PublishInfo publishInfo;
    private EditInfo editInfo;
    private long orderNumber;
    private TrashableInfo trashable;
    private String langCode;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public ProjectsUpdater(long id, String name, String headline, String description, boolean hasDonations, boolean hasVolunteers, long volunteersActual, long volunteersWanted, long donationsActual, long donationsWanted, Image photo, ImageList imagesList, PublishInfo publishInfo, TrashableInfo trashable, String langCode, UpdateInfo updateInfo) {
        this.id = id;
        this.name = name;
        this.headline = headline;
        this.description = description;
        this.hasDonations = hasDonations;
        this.hasVolunteers = hasVolunteers;
        this.volunteersActual = volunteersActual;
        this.volunteersWanted = volunteersWanted;
        this.donationsActual = donationsActual;
        this.donationsWanted = donationsWanted;
        this.photo = photo;
        this.imagesList = imagesList;
        this.publishInfo = publishInfo;
        this.editInfo = editInfo;
        this.orderNumber = orderNumber;
        this.trashable = trashable;
        this.langCode = langCode;
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
		return "UPDATE PROJECTS, `weezziserver`.`MULTILANG_TRANSLATIONS` " +
               " SET `weezziserver`.MULTILANG_TRANSLATIONS.SMALL_TEXT1 = ? , `weezziserver`.MULTILANG_TRANSLATIONS.MEDIUM_TEXT1 = ? , `weezziserver`.MULTILANG_TRANSLATIONS.LARGE_TEXT1 = ? , HAS_DONATIONS = ? , HAS_VOLUNTEERS = ? , VOLUNTEERS_ACTUAL = ? , VOLUNTEERS_WANTED = ? , DONATIONS_ACTUAL = ? , DONATIONS_WANTED = ? , PHOTO = ? , IMAGES_LIST = ? , PUBLISH_INFO_DATE  = ? , PUBLISH_INFO_USER  = ? , ORDER_NUMBER = ? , TRASHABLE_IN_TRASH  = ? , TRASHABLE_IN_USE  = ? , TRASHABLE_DELETED  = ? , EDIT_INFO_UPDATE_DATE  = ? , EDIT_INFO_UPDATE_USER  = ?  " +
               " WHERE PROJECTS.MLK_ID = `weezziserver`.MULTILANG_TRANSLATIONS.ID_MLK AND `weezziserver`.MULTILANG_TRANSLATIONS.LANG_CODE = ? AND PROJECTS.ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        statement.setString(1, name);
        statement.setString(2, headline);
        statement.setString(3, description);
        statement.setBoolean(4, hasDonations);
        statement.setBoolean(5, hasVolunteers);
        statement.setLong(6, volunteersActual);
        statement.setLong(7, volunteersWanted);
        statement.setLong(8, donationsActual);
        statement.setLong(9, donationsWanted);
        // Check If Null
        if (photo == null) {
            statement.setNull(10, java.sql.Types.VARCHAR);
        } else {
            statement.setString(10, photo.serialize());
        }
        // Check If Null
        if (imagesList == null) {
            statement.setNull(11, java.sql.Types.VARCHAR);
        } else {
            statement.setString(11, imagesList.serialize());
        }
        // Check if publish info is null
        if (publishInfo != null) {
            // Check if publish info create date is Null
            if (publishInfo.getPublishDate() == null) {
                statement.setNull(12, java.sql.Types.TIMESTAMP);
            } else {
                // Set publish date
                statement.setTimestamp(12,  publishInfo.getPublishDate());
            } 
            // Check if publish info create user is Null
            if (publishInfo.getPublishUserId() == null) {
                statement.setNull(13, java.sql.Types.NUMERIC);
            } else {
                // Set publish user
                statement.setLong(13, publishInfo.getPublishUserId());
            } 
        } else {
            statement.setNull(12, java.sql.Types.TIMESTAMP);
            statement.setNull(13, java.sql.Types.NUMERIC);
        }
        // Check if edit info create date is Null
        if (editInfo.getCreateDate() == null) {
            statement.setNull(14, java.sql.Types.TIMESTAMP);
        } else {
            // Set create date
            statement.setTimestamp(14,  editInfo.getCreateDate());
        } 
        // Check if edit info create user is Null
        if (editInfo.getCreateUserId() == null) {
            statement.setNull(15, java.sql.Types.NUMERIC);
        } else {
            // Set create user
            statement.setLong(15, editInfo.getCreateUserId());
        } 
        // Check if edit info update date is Null
        if (editInfo.getUpdateDate() == null) {
            statement.setNull(16, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(16,  editInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (editInfo.getUpdateUserId() == null) {
            statement.setNull(17, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(17, editInfo.getUpdateUserId());
        } 
        statement.setLong(18, orderNumber);
        // Check if trashable info is not null
        if (trashable == null) {
            statement.setNull(19, java.sql.Types.NUMERIC);
            statement.setNull(20, java.sql.Types.NUMERIC);
            statement.setNull(21, java.sql.Types.NUMERIC);
        } else {
            statement.setBoolean(19, trashable.isInTrash());
            statement.setBoolean(20, trashable.isInUse());
            statement.setBoolean(21, trashable.isDeleted());
        } 
        // Set multilang language code
        statement.setString(22, langCode);
        statement.setLong(23, id);
	}


	/**
	 * Gets extended update SQL
	 * @return query
	 */
	public String getExtendedQuerySQL() {
		return " UPDATE PROJECTS SET MLK_LANGS = (" + 
                "SELECT group_concat(lang_code) FROM (SELECT MLK_ID FROM PROJECTS WHERE ID=?) AS TEMP, `weezziserver`.multilang_translations " + 
                "WHERE `weezziserver`.multilang_translations.id_mlk= TEMP.MLK_ID " + 
                    "AND length(`weezziserver`.multilang_translations.SMALL_TEXT1) > 0 " + 
                    "AND length(`weezziserver`.multilang_translations.MEDIUM_TEXT1) > 0 " + 
                    "AND length(`weezziserver`.multilang_translations.LARGE_TEXT1) > 0 " + 
                ") WHERE ID = ?";
	}
	
	
	/**
	 * Updates Extended Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateExtendedQueryFields(CallableStatement statement) throws Exception {
        statement.setLong(1, id);
        statement.setLong(2, id);
	}
	
	
}