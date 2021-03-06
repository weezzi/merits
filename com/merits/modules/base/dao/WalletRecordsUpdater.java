package com.merits.modules.base.dao;

// IMPORTS ---------------------------------------------------------------------

import java.sql.CallableStatement;
import java.sql.Timestamp;

import com.weezzi.core.data.*;
import com.weezzi.core.dbmanager.dao.UpdaterDAO;
import com.weezzi.utils.StringUtilities;
import com.merits.modules.base.uobjects.enums.WalletType;
import com.merits.modules.base.uobjects.enums.WalletOperation;
import com.merits.modules.base.uobjects.enums.WalletType;


/**
 * <b>Title: </b>Wallet Record Updater Object<br/>
 * <b>Description: </b>Wallet Record Updater Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
 @SuppressWarnings("unused")
public class WalletRecordsUpdater implements UpdaterDAO {


    // PROPERTIES --------------------------------------------------------------

    private long id;
    private long idWallet;
    private WalletType walletType;
    private Timestamp transactionDate;
    private WalletOperation operation;
    private float transactionValue;
    private long refWallet;
    private WalletType refWalletType;
    private String refName;


    // CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Empty Constructor
	 **/
	public WalletRecordsUpdater(long id, long idWallet, WalletType walletType, Timestamp transactionDate, WalletOperation operation, float transactionValue, long refWallet, WalletType refWalletType, String refName) {
        this.id = id;
        this.idWallet = idWallet;
        this.walletType = walletType;
        this.transactionDate = transactionDate;
        this.operation = operation;
        this.transactionValue = transactionValue;
        this.refWallet = refWallet;
        this.refWalletType = refWalletType;
        this.refName = refName;
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
		return "UPDATE WALLET_RECORDS " +
               " SET ID_WALLET = ? , WALLET_TYPE = ? , TRANSACTION_DATE = ? , OPERATION = ? , TRANSACTION_VALUE = ? , REF_WALLET = ? , REF_WALLET_TYPE = ? , REF_NAME = ?  " +
               " WHERE  ID = ?";
	}
	
	
	/**
	 * Updates Query Fields
	 * @param statment
	 * @throws Exception
	 */
	public void updateFields(CallableStatement statement) throws Exception {
        // Set Fields
        statement.setLong(1, idWallet);
        // Check If Null
        if (walletType == null) {
            statement.setNull(2, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(2, walletType.getValue());
        }
        statement.setTimestamp(3, transactionDate);
        // Check If Null
        if (operation == null) {
            statement.setNull(4, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(4, operation.getValue());
        }
        statement.setFloat(5, transactionValue);
        statement.setLong(6, refWallet);
        // Check If Null
        if (refWalletType == null) {
            statement.setNull(7, java.sql.Types.VARCHAR);
        } else {
            statement.setInt(7, refWalletType.getValue());
        }
        // Check If Null
        if (refName == null) {
            statement.setNull(8, java.sql.Types.VARCHAR);
        } else {
            statement.setString(8, StringUtilities.capString(refName, 100));
        }
        statement.setLong(9, id);
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
