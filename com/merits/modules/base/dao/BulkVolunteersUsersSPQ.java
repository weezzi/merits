package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.dbmanager.dao.BulkDAO;
import com.weezzi.core.dbmanager.dao.DAOParameters;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.merits.modules.base.dao.VolunteersUsersSPQ;

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

public class BulkVolunteersUsersSPQ extends BulkDAO {


	// CONSTANTS ---------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "BS3_1#";
	private static final long serialVersionUID = 1L;


    // PROPERTIES --------------------------------------------------------------


    // Volunteer Bulk DTO Data Vector
    public Vector<VolunteersUsersSPQ> data;


    // CONSTRUCTORS ------------------------------------------------------------


    /**
     * Bulk DAO Special Query Constructor
     * @param idWallet Object Volunteers Wallet Identifier RelationShip Field
     */
    public BulkVolunteersUsersSPQ() {
        // Set Cache Object Type
        this.setCacheObjectType(WeezziCacheObjectType.SpecialQuery);
        this.data = new Vector<VolunteersUsersSPQ>();
        this.setBlockSize(100);
    }


    // PUBLIC ------------------------------------------------------------------


    /**
     * Adds a Volunteer DAO to the data
     * @param volunteers VolunteersUsersSPQ Volunteer DAO
     */
    public void add(VolunteersUsersSPQ volunteers) {
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
    	VolunteersUsersSPQ dto;
    	// Create DTO
    	dto = new VolunteersUsersSPQ();
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
     * @return VolunteersUsersSPQ Volunteer data transfer data object
     */
    public VolunteersUsersSPQ get(int index) {
        // Gets one Volunteer from the bulk data
        return data.get(index);
    }


    /**
     * Gets all data as an array
     * @return VolunteersUsersSPQ[] Volunteer DTO array
     */
    public VolunteersUsersSPQ[] getArray() {
        // Local variables
        VolunteersUsersSPQ[] array = new VolunteersUsersSPQ[data.size()];
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




	// Users Parameters Class -----------------------------------------------


	/**
	 * Users
	 */
	public class Parameters extends DAOParameters {

		
		// Properties .........................................................

		
        // Volunteers Search
        private String search;
        

		// Constructors .......................................................

		
		public Parameters(String search) {
            this.search = search;
		}


        // DAO Parameters .....................................................


        /**
         * Gets the search fields
         * @return
         */
		public Object[] getSearchFields() {
			// Local Variables
			return new Object[] {search};
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
