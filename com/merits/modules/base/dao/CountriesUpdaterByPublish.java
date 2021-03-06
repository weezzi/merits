package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;


/**
 * <b>Title: </b>Country Updater Object<br/>
 * <b>Description: </b>Country Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class CountriesUpdaterByPublish implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private PublishInfo publishInfo;
    private UpdateInfo _updateInfo;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public CountriesUpdaterByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) {
        this.id = id;
        this.publishInfo = publishInfo;
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
		return "UPDATE COUNTRIES " +
               " SET PUBLISH_INFO_DATE  = ? , PUBLISH_INFO_USER  = ? , EDIT_INFO_UPDATE_DATE  = ? , EDIT_INFO_UPDATE_USER  = ?  " +
               " WHERE  ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        // Check if publish info is null
        if (publishInfo != null) {
            // Check if publish info create date is Null
            if (publishInfo.getPublishDate() == null) {
                statement.setNull(1, java.sql.Types.TIMESTAMP);
            } else {
                // Set publish date
                statement.setTimestamp(1,  publishInfo.getPublishDate());
            } 
            // Check if publish info create user is Null
            if (publishInfo.getPublishUserId() == null) {
                statement.setNull(2, java.sql.Types.NUMERIC);
            } else {
                // Set publish user
                statement.setLong(2, publishInfo.getPublishUserId());
            } 
        } else {
            statement.setNull(1, java.sql.Types.TIMESTAMP);
            statement.setNull(2, java.sql.Types.NUMERIC);
        }
        // Check if edit info update date is Null
        if (_updateInfo.getUpdateDate() == null) {
            statement.setNull(3, java.sql.Types.TIMESTAMP);
        } else {
            // Set update date
            statement.setTimestamp(3,  _updateInfo.getUpdateDate());
        } 
        // Check if edit info update user is Null
        if (_updateInfo.getUpdateUserId() == null) {
            statement.setNull(4, java.sql.Types.NUMERIC);
        } else {
            // Set update user
            statement.setLong(4, _updateInfo.getUpdateUserId());
        } 
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
