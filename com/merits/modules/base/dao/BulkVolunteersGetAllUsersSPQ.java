package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.dbmanager.dao.BulkDAO;
import com.weezzi.core.dbmanager.dao.DAOParameters;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.merits.modules.base.dao.VolunteersGetAllUsersSPQ;

import java.util.Vector;
import java.sql.ResultSet;
import java.util.Collection;


/**
 * <b>Title: </b>Volunteer Bulk Data Transfer Object<br/>
 * <b>Description: </b>Volunteer Bulk DTO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */

public class BulkVolunteersGetAllUsersSPQ extends BulkDAO {


	// CONSTANTS ---------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "BS3_0#";
	private static final long serialVersionUID = 1L;


    // PROPERTIES --------------------------------------------------------------


    // Volunteer Bulk DTO Data Vector
    public Vector<VolunteersGetAllUsersSPQ> data;


    // CONSTRUCTORS ------------------------------------------------------------


    /**
     * Bulk DAO Special Query Constructor
     * @param idWallet Object Volunteers Wallet Identifier RelationShip Field
     */
    public BulkVolunteersGetAllUsersSPQ() {
        // Set Cache Object Type
        this.setCacheObjectType(WeezziCacheObjectType.SpecialQuery);
        this.data = new Vector<VolunteersGetAllUsersSPQ>();
        this.setBlockSize(100);
    }


    // PUBLIC ------------------------------------------------------------------


    /**
     * Adds a Volunteer DAO to the data
     * @param volunteers VolunteersGetAllUsersSPQ Volunteer DAO
     */
    public void add(VolunteersGetAllUsersSPQ volunteers) {
        // Adds Volunteer
        data.add(volunteers);
    }


    /**
     * Adds a Volunteer from a recordset
     * @param rs ResultSet
     * @throws Exception
     */
    public void add(ResultSet rs) throws Exception {
    	// Local Variables
    	VolunteersGetAllUsersSPQ dto;
    	// Create DTO
    	dto = new VolunteersGetAllUsersSPQ();
    	// Fill DTO values
    	dto.fillValuesFromResultSet(rs);
        this.add(dto);
    }


    /**
     * Adds a collection of Volunteer DTO to the list
     * @param Collection Volunteer DTO Collection
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void add(Collection collection) {
        // Adds all collection data
        data.addAll(collection);
    }


    // GETTERS -----------------------------------------------------------------


    /**
     * Gets all Bulk DTO Data
     * @return Vector
     */
    @SuppressWarnings("rawtypes")
    public Vector getAllData() {
        return data;
    }


    /**
     * Gets a particular Volunteer DTO
     * @param index int Volunteer index
     * @return VolunteersGetAllUsersSPQ Volunteer data transfer data object
     */
    public VolunteersGetAllUsersSPQ get(int index) {
        // Gets one Volunteer from the bulk data
        return data.get(index);
    }


    /**
     * Gets all data as an array
     * @return VolunteersGetAllUsersSPQ[] Volunteer DTO array
     */
    public VolunteersGetAllUsersSPQ[] getArray() {
        // Local variables
        VolunteersGetAllUsersSPQ[] array = new VolunteersGetAllUsersSPQ[data.size()];
        // Fill Array
        for (int i=0; i<data.size(); i++) {
            // Fill array value
            array[i] = this.get(i);
        }
        // Return array
        return array;
    }


    /**
     * Gets bulk set data size
     * @return int
     */
    public int getBulkSize() {
        return data.size();
    }


    /**
     * Resets all data in the Bulk DTO
     */
    public void reset() {
        data.clear();
    }


    // CACHING ----------------------------------------------------------------
    
    
	/**
	 * Gets cachePrefix
	 * @return The cachePrefix of this object
	 */
	public String getCachePrefix() {
		return CACHE_PREFIX;
	}


    // DATABASE MANAGER SPECIFIC ----------------------------------------------

    
    /**
     * Gets DB Connection name
     * @return project database connection name;
     */
    public String getDBConnectionName() {
    	return "Merits_Merits";
    }

    
    // ------------------------------------------------------------------------
    // PARAMETERS CLASSES -----------------------------------------------------
    // ------------------------------------------------------------------------




}
