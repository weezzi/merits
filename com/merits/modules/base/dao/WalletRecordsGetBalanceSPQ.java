package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Timestamp;


import com.weezzi.utils.DatabaseType;
import com.weezzi.core.dbmanager.dao.DAOParameters;
import com.weezzi.core.dbmanager.dao.SpecialQueryDAO;
import com.weezzi.core.dbmanager.dao.SingleRecordDAO;
import com.weezzi.core.data.*;
import com.weezzi.utils.extras.cache.WeezziCacheObjectType;




/**
 * <b>Title: </b>Wallet Record Data Transfer Object<br/>
 * <b>Description: </b>Wallet Record DTO Class<br/>
 * <b>Copyright: </b>Copyright (c) 2020 Overture Software<br/>
 * <b>Company: </b><A HREF="http://www.overturesoftware.com">Overture Software</A><br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public class WalletRecordsGetBalanceSPQ extends SpecialQueryDAO {


	// CONSTANTS ---------------------------------------------------------------

	
	public static final String CACHE_PREFIX = "S1_0#";
	private static final long serialVersionUID = 1L;


    // PROPERTIES -------------------------------------------------------------


	// Special Query Fields	
    // Get Balance Balance
    private float balance;


    // CONSTRUCTORS -----------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public WalletRecordsGetBalanceSPQ() {
        // Set cache object type
		this.setCacheObjectType(WeezziCacheObjectType.SpecialQuery);
	}
	
	// SPECIAL QUERY METHODS --------------------------------------------------


    /**
     * Wallet Record Bean Field Constructor
     * @param balance float Wallet Records Balance
     */
    public WalletRecordsGetBalanceSPQ(float balance) {
        // Call default constructor
        this();
        // Set Wallet Records Balance
        setBalance(balance);
    }


    // GETTERS -----------------------------------------------------------------


    /**
     * Get Wallet Records Balance
     * @return float Wallet Records Balance
     */
    public float getBalance() {
        return this.balance;
    }


    // SETTERS -----------------------------------------------------------------


    /**
     * Set Wallet Records Balance
     * @param balance float Wallet Records Balance
     */
    public void setBalance(float balance) {
        this.balance = balance;
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


    public void fillValuesFromResultSet(ResultSet resultset) throws Exception {
        // Set Wallet Records Balance
        this.setBalance(resultset.getFloat("BALANCE"));
    }

	
	// SPECIAL QUERY PARAMETERS OBJECT CLASS ----------------------------------
	
	
	/**
	 * Wallet Record 
	 */
	public class Parameters extends DAOParameters {

		
		// Properties .........................................................

		
        // Get Balance Identifier
        public long id;

		
		// Constructors .......................................................


    public Parameters(long id) {
            this.id = id;
    }



        // DAO Parameters .....................................................


        /**
         * Gets the search fields
         * @return
         */
		public Object[] getSearchFields() {
			// Local Variables
			return new Object[] {id};
		}
	
	
		/**
		 * Gets the object cache keys
		 * @return cacheKeys
		 */
		public String[] getCacheKeys() {
			return new String[] {"ID_WALLET=" + id};
		}
		
	}
}