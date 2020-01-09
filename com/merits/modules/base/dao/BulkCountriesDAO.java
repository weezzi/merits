package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.BulkDAO;
import com.weezzi.core.dbmanager.dao.DAOParameters;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;
import com.merits.modules.base.dao.CountriesDAO;

import java.util.Vector;
import java.sql.ResultSet;
import java.util.Collection;


/**
 * <b>Title: </b>Country Bulk Data Transfer Object<br/>
 * <b>Description: </b>Country Bulk DTO Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public class BulkCountriesDAO extends BulkDAO {


	// CONSTANTS ---------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "B12#";
	private static final long serialVersionUID = 1L;


    // DATA TYPE ENUMERATION --------------------------------------------------


    /**
     *  DAO Search Type
     */
    public enum SearchType {

    	// Single Record Queries
        All("Q1"),

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


    // Country Bulk DTO Data Vector
    public Vector<CountriesDAO> data;


    // CONSTRUCTORS ------------------------------------------------------------


    /**
     * Bulk DTO Search Constructor
     * @param type Type Bulk DAO Query Type
     */
    public BulkCountriesDAO(SearchType searchType) {
        // Set Cache Object Type
        this.setCacheObjectType(WeezziCacheObjectType.Query);
        // Set Bulk DAO search type
        this.setSearchType(searchType);
        this.data = new Vector<CountriesDAO>();
    }


    // PUBLIC ------------------------------------------------------------------


    /**
     * Adds a Country DAO to the data
     * @param countries CountriesDAO Country DAO
     */
    public void add(CountriesDAO countries) {
        // Adds Country
        data.add(countries);
    }


    /**
     * Adds a Country from a recordset
     * @param rs ResultSet
     * @throws Exception
     */
    public void add(ResultSet rs) throws Exception {
    	// Local Variables
    	CountriesDAO dto;
    	// Create DTO
    	dto = new CountriesDAO();
    	// Fill DTO values
    	dto.fillValuesFromResultSet(rs);
        this.add(dto);
    }


    /**
     * Adds a collection of Country DTO to the list
     * @param Collection Country DTO Collection
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Vector getAllData() {
        return data;
    }


    /**
     * Gets a particular Country DTO
     * @param index int Country index
     * @return CountriesDAO Country data transfer data object
     */
    public CountriesDAO get(int index) {
        // Gets one Country from the bulk data
        return data.get(index);
    }


    /**
     * Gets all data as an array
     * @return CountriesDAO[] Country DTO array
     */
    public CountriesDAO[] getArray() {
        // Local variables
        CountriesDAO[] array = new CountriesDAO[data.size()];
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




	// All Parameters Class -----------------------------------------------


	/**
	 * All
	 */
	public class AllParameters extends DAOParameters {

		
		// Properties .........................................................

		
        

		// Constructors .......................................................

		
		public AllParameters() {
		}


        // DAO Parameters .....................................................


        /**
         * Gets the search fields
         * @return
         */
		public Object[] getSearchFields() {
			// Local Variables
			return new Object[] {};
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
