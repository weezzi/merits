package com.merits.modules.base.container;

// IMPORTS ---------------------------------------------------------------------

import com.weezzi.utils.NumberUtilities;
import com.weezzi.utils.DatabaseType;

import com.weezzi.utils.extras.console.Console;
import com.weezzi.utils.extras.console.annotations.WConsole;
import com.weezzi.core.containers.FilesContainer;
import com.weezzi.core.containers.registry.ContainerRegistry;
import com.weezzi.core.containers.registry.RegisterableContainer;
import com.weezzi.core.multilanguage.MultiLanguageUtils;
import com.weezzi.core.context.PageContext;
import com.weezzi.core.hotdeploy.data.WeezziClassLoader;
import com.weezzi.utils.extras.cache.WeezziCache;
import com.weezzi.utils.extras.cache.WeezziCacheType;
import com.weezzi.utils.extras.cache.WeezziCacheTransactionalRelease;
import com.weezzi.core.dbmanager.GlobalDBManager;
import com.weezzi.core.dbmanager.dao.DAOInstantParameters;
import com.weezzi.core.dbmanager.exceptions.NoDataFoundException;
import com.weezzi.core.dbmanager.exceptions.SQLExecutionException;
import com.weezzi.core.wlanguage.data.WArgumentType;
import com.weezzi.core.wlanguage.data.WFunction;
import com.weezzi.core.wlanguage.data.WFunctionArgument;
import com.weezzi.core.wlanguage.data.WObject;
import com.weezzi.core.data.*;
import com.weezzi.utils.*;
import com.merits.modules.base.container.BaseDatasource;
import com.merits.modules.base.dao.WalletsDAO;
import com.merits.modules.base.dao.WalletsUpdater;
import com.merits.modules.base.uobjects.enums.WalletType;
import com.merits.modules.base.uobjects.enums.IdcardType;
import com.merits.modules.base.dao.WalletRecordsDAO;
import com.merits.modules.base.dao.WalletRecordsUpdater;
import com.merits.modules.base.dao.BulkWalletRecordsDAO;
import com.merits.modules.base.dao.WalletRecordsGetBalanceSPQ;
import com.merits.modules.base.dao.WalletRecordsTotalsSPQ;
import com.merits.modules.base.dao.BulkWalletRecordsTotalsSPQ;
import com.merits.modules.base.dao.WalletRecordsMasterWalletSPQ;
import com.merits.modules.base.uobjects.enums.WalletType;
import com.merits.modules.base.uobjects.enums.WalletOperation;
import com.merits.modules.base.uobjects.enums.WalletType;
import com.merits.modules.base.dao.GoodTypesDAO;
import com.merits.modules.base.dao.GoodTypesUpdater;
import com.merits.modules.base.dao.BulkGoodTypesDAO;
import com.merits.modules.base.dao.GoodTypesUpdaterByName;
import com.merits.modules.base.lists.GoodTypesListGoodTypes;
import com.merits.modules.base.dao.VolunteersDAO;
import com.merits.modules.base.dao.VolunteersUpdater;
import com.merits.modules.base.dao.BulkVolunteersDAO;
import com.merits.modules.base.dao.VolunteersUpdaterByAll;
import com.merits.modules.base.dao.VolunteersUpdaterByLanguage;
import com.merits.modules.base.dao.VolunteersUpdaterByPhoto;
import com.merits.modules.base.dao.VolunteersUpdaterByPassword;
import com.merits.modules.base.dao.VolunteersGetAllUsersSPQ;
import com.merits.modules.base.dao.BulkVolunteersGetAllUsersSPQ;
import com.merits.modules.base.dao.VolunteersUsersSPQ;
import com.merits.modules.base.dao.BulkVolunteersUsersSPQ;
import com.merits.modules.base.uobjects.enums.IdcardType;
import com.merits.modules.base.lists.VolunteersListVolunteers;
import com.merits.modules.base.dao.ShopsDAO;
import com.merits.modules.base.dao.ShopsUpdater;
import com.merits.modules.base.dao.BulkShopsDAO;
import com.merits.modules.base.dao.ShopsUpdaterByAll;
import com.merits.modules.base.dao.ShopsUpdaterByLanguage;
import com.merits.modules.base.dao.ShopsUpdaterByPassword;
import com.merits.modules.base.lists.ShopsListShops;
import com.merits.modules.base.dao.ShopCashiersDAO;
import com.merits.modules.base.dao.ShopCashiersUpdater;
import com.merits.modules.base.dao.BulkShopCashiersDAO;
import com.merits.modules.base.dao.ShopCashiersUpdaterByAll;
import com.merits.modules.base.dao.ShopCashiersUpdaterByPassword;
import com.merits.modules.base.dao.ShopCashiersUpdaterByLanguage;
import com.merits.modules.base.dao.ShopGoodtypesDAO;
import com.merits.modules.base.dao.ShopGoodtypesUpdater;
import com.merits.modules.base.dao.BulkShopGoodtypesDAO;
import com.merits.modules.base.dao.ShopGoodtypesShopGoodSPQ;
import com.merits.modules.base.dao.BulkShopGoodtypesShopGoodSPQ;
import com.merits.modules.base.dao.ShopTransactionsDAO;
import com.merits.modules.base.dao.ShopTransactionsUpdater;
import com.merits.modules.base.dao.BulkShopTransactionsDAO;
import com.merits.modules.base.dao.OrganizationsDAO;
import com.merits.modules.base.dao.OrganizationsUpdater;
import com.merits.modules.base.dao.BulkOrganizationsDAO;
import com.merits.modules.base.lists.OrganizationsListOrganizations;
import com.merits.modules.base.dao.PaymentsCodeDAO;
import com.merits.modules.base.dao.PaymentsCodeUpdater;
import com.merits.modules.base.dao.PaymentsCodeUpdaterByStatus;
import com.merits.modules.base.uobjects.enums.PaymentCodeStatus;
import com.merits.modules.base.dao.PaymentsRequestsDAO;
import com.merits.modules.base.dao.PaymentsRequestsUpdater;
import com.merits.modules.base.dao.PaymentsRequestsUpdaterByStatus;
import com.merits.modules.base.uobjects.enums.PaymentRequestStatus;
import com.merits.modules.base.dao.ShopTransactionsGoodsDAO;
import com.merits.modules.base.dao.ShopTransactionsGoodsUpdater;
import com.merits.modules.base.dao.CountriesDAO;
import com.merits.modules.base.dao.CountriesUpdater;
import com.merits.modules.base.dao.BulkCountriesDAO;
import com.merits.modules.base.dao.CountriesUpdaterByPublish;
import com.merits.modules.base.dao.CountriesUpdaterByName;
import com.merits.modules.base.dao.CitiesDAO;
import com.merits.modules.base.dao.CitiesUpdater;
import com.merits.modules.base.dao.BulkCitiesDAO;
import com.merits.modules.base.dao.CitiesUpdaterByPublish;
import com.merits.modules.base.dao.CitiesUpdaterByAll;
import com.merits.modules.base.dao.TeamDAO;
import com.merits.modules.base.dao.TeamUpdater;
import com.merits.modules.base.dao.BulkTeamDAO;
import com.merits.modules.base.dao.TeamUpdaterByAll;
import com.merits.modules.base.dao.TeamUpdaterByPublish;
import com.merits.modules.base.dao.SponsorsDAO;
import com.merits.modules.base.dao.SponsorsUpdater;
import com.merits.modules.base.dao.BulkSponsorsDAO;
import com.merits.modules.base.dao.SponsorsUpdaterByAll;
import com.merits.modules.base.dao.SponsorsUpdaterByPublish;
import com.merits.modules.base.dao.CompaniesDAO;
import com.merits.modules.base.dao.CompaniesUpdater;
import com.merits.modules.base.dao.BulkCompaniesDAO;
import com.merits.modules.base.dao.CompaniesUpdaterByAll;
import com.merits.modules.base.dao.CompaniesUpdaterByPublish;
import com.merits.modules.base.dao.ProjectsDAO;
import com.merits.modules.base.dao.ProjectsUpdater;
import com.merits.modules.base.dao.BulkProjectsDAO;
import com.merits.modules.base.dao.ProjectsUpdaterByAll;
import com.weezzi.core.dbmanager.querybuilder.QueryBuilder;
import java.util.HashMap;
import java.sql.Timestamp;
import com.weezzi.system.modules.base.uobjects.enums.ContentArea;




/**
 * <b>Title: </b>Base Container<br/>
 * <b>Description: </b>Base Container Class<br/>
 *
 * @author AUTO-GENERATED By Weezzi Builder
 * @version 1.0
 */
@WConsole (name = "BaseContainerContainer")
@SuppressWarnings("unused")
public class BaseContainer extends RegisterableContainer {

    // CONSTANTS --------------------------------------------------------------


    // PROPERTIES -------------------------------------------------------------

	// INTERNAL
	private static Long siteId;
	// CACHES
    // Wallet Cache
    private static WeezziCache walletsSingleCache;
    private static WeezziCache walletsQueriesCache;
    // WalletRecord Cache
    private static WeezziCache walletRecordsSingleCache;
    private static WeezziCache walletRecordsQueriesCache;
    // GoodType Cache
    private static WeezziCache goodTypesSingleCache;
    private static WeezziCache goodTypesQueriesCache;
    // Volunteer Cache
    private static WeezziCache volunteersSingleCache;
    private static WeezziCache volunteersQueriesCache;
    // Shop Cache
    private static WeezziCache shopsSingleCache;
    private static WeezziCache shopsQueriesCache;
    // ShopCashier Cache
    private static WeezziCache shopCashiersSingleCache;
    private static WeezziCache shopCashiersQueriesCache;
    // ShopGoodtype Cache
    private static WeezziCache shopGoodtypesSingleCache;
    private static WeezziCache shopGoodtypesQueriesCache;
    // ShopTransaction Cache
    private static WeezziCache shopTransactionsSingleCache;
    private static WeezziCache shopTransactionsQueriesCache;
    // Organization Cache
    private static WeezziCache organizationsSingleCache;
    private static WeezziCache organizationsQueriesCache;
    // PaymentsCode Cache
    private static WeezziCache paymentsCodeSingleCache;
    private static WeezziCache paymentsCodeQueriesCache;
    // PaymentsRequest Cache
    private static WeezziCache paymentsRequestsSingleCache;
    private static WeezziCache paymentsRequestsQueriesCache;
    // ShopTransactionsGood Cache
    private static WeezziCache shopTransactionsGoodsSingleCache;
    private static WeezziCache shopTransactionsGoodsQueriesCache;
    // Country Cache
    private static WeezziCache countriesSingleCache;
    private static WeezziCache countriesQueriesCache;
    // City Cache
    private static WeezziCache citiesSingleCache;
    private static WeezziCache citiesQueriesCache;
    // Team Cache
    private static WeezziCache teamSingleCache;
    private static WeezziCache teamQueriesCache;
    // Sponsor Cache
    private static WeezziCache sponsorsSingleCache;
    private static WeezziCache sponsorsQueriesCache;
    // Company Cache
    private static WeezziCache companiesSingleCache;
    private static WeezziCache companiesQueriesCache;
    // Project Cache
    private static WeezziCache projectsSingleCache;
    private static WeezziCache projectsQueriesCache;

    // DATASOURCE
    private static BaseDatasource datasource;



    // INITIALIZATION  --------------------------------------------------------


    static {
        // Create DataSource
        datasource = new BaseDatasource();
        // CACHES
        // Wallets
        walletsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Wallets", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        walletsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Wallets", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // WalletRecords
        walletRecordsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "WalletRecords", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        walletRecordsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "WalletRecords", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // GoodTypes
        goodTypesSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "GoodTypes", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        goodTypesQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "GoodTypes", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // Volunteers
        volunteersSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Volunteers", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        volunteersQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Volunteers", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // Shops
        shopsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Shops", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        shopsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Shops", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // ShopCashiers
        shopCashiersSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "ShopCashiers", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        shopCashiersQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "ShopCashiers", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // ShopGoodtypes
        shopGoodtypesSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "ShopGoodtypes", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        shopGoodtypesQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "ShopGoodtypes", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // ShopTransactions
        shopTransactionsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "ShopTransactions", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        shopTransactionsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "ShopTransactions", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // Organizations
        organizationsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Organizations", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        organizationsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Organizations", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // PaymentsCode
        paymentsCodeSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "PaymentsCode", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        paymentsCodeQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "PaymentsCode", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // PaymentsRequests
        paymentsRequestsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "PaymentsRequests", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        paymentsRequestsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "PaymentsRequests", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // ShopTransactionsGoods
        shopTransactionsGoodsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "ShopTransactionsGoods", null, 1 * NumberUtilities.KB, 2*1000, datasource);
        shopTransactionsGoodsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "ShopTransactionsGoods", null, 1 * NumberUtilities.MB, 1*1000, datasource);
        // Countries
        countriesSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Countries", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        countriesQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Countries", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Cities
        citiesSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Cities", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        citiesQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Cities", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Team
        teamSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Team", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        teamQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Team", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Sponsors
        sponsorsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Sponsors", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        sponsorsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Sponsors", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Companies
        companiesSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Companies", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        companiesQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Companies", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Projects
        projectsSingleCache = new WeezziCache(WeezziCacheType.SingleRecord, "Merits", "Projects", null, 2 * NumberUtilities.MB, 2*1000, datasource);
        projectsQueriesCache = new WeezziCache(WeezziCacheType.Queries, "Merits", "Projects", null, 10 * NumberUtilities.MB, 1*1000, datasource);
        // Get Site Id from class loader
        if (BaseContainer.class.getClassLoader() instanceof WeezziClassLoader) {
        	siteId = ((WeezziClassLoader) BaseContainer.class.getClassLoader()).getSiteId();
        } else {
        	siteId = 0l;
        }
        // Register Container
        ContainerRegistry.registerContainer(new BaseContainer());
    }


	// PUBLIC -----------------------------------------------------------------


	/**
	 * Releases all container cache from a particular
	 * @param siteId
	 */
	public void releaseSiteCache(long siteId) {
		releaseAllCache();
	}


	/**
	 * Releases all container caches
	 **/
	public static void releaseAllCache() {
        // Wallet Cache
        walletsSingleCache.clear();
        walletsQueriesCache.clear();
        // WalletRecord Cache
        walletRecordsSingleCache.clear();
        walletRecordsQueriesCache.clear();
        // GoodType Cache
        goodTypesSingleCache.clear();
        goodTypesQueriesCache.clear();
        // Volunteer Cache
        volunteersSingleCache.clear();
        volunteersQueriesCache.clear();
        // Shop Cache
        shopsSingleCache.clear();
        shopsQueriesCache.clear();
        // ShopCashier Cache
        shopCashiersSingleCache.clear();
        shopCashiersQueriesCache.clear();
        // ShopGoodtype Cache
        shopGoodtypesSingleCache.clear();
        shopGoodtypesQueriesCache.clear();
        // ShopTransaction Cache
        shopTransactionsSingleCache.clear();
        shopTransactionsQueriesCache.clear();
        // Organization Cache
        organizationsSingleCache.clear();
        organizationsQueriesCache.clear();
        // PaymentsCode Cache
        paymentsCodeSingleCache.clear();
        paymentsCodeQueriesCache.clear();
        // PaymentsRequest Cache
        paymentsRequestsSingleCache.clear();
        paymentsRequestsQueriesCache.clear();
        // ShopTransactionsGood Cache
        shopTransactionsGoodsSingleCache.clear();
        shopTransactionsGoodsQueriesCache.clear();
        // Country Cache
        countriesSingleCache.clear();
        countriesQueriesCache.clear();
        // City Cache
        citiesSingleCache.clear();
        citiesQueriesCache.clear();
        // Team Cache
        teamSingleCache.clear();
        teamQueriesCache.clear();
        // Sponsor Cache
        sponsorsSingleCache.clear();
        sponsorsQueriesCache.clear();
        // Company Cache
        companiesSingleCache.clear();
        companiesQueriesCache.clear();
        // Project Cache
        projectsSingleCache.clear();
        projectsQueriesCache.clear();
	}


    /**
     * Releases all container caches
     **/
    public static void releaseWalletCache() {
        // Wallet Cache
        walletsSingleCache.clear();
        walletsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseWalletRecordCache() {
        // WalletRecord Cache
        walletRecordsSingleCache.clear();
        walletRecordsQueriesCache.clear();
    }


    /**
     * Releases all container by cache keys caches
     **/
    public static void releaseWalletRecordCache(long idWallet) {
        // Local Variables
        WeezziCacheTransactionalRelease cacheTR;
        // WalletRecords TABLE
        // Create transactional release object
        cacheTR = new WeezziCacheTransactionalRelease();
        cacheTR.addKeyMixedPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.Transactions, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyMixedPatternRelease(WalletRecordsDAO.CACHE_PREFIX, WalletRecordsDAO.SearchType.Transaction, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.All);
        walletRecordsQueriesCache.release(cacheTR);
    }


    /**
     * Releases all container caches
     **/
    public static void releaseGoodTypeCache() {
        // GoodType Cache
        goodTypesSingleCache.clear();
        goodTypesQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseVolunteerCache() {
        // Volunteer Cache
        volunteersSingleCache.clear();
        volunteersQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseShopCache() {
        // Shop Cache
        shopsSingleCache.clear();
        shopsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseShopCashierCache() {
        // ShopCashier Cache
        shopCashiersSingleCache.clear();
        shopCashiersQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseShopGoodtypeCache() {
        // ShopGoodtype Cache
        shopGoodtypesSingleCache.clear();
        shopGoodtypesQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseShopTransactionCache() {
        // ShopTransaction Cache
        shopTransactionsSingleCache.clear();
        shopTransactionsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseOrganizationCache() {
        // Organization Cache
        organizationsSingleCache.clear();
        organizationsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releasePaymentsCodeCache() {
        // PaymentsCode Cache
        paymentsCodeSingleCache.clear();
        paymentsCodeQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releasePaymentsRequestCache() {
        // PaymentsRequest Cache
        paymentsRequestsSingleCache.clear();
        paymentsRequestsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseShopTransactionsGoodCache() {
        // ShopTransactionsGood Cache
        shopTransactionsGoodsSingleCache.clear();
        shopTransactionsGoodsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseCountryCache() {
        // Country Cache
        countriesSingleCache.clear();
        countriesQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseCityCache() {
        // City Cache
        citiesSingleCache.clear();
        citiesQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseTeamCache() {
        // Team Cache
        teamSingleCache.clear();
        teamQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseSponsorCache() {
        // Sponsor Cache
        sponsorsSingleCache.clear();
        sponsorsQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseCompanyCache() {
        // Company Cache
        companiesSingleCache.clear();
        companiesQueriesCache.clear();
    }


    /**
     * Releases all container caches
     **/
    public static void releaseProjectCache() {
        // Project Cache
        projectsSingleCache.clear();
        projectsQueriesCache.clear();
    }


    // =========================================================================
    // BEAN METHODS
    // =========================================================================


    // WALLETS Bean Methods ----------------------------------------------------


    /**
     * Creates a Wallet
     * @param id long Wallets Identifier
     * @param walletType WalletType Wallets Wallet Type
     * @return Wallet created Identifier
     */
    public static long createWallet(WalletType walletType) throws Exception {
        // Local variables
        WalletsDAO wallets;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        wallets = new WalletsDAO(0, walletType);
        // Call DB Manager Adder Method
        try {
            // Add Wallet
            GlobalDBManager.create(wallets);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        walletsQueriesCache.clear();
        // Add the created object to the cache
        walletsSingleCache.put(wallets);
        // Return created Wallet Identifier
        return wallets.getId();
    }


    /**
     * Creates a Wallet
     * @param id long Wallets Identifier
     * @param walletType WalletType Wallets Wallet Type
     * @param idcardType IdcardType Wallets Card Type Identifier
     * @param idcardNumber String Wallets Card Number Identifier
     * @param firstName String Wallets First Name
     * @param lastName String Wallets Last Name
     * @param birthdate Timestamp Wallets Birthdate
     * @param countryOfOrigin Long Wallets Country Of Origin
     * @return Wallet created Identifier
     */
    public static long createWallet(WalletType walletType, IdcardType idcardType, 
                                    String idcardNumber, String firstName, 
                                    String lastName, Timestamp birthdate, 
                                    Long countryOfOrigin) throws Exception {
        // Local variables
        WalletsDAO wallets;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        wallets = new WalletsDAO(0, walletType, idcardType, idcardNumber, firstName, lastName, 
                                 birthdate, countryOfOrigin);
        // Call DB Manager Adder Method
        try {
            // Add Wallet
            GlobalDBManager.create(wallets);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        walletsQueriesCache.clear();
        // Add the created object to the cache
        walletsSingleCache.put(wallets);
        // Return created Wallet Identifier
        return wallets.getId();
    }


    /**
     * WalletUpdater
     * @param id
     * @param walletType
     * @param idcardType
     * @param idcardNumber
     * @param firstName
     * @param lastName
     * @param birthdate
     * @param countryOfOrigin
     */
    public static void updateWallet(long id, WalletType walletType, IdcardType idcardType, String idcardNumber, String firstName, String lastName, Timestamp birthdate, Long countryOfOrigin) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        WalletsDAO dao;
        WalletsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new WalletsUpdater(id, walletType, idcardType, idcardNumber, firstName, lastName, birthdate, countryOfOrigin);
        // Call DB Manager Updater Method
        try {
            // Update Wallet
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating WALLETS table", ex);
            throw ex;
        }
        // CACHES
        walletsQueriesCache.clear();
        // Create DAO
        dao = new WalletsDAO(id);
        // Release cache
        walletsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Wallet
     * @param id long Wallets Identifier
     */
    public static void removeWallet(long id) throws Exception {
            // Local Variables
        WalletsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Wallet
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM WALLETS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        walletsQueriesCache.clear();
        // Clears all single cache of this object
        walletsSingleCache.release(new WalletsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Wallet
     * @param id long Wallets Identifier
     */
    public static long copyWallet(long id) throws Exception {
        // Local Variables
        long copyId;
        WalletsDAO copy;
        WalletsDAO original;
        // Get Original
        original = getWallet(id);
        // Copy Original
        copyId = createWallet(
                original.getWalletType(), // walletType
                original.getIdcardType(), // idcardType
                original.getIdcardNumber(), // idcardNumber
                original.getFirstName(), // firstName
                original.getLastName(), // lastName
                original.getBirthdate(), // birthdate
                original.getCountryOfOrigin() // countryOfOrigin
        );
        return copyId;
    }


    /**
     * Gets a Wallet
     * @param id long Wallets Identifier
     * @return Wallet DAO
     */
    public static WalletsDAO getWallet(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        WalletsDAO dao;
        // Create DAO
        dao = new WalletsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (WalletsDAO) walletsSingleCache.get(dao);
    }
    /**
     * Gets a Wallet
     * @param id long Wallets Identifier
     * @return Wallet DAO
     */
    public static WalletsDAO getUncachedWallet(long id) throws Exception {
        try {
            return datasource.getWallet(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @return Wallets DAO
     */
    public static WalletsDAO getWalletFindByMasterWallet() throws Exception {
        // Local Variables
        WalletsDAO dao;
        WalletsDAO.MasterWalletParameters parameters;
        // Create DAO
        dao = new WalletsDAO(WalletsDAO.SearchType.MasterWallet);
        // Create Parameters
        parameters = dao.new MasterWalletParameters();
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (WalletsDAO) walletsQueriesCache.get(dao);
    }
    /**
     * Description
     * @return Wallets DAO
     */
    public static WalletsDAO getUncachedWalletFindByMasterWallet() throws Exception {
        // Call datasource directly
        return datasource.getWalletFindByMasterWallet();
    }


    // WALLET RECORDS Bean Methods ---------------------------------------------


    /**
     * Creates a Wallet Record
     * @param id long Wallet Records Identifier
     * @param idWallet long Wallet Records Wallet Identifier
     * @param walletType WalletType Wallet Records Wallet Type
     * @param transactionDate Timestamp Wallet Records Transaction Date
     * @param operation WalletOperation Wallet Records Operation
     * @param transactionValue float Wallet Records Transaction Value
     * @param refWallet long Wallet Records Ref Wallet
     * @param refWalletType WalletType Wallet Records Ref Wallet Type
     * @param refName String Wallet Records Ref Name
     * @return Wallet Record created Identifier
     */
    public static long createWalletRecord(long idWallet, WalletType walletType, 
                                          Timestamp transactionDate, 
                                          WalletOperation operation, 
                                          float transactionValue, long refWallet, 
                                          WalletType refWalletType, 
                                          String refName) throws Exception {
        // Local variables
        WalletRecordsDAO walletRecords;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        walletRecords = new WalletRecordsDAO(0, idWallet, walletType, transactionDate, operation, 
                                             transactionValue, refWallet, 
                                             refWalletType, refName);
        // Call DB Manager Adder Method
        try {
            // Add Wallet Record
            GlobalDBManager.create(walletRecords);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        // WalletRecords TABLE
        // Create transactional release object
        cacheTR = new WeezziCacheTransactionalRelease();
        cacheTR.addKeyMixedPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.Transactions, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyMixedPatternRelease(WalletRecordsDAO.CACHE_PREFIX, WalletRecordsDAO.SearchType.Transaction, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.All);
        walletRecordsQueriesCache.release(cacheTR);
        // Add the created object to the cache
        walletRecordsSingleCache.put(walletRecords);
        // Return created Wallet Record Identifier
        return walletRecords.getId();
    }


    /**
     * WalletRecordUpdater
     * @param id
     * @param idWallet
     * @param walletType
     * @param transactionDate
     * @param operation
     * @param transactionValue
     * @param refWallet
     * @param refWalletType
     * @param refName
     */
    public static void updateWalletRecord(long id, long idWallet, WalletType walletType, Timestamp transactionDate, WalletOperation operation, float transactionValue, long refWallet, WalletType refWalletType, String refName) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        WalletRecordsDAO dao;
        WalletRecordsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new WalletRecordsUpdater(id, idWallet, walletType, transactionDate, operation, transactionValue, refWallet, refWalletType, refName);
        // Call DB Manager Updater Method
        try {
            // Update Wallet Record
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating WALLET_RECORDS table", ex);
            throw ex;
        }
        // CACHES
        // WalletRecords TABLE
        // Create transactional release object
        cacheTR = new WeezziCacheTransactionalRelease();
        cacheTR.addKeyMixedPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.Transactions, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyMixedPatternRelease(WalletRecordsDAO.CACHE_PREFIX, WalletRecordsDAO.SearchType.Transaction, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.All);
        walletRecordsQueriesCache.release(cacheTR);
        // Create DAO
        dao = new WalletRecordsDAO(id);
        // Release cache
        walletRecordsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Wallet Record
     * @param id long Wallet Records Identifier
     */
    public static void removeWalletRecord(long id) throws Exception {
            // Local Variables
        WalletRecordsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Wallet Record
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM WALLET_RECORDS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        walletRecordsQueriesCache.clear();
        // Clears all single cache of this object
        walletRecordsSingleCache.release(new WalletRecordsDAO(id).getCacheUniqueKey());
    }


    /**
     * Removes a Wallet Record
     * @param id long Wallet Records Identifier
     * @param idWallet long Wallet Records Wallet Identifier
     */
    public static void removeWalletRecord(long id, long idWallet) throws Exception {
            // Local Variables
        WalletRecordsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Wallet Record
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM WALLET_RECORDS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        // WalletRecords TABLE
        // Create transactional release object
        cacheTR = new WeezziCacheTransactionalRelease();
        cacheTR.addKeyMixedPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.Transactions, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyMixedPatternRelease(WalletRecordsDAO.CACHE_PREFIX, WalletRecordsDAO.SearchType.Transaction, new String[] {"ID_WALLET=" + idWallet});
        cacheTR.addKeyPatternRelease(BulkWalletRecordsDAO.CACHE_PREFIX, BulkWalletRecordsDAO.SearchType.All);
        walletRecordsQueriesCache.release(cacheTR);
        // Clears all single cache of this object
        walletRecordsSingleCache.release(new WalletRecordsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Wallet Record
     * @param id long Wallet Records Identifier
     * @param idWallet long Wallet Records Wallet Identifier
     * @param refWallet long Wallet Records Ref Wallet
     */
    public static long copyWalletRecord(long id, long idWallet, long refWallet) throws Exception {
        // Local Variables
        long copyId;
        WalletRecordsDAO copy;
        WalletRecordsDAO original;
        // Get Original
        original = getWalletRecord(id);
        // Copy Original
        copyId = createWalletRecord(
                idWallet, // Publish Info
                original.getWalletType(), // walletType
                original.getTransactionDate(), // transactionDate
                original.getOperation(), // operation
                original.getTransactionValue(), // transactionValue
                refWallet, // Publish Info
                original.getRefWalletType(), // refWalletType
                original.getRefName() // refName
        );
        return copyId;
    }


    /**
     * Gets a Wallet Record
     * @param id long Wallet Records Identifier
     * @return Wallet Record DAO
     */
    public static WalletRecordsDAO getWalletRecord(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        WalletRecordsDAO dao;
        // Create DAO
        dao = new WalletRecordsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (WalletRecordsDAO) walletRecordsSingleCache.get(dao);
    }
    /**
     * Gets a Wallet Record
     * @param id long Wallet Records Identifier
     * @return Wallet Record DAO
     */
    public static WalletRecordsDAO getUncachedWalletRecord(long id) throws Exception {
        try {
            return datasource.getWalletRecord(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idWallet long Wallet Records Wallet Identifier
     * @return Wallet Records DAO
     */
    public static BulkWalletRecordsDAO getWalletRecordsFindByTransactions(
                                                                          long idWallet) throws Exception {
        // Local Variables
        BulkWalletRecordsDAO dao;
        BulkWalletRecordsDAO.TransactionsParameters parameters;
        // Create DAO
        dao = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.Transactions);
        // Create Parameters
        parameters = dao.new TransactionsParameters(idWallet, null);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkWalletRecordsDAO) walletRecordsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param idWallet long Wallet Records Wallet Identifier
     * @param sinceId Long Wallet Records Since Id
     * @return Wallet Records DAO
     */
    public static BulkWalletRecordsDAO getWalletRecordsFindByTransactions(
                                                                          long idWallet, 
                                                                          Long sinceId) throws Exception {
        // Local Variables
        BulkWalletRecordsDAO dao;
        BulkWalletRecordsDAO.TransactionsParameters parameters;
        // Create DAO
        dao = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.Transactions);
        // Create Parameters
        parameters = dao.new TransactionsParameters(idWallet, sinceId);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkWalletRecordsDAO) walletRecordsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param id long Wallet Records Identifier
     * @param idWallet long Wallet Records Wallet Identifier
     * @return Wallet Records DAO
     */
    public static WalletRecordsDAO getWalletRecordFindByTransaction(long id, 
                                                                    long idWallet) throws Exception {
        // Local Variables
        WalletRecordsDAO dao;
        WalletRecordsDAO.TransactionParameters parameters;
        // Create DAO
        dao = new WalletRecordsDAO(WalletRecordsDAO.SearchType.Transaction);
        // Create Parameters
        parameters = dao.new TransactionParameters(id, idWallet);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (WalletRecordsDAO) walletRecordsQueriesCache.get(dao);
    }
    /**
     * Description
     * @param id long Wallet Records Identifier
     * @param idWallet long Wallet Records Wallet Identifier
     * @return Wallet Records DAO
     */
    public static WalletRecordsDAO getUncachedWalletRecordFindByTransaction(
                                                                            long id, 
                                                                            long idWallet) throws Exception {
        // Call datasource directly
        return datasource.getWalletRecordFindByTransaction(id, idWallet);
    }


    /**
     * Description
     * @return Wallet Records DAO
     */
    public static BulkWalletRecordsDAO getWalletRecordsFindByAll() throws Exception {
        // Local Variables
        BulkWalletRecordsDAO dao;
        BulkWalletRecordsDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(null, null, null, null, null);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkWalletRecordsDAO) walletRecordsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param start int Wallet Records Start
     * @param end int Wallet Records End
     * @return Wallet Records Bulk DTO
     */
    public static BulkWalletRecordsDAO getWalletRecordsBlockFindByAll(int start, 
                                                                      int end) {
        // Local Variables
        BulkWalletRecordsDAO.AllParameters parameters;
        BulkWalletRecordsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(null, null, null, null, null);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkWalletRecordsDAO) getBulkBlockQueryData(walletRecordsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Description
     * @param idVolunteer Long Wallet Records Volunteer Identifier
     * @param idShop Long Wallet Records Shop Identifier
     * @param search String Wallet Records Search
     * @param startDate String Wallet Records Start Date
     * @param endDate String Wallet Records End Date
     * @return Wallet Records DAO
     */
    public static BulkWalletRecordsDAO getWalletRecordsFindByAll(
                                                                 Long idVolunteer, 
                                                                 Long idShop, 
                                                                 String search, 
                                                                 String startDate, 
                                                                 String endDate) throws Exception {
        // Local Variables
        BulkWalletRecordsDAO dao;
        BulkWalletRecordsDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(idVolunteer, idShop, search, startDate, endDate);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkWalletRecordsDAO) walletRecordsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param idVolunteer long Wallet Records Volunteer Identifier
     * @param idShop long Wallet Records Shop Identifier
     * @param search String Wallet Records Search
     * @param startDate String Wallet Records Start Date
     * @param endDate String Wallet Records End Date
     * @param start int Wallet Records Start
     * @param end int Wallet Records End
     * @return Wallet Records Bulk DTO
     */
    public static BulkWalletRecordsDAO getWalletRecordsBlockFindByAll(Long idVolunteer, 
                                                                      Long idShop, 
                                                                      String search, 
                                                                      String startDate, 
                                                                      String endDate, 
                                                                      int start, 
                                                                      int end) {
        // Local Variables
        BulkWalletRecordsDAO.AllParameters parameters;
        BulkWalletRecordsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkWalletRecordsDAO(BulkWalletRecordsDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(idVolunteer, idShop, search, startDate, endDate);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkWalletRecordsDAO) getBulkBlockQueryData(walletRecordsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    // Special Queries -------------------------------------------------------


    /**
     * Description
     * @param id long Wallet Records Identifier
     * @return Wallet Records Special Query
     */
    public static WalletRecordsGetBalanceSPQ getWalletRecordsFindByGetBalanceSPQ(long id) throws Exception {
        try {
            // Return data
            return datasource.getWalletRecordsFindByGetBalanceSPQ(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @return Wallet Records Special Query
     */
    public static BulkWalletRecordsTotalsSPQ getWalletRecordsFindByTotalsSPQ() throws Exception {
        try {
            // Return data
            return datasource.getWalletRecordsFindByTotalsSPQ();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param id long Wallet Records Identifier
     * @return Wallet Records Special Query
     */
    public static WalletRecordsMasterWalletSPQ getWalletRecordsFindByMasterWalletSPQ(long id) throws Exception {
        try {
            // Return data
            return datasource.getWalletRecordsFindByMasterWalletSPQ(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // GOOD TYPES Bean Methods -------------------------------------------------


    /**
     * Creates a Good Type
     * @param langCode String Good Types Lang Code
     * @param id long Good Types Identifier
     * @param name String Good Types Name
     * @param editInfo EditInfo Good Types Edit Info
     * @return Good Type created Identifier
     */
    public static long createGoodType(String langCode, String name, 
                                      EditInfo editInfo) throws Exception {
        // Local variables
        long mlkId;
        GoodTypesDAO goodTypes;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        goodTypes = new GoodTypesDAO(0, name, editInfo);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        goodTypes.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Good Type
            GlobalDBManager.create(goodTypes);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        name, null, null, null, null, null, null, null, null, null,
                                        null, null, null, null,
                                        null, null, null);
        } catch(Exception ex) {
            // Remove created
            removeGoodType(goodTypes.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Add the created object to the cache
        goodTypesSingleCache.put(goodTypes);
        // Return created Good Type Identifier
        return goodTypes.getId();
    }


    /**
     * GoodTypeUpdater
     * @param id
     * @param name
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateGoodType(long id, String name, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        GoodTypesDAO dao;
        GoodTypesDAO multiLangCheck;
        GoodTypesUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new GoodTypesUpdater(id, name, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getGoodType(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getName() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            name, null, null, null, null, null, null, null, null, null,
                                            null, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Good Type
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating GOOD_TYPES table", ex);
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Create DAO
        dao = new GoodTypesDAO(id);
        // Release cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * GoodTypeUpdater ByName
     * @param id
     * @param name
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateGoodTypeByName(long id, String name, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        GoodTypesDAO dao;
        GoodTypesDAO multiLangCheck;
        GoodTypesUpdaterByName updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new GoodTypesUpdaterByName(id, name, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getGoodType(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getName() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            name, null, null, null, null, null, null, null, null, null,
                                            null, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Good Type
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating GOOD_TYPES table on updater \"ByName\"", ex);
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Create DAO
        dao = new GoodTypesDAO(id);
        // Release cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Good Type
     * @param id long Good Types Identifier
     */
    public static void removeGoodType(long id) throws Exception {
            // Local Variables
        GoodTypesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Good Type
        try {
            // Delete Multilanguage Key Translations
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_TRANSLATIONS` WHERE ID_MLK = (SELECT MLK_ID FROM GOOD_TYPES WHERE ID = " + id + ")");
            // Delete Multilanguage Key
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_KEYS` WHERE ID = (SELECT MLK_ID FROM GOOD_TYPES WHERE ID = " + id + ")");
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM GOOD_TYPES WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Clears all single cache of this object
        goodTypesSingleCache.releasePattern(new GoodTypesDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Good Type
     * @param id long Good Types Identifier
     * @param defaultLangCode String Good Types Default Lang Code
     * @param editInfo EditInfo Good Types Edit Info
     */
    public static long copyGoodType(long id, String defaultLangCode, 
                                    EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        GoodTypesDAO copy;
        GoodTypesDAO original;
        // Get Original
        original = getGoodType(id, null);
        // Copy Original
        copyId = createGoodType(
                defaultLangCode, // langCode
                original.getName(), // name
                editInfo // Edit Info
        );
        // Get copied data
        copy = getGoodType(copyId, null);
        // Copy multi language key data
        MultiLanguageUtils.copyMultiLanguageKey(siteId, original.getMultiLangKeyId(), copy.getMultiLangKeyId());
        return copyId;
    }


    /**
     * Gets a Good Type
     * @param id long Good Types Identifier
     * @param langCode String Good Types Lang Code
     * @return Good Type DAO
     */
    public static GoodTypesDAO getGoodType(long id, String langCode) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        GoodTypesDAO dao;
        // Create DAO
        dao = new GoodTypesDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id, langCode);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (GoodTypesDAO) goodTypesSingleCache.get(dao);
    }
    /**
     * Gets a Good Type
     * @param id long Good Types Identifier
     * @param langCode String Good Types Lang Code
     * @return Good Type DAO
     */
    public static GoodTypesDAO getUncachedGoodType(long id, String langCode) throws Exception {
        try {
            return datasource.getGoodType(id, langCode);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param langCode String Good Types Lang Code
     * @return Good Types DAO
     */
    public static BulkGoodTypesDAO getGoodTypesFindByAll(String langCode) throws Exception {
        // Local Variables
        BulkGoodTypesDAO dao;
        BulkGoodTypesDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkGoodTypesDAO(BulkGoodTypesDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(langCode);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkGoodTypesDAO) goodTypesQueriesCache.get(dao);
    }


    /**
     * Checks all the translations for specific fields in a GoodType
     * @param id GoodType id
     * @param fields Multi Language fields to search if exist translations
     * @throws Exception
     */
    public static String getGoodTypeTranslatedLanguages(long id, GoodTypesDAO.MultiLanguageFields... fields) throws Exception{
        // Local Variables
        String query;
        // Create query
        query = "SELECT group_concat(lang_code) as translations FROM GOOD_TYPES, `weezziserver`.multilang_translations " +
                "WHERE GOOD_TYPES.id = " + id + " AND `weezziserver`.multilang_translations.id_mlk= GOOD_TYPES.MLK_ID";
        // Append mandatory fields
        for(GoodTypesDAO.MultiLanguageFields field : fields) {
            query += "\n AND length(`weezziserver`.multilang_translations." + field.getColumnName() + ") > 0";
        }
        try {
            // Get translations
            return GlobalDBManager.getQueryStringColumnValue("Merits_Merits", query, "TRANSLATIONS");
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
    }


    /**
     * Moves a Good Type
     * @param sourceId long Good Types Source Id
     * @param destinationId long Good Types Destination Id
     * @param direction String Good Types Direction
     */
    public static void moveGoodType(long sourceId, long destinationId, 
                                    String direction) throws Exception {
        // Local variables
        GoodTypesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Good Type
            GlobalDBManager.executeSQL(new GoodTypesDAO().getDBConnectionName(), "CALL MOVE_GOOD_TYPES(" + sourceId + ", " + destinationId + ", '" + direction + "')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Create DAO
        dao = new GoodTypesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
        // Create DAO
        dao = new GoodTypesDAO();
        // Create search parameters for destination Id
        parameters = new DAOInstantParameters(destinationId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the First ordering position a Good Type
     * @param sourceId long Good Types Source Id
     */
    public static void moveFirstGoodType(long sourceId) throws Exception {
        // Local variables
        GoodTypesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Good Type
            GlobalDBManager.executeSQL(new GoodTypesDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_GOOD_TYPES(" + sourceId + ", 'first')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Create DAO
        dao = new GoodTypesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the Last ordering position a Good Type
     * @param sourceId long Good Types Source Id
     */
    public static void moveLastGoodType(long sourceId) throws Exception {
        // Local variables
        GoodTypesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Good Type
            GlobalDBManager.executeSQL(new GoodTypesDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_GOOD_TYPES(" + sourceId + ", 'last')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        goodTypesQueriesCache.clear();
        // Create DAO
        dao = new GoodTypesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        goodTypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    // List Methods ----------------------------------------------------------


    /**
     * Description
     * @return Good Types GoodTypes List
     */
    public static GoodTypesListGoodTypes getGoodTypesGoodTypesList() throws Exception {
        try {
            // Call datasource list getter method
            return datasource.getGoodTypesListGoodTypes();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // VOLUNTEERS Bean Methods -------------------------------------------------


    /**
     * Creates a Volunteer
     * @param id long Volunteers Identifier
     * @param idWallet long Volunteers Wallet Identifier
     * @param firstName String Volunteers First Name
     * @param lastName String Volunteers Last Name
     * @param loginEmail String Volunteers Login Email
     * @param loginPassword String Volunteers Login Password
     * @param isBlocked boolean Volunteers Is Blocked
     * @param editInfo EditInfo Volunteers Edit Info
     * @return Volunteer created Identifier
     */
    public static long createVolunteer(long idWallet, String firstName, 
                                       String lastName, String loginEmail, 
                                       String loginPassword, boolean isBlocked, 
                                       EditInfo editInfo) throws Exception {
        // Local variables
        VolunteersDAO volunteers;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        volunteers = new VolunteersDAO(0, idWallet, firstName, lastName, loginEmail, loginPassword, 
                                       isBlocked, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Volunteer
            GlobalDBManager.create(volunteers);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Add the created object to the cache
        volunteersSingleCache.put(volunteers);
        // Return created Volunteer Identifier
        return volunteers.getId();
    }


    /**
     * Creates a Volunteer
     * @param id long Volunteers Identifier
     * @param idWallet long Volunteers Wallet Identifier
     * @param idOrganization Long Volunteers Organization Identifier
     * @param firstName String Volunteers First Name
     * @param lastName String Volunteers Last Name
     * @param photo Image Volunteers Photo
     * @param address String Volunteers Address
     * @param mobile String Volunteers Mobile
     * @param country Long Volunteers Country
     * @param idCardType IdcardType Volunteers Card Type Identifier
     * @param cardNumber String Volunteers Card Number
     * @param preferredLanguage String Volunteers Preferred Language
     * @param loginEmail String Volunteers Login Email
     * @param loginPassword String Volunteers Login Password
     * @param isBlocked boolean Volunteers Is Blocked
     * @param editInfo EditInfo Volunteers Edit Info
     * @return Volunteer created Identifier
     */
    public static long createVolunteer(long idWallet, Long idOrganization, 
                                       String firstName, String lastName, 
                                       Image photo, String address, 
                                       String mobile, Long country, 
                                       IdcardType idCardType, String cardNumber, 
                                       String preferredLanguage, 
                                       String loginEmail, String loginPassword, 
                                       boolean isBlocked, EditInfo editInfo) throws Exception {
        // Local variables
        VolunteersDAO volunteers;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        volunteers = new VolunteersDAO(0, idWallet, idOrganization, firstName, lastName, photo, 
                                       address, mobile, country, idCardType, 
                                       cardNumber, preferredLanguage, loginEmail, 
                                       loginPassword, isBlocked, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Volunteer
            GlobalDBManager.create(volunteers);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Add the created object to the cache
        volunteersSingleCache.put(volunteers);
        // Return created Volunteer Identifier
        return volunteers.getId();
    }


    /**
     * VolunteerUpdater
     * @param id
     * @param idWallet
     * @param idOrganization
     * @param firstName
     * @param lastName
     * @param photo
     * @param address
     * @param mobile
     * @param country
     * @param idCardType
     * @param cardNumber
     * @param preferredLanguage
     * @param loginEmail
     * @param loginPassword
     * @param isBlocked
     * @param updateInfo Update Info
     */
    public static void updateVolunteer(long id, long idWallet, Long idOrganization, String firstName, String lastName, Image photo, String address, String mobile, Long country, IdcardType idCardType, String cardNumber, String preferredLanguage, String loginEmail, String loginPassword, boolean isBlocked, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        VolunteersUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new VolunteersUpdater(id, idWallet, idOrganization, firstName, lastName, photo, address, mobile, country, idCardType, cardNumber, preferredLanguage, loginEmail, loginPassword, isBlocked, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Volunteer
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating VOLUNTEERS table", ex);
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Create DAO
        dao = new VolunteersDAO(id);
        // Release cache
        volunteersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * VolunteerUpdater ByAll
     * @param id
     * @param idOrganization
     * @param firstName
     * @param lastName
     * @param photo
     * @param address
     * @param mobile
     * @param country
     * @param idCardType
     * @param cardNumber
     * @param loginEmail
     * @param isBlocked
     * @param updateInfo Update Info
     */
    public static void updateVolunteerByAll(long id, Long idOrganization, String firstName, String lastName, Image photo, String address, String mobile, Long country, IdcardType idCardType, String cardNumber, String loginEmail, boolean isBlocked, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        VolunteersUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new VolunteersUpdaterByAll(id, idOrganization, firstName, lastName, photo, address, mobile, country, idCardType, cardNumber, loginEmail, isBlocked, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Volunteer
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating VOLUNTEERS table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Create DAO
        dao = new VolunteersDAO(id);
        // Release cache
        volunteersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * VolunteerUpdater ByLanguage
     * @param id
     * @param preferredLanguage
     * @param updateInfo Update Info
     */
    public static void updateVolunteerByLanguage(long id, String preferredLanguage, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        VolunteersUpdaterByLanguage updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new VolunteersUpdaterByLanguage(id, preferredLanguage, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Volunteer
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating VOLUNTEERS table on updater \"ByLanguage\"", ex);
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Create DAO
        dao = new VolunteersDAO(id);
        // Release cache
        volunteersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * VolunteerUpdater ByPhoto
     * @param id
     * @param photo
     * @param updateInfo Update Info
     */
    public static void updateVolunteerByPhoto(long id, Image photo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        VolunteersUpdaterByPhoto updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new VolunteersUpdaterByPhoto(id, photo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Volunteer
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating VOLUNTEERS table on updater \"ByPhoto\"", ex);
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Create DAO
        dao = new VolunteersDAO(id);
        // Release cache
        volunteersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * VolunteerUpdater ByPassword
     * @param id
     * @param loginPassword
     * @param updateInfo Update Info
     */
    public static void updateVolunteerByPassword(long id, String loginPassword, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        VolunteersUpdaterByPassword updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new VolunteersUpdaterByPassword(id, loginPassword, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Volunteer
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating VOLUNTEERS table on updater \"ByPassword\"", ex);
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Create DAO
        dao = new VolunteersDAO(id);
        // Release cache
        volunteersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Volunteer
     * @param id long Volunteers Identifier
     */
    public static void removeVolunteer(long id) throws Exception {
            // Local Variables
        VolunteersDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getVolunteer(id);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
        }
        // Remove Volunteer
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM VOLUNTEERS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        volunteersQueriesCache.clear();
        // Clears all single cache of this object
        volunteersSingleCache.release(new VolunteersDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Volunteer
     * @param id long Volunteers Identifier
     * @param idWallet long Volunteers Wallet Identifier
     * @param idOrganization Long Volunteers Organization Identifier
     * @param editInfo EditInfo Volunteers Edit Info
     */
    public static long copyVolunteer(long id, long idWallet, Long idOrganization, 
                                     EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        VolunteersDAO copy;
        VolunteersDAO original;
        // Get Original
        original = getVolunteer(id);
        // Copy Original
        copyId = createVolunteer(
                idWallet, // Publish Info
                idOrganization, // Publish Info
                original.getFirstName(), // firstName
                original.getLastName(), // lastName
                original.getPhoto(), // photo
                original.getAddress(), // address
                original.getMobile(), // mobile
                original.getCountry(), // country
                original.getIdCardType(), // idCardType
                original.getCardNumber(), // cardNumber
                original.getPreferredLanguage(), // preferredLanguage
                original.getLoginEmail(), // loginEmail
                original.getLoginPassword(), // loginPassword
                original.getIsBlocked(), // isBlocked
                editInfo // Edit Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        return copyId;
    }


    /**
     * Gets a Volunteer
     * @param id long Volunteers Identifier
     * @return Volunteer DAO
     */
    public static VolunteersDAO getVolunteer(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        VolunteersDAO dao;
        // Create DAO
        dao = new VolunteersDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (VolunteersDAO) volunteersSingleCache.get(dao);
    }
    /**
     * Gets a Volunteer
     * @param id long Volunteers Identifier
     * @return Volunteer DAO
     */
    public static VolunteersDAO getUncachedVolunteer(long id) throws Exception {
        try {
            return datasource.getVolunteer(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param search String Volunteers Search
     * @return Volunteers DAO
     */
    public static BulkVolunteersDAO getVolunteersFindByAll(String search) throws Exception {
        // Local Variables
        BulkVolunteersDAO dao;
        BulkVolunteersDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkVolunteersDAO(BulkVolunteersDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(search);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkVolunteersDAO) volunteersQueriesCache.get(dao);
    }


    /**
     * Description
     * @param search String Volunteers Search
     * @param start int Volunteers Start
     * @param end int Volunteers End
     * @return Volunteers Bulk DTO
     */
    public static BulkVolunteersDAO getVolunteersBlockFindByAll(String search, 
                                                                int start, 
                                                                int end) {
        // Local Variables
        BulkVolunteersDAO.AllParameters parameters;
        BulkVolunteersDAO key, result;
        // Create Bulk DTO Key
        key = new BulkVolunteersDAO(BulkVolunteersDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(search);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkVolunteersDAO) getBulkBlockQueryData(volunteersQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Description
     * @param loginEmail String Volunteers Login Email
     * @return Volunteers DAO
     */
    public static VolunteersDAO getVolunteerFindByLogin(String loginEmail) throws Exception {
        // Local Variables
        VolunteersDAO dao;
        VolunteersDAO.LoginParameters parameters;
        // Create DAO
        dao = new VolunteersDAO(VolunteersDAO.SearchType.Login);
        // Create Parameters
        parameters = dao.new LoginParameters(loginEmail);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (VolunteersDAO) volunteersQueriesCache.get(dao);
    }
    /**
     * Description
     * @param loginEmail String Volunteers Login Email
     * @return Volunteers DAO
     */
    public static VolunteersDAO getUncachedVolunteerFindByLogin(
                                                                String loginEmail) throws Exception {
        // Call datasource directly
        return datasource.getVolunteerFindByLogin(loginEmail);
    }


    /**
     * Description
     * @param idWallet long Volunteers Wallet Identifier
     * @return Volunteers DAO
     */
    public static VolunteersDAO getVolunteerFindByWallet(long idWallet) throws Exception {
        // Local Variables
        VolunteersDAO dao;
        VolunteersDAO.WalletParameters parameters;
        // Create DAO
        dao = new VolunteersDAO(VolunteersDAO.SearchType.Wallet);
        // Create Parameters
        parameters = dao.new WalletParameters(idWallet);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (VolunteersDAO) volunteersQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idWallet long Volunteers Wallet Identifier
     * @return Volunteers DAO
     */
    public static VolunteersDAO getUncachedVolunteerFindByWallet(long idWallet) throws Exception {
        // Call datasource directly
        return datasource.getVolunteerFindByWallet(idWallet);
    }


    // Special Queries -------------------------------------------------------


    /**
     * Description
     * @return Volunteers Special Query
     */
    public static BulkVolunteersGetAllUsersSPQ getVolunteersFindByGetAllUsersSPQ() throws Exception {
        try {
            // Return data
            return datasource.getVolunteersFindByGetAllUsersSPQ();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param search String Volunteers Search
     * @return Volunteers Special Query
     */
    public static BulkVolunteersUsersSPQ getVolunteersFindByUsersSPQ(String search) throws Exception {
        try {
            // Return data
            return datasource.getVolunteersFindByUsersSPQ(search);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // List Methods ----------------------------------------------------------


    /**
     * Description
     * @return Volunteers Volunteers List
     */
    public static VolunteersListVolunteers getVolunteersVolunteersList() throws Exception {
        try {
            // Call datasource list getter method
            return datasource.getVolunteersListVolunteers();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // SHOPS Bean Methods ------------------------------------------------------


    /**
     * Creates a Shop
     * @param id long Shops Identifier
     * @param idWallet long Shops Wallet Identifier
     * @param name String Shops Name
     * @param editInfo EditInfo Shops Edit Info
     * @return Shop created Identifier
     */
    public static long createShop(long idWallet, String name, EditInfo editInfo) throws Exception {
        // Local variables
        ShopsDAO shops;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shops = new ShopsDAO(0, idWallet, name, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Shop
            GlobalDBManager.create(shops);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Add the created object to the cache
        shopsSingleCache.put(shops);
        // Return created Shop Identifier
        return shops.getId();
    }


    /**
     * Creates a Shop
     * @param id long Shops Identifier
     * @param idWallet long Shops Wallet Identifier
     * @param idCity Long Shops City Identifier
     * @param name String Shops Name
     * @param photo Image Shops Photo
     * @param location MapInfo Shops Location
     * @param ownerFirstName String Shops Owner First Name
     * @param ownerLastName String Shops Owner Last Name
     * @param ownerMobile Phone Shops Owner Mobile
     * @param ownerEmail String Shops Owner Email
     * @param bankIban String Shops Bank Iban
     * @param bankSwift String Shops Bank Swift
     * @param address String Shops Address
     * @param notes String Shops Notes
     * @param shopUrl String Shops Shop Url
     * @param shopPhone String Shops Shop Phone
     * @param shopEmail String Shops Shop Email
     * @param preferredLanguage String Shops Preferred Language
     * @param ownerLogin String Shops Owner Login
     * @param ownerPassword String Shops Owner Password
     * @param editInfo EditInfo Shops Edit Info
     * @return Shop created Identifier
     */
    public static long createShop(long idWallet, Long idCity, String name, 
                                  Image photo, MapInfo location, 
                                  String ownerFirstName, String ownerLastName, 
                                  Phone ownerMobile, String ownerEmail, 
                                  String bankIban, String bankSwift, 
                                  String address, String notes, String shopUrl, 
                                  String shopPhone, String shopEmail, 
                                  String preferredLanguage, String ownerLogin, 
                                  String ownerPassword, EditInfo editInfo) throws Exception {
        // Local variables
        ShopsDAO shops;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shops = new ShopsDAO(0, idWallet, idCity, name, photo, location, ownerFirstName, 
                             ownerLastName, ownerMobile, ownerEmail, bankIban, 
                             bankSwift, address, notes, shopUrl, shopPhone, 
                             shopEmail, preferredLanguage, ownerLogin, 
                             ownerPassword, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Shop
            GlobalDBManager.create(shops);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Add the created object to the cache
        shopsSingleCache.put(shops);
        // Return created Shop Identifier
        return shops.getId();
    }


    /**
     * ShopUpdater
     * @param id
     * @param idWallet
     * @param idCity
     * @param name
     * @param photo
     * @param location
     * @param ownerFirstName
     * @param ownerLastName
     * @param ownerMobile
     * @param ownerEmail
     * @param bankIban
     * @param bankSwift
     * @param address
     * @param notes
     * @param shopUrl
     * @param shopPhone
     * @param shopEmail
     * @param preferredLanguage
     * @param ownerLogin
     * @param ownerPassword
     * @param updateInfo Update Info
     */
    public static void updateShop(long id, long idWallet, Long idCity, String name, Image photo, MapInfo location, String ownerFirstName, String ownerLastName, Phone ownerMobile, String ownerEmail, String bankIban, String bankSwift, String address, String notes, String shopUrl, String shopPhone, String shopEmail, String preferredLanguage, String ownerLogin, String ownerPassword, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopsDAO dao;
        ShopsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopsUpdater(id, idWallet, idCity, name, photo, location, ownerFirstName, ownerLastName, ownerMobile, ownerEmail, bankIban, bankSwift, address, notes, shopUrl, shopPhone, shopEmail, preferredLanguage, ownerLogin, ownerPassword, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Shop
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOPS table", ex);
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Create DAO
        dao = new ShopsDAO(id);
        // Release cache
        shopsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopUpdater ByAll
     * @param id
     * @param name
     * @param photo
     * @param ownerFirstName
     * @param ownerLastName
     * @param ownerMobile
     * @param ownerEmail
     * @param bankIban
     * @param bankSwift
     * @param address
     * @param notes
     * @param shopUrl
     * @param shopPhone
     * @param shopEmail
     * @param ownerLogin
     * @param updateInfo Update Info
     */
    public static void updateShopByAll(long id, String name, Image photo, String ownerFirstName, String ownerLastName, Phone ownerMobile, String ownerEmail, String bankIban, String bankSwift, String address, String notes, String shopUrl, String shopPhone, String shopEmail, String ownerLogin, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopsDAO dao;
        ShopsUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopsUpdaterByAll(id, name, photo, ownerFirstName, ownerLastName, ownerMobile, ownerEmail, bankIban, bankSwift, address, notes, shopUrl, shopPhone, shopEmail, ownerLogin, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Shop
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOPS table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Create DAO
        dao = new ShopsDAO(id);
        // Release cache
        shopsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopUpdater ByLanguage
     * @param id
     * @param preferredLanguage
     * @param updateInfo Update Info
     */
    public static void updateShopByLanguage(long id, String preferredLanguage, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopsDAO dao;
        ShopsUpdaterByLanguage updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopsUpdaterByLanguage(id, preferredLanguage, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Shop
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOPS table on updater \"ByLanguage\"", ex);
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Create DAO
        dao = new ShopsDAO(id);
        // Release cache
        shopsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopUpdater ByPassword
     * @param id
     * @param ownerPassword
     * @param updateInfo Update Info
     */
    public static void updateShopByPassword(long id, String ownerPassword, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopsDAO dao;
        ShopsUpdaterByPassword updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopsUpdaterByPassword(id, ownerPassword, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Shop
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOPS table on updater \"ByPassword\"", ex);
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Create DAO
        dao = new ShopsDAO(id);
        // Release cache
        shopsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Shop
     * @param id long Shops Identifier
     */
    public static void removeShop(long id) throws Exception {
            // Local Variables
        ShopsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getShop(id);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
        }
        // Remove Shop
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SHOPS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        shopsQueriesCache.clear();
        // Clears all single cache of this object
        shopsSingleCache.release(new ShopsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Shop
     * @param id long Shops Identifier
     * @param idWallet long Shops Wallet Identifier
     * @param idCity Long Shops City Identifier
     * @param editInfo EditInfo Shops Edit Info
     */
    public static long copyShop(long id, long idWallet, Long idCity, 
                                EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        ShopsDAO copy;
        ShopsDAO original;
        // Get Original
        original = getShop(id);
        // Copy Original
        copyId = createShop(
                idWallet, // Publish Info
                idCity, // Publish Info
                original.getName(), // name
                original.getPhoto(), // photo
                original.getLocation(), // location
                original.getOwnerFirstName(), // ownerFirstName
                original.getOwnerLastName(), // ownerLastName
                original.getOwnerMobile(), // ownerMobile
                original.getOwnerEmail(), // ownerEmail
                original.getBankIban(), // bankIban
                original.getBankSwift(), // bankSwift
                original.getAddress(), // address
                original.getNotes(), // notes
                original.getShopUrl(), // shopUrl
                original.getShopPhone(), // shopPhone
                original.getShopEmail(), // shopEmail
                original.getPreferredLanguage(), // preferredLanguage
                original.getOwnerLogin(), // ownerLogin
                original.getOwnerPassword(), // ownerPassword
                editInfo // Edit Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        return copyId;
    }


    /**
     * Gets a Shop
     * @param id long Shops Identifier
     * @return Shop DAO
     */
    public static ShopsDAO getShop(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ShopsDAO dao;
        // Create DAO
        dao = new ShopsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ShopsDAO) shopsSingleCache.get(dao);
    }
    /**
     * Gets a Shop
     * @param id long Shops Identifier
     * @return Shop DAO
     */
    public static ShopsDAO getUncachedShop(long id) throws Exception {
        try {
            return datasource.getShop(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @return Shops DAO
     */
    public static BulkShopsDAO getShopsFindByGetAll() throws Exception {
        // Local Variables
        BulkShopsDAO dao;
        BulkShopsDAO.GetAllParameters parameters;
        // Create DAO
        dao = new BulkShopsDAO(BulkShopsDAO.SearchType.GetAll);
        // Create Parameters
        parameters = dao.new GetAllParameters(null);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopsDAO) shopsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param start int Shops Start
     * @param end int Shops End
     * @return Shops Bulk DTO
     */
    public static BulkShopsDAO getShopsBlockFindByGetAll(int start, int end) {
        // Local Variables
        BulkShopsDAO.GetAllParameters parameters;
        BulkShopsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkShopsDAO(BulkShopsDAO.SearchType.GetAll);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new GetAllParameters(null);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkShopsDAO) getBulkBlockQueryData(shopsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Description
     * @param search String Shops Search
     * @return Shops DAO
     */
    public static BulkShopsDAO getShopsFindByGetAll(String search) throws Exception {
        // Local Variables
        BulkShopsDAO dao;
        BulkShopsDAO.GetAllParameters parameters;
        // Create DAO
        dao = new BulkShopsDAO(BulkShopsDAO.SearchType.GetAll);
        // Create Parameters
        parameters = dao.new GetAllParameters(search);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopsDAO) shopsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param search String Shops Search
     * @param start int Shops Start
     * @param end int Shops End
     * @return Shops Bulk DTO
     */
    public static BulkShopsDAO getShopsBlockFindByGetAll(String search, 
                                                         int start, int end) {
        // Local Variables
        BulkShopsDAO.GetAllParameters parameters;
        BulkShopsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkShopsDAO(BulkShopsDAO.SearchType.GetAll);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new GetAllParameters(search);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkShopsDAO) getBulkBlockQueryData(shopsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Description
     * @param idWallet long Shops Wallet Identifier
     * @return Shops DAO
     */
    public static ShopsDAO getShopFindByWallet(long idWallet) throws Exception {
        // Local Variables
        ShopsDAO dao;
        ShopsDAO.WalletParameters parameters;
        // Create DAO
        dao = new ShopsDAO(ShopsDAO.SearchType.Wallet);
        // Create Parameters
        parameters = dao.new WalletParameters(idWallet);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (ShopsDAO) shopsQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idWallet long Shops Wallet Identifier
     * @return Shops DAO
     */
    public static ShopsDAO getUncachedShopFindByWallet(long idWallet) throws Exception {
        // Call datasource directly
        return datasource.getShopFindByWallet(idWallet);
    }


    // List Methods ----------------------------------------------------------


    /**
     * Description
     * @return Shops Shops List
     */
    public static ShopsListShops getShopsShopsList() throws Exception {
        try {
            // Call datasource list getter method
            return datasource.getShopsListShops();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // SHOP CASHIERS Bean Methods ----------------------------------------------


    /**
     * Creates a Shop Cashier
     * @param id long Shop Cashiers Identifier
     * @param idShop long Shop Cashiers Shop Identifier
     * @return Shop Cashier created Identifier
     */
    public static long createShopCashier(long idShop) throws Exception {
        // Local variables
        ShopCashiersDAO shopCashiers;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shopCashiers = new ShopCashiersDAO(0, idShop);
        // Call DB Manager Adder Method
        try {
            // Add Shop Cashier
            GlobalDBManager.create(shopCashiers);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Add the created object to the cache
        shopCashiersSingleCache.put(shopCashiers);
        // Return created Shop Cashier Identifier
        return shopCashiers.getId();
    }


    /**
     * Creates a Shop Cashier
     * @param id long Shop Cashiers Identifier
     * @param idShop long Shop Cashiers Shop Identifier
     * @param firstName String Shop Cashiers First Name
     * @param lastName String Shop Cashiers Last Name
     * @param phone String Shop Cashiers Phone
     * @param loginUsername String Shop Cashiers Login Username
     * @param loginPassword String Shop Cashiers Login Password
     * @param preferredLanguage String Shop Cashiers Preferred Language
     * @return Shop Cashier created Identifier
     */
    public static long createShopCashier(long idShop, String firstName, 
                                         String lastName, String phone, 
                                         String loginUsername, 
                                         String loginPassword, 
                                         String preferredLanguage) throws Exception {
        // Local variables
        ShopCashiersDAO shopCashiers;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shopCashiers = new ShopCashiersDAO(0, idShop, firstName, lastName, phone, loginUsername, 
                                           loginPassword, preferredLanguage);
        // Call DB Manager Adder Method
        try {
            // Add Shop Cashier
            GlobalDBManager.create(shopCashiers);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Add the created object to the cache
        shopCashiersSingleCache.put(shopCashiers);
        // Return created Shop Cashier Identifier
        return shopCashiers.getId();
    }


    /**
     * ShopCashierUpdater
     * @param id
     * @param idShop
     * @param firstName
     * @param lastName
     * @param phone
     * @param loginUsername
     * @param loginPassword
     * @param preferredLanguage
     */
    public static void updateShopCashier(long id, long idShop, String firstName, String lastName, String phone, String loginUsername, String loginPassword, String preferredLanguage) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopCashiersDAO dao;
        ShopCashiersUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopCashiersUpdater(id, idShop, firstName, lastName, phone, loginUsername, loginPassword, preferredLanguage);
        // Call DB Manager Updater Method
        try {
            // Update Shop Cashier
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_CASHIERS table", ex);
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Create DAO
        dao = new ShopCashiersDAO(id);
        // Release cache
        shopCashiersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopCashierUpdater ByAll
     * @param id
     * @param firstName
     * @param lastName
     * @param phone
     * @param loginUsername
     */
    public static void updateShopCashierByAll(long id, String firstName, String lastName, String phone, String loginUsername) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopCashiersDAO dao;
        ShopCashiersUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopCashiersUpdaterByAll(id, firstName, lastName, phone, loginUsername);
        // Call DB Manager Updater Method
        try {
            // Update Shop Cashier
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_CASHIERS table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Create DAO
        dao = new ShopCashiersDAO(id);
        // Release cache
        shopCashiersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopCashierUpdater ByPassword
     * @param id
     * @param loginPassword
     */
    public static void updateShopCashierByPassword(long id, String loginPassword) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopCashiersDAO dao;
        ShopCashiersUpdaterByPassword updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopCashiersUpdaterByPassword(id, loginPassword);
        // Call DB Manager Updater Method
        try {
            // Update Shop Cashier
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_CASHIERS table on updater \"ByPassword\"", ex);
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Create DAO
        dao = new ShopCashiersDAO(id);
        // Release cache
        shopCashiersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ShopCashierUpdater ByLanguage
     * @param id
     * @param preferredLanguage
     */
    public static void updateShopCashierByLanguage(long id, String preferredLanguage) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopCashiersDAO dao;
        ShopCashiersUpdaterByLanguage updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopCashiersUpdaterByLanguage(id, preferredLanguage);
        // Call DB Manager Updater Method
        try {
            // Update Shop Cashier
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_CASHIERS table on updater \"ByLanguage\"", ex);
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Create DAO
        dao = new ShopCashiersDAO(id);
        // Release cache
        shopCashiersSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Shop Cashier
     * @param id long Shop Cashiers Identifier
     */
    public static void removeShopCashier(long id) throws Exception {
            // Local Variables
        ShopCashiersDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Shop Cashier
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SHOP_CASHIERS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        shopCashiersQueriesCache.clear();
        // Clears all single cache of this object
        shopCashiersSingleCache.release(new ShopCashiersDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Shop Cashier
     * @param id long Shop Cashiers Identifier
     * @param idShop long Shop Cashiers Shop Identifier
     */
    public static long copyShopCashier(long id, long idShop) throws Exception {
        // Local Variables
        long copyId;
        ShopCashiersDAO copy;
        ShopCashiersDAO original;
        // Get Original
        original = getShopCashier(id);
        // Copy Original
        copyId = createShopCashier(
                idShop, // Publish Info
                original.getFirstName(), // firstName
                original.getLastName(), // lastName
                original.getPhone(), // phone
                original.getLoginUsername(), // loginUsername
                original.getLoginPassword(), // loginPassword
                original.getPreferredLanguage() // preferredLanguage
        );
        return copyId;
    }


    /**
     * Gets a Shop Cashier
     * @param id long Shop Cashiers Identifier
     * @return Shop Cashier DAO
     */
    public static ShopCashiersDAO getShopCashier(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ShopCashiersDAO dao;
        // Create DAO
        dao = new ShopCashiersDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ShopCashiersDAO) shopCashiersSingleCache.get(dao);
    }
    /**
     * Gets a Shop Cashier
     * @param id long Shop Cashiers Identifier
     * @return Shop Cashier DAO
     */
    public static ShopCashiersDAO getUncachedShopCashier(long id) throws Exception {
        try {
            return datasource.getShopCashier(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idShop long Shop Cashiers Shop Identifier
     * @param loginUsername String Shop Cashiers Login Username
     * @return Shop Cashiers DAO
     */
    public static ShopCashiersDAO getShopCashierFindByUsername(long idShop, 
                                                               String loginUsername) throws Exception {
        // Local Variables
        ShopCashiersDAO dao;
        ShopCashiersDAO.UsernameParameters parameters;
        // Create DAO
        dao = new ShopCashiersDAO(ShopCashiersDAO.SearchType.Username);
        // Create Parameters
        parameters = dao.new UsernameParameters(idShop, loginUsername);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (ShopCashiersDAO) shopCashiersQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idShop long Shop Cashiers Shop Identifier
     * @param loginUsername String Shop Cashiers Login Username
     * @return Shop Cashiers DAO
     */
    public static ShopCashiersDAO getUncachedShopCashierFindByUsername(
                                                                       long idShop, 
                                                                       String loginUsername) throws Exception {
        // Call datasource directly
        return datasource.getShopCashierFindByUsername(idShop, loginUsername);
    }


    /**
     * Description
     * @param idShop long Shop Cashiers Shop Identifier
     * @return Shop Cashiers DAO
     */
    public static BulkShopCashiersDAO getShopCashiersFindByAll(long idShop) throws Exception {
        // Local Variables
        BulkShopCashiersDAO dao;
        BulkShopCashiersDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkShopCashiersDAO(BulkShopCashiersDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(idShop);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopCashiersDAO) shopCashiersQueriesCache.get(dao);
    }


    // SHOP GOODTYPES Bean Methods ---------------------------------------------


    /**
     * Creates a Shop Goodtype
     * @param id long Shop Goodtypes Identifier
     * @param idShop long Shop Goodtypes Shop Identifier
     * @param idGoodtype long Shop Goodtypes Goodtype Identifier
     * @return Shop Goodtype created Identifier
     */
    public static long createShopGoodtype(long idShop, long idGoodtype) throws Exception {
        // Local variables
        ShopGoodtypesDAO shopGoodtypes;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shopGoodtypes = new ShopGoodtypesDAO(0, idShop, idGoodtype);
        // Call DB Manager Adder Method
        try {
            // Add Shop Goodtype
            GlobalDBManager.create(shopGoodtypes);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopGoodtypesQueriesCache.clear();
        // Add the created object to the cache
        shopGoodtypesSingleCache.put(shopGoodtypes);
        // Return created Shop Goodtype Identifier
        return shopGoodtypes.getId();
    }


    /**
     * ShopGoodtypeUpdater
     * @param id
     * @param idShop
     * @param idGoodtype
     */
    public static void updateShopGoodtype(long id, long idShop, long idGoodtype) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopGoodtypesDAO dao;
        ShopGoodtypesUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopGoodtypesUpdater(id, idShop, idGoodtype);
        // Call DB Manager Updater Method
        try {
            // Update Shop Goodtype
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_GOODTYPES table", ex);
            throw ex;
        }
        // CACHES
        shopGoodtypesQueriesCache.clear();
        // Create DAO
        dao = new ShopGoodtypesDAO(id);
        // Release cache
        shopGoodtypesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Shop Goodtype
     * @param id long Shop Goodtypes Identifier
     */
    public static void removeShopGoodtype(long id) throws Exception {
            // Local Variables
        ShopGoodtypesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Shop Goodtype
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SHOP_GOODTYPES WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        shopGoodtypesQueriesCache.clear();
        // Clears all single cache of this object
        shopGoodtypesSingleCache.release(new ShopGoodtypesDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Shop Goodtype
     * @param id long Shop Goodtypes Identifier
     * @param idShop long Shop Goodtypes Shop Identifier
     * @param idGoodtype long Shop Goodtypes Goodtype Identifier
     */
    public static long copyShopGoodtype(long id, long idShop, long idGoodtype) throws Exception {
        // Local Variables
        long copyId;
        ShopGoodtypesDAO copy;
        ShopGoodtypesDAO original;
        // Get Original
        original = getShopGoodtype(id);
        // Copy Original
        copyId = createShopGoodtype(
                idShop, // Publish Info
                idGoodtype // Publish Info
        );
        return copyId;
    }


    /**
     * Gets a Shop Goodtype
     * @param id long Shop Goodtypes Identifier
     * @return Shop Goodtype DAO
     */
    public static ShopGoodtypesDAO getShopGoodtype(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ShopGoodtypesDAO dao;
        // Create DAO
        dao = new ShopGoodtypesDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ShopGoodtypesDAO) shopGoodtypesSingleCache.get(dao);
    }
    /**
     * Gets a Shop Goodtype
     * @param id long Shop Goodtypes Identifier
     * @return Shop Goodtype DAO
     */
    public static ShopGoodtypesDAO getUncachedShopGoodtype(long id) throws Exception {
        try {
            return datasource.getShopGoodtype(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idShop long Shop Goodtypes Shop Identifier
     * @return Shop Goodtypes DAO
     */
    public static BulkShopGoodtypesDAO getShopGoodtypesFindByGoodTypes(
                                                                       long idShop) throws Exception {
        // Local Variables
        BulkShopGoodtypesDAO dao;
        BulkShopGoodtypesDAO.GoodTypesParameters parameters;
        // Create DAO
        dao = new BulkShopGoodtypesDAO(BulkShopGoodtypesDAO.SearchType.GoodTypes);
        // Create Parameters
        parameters = dao.new GoodTypesParameters(idShop);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopGoodtypesDAO) shopGoodtypesQueriesCache.get(dao);
    }


    /**
     * Description
     * @param idShop long Shop Goodtypes Shop Identifier
     * @param idGoodtype long Shop Goodtypes Goodtype Identifier
     * @return Shop Goodtypes DAO
     */
    public static ShopGoodtypesDAO getShopGoodtypeFindByCheck(long idShop, 
                                                              long idGoodtype) throws Exception {
        // Local Variables
        ShopGoodtypesDAO dao;
        ShopGoodtypesDAO.CheckParameters parameters;
        // Create DAO
        dao = new ShopGoodtypesDAO(ShopGoodtypesDAO.SearchType.Check);
        // Create Parameters
        parameters = dao.new CheckParameters(idShop, idGoodtype);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (ShopGoodtypesDAO) shopGoodtypesQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idShop long Shop Goodtypes Shop Identifier
     * @param idGoodtype long Shop Goodtypes Goodtype Identifier
     * @return Shop Goodtypes DAO
     */
    public static ShopGoodtypesDAO getUncachedShopGoodtypeFindByCheck(
                                                                      long idShop, 
                                                                      long idGoodtype) throws Exception {
        // Call datasource directly
        return datasource.getShopGoodtypeFindByCheck(idShop, idGoodtype);
    }


    // Special Queries -------------------------------------------------------


    /**
     * Description
     * @param shopId long Shop Goodtypes Shop Id
     * @param langCode String Shop Goodtypes Lang Code
     * @return Shop Goodtypes Special Query
     */
    public static BulkShopGoodtypesShopGoodSPQ getShopGoodtypesFindByShopGoodSPQ(long shopId, 
                                                                                 String langCode) throws Exception {
        try {
            // Return data
            return datasource.getShopGoodtypesFindByShopGoodSPQ(shopId, langCode);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // SHOP TRANSACTIONS Bean Methods ------------------------------------------


    /**
     * Creates a Shop Transaction
     * @param id long Shop Transactions Identifier
     * @param idShop long Shop Transactions Shop Identifier
     * @param idCashier long Shop Transactions Cashier Identifier
     * @param idVolunteer long Shop Transactions Volunteer Identifier
     * @param idVolunteerWalletRecord long Shop Transactions Volunteer Wallet Record Identifier
     * @param idShopWalletRecord long Shop Transactions Shop Wallet Record Identifier
     * @param transactionDate Timestamp Shop Transactions Transaction Date
     * @param goodTypes String Shop Transactions Good Types
     * @param transactionValue float Shop Transactions Transaction Value
     * @return Shop Transaction created Identifier
     */
    public static long createShopTransaction(long idShop, long idCashier, 
                                             long idVolunteer, 
                                             long idVolunteerWalletRecord, 
                                             long idShopWalletRecord, 
                                             Timestamp transactionDate, 
                                             String goodTypes, 
                                             float transactionValue) throws Exception {
        // Local variables
        ShopTransactionsDAO shopTransactions;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shopTransactions = new ShopTransactionsDAO(0, idShop, idCashier, idVolunteer, 
                                                   idVolunteerWalletRecord, 
                                                   idShopWalletRecord, 
                                                   transactionDate, goodTypes, 
                                                   transactionValue);
        // Call DB Manager Adder Method
        try {
            // Add Shop Transaction
            GlobalDBManager.create(shopTransactions);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopTransactionsQueriesCache.clear();
        // Add the created object to the cache
        shopTransactionsSingleCache.put(shopTransactions);
        // Return created Shop Transaction Identifier
        return shopTransactions.getId();
    }


    /**
     * ShopTransactionUpdater
     * @param id
     * @param idShop
     * @param idCashier
     * @param idVolunteer
     * @param idVolunteerWalletRecord
     * @param idShopWalletRecord
     * @param transactionDate
     * @param goodTypes
     * @param transactionValue
     */
    public static void updateShopTransaction(long id, long idShop, long idCashier, long idVolunteer, long idVolunteerWalletRecord, long idShopWalletRecord, Timestamp transactionDate, String goodTypes, float transactionValue) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopTransactionsDAO dao;
        ShopTransactionsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopTransactionsUpdater(id, idShop, idCashier, idVolunteer, idVolunteerWalletRecord, idShopWalletRecord, transactionDate, goodTypes, transactionValue);
        // Call DB Manager Updater Method
        try {
            // Update Shop Transaction
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_TRANSACTIONS table", ex);
            throw ex;
        }
        // CACHES
        shopTransactionsQueriesCache.clear();
        // Create DAO
        dao = new ShopTransactionsDAO(id);
        // Release cache
        shopTransactionsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Shop Transaction
     * @param id long Shop Transactions Identifier
     */
    public static void removeShopTransaction(long id) throws Exception {
            // Local Variables
        ShopTransactionsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Shop Transaction
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SHOP_TRANSACTIONS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        shopTransactionsQueriesCache.clear();
        // Clears all single cache of this object
        shopTransactionsSingleCache.release(new ShopTransactionsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Shop Transaction
     * @param id long Shop Transactions Identifier
     * @param idShop long Shop Transactions Shop Identifier
     * @param idCashier long Shop Transactions Cashier Identifier
     * @param idVolunteer long Shop Transactions Volunteer Identifier
     * @param idVolunteerWalletRecord long Shop Transactions Volunteer Wallet Record Identifier
     * @param idShopWalletRecord long Shop Transactions Shop Wallet Record Identifier
     */
    public static long copyShopTransaction(long id, long idShop, long idCashier, 
                                           long idVolunteer, 
                                           long idVolunteerWalletRecord, 
                                           long idShopWalletRecord) throws Exception {
        // Local Variables
        long copyId;
        ShopTransactionsDAO copy;
        ShopTransactionsDAO original;
        // Get Original
        original = getShopTransaction(id);
        // Copy Original
        copyId = createShopTransaction(
                idShop, // Publish Info
                idCashier, // Publish Info
                idVolunteer, // Publish Info
                idVolunteerWalletRecord, // Publish Info
                idShopWalletRecord, // Publish Info
                original.getTransactionDate(), // transactionDate
                original.getGoodTypes(), // goodTypes
                original.getTransactionValue() // transactionValue
        );
        return copyId;
    }


    /**
     * Gets a Shop Transaction
     * @param id long Shop Transactions Identifier
     * @return Shop Transaction DAO
     */
    public static ShopTransactionsDAO getShopTransaction(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ShopTransactionsDAO dao;
        // Create DAO
        dao = new ShopTransactionsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ShopTransactionsDAO) shopTransactionsSingleCache.get(dao);
    }
    /**
     * Gets a Shop Transaction
     * @param id long Shop Transactions Identifier
     * @return Shop Transaction DAO
     */
    public static ShopTransactionsDAO getUncachedShopTransaction(long id) throws Exception {
        try {
            return datasource.getShopTransaction(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idVolunteerWalletRecord long Shop Transactions Volunteer Wallet Record Identifier
     * @return Shop Transactions DAO
     */
    public static ShopTransactionsDAO getShopTransactionFindByVolunteerWallet(
                                                                              long idVolunteerWalletRecord) throws Exception {
        // Local Variables
        ShopTransactionsDAO dao;
        ShopTransactionsDAO.VolunteerWalletParameters parameters;
        // Create DAO
        dao = new ShopTransactionsDAO(ShopTransactionsDAO.SearchType.VolunteerWallet);
        // Create Parameters
        parameters = dao.new VolunteerWalletParameters(idVolunteerWalletRecord);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (ShopTransactionsDAO) shopTransactionsQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idVolunteerWalletRecord long Shop Transactions Volunteer Wallet Record Identifier
     * @return Shop Transactions DAO
     */
    public static ShopTransactionsDAO getUncachedShopTransactionFindByVolunteerWallet(
                                                                                      long idVolunteerWalletRecord) throws Exception {
        // Call datasource directly
        return datasource.getShopTransactionFindByVolunteerWallet(idVolunteerWalletRecord);
    }


    /**
     * Description
     * @param idShop long Shop Transactions Shop Identifier
     * @return Shop Transactions DAO
     */
    public static BulkShopTransactionsDAO getShopTransactionsFindByShop(
                                                                        long idShop) throws Exception {
        // Local Variables
        BulkShopTransactionsDAO dao;
        BulkShopTransactionsDAO.ShopParameters parameters;
        // Create DAO
        dao = new BulkShopTransactionsDAO(BulkShopTransactionsDAO.SearchType.Shop);
        // Create Parameters
        parameters = dao.new ShopParameters(idShop);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopTransactionsDAO) shopTransactionsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param idShop long Shop Transactions Shop Identifier
     * @param start int Shop Transactions Start
     * @param end int Shop Transactions End
     * @return Shop Transactions Bulk DTO
     */
    public static BulkShopTransactionsDAO getShopTransactionsBlockFindByShop(long idShop, 
                                                                             int start, 
                                                                             int end) {
        // Local Variables
        BulkShopTransactionsDAO.ShopParameters parameters;
        BulkShopTransactionsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkShopTransactionsDAO(BulkShopTransactionsDAO.SearchType.Shop);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new ShopParameters(idShop);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkShopTransactionsDAO) getBulkBlockQueryData(shopTransactionsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Description
     * @param idShop long Shop Transactions Shop Identifier
     * @param idCashier long Shop Transactions Cashier Identifier
     * @return Shop Transactions DAO
     */
    public static BulkShopTransactionsDAO getShopTransactionsFindByShopCashier(
                                                                               long idShop, 
                                                                               long idCashier) throws Exception {
        // Local Variables
        BulkShopTransactionsDAO dao;
        BulkShopTransactionsDAO.ShopCashierParameters parameters;
        // Create DAO
        dao = new BulkShopTransactionsDAO(BulkShopTransactionsDAO.SearchType.ShopCashier);
        // Create Parameters
        parameters = dao.new ShopCashierParameters(idShop, idCashier);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkShopTransactionsDAO) shopTransactionsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param idShop long Shop Transactions Shop Identifier
     * @param idCashier long Shop Transactions Cashier Identifier
     * @param start int Shop Transactions Start
     * @param end int Shop Transactions End
     * @return Shop Transactions Bulk DTO
     */
    public static BulkShopTransactionsDAO getShopTransactionsBlockFindByShopCashier(long idShop, 
                                                                                    long idCashier, 
                                                                                    int start, 
                                                                                    int end) {
        // Local Variables
        BulkShopTransactionsDAO.ShopCashierParameters parameters;
        BulkShopTransactionsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkShopTransactionsDAO(BulkShopTransactionsDAO.SearchType.ShopCashier);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new ShopCashierParameters(idShop, idCashier);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkShopTransactionsDAO) getBulkBlockQueryData(shopTransactionsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    // ORGANIZATIONS Bean Methods ----------------------------------------------


    /**
     * Creates a Organization
     * @param id long Organizations Identifier
     * @param idWallet long Organizations Wallet Identifier
     * @param name String Organizations Name
     * @param logo Image Organizations Logo
     * @param editInfo EditInfo Organizations Edit Info
     * @return Organization created Identifier
     */
    public static long createOrganization(long idWallet, String name, Image logo, 
                                          EditInfo editInfo) throws Exception {
        // Local variables
        OrganizationsDAO organizations;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        organizations = new OrganizationsDAO(0, idWallet, name, logo, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Organization
            GlobalDBManager.create(organizations);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        organizationsQueriesCache.clear();
        // Add the created object to the cache
        organizationsSingleCache.put(organizations);
        // Return created Organization Identifier
        return organizations.getId();
    }


    /**
     * OrganizationUpdater
     * @param id
     * @param idWallet
     * @param name
     * @param logo
     * @param updateInfo Update Info
     */
    public static void updateOrganization(long id, long idWallet, String name, Image logo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        OrganizationsDAO dao;
        OrganizationsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new OrganizationsUpdater(id, idWallet, name, logo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Organization
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating ORGANIZATIONS table", ex);
            throw ex;
        }
        // CACHES
        organizationsQueriesCache.clear();
        // Create DAO
        dao = new OrganizationsDAO(id);
        // Release cache
        organizationsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Organization
     * @param id long Organizations Identifier
     */
    public static void removeOrganization(long id) throws Exception {
            // Local Variables
        OrganizationsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getOrganization(id);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getLogo());
        }
        // Remove Organization
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM ORGANIZATIONS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        organizationsQueriesCache.clear();
        // Clears all single cache of this object
        organizationsSingleCache.release(new OrganizationsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Organization
     * @param id long Organizations Identifier
     * @param idWallet long Organizations Wallet Identifier
     * @param editInfo EditInfo Organizations Edit Info
     */
    public static long copyOrganization(long id, long idWallet, 
                                        EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        OrganizationsDAO copy;
        OrganizationsDAO original;
        // Get Original
        original = getOrganization(id);
        // Copy Original
        copyId = createOrganization(
                idWallet, // Publish Info
                original.getName(), // name
                original.getLogo(), // logo
                editInfo // Edit Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getLogo());
        return copyId;
    }


    /**
     * Gets a Organization
     * @param id long Organizations Identifier
     * @return Organization DAO
     */
    public static OrganizationsDAO getOrganization(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        OrganizationsDAO dao;
        // Create DAO
        dao = new OrganizationsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (OrganizationsDAO) organizationsSingleCache.get(dao);
    }
    /**
     * Gets a Organization
     * @param id long Organizations Identifier
     * @return Organization DAO
     */
    public static OrganizationsDAO getUncachedOrganization(long id) throws Exception {
        try {
            return datasource.getOrganization(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idWallet long Organizations Wallet Identifier
     * @return Organizations DAO
     */
    public static OrganizationsDAO getOrganizationFindByWalletId(long idWallet) throws Exception {
        // Local Variables
        OrganizationsDAO dao;
        OrganizationsDAO.WalletIdParameters parameters;
        // Create DAO
        dao = new OrganizationsDAO(OrganizationsDAO.SearchType.WalletId);
        // Create Parameters
        parameters = dao.new WalletIdParameters(idWallet);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (OrganizationsDAO) organizationsQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idWallet long Organizations Wallet Identifier
     * @return Organizations DAO
     */
    public static OrganizationsDAO getUncachedOrganizationFindByWalletId(
                                                                         long idWallet) throws Exception {
        // Call datasource directly
        return datasource.getOrganizationFindByWalletId(idWallet);
    }


    /**
     * Description
     * @return Organizations DAO
     */
    public static BulkOrganizationsDAO getOrganizationsFindByAll() throws Exception {
        // Local Variables
        BulkOrganizationsDAO dao;
        BulkOrganizationsDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkOrganizationsDAO(BulkOrganizationsDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters();
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkOrganizationsDAO) organizationsQueriesCache.get(dao);
    }


    // List Methods ----------------------------------------------------------


    /**
     * Description
     * @return Organizations Organizations List
     */
    public static OrganizationsListOrganizations getOrganizationsOrganizationsList() throws Exception {
        try {
            // Call datasource list getter method
            return datasource.getOrganizationsListOrganizations();
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // PAYMENTS CODE Bean Methods ----------------------------------------------


    /**
     * Creates a Payments Code
     * @param id long Payments Code Identifier
     * @param idVolunteer long Payments Code Volunteer Identifier
     * @param createDate Timestamp Payments Code Create Date
     * @param expiryDate Timestamp Payments Code Expiry Date
     * @param codeStatus PaymentCodeStatus Payments Code Code Status
     * @param paymentCode String Payments Code Payment Code
     * @return Payments Code created Identifier
     */
    public static long createPaymentsCode(long idVolunteer, Timestamp createDate, 
                                          Timestamp expiryDate, 
                                          PaymentCodeStatus codeStatus, 
                                          String paymentCode) throws Exception {
        // Local variables
        PaymentsCodeDAO paymentsCode;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        paymentsCode = new PaymentsCodeDAO(0, idVolunteer, createDate, expiryDate, codeStatus, 
                                           paymentCode);
        // Call DB Manager Adder Method
        try {
            // Add Payments Code
            GlobalDBManager.create(paymentsCode);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        paymentsCodeQueriesCache.clear();
        // Add the created object to the cache
        paymentsCodeSingleCache.put(paymentsCode);
        // Return created Payments Code Identifier
        return paymentsCode.getId();
    }


    /**
     * PaymentsCodeUpdater
     * @param id
     * @param idVolunteer
     * @param createDate
     * @param expiryDate
     * @param codeStatus
     * @param paymentCode
     */
    public static void updatePaymentsCode(long id, long idVolunteer, Timestamp createDate, Timestamp expiryDate, PaymentCodeStatus codeStatus, String paymentCode) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        PaymentsCodeDAO dao;
        PaymentsCodeUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new PaymentsCodeUpdater(id, idVolunteer, createDate, expiryDate, codeStatus, paymentCode);
        // Call DB Manager Updater Method
        try {
            // Update Payments Code
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PAYMENTS_CODE table", ex);
            throw ex;
        }
        // CACHES
        paymentsCodeQueriesCache.clear();
        // Create DAO
        dao = new PaymentsCodeDAO(id);
        // Release cache
        paymentsCodeSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * PaymentsCodeUpdater ByStatus
     * @param id
     * @param codeStatus
     * @param paymentCode
     */
    public static void updatePaymentsCodeByStatus(long id, PaymentCodeStatus codeStatus, String paymentCode) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        PaymentsCodeDAO dao;
        PaymentsCodeUpdaterByStatus updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new PaymentsCodeUpdaterByStatus(id, codeStatus, paymentCode);
        // Call DB Manager Updater Method
        try {
            // Update Payments Code
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PAYMENTS_CODE table on updater \"ByStatus\"", ex);
            throw ex;
        }
        // CACHES
        paymentsCodeQueriesCache.clear();
        // Create DAO
        dao = new PaymentsCodeDAO(id);
        // Release cache
        paymentsCodeSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Payments Code
     * @param id long Payments Code Identifier
     */
    public static void removePaymentsCode(long id) throws Exception {
            // Local Variables
        PaymentsCodeDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Payments Code
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM PAYMENTS_CODE WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        paymentsCodeQueriesCache.clear();
        // Clears all single cache of this object
        paymentsCodeSingleCache.release(new PaymentsCodeDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Payments Code
     * @param id long Payments Code Identifier
     * @param idVolunteer long Payments Code Volunteer Identifier
     */
    public static long copyPaymentsCode(long id, long idVolunteer) throws Exception {
        // Local Variables
        long copyId;
        PaymentsCodeDAO copy;
        PaymentsCodeDAO original;
        // Get Original
        original = getPaymentsCode(id);
        // Copy Original
        copyId = createPaymentsCode(
                idVolunteer, // Publish Info
                original.getCreateDate(), // createDate
                original.getExpiryDate(), // expiryDate
                original.getCodeStatus(), // codeStatus
                original.getPaymentCode() // paymentCode
        );
        return copyId;
    }


    /**
     * Gets a Payments Code
     * @param id long Payments Code Identifier
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getPaymentsCode(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        PaymentsCodeDAO dao;
        // Create DAO
        dao = new PaymentsCodeDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (PaymentsCodeDAO) paymentsCodeSingleCache.get(dao);
    }
    /**
     * Gets a Payments Code
     * @param id long Payments Code Identifier
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getUncachedPaymentsCode(long id) throws Exception {
        try {
            return datasource.getPaymentsCode(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param paymentCode String Payments Code Payment Code
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getPaymentsCodeFindByGetPaymentCode(
                                                                      String paymentCode) throws Exception {
        // Local Variables
        PaymentsCodeDAO dao;
        PaymentsCodeDAO.GetPaymentCodeParameters parameters;
        // Create DAO
        dao = new PaymentsCodeDAO(PaymentsCodeDAO.SearchType.GetPaymentCode);
        // Create Parameters
        parameters = dao.new GetPaymentCodeParameters(paymentCode);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (PaymentsCodeDAO) paymentsCodeQueriesCache.get(dao);
    }
    /**
     * Description
     * @param paymentCode String Payments Code Payment Code
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getUncachedPaymentsCodeFindByGetPaymentCode(
                                                                              String paymentCode) throws Exception {
        // Call datasource directly
        return datasource.getPaymentsCodeFindByGetPaymentCode(paymentCode);
    }


    /**
     * Description
     * @param idVolunteer long Payments Code Volunteer Identifier
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getPaymentsCodeFindByGetLatest(
                                                                 long idVolunteer) throws Exception {
        // Local Variables
        PaymentsCodeDAO dao;
        PaymentsCodeDAO.GetLatestParameters parameters;
        // Create DAO
        dao = new PaymentsCodeDAO(PaymentsCodeDAO.SearchType.GetLatest);
        // Create Parameters
        parameters = dao.new GetLatestParameters(idVolunteer);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (PaymentsCodeDAO) paymentsCodeQueriesCache.get(dao);
    }
    /**
     * Description
     * @param idVolunteer long Payments Code Volunteer Identifier
     * @return Payments Code DAO
     */
    public static PaymentsCodeDAO getUncachedPaymentsCodeFindByGetLatest(
                                                                         long idVolunteer) throws Exception {
        // Call datasource directly
        return datasource.getPaymentsCodeFindByGetLatest(idVolunteer);
    }


    // PAYMENTS REQUESTS Bean Methods ------------------------------------------


    /**
     * Creates a Payments Request
     * @param id long Payments Requests Identifier
     * @param idShop long Payments Requests Shop Identifier
     * @param idCashier long Payments Requests Cashier Identifier
     * @param idVolunteer long Payments Requests Volunteer Identifier
     * @param idPaymentCode long Payments Requests Payment Code Identifier
     * @param transactionValue float Payments Requests Transaction Value
     * @param goodTypes String Payments Requests Good Types
     * @param paymentStatus PaymentRequestStatus Payments Requests Payment Status
     * @return Payments Request created Identifier
     */
    public static long createPaymentsRequest(long idShop, long idCashier, 
                                             long idVolunteer, 
                                             long idPaymentCode, 
                                             float transactionValue, 
                                             String goodTypes, 
                                             PaymentRequestStatus paymentStatus) throws Exception {
        // Local variables
        PaymentsRequestsDAO paymentsRequests;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        paymentsRequests = new PaymentsRequestsDAO(0, idShop, idCashier, idVolunteer, idPaymentCode, 
                                                   transactionValue, goodTypes, 
                                                   paymentStatus);
        // Call DB Manager Adder Method
        try {
            // Add Payments Request
            GlobalDBManager.create(paymentsRequests);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        paymentsRequestsQueriesCache.clear();
        // Add the created object to the cache
        paymentsRequestsSingleCache.put(paymentsRequests);
        // Return created Payments Request Identifier
        return paymentsRequests.getId();
    }


    /**
     * PaymentsRequestUpdater
     * @param id
     * @param idShop
     * @param idCashier
     * @param idVolunteer
     * @param idPaymentCode
     * @param transactionValue
     * @param goodTypes
     * @param paymentStatus
     */
    public static void updatePaymentsRequest(long id, long idShop, long idCashier, long idVolunteer, long idPaymentCode, float transactionValue, String goodTypes, PaymentRequestStatus paymentStatus) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        PaymentsRequestsDAO dao;
        PaymentsRequestsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new PaymentsRequestsUpdater(id, idShop, idCashier, idVolunteer, idPaymentCode, transactionValue, goodTypes, paymentStatus);
        // Call DB Manager Updater Method
        try {
            // Update Payments Request
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PAYMENTS_REQUESTS table", ex);
            throw ex;
        }
        // CACHES
        paymentsRequestsQueriesCache.clear();
        // Create DAO
        dao = new PaymentsRequestsDAO(id);
        // Release cache
        paymentsRequestsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * PaymentsRequestUpdater ByStatus
     * @param id
     * @param paymentStatus
     */
    public static void updatePaymentsRequestByStatus(long id, PaymentRequestStatus paymentStatus) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        PaymentsRequestsDAO dao;
        PaymentsRequestsUpdaterByStatus updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new PaymentsRequestsUpdaterByStatus(id, paymentStatus);
        // Call DB Manager Updater Method
        try {
            // Update Payments Request
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PAYMENTS_REQUESTS table on updater \"ByStatus\"", ex);
            throw ex;
        }
        // CACHES
        paymentsRequestsQueriesCache.clear();
        // Create DAO
        dao = new PaymentsRequestsDAO(id);
        // Release cache
        paymentsRequestsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Payments Request
     * @param id long Payments Requests Identifier
     */
    public static void removePaymentsRequest(long id) throws Exception {
            // Local Variables
        PaymentsRequestsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Payments Request
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM PAYMENTS_REQUESTS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        paymentsRequestsQueriesCache.clear();
        // Clears all single cache of this object
        paymentsRequestsSingleCache.release(new PaymentsRequestsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Payments Request
     * @param id long Payments Requests Identifier
     * @param idShop long Payments Requests Shop Identifier
     * @param idCashier long Payments Requests Cashier Identifier
     * @param idVolunteer long Payments Requests Volunteer Identifier
     * @param idPaymentCode long Payments Requests Payment Code Identifier
     */
    public static long copyPaymentsRequest(long id, long idShop, long idCashier, 
                                           long idVolunteer, long idPaymentCode) throws Exception {
        // Local Variables
        long copyId;
        PaymentsRequestsDAO copy;
        PaymentsRequestsDAO original;
        // Get Original
        original = getPaymentsRequest(id);
        // Copy Original
        copyId = createPaymentsRequest(
                idShop, // Publish Info
                idCashier, // Publish Info
                idVolunteer, // Publish Info
                idPaymentCode, // Publish Info
                original.getTransactionValue(), // transactionValue
                original.getGoodTypes(), // goodTypes
                original.getPaymentStatus() // paymentStatus
        );
        return copyId;
    }


    /**
     * Gets a Payments Request
     * @param id long Payments Requests Identifier
     * @return Payments Request DAO
     */
    public static PaymentsRequestsDAO getPaymentsRequest(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        PaymentsRequestsDAO dao;
        // Create DAO
        dao = new PaymentsRequestsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (PaymentsRequestsDAO) paymentsRequestsSingleCache.get(dao);
    }
    /**
     * Gets a Payments Request
     * @param id long Payments Requests Identifier
     * @return Payments Request DAO
     */
    public static PaymentsRequestsDAO getUncachedPaymentsRequest(long id) throws Exception {
        try {
            return datasource.getPaymentsRequest(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // SHOP TRANSACTIONS GOODS Bean Methods ------------------------------------


    /**
     * Creates a Shop Transactions Good
     * @param id long Shop Transactions Goods Identifier
     * @param idShop long Shop Transactions Goods Shop Identifier
     * @param idCashier long Shop Transactions Goods Cashier Identifier
     * @param idGoodType long Shop Transactions Goods Good Type Identifier
     * @param idShopTransaction long Shop Transactions Goods Shop Transaction Identifier
     * @param transactionDate Timestamp Shop Transactions Goods Transaction Date
     * @return Shop Transactions Good created Identifier
     */
    public static long createShopTransactionsGood(long idShop, long idCashier, 
                                                  long idGoodType, 
                                                  long idShopTransaction, 
                                                  Timestamp transactionDate) throws Exception {
        // Local variables
        ShopTransactionsGoodsDAO shopTransactionsGoods;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        shopTransactionsGoods = new ShopTransactionsGoodsDAO(0, idShop, idCashier, idGoodType, 
                                                             idShopTransaction, 
                                                             transactionDate);
        // Call DB Manager Adder Method
        try {
            // Add Shop Transactions Good
            GlobalDBManager.create(shopTransactionsGoods);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        shopTransactionsGoodsQueriesCache.clear();
        // Add the created object to the cache
        shopTransactionsGoodsSingleCache.put(shopTransactionsGoods);
        // Return created Shop Transactions Good Identifier
        return shopTransactionsGoods.getId();
    }


    /**
     * ShopTransactionsGoodUpdater
     * @param id
     * @param idShop
     * @param idCashier
     * @param idGoodType
     * @param idShopTransaction
     * @param transactionDate
     */
    public static void updateShopTransactionsGood(long id, long idShop, long idCashier, long idGoodType, long idShopTransaction, Timestamp transactionDate) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ShopTransactionsGoodsDAO dao;
        ShopTransactionsGoodsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ShopTransactionsGoodsUpdater(id, idShop, idCashier, idGoodType, idShopTransaction, transactionDate);
        // Call DB Manager Updater Method
        try {
            // Update Shop Transactions Good
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SHOP_TRANSACTIONS_GOODS table", ex);
            throw ex;
        }
        // CACHES
        shopTransactionsGoodsQueriesCache.clear();
        // Create DAO
        dao = new ShopTransactionsGoodsDAO(id);
        // Release cache
        shopTransactionsGoodsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Shop Transactions Good
     * @param id long Shop Transactions Goods Identifier
     */
    public static void removeShopTransactionsGood(long id) throws Exception {
            // Local Variables
        ShopTransactionsGoodsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Shop Transactions Good
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SHOP_TRANSACTIONS_GOODS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        shopTransactionsGoodsQueriesCache.clear();
        // Clears all single cache of this object
        shopTransactionsGoodsSingleCache.release(new ShopTransactionsGoodsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Shop Transactions Good
     * @param id long Shop Transactions Goods Identifier
     * @param idShop long Shop Transactions Goods Shop Identifier
     * @param idCashier long Shop Transactions Goods Cashier Identifier
     * @param idGoodType long Shop Transactions Goods Good Type Identifier
     * @param idShopTransaction long Shop Transactions Goods Shop Transaction Identifier
     */
    public static long copyShopTransactionsGood(long id, long idShop, 
                                                long idCashier, long idGoodType, 
                                                long idShopTransaction) throws Exception {
        // Local Variables
        long copyId;
        ShopTransactionsGoodsDAO copy;
        ShopTransactionsGoodsDAO original;
        // Get Original
        original = getShopTransactionsGood(id);
        // Copy Original
        copyId = createShopTransactionsGood(
                idShop, // Publish Info
                idCashier, // Publish Info
                idGoodType, // Publish Info
                idShopTransaction, // Publish Info
                original.getTransactionDate() // transactionDate
        );
        return copyId;
    }


    /**
     * Gets a Shop Transactions Good
     * @param id long Shop Transactions Goods Identifier
     * @return Shop Transactions Good DAO
     */
    public static ShopTransactionsGoodsDAO getShopTransactionsGood(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ShopTransactionsGoodsDAO dao;
        // Create DAO
        dao = new ShopTransactionsGoodsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ShopTransactionsGoodsDAO) shopTransactionsGoodsSingleCache.get(dao);
    }
    /**
     * Gets a Shop Transactions Good
     * @param id long Shop Transactions Goods Identifier
     * @return Shop Transactions Good DAO
     */
    public static ShopTransactionsGoodsDAO getUncachedShopTransactionsGood(long id) throws Exception {
        try {
            return datasource.getShopTransactionsGood(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    // Executer Methods ------------------------------------------------------


    /**
     * Executes the DeleteAllFromTransaction
     * @param transactionId long Shop Transactions Goods Transaction Id
     * @return Executes the DeleteAllFromTransaction
     */
    public static void executeShopTransactionsGoodsDeleteAllFromTransaction(long transactionId) throws Exception {
        // Local Variables
        String query;
        QueryBuilder qbuilder;
        HashMap<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("TRANSACTIONID", 1);
        // Build Query
        // Create query
        qbuilder = new QueryBuilder("DELETE FROM SHOP_TRANSACTIONS_GOODS \r\n " + 
                                 "WHERE ID_SHOP_TRANSACTION = ?TRANSACTIONID");
        qbuilder.setDatabaseType(DatabaseType.MySQL);
        qbuilder.setTreatEnumsAsIntegers(true);
        // Get query
        query = qbuilder.getQuery(parameters, transactionId);
        try {
            // Execute query
            GlobalDBManager.executeSQL("Merits_Merits", query);
        } catch(Exception ex) {
            // Finder Exception caught
            Console.error("Could not execute DirectiveMapping \"Delete All\" executer", ex);
            throw ex;
        }
        // CACHES
        // Clears all single cache
        shopTransactionsGoodsSingleCache.clear();
        shopTransactionsGoodsQueriesCache.clear();
    }


    // COUNTRIES Bean Methods --------------------------------------------------


    /**
     * Creates a Country
     * @param id long Countries Identifier
     * @param name String Countries Name
     * @param publishInfo PublishInfo Countries Publish Info
     * @param editInfo EditInfo Countries Edit Info
     * @return Country created Identifier
     */
    public static long createCountry(String name, PublishInfo publishInfo, 
                                     EditInfo editInfo) throws Exception {
        // Local variables
        CountriesDAO countries;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        countries = new CountriesDAO(0, name, publishInfo, editInfo);
        // Call DB Manager Adder Method
        try {
            // Add Country
            GlobalDBManager.create(countries);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Add the created object to the cache
        countriesSingleCache.put(countries);
        // Return created Country Identifier
        return countries.getId();
    }


    /**
     * CountryUpdater
     * @param id
     * @param name
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateCountry(long id, String name, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CountriesDAO dao;
        CountriesUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CountriesUpdater(id, name, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Country
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COUNTRIES table", ex);
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Create DAO
        dao = new CountriesDAO(id);
        // Release cache
        countriesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CountryUpdater ByPublish
     * @param id
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateCountryByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CountriesDAO dao;
        CountriesUpdaterByPublish updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CountriesUpdaterByPublish(id, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Country
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COUNTRIES table on updater \"ByPublish\"", ex);
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Create DAO
        dao = new CountriesDAO(id);
        // Release cache
        countriesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CountryUpdater ByName
     * @param id
     * @param name
     * @param updateInfo Update Info
     */
    public static void updateCountryByName(long id, String name, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CountriesDAO dao;
        CountriesUpdaterByName updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CountriesUpdaterByName(id, name, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Country
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COUNTRIES table on updater \"ByName\"", ex);
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Create DAO
        dao = new CountriesDAO(id);
        // Release cache
        countriesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Country
     * @param id long Countries Identifier
     */
    public static void removeCountry(long id) throws Exception {
            // Local Variables
        CountriesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove Country
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM COUNTRIES WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Clears all single cache of this object
        countriesSingleCache.release(new CountriesDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Country
     * @param id long Countries Identifier
     * @param published PublishInfo Countries Published
     * @param editInfo EditInfo Countries Edit Info
     */
    public static long copyCountry(long id, PublishInfo published, 
                                   EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        CountriesDAO copy;
        CountriesDAO original;
        // Get Original
        original = getCountry(id);
        // Copy Original
        copyId = createCountry(
                original.getName(), // name
                published, // Publish Info
                editInfo // Edit Info
        );
        return copyId;
    }


    /**
     * Publishes / Unpublishes Country
     * @param id long Countries Identifier
     * @param published boolean Countries Published
     * @param userId long Countries User Id
     */
    public static void publishCountry(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        CountriesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info Country
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE COUNTRIES " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        countriesQueriesCache.clear();
        // Clears all single cache of this object
        countriesSingleCache.release(new CountriesDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a Country
     * @param id long Countries Identifier
     * @return Country DAO
     */
    public static CountriesDAO getCountry(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        CountriesDAO dao;
        // Create DAO
        dao = new CountriesDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (CountriesDAO) countriesSingleCache.get(dao);
    }
    /**
     * Gets a Country
     * @param id long Countries Identifier
     * @return Country DAO
     */
    public static CountriesDAO getUncachedCountry(long id) throws Exception {
        try {
            return datasource.getCountry(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @return Countries DAO
     */
    public static BulkCountriesDAO getCountriesFindByAll() throws Exception {
        // Local Variables
        BulkCountriesDAO dao;
        BulkCountriesDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkCountriesDAO(BulkCountriesDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters();
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkCountriesDAO) countriesQueriesCache.get(dao);
    }


    // CITIES Bean Methods -----------------------------------------------------


    /**
     * Creates a City
     * @param id long Cities Identifier
     * @param idCountry long Cities Country Identifier
     * @param name String Cities Name
     * @param geoLocation GeoLocation Cities Geo Location
     * @param editInfo EditInfo Cities Edit Info
     * @param publishInfo PublishInfo Cities Publish Info
     * @return City created Identifier
     */
    public static long createCity(long idCountry, String name, 
                                  GeoLocation geoLocation, EditInfo editInfo, 
                                  PublishInfo publishInfo) throws Exception {
        // Local variables
        CitiesDAO cities;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        cities = new CitiesDAO(0, idCountry, name, geoLocation, editInfo, publishInfo);
        // Call DB Manager Adder Method
        try {
            // Add City
            GlobalDBManager.create(cities);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Add the created object to the cache
        citiesSingleCache.put(cities);
        // Return created City Identifier
        return cities.getId();
    }


    /**
     * CityUpdater
     * @param id
     * @param idCountry
     * @param name
     * @param geoLocation
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateCity(long id, long idCountry, String name, GeoLocation geoLocation, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CitiesDAO dao;
        CitiesUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CitiesUpdater(id, idCountry, name, geoLocation, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update City
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating CITIES table", ex);
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Create DAO
        dao = new CitiesDAO(id);
        // Release cache
        citiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CityUpdater ByPublish
     * @param id
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateCityByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CitiesDAO dao;
        CitiesUpdaterByPublish updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CitiesUpdaterByPublish(id, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update City
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating CITIES table on updater \"ByPublish\"", ex);
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Create DAO
        dao = new CitiesDAO(id);
        // Release cache
        citiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CityUpdater ByAll
     * @param id
     * @param name
     * @param geoLocation
     * @param updateInfo Update Info
     */
    public static void updateCityByAll(long id, String name, GeoLocation geoLocation, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CitiesDAO dao;
        CitiesUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CitiesUpdaterByAll(id, name, geoLocation, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update City
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating CITIES table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Create DAO
        dao = new CitiesDAO(id);
        // Release cache
        citiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a City
     * @param id long Cities Identifier
     */
    public static void removeCity(long id) throws Exception {
            // Local Variables
        CitiesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Remove City
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM CITIES WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Clears all single cache of this object
        citiesSingleCache.release(new CitiesDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a City
     * @param id long Cities Identifier
     * @param idCountry long Cities Country Identifier
     * @param published PublishInfo Cities Published
     * @param editInfo EditInfo Cities Edit Info
     */
    public static long copyCity(long id, long idCountry, PublishInfo published, 
                                EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        CitiesDAO copy;
        CitiesDAO original;
        // Get Original
        original = getCity(id);
        // Copy Original
        copyId = createCity(
                idCountry, // Publish Info
                original.getName(), // name
                original.getGeoLocation(), // geoLocation
                editInfo, // Edit Info
                published // Publish Info
        );
        return copyId;
    }


    /**
     * Publishes / Unpublishes City
     * @param id long Cities Identifier
     * @param published boolean Cities Published
     * @param userId long Cities User Id
     */
    public static void publishCity(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        CitiesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info City
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE CITIES " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        citiesQueriesCache.clear();
        // Clears all single cache of this object
        citiesSingleCache.release(new CitiesDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a City
     * @param id long Cities Identifier
     * @return City DAO
     */
    public static CitiesDAO getCity(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        CitiesDAO dao;
        // Create DAO
        dao = new CitiesDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (CitiesDAO) citiesSingleCache.get(dao);
    }
    /**
     * Gets a City
     * @param id long Cities Identifier
     * @return City DAO
     */
    public static CitiesDAO getUncachedCity(long id) throws Exception {
        try {
            return datasource.getCity(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param idCountry long Cities Country Identifier
     * @return Cities DAO
     */
    public static BulkCitiesDAO getCitiesFindByAll(long idCountry) throws Exception {
        // Local Variables
        BulkCitiesDAO dao;
        BulkCitiesDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkCitiesDAO(BulkCitiesDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(idCountry);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkCitiesDAO) citiesQueriesCache.get(dao);
    }


    // Executer Methods ------------------------------------------------------


    /**
     * Executes the removeCountryCities
     * @param countryId long Cities Country Id
     * @return Executes the removeCountryCities
     */
    public static void executeCitiesRemoveCountryCities(long countryId) throws Exception {
        // Local Variables
        String query;
        QueryBuilder qbuilder;
        HashMap<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("COUNTRYID", 1);
        // Build Query
        // Create query
        qbuilder = new QueryBuilder("DELETE FROM CITIES \r\n " + 
                                 "WHERE ID_COUNTRY = ?COUNTRYID \r\n " + 
                                 " \r\n " + 
                                 "");
        qbuilder.setDatabaseType(DatabaseType.MySQL);
        qbuilder.setTreatEnumsAsIntegers(true);
        // Get query
        query = qbuilder.getQuery(parameters, countryId);
        try {
            // Execute query
            GlobalDBManager.executeSQL("Merits_Merits", query);
        } catch(Exception ex) {
            // Finder Exception caught
            Console.error("Could not execute DirectiveMapping \"Delete All\" executer", ex);
            throw ex;
        }
        // CACHES
        // Clears all single cache
        citiesSingleCache.clear();
        citiesQueriesCache.clear();
    }


    // TEAM Bean Methods -------------------------------------------------------


    /**
     * Creates a Team
     * @param langCode String Team Lang Code
     * @param id long Team Identifier
     * @param name String Team Name
     * @param position String Team Position
     * @param description String Team Description
     * @param editInfo EditInfo Team Edit Info
     * @param publishInfo PublishInfo Team Publish Info
     * @return Team created Identifier
     */
    public static long createTeam(String langCode, String name, String position, 
                                  String description, EditInfo editInfo, 
                                  PublishInfo publishInfo) throws Exception {
        // Local variables
        long mlkId;
        TeamDAO team;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        team = new TeamDAO(0, name, position, description, editInfo, publishInfo);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        team.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Team
            GlobalDBManager.create(team);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        position, null, null, null, null, null, null, null, null, null,
                                        description, null, null, null,
                                        null, null, null);
        } catch(Exception ex) {
            // Remove created
            removeTeam(team.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Add the created object to the cache
        teamSingleCache.put(team);
        // Return created Team Identifier
        return team.getId();
    }


    /**
     * Creates a Team
     * @param langCode String Team Lang Code
     * @param id long Team Identifier
     * @param name String Team Name
     * @param position String Team Position
     * @param description String Team Description
     * @param photo Image Team Photo
     * @param instagramUrl String Team Instagram Url
     * @param twitterUrl String Team Twitter Url
     * @param facebookUrl String Team Facebook Url
     * @param editInfo EditInfo Team Edit Info
     * @param publishInfo PublishInfo Team Publish Info
     * @return Team created Identifier
     */
    public static long createTeam(String langCode, String name, String position, 
                                  String description, Image photo, 
                                  String instagramUrl, String twitterUrl, 
                                  String facebookUrl, EditInfo editInfo, 
                                  PublishInfo publishInfo) throws Exception {
        // Local variables
        long mlkId;
        TeamDAO team;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        team = new TeamDAO(0, name, position, description, photo, instagramUrl, twitterUrl, 
                           facebookUrl, editInfo, publishInfo);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        team.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Team
            GlobalDBManager.create(team);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        position, null, null, null, null, null, null, null, null, null,
                                        description, null, null, null,
                                        null, null, null);
        } catch(Exception ex) {
            // Remove created
            removeTeam(team.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Add the created object to the cache
        teamSingleCache.put(team);
        // Return created Team Identifier
        return team.getId();
    }


    /**
     * TeamUpdater
     * @param id
     * @param name
     * @param position
     * @param description
     * @param photo
     * @param instagramUrl
     * @param twitterUrl
     * @param facebookUrl
     * @param publishInfo
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateTeam(long id, String name, String position, String description, Image photo, String instagramUrl, String twitterUrl, String facebookUrl, PublishInfo publishInfo, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        TeamDAO dao;
        TeamDAO multiLangCheck;
        TeamUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new TeamUpdater(id, name, position, description, photo, instagramUrl, twitterUrl, facebookUrl, publishInfo, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getTeam(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getPosition() == null) && (multiLangCheck.getDescription() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            position, null, null, null, null, null, null, null, null, null,
                                            description, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Team
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating TEAM table", ex);
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO(id);
        // Release cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * TeamUpdater ByAll
     * @param id
     * @param name
     * @param position
     * @param description
     * @param photo
     * @param instagramUrl
     * @param twitterUrl
     * @param facebookUrl
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateTeamByAll(long id, String name, String position, String description, Image photo, String instagramUrl, String twitterUrl, String facebookUrl, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        TeamDAO dao;
        TeamDAO multiLangCheck;
        TeamUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new TeamUpdaterByAll(id, name, position, description, photo, instagramUrl, twitterUrl, facebookUrl, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getTeam(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getDescription() == null) && (multiLangCheck.getPosition() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            position, null, null, null, null, null, null, null, null, null,
                                            description, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Team
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating TEAM table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO(id);
        // Release cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * TeamUpdater ByPublish
     * @param id
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateTeamByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        TeamDAO dao;
        TeamUpdaterByPublish updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new TeamUpdaterByPublish(id, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Team
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating TEAM table on updater \"ByPublish\"", ex);
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO(id);
        // Release cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Team
     * @param id long Team Identifier
     */
    public static void removeTeam(long id) throws Exception {
            // Local Variables
        TeamDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getTeam(id, null);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
        }
        // Remove Team
        try {
            // Delete Multilanguage Key Translations
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_TRANSLATIONS` WHERE ID_MLK = (SELECT MLK_ID FROM TEAM WHERE ID = " + id + ")");
            // Delete Multilanguage Key
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_KEYS` WHERE ID = (SELECT MLK_ID FROM TEAM WHERE ID = " + id + ")");
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM TEAM WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Clears all single cache of this object
        teamSingleCache.releasePattern(new TeamDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Team
     * @param id long Team Identifier
     * @param defaultLangCode String Team Default Lang Code
     * @param published PublishInfo Team Published
     * @param editInfo EditInfo Team Edit Info
     */
    public static long copyTeam(long id, String defaultLangCode, 
                                PublishInfo published, EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        TeamDAO copy;
        TeamDAO original;
        // Get Original
        original = getTeam(id, null);
        // Copy Original
        copyId = createTeam(
                defaultLangCode, // langCode
                original.getName(), // name
                original.getPosition(), // position
                original.getDescription(), // description
                original.getPhoto(), // photo
                original.getInstagramUrl(), // instagramUrl
                original.getTwitterUrl(), // twitterUrl
                original.getFacebookUrl(), // facebookUrl
                editInfo, // Edit Info
                published // Publish Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        // Get copied data
        copy = getTeam(copyId, null);
        // Copy multi language key data
        MultiLanguageUtils.copyMultiLanguageKey(siteId, original.getMultiLangKeyId(), copy.getMultiLangKeyId());
        return copyId;
    }


    /**
     * Publishes / Unpublishes Team
     * @param id long Team Identifier
     * @param published boolean Team Published
     * @param userId long Team User Id
     */
    public static void publishTeam(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        TeamDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info Team
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE TEAM " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Clears all single cache of this object
        teamSingleCache.releasePattern(new TeamDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a Team
     * @param id long Team Identifier
     * @param langCode String Team Lang Code
     * @return Team DAO
     */
    public static TeamDAO getTeam(long id, String langCode) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        TeamDAO dao;
        // Create DAO
        dao = new TeamDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id, langCode);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (TeamDAO) teamSingleCache.get(dao);
    }
    /**
     * Gets a Team
     * @param id long Team Identifier
     * @param langCode String Team Lang Code
     * @return Team DAO
     */
    public static TeamDAO getUncachedTeam(long id, String langCode) throws Exception {
        try {
            return datasource.getTeam(id, langCode);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param langCode String Team Lang Code
     * @return Team DAO
     */
    public static BulkTeamDAO getTeamFindByAll(String langCode) throws Exception {
        // Local Variables
        BulkTeamDAO dao;
        BulkTeamDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkTeamDAO(BulkTeamDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(langCode);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkTeamDAO) teamQueriesCache.get(dao);
    }


    /**
     * Checks all the translations for specific fields in a Team
     * @param id Team id
     * @param fields Multi Language fields to search if exist translations
     * @throws Exception
     */
    public static String getTeamTranslatedLanguages(long id, TeamDAO.MultiLanguageFields... fields) throws Exception{
        // Local Variables
        String query;
        // Create query
        query = "SELECT group_concat(lang_code) as translations FROM TEAM, `weezziserver`.multilang_translations " +
                "WHERE TEAM.id = " + id + " AND `weezziserver`.multilang_translations.id_mlk= TEAM.MLK_ID";
        // Append mandatory fields
        for(TeamDAO.MultiLanguageFields field : fields) {
            query += "\n AND length(`weezziserver`.multilang_translations." + field.getColumnName() + ") > 0";
        }
        try {
            // Get translations
            return GlobalDBManager.getQueryStringColumnValue("Merits_Merits", query, "TRANSLATIONS");
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
    }


    /**
     * Moves a Team
     * @param sourceId long Team Source Id
     * @param destinationId long Team Destination Id
     * @param direction String Team Direction
     */
    public static void moveTeam(long sourceId, long destinationId, 
                                String direction) throws Exception {
        // Local variables
        TeamDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Team
            GlobalDBManager.executeSQL(new TeamDAO().getDBConnectionName(), "CALL MOVE_TEAM(" + sourceId + ", " + destinationId + ", '" + direction + "')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
        // Create DAO
        dao = new TeamDAO();
        // Create search parameters for destination Id
        parameters = new DAOInstantParameters(destinationId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the First ordering position a Team
     * @param sourceId long Team Source Id
     */
    public static void moveFirstTeam(long sourceId) throws Exception {
        // Local variables
        TeamDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Team
            GlobalDBManager.executeSQL(new TeamDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_TEAM(" + sourceId + ", 'first')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the Last ordering position a Team
     * @param sourceId long Team Source Id
     */
    public static void moveLastTeam(long sourceId) throws Exception {
        // Local variables
        TeamDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Team
            GlobalDBManager.executeSQL(new TeamDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_TEAM(" + sourceId + ", 'last')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        teamQueriesCache.clear();
        // Create DAO
        dao = new TeamDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        teamSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    // SPONSORS Bean Methods ---------------------------------------------------


    /**
     * Creates a Sponsor
     * @param id long Sponsors Identifier
     * @param name String Sponsors Name
     * @param editInfo EditInfo Sponsors Edit Info
     * @param publishInfo PublishInfo Sponsors Publish Info
     * @return Sponsor created Identifier
     */
    public static long createSponsor(String name, EditInfo editInfo, 
                                     PublishInfo publishInfo) throws Exception {
        // Local variables
        SponsorsDAO sponsors;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        sponsors = new SponsorsDAO(0, name, editInfo, publishInfo);
        // Call DB Manager Adder Method
        try {
            // Add Sponsor
            GlobalDBManager.create(sponsors);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Add the created object to the cache
        sponsorsSingleCache.put(sponsors);
        // Return created Sponsor Identifier
        return sponsors.getId();
    }


    /**
     * Creates a Sponsor
     * @param id long Sponsors Identifier
     * @param name String Sponsors Name
     * @param photo Image Sponsors Photo
     * @param url String Sponsors Url
     * @param editInfo EditInfo Sponsors Edit Info
     * @param publishInfo PublishInfo Sponsors Publish Info
     * @return Sponsor created Identifier
     */
    public static long createSponsor(String name, Image photo, String url, 
                                     EditInfo editInfo, PublishInfo publishInfo) throws Exception {
        // Local variables
        SponsorsDAO sponsors;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        sponsors = new SponsorsDAO(0, name, photo, url, editInfo, publishInfo);
        // Call DB Manager Adder Method
        try {
            // Add Sponsor
            GlobalDBManager.create(sponsors);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Add the created object to the cache
        sponsorsSingleCache.put(sponsors);
        // Return created Sponsor Identifier
        return sponsors.getId();
    }


    /**
     * SponsorUpdater
     * @param id
     * @param name
     * @param photo
     * @param url
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateSponsor(long id, String name, Image photo, String url, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        SponsorsDAO dao;
        SponsorsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new SponsorsUpdater(id, name, photo, url, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Sponsor
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SPONSORS table", ex);
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO(id);
        // Release cache
        sponsorsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * SponsorUpdater ByAll
     * @param id
     * @param name
     * @param photo
     * @param url
     * @param updateInfo Update Info
     */
    public static void updateSponsorByAll(long id, String name, Image photo, String url, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        SponsorsDAO dao;
        SponsorsUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new SponsorsUpdaterByAll(id, name, photo, url, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Sponsor
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SPONSORS table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO(id);
        // Release cache
        sponsorsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * SponsorUpdater ByPublish
     * @param id
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateSponsorByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        SponsorsDAO dao;
        SponsorsUpdaterByPublish updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new SponsorsUpdaterByPublish(id, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Sponsor
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating SPONSORS table on updater \"ByPublish\"", ex);
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO(id);
        // Release cache
        sponsorsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Sponsor
     * @param id long Sponsors Identifier
     */
    public static void removeSponsor(long id) throws Exception {
            // Local Variables
        SponsorsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getSponsor(id);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
        }
        // Remove Sponsor
        try {
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM SPONSORS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Clears all single cache of this object
        sponsorsSingleCache.release(new SponsorsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Sponsor
     * @param id long Sponsors Identifier
     * @param published PublishInfo Sponsors Published
     * @param editInfo EditInfo Sponsors Edit Info
     */
    public static long copySponsor(long id, PublishInfo published, 
                                   EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        SponsorsDAO copy;
        SponsorsDAO original;
        // Get Original
        original = getSponsor(id);
        // Copy Original
        copyId = createSponsor(
                original.getName(), // name
                original.getPhoto(), // photo
                original.getUrl(), // url
                editInfo, // Edit Info
                published // Publish Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        return copyId;
    }


    /**
     * Publishes / Unpublishes Sponsor
     * @param id long Sponsors Identifier
     * @param published boolean Sponsors Published
     * @param userId long Sponsors User Id
     */
    public static void publishSponsor(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        SponsorsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info Sponsor
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE SPONSORS " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Clears all single cache of this object
        sponsorsSingleCache.release(new SponsorsDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a Sponsor
     * @param id long Sponsors Identifier
     * @return Sponsor DAO
     */
    public static SponsorsDAO getSponsor(long id) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        SponsorsDAO dao;
        // Create DAO
        dao = new SponsorsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (SponsorsDAO) sponsorsSingleCache.get(dao);
    }
    /**
     * Gets a Sponsor
     * @param id long Sponsors Identifier
     * @return Sponsor DAO
     */
    public static SponsorsDAO getUncachedSponsor(long id) throws Exception {
        try {
            return datasource.getSponsor(id);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param search String Sponsors Search
     * @return Sponsors DAO
     */
    public static BulkSponsorsDAO getSponsorsFindByAll(String search) throws Exception {
        // Local Variables
        BulkSponsorsDAO dao;
        BulkSponsorsDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkSponsorsDAO(BulkSponsorsDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(search);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkSponsorsDAO) sponsorsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param search String Sponsors Search
     * @param start int Sponsors Start
     * @param end int Sponsors End
     * @return Sponsors Bulk DTO
     */
    public static BulkSponsorsDAO getSponsorsBlockFindByAll(String search, 
                                                            int start, int end) {
        // Local Variables
        BulkSponsorsDAO.AllParameters parameters;
        BulkSponsorsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkSponsorsDAO(BulkSponsorsDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(search);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkSponsorsDAO) getBulkBlockQueryData(sponsorsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Moves a Sponsor
     * @param sourceId long Sponsors Source Id
     * @param destinationId long Sponsors Destination Id
     * @param direction String Sponsors Direction
     */
    public static void moveSponsor(long sourceId, long destinationId, 
                                   String direction) throws Exception {
        // Local variables
        SponsorsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Sponsor
            GlobalDBManager.executeSQL(new SponsorsDAO().getDBConnectionName(), "CALL MOVE_SPONSORS(" + sourceId + ", " + destinationId + ", '" + direction + "')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        sponsorsSingleCache.release(dao.getCacheUniqueKey());
        // Create DAO
        dao = new SponsorsDAO();
        // Create search parameters for destination Id
        parameters = new DAOInstantParameters(destinationId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        sponsorsSingleCache.release(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the First ordering position a Sponsor
     * @param sourceId long Sponsors Source Id
     */
    public static void moveFirstSponsor(long sourceId) throws Exception {
        // Local variables
        SponsorsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Sponsor
            GlobalDBManager.executeSQL(new SponsorsDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_SPONSORS(" + sourceId + ", 'first')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        sponsorsSingleCache.release(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the Last ordering position a Sponsor
     * @param sourceId long Sponsors Source Id
     */
    public static void moveLastSponsor(long sourceId) throws Exception {
        // Local variables
        SponsorsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Sponsor
            GlobalDBManager.executeSQL(new SponsorsDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_SPONSORS(" + sourceId + ", 'last')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        sponsorsQueriesCache.clear();
        // Create DAO
        dao = new SponsorsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        sponsorsSingleCache.release(dao.getCacheUniqueKey());
    }


    // COMPANIES Bean Methods --------------------------------------------------


    /**
     * Creates a Company
     * @param langCode String Companies Lang Code
     * @param id long Companies Identifier
     * @param name String Companies Name
     * @param description String Companies Description
     * @param editInfo EditInfo Companies Edit Info
     * @param publishInfo PublishInfo Companies Publish Info
     * @return Company created Identifier
     */
    public static long createCompany(String langCode, String name, 
                                     String description, EditInfo editInfo, 
                                     PublishInfo publishInfo) throws Exception {
        // Local variables
        long mlkId;
        CompaniesDAO companies;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        companies = new CompaniesDAO(0, name, description, editInfo, publishInfo);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        companies.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Company
            GlobalDBManager.create(companies);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        null, null, null, null, null, null, null, null, null, null,
                                        description, null, null, null,
                                        null, null, null);
        } catch(Exception ex) {
            // Remove created
            removeCompany(companies.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Add the created object to the cache
        companiesSingleCache.put(companies);
        // Return created Company Identifier
        return companies.getId();
    }


    /**
     * Creates a Company
     * @param langCode String Companies Lang Code
     * @param id long Companies Identifier
     * @param name String Companies Name
     * @param description String Companies Description
     * @param photo Image Companies Photo
     * @param url String Companies Url
     * @param editInfo EditInfo Companies Edit Info
     * @param publishInfo PublishInfo Companies Publish Info
     * @return Company created Identifier
     */
    public static long createCompany(String langCode, String name, 
                                     String description, Image photo, String url, 
                                     EditInfo editInfo, PublishInfo publishInfo) throws Exception {
        // Local variables
        long mlkId;
        CompaniesDAO companies;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        companies = new CompaniesDAO(0, name, description, photo, url, editInfo, publishInfo);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        companies.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Company
            GlobalDBManager.create(companies);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        null, null, null, null, null, null, null, null, null, null,
                                        description, null, null, null,
                                        null, null, null);
        } catch(Exception ex) {
            // Remove created
            removeCompany(companies.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Add the created object to the cache
        companiesSingleCache.put(companies);
        // Return created Company Identifier
        return companies.getId();
    }


    /**
     * CompanyUpdater
     * @param id
     * @param name
     * @param description
     * @param photo
     * @param url
     * @param publishInfo
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateCompany(long id, String name, String description, Image photo, String url, PublishInfo publishInfo, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CompaniesDAO dao;
        CompaniesDAO multiLangCheck;
        CompaniesUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CompaniesUpdater(id, name, description, photo, url, publishInfo, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getCompany(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getDescription() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            null, null, null, null, null, null, null, null, null, null,
                                            description, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Company
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COMPANIES table", ex);
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO(id);
        // Release cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CompanyUpdater ByAll
     * @param id
     * @param name
     * @param description
     * @param photo
     * @param url
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateCompanyByAll(long id, String name, String description, Image photo, String url, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CompaniesDAO dao;
        CompaniesDAO multiLangCheck;
        CompaniesUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CompaniesUpdaterByAll(id, name, description, photo, url, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getCompany(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getDescription() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            null, null, null, null, null, null, null, null, null, null,
                                            description, null, null, null,
                                            null, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Company
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COMPANIES table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO(id);
        // Release cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * CompanyUpdater ByPublish
     * @param id
     * @param publishInfo
     * @param updateInfo Update Info
     */
    public static void updateCompanyByPublish(long id, PublishInfo publishInfo, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        CompaniesDAO dao;
        CompaniesUpdaterByPublish updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new CompaniesUpdaterByPublish(id, publishInfo, updateInfo);
        // Call DB Manager Updater Method
        try {
            // Update Company
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating COMPANIES table on updater \"ByPublish\"", ex);
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO(id);
        // Release cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Company
     * @param id long Companies Identifier
     */
    public static void removeCompany(long id) throws Exception {
            // Local Variables
        CompaniesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getCompany(id, null);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
        }
        // Remove Company
        try {
            // Delete Multilanguage Key Translations
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_TRANSLATIONS` WHERE ID_MLK = (SELECT MLK_ID FROM COMPANIES WHERE ID = " + id + ")");
            // Delete Multilanguage Key
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_KEYS` WHERE ID = (SELECT MLK_ID FROM COMPANIES WHERE ID = " + id + ")");
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM COMPANIES WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Clears all single cache of this object
        companiesSingleCache.releasePattern(new CompaniesDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Company
     * @param id long Companies Identifier
     * @param defaultLangCode String Companies Default Lang Code
     * @param published PublishInfo Companies Published
     * @param editInfo EditInfo Companies Edit Info
     */
    public static long copyCompany(long id, String defaultLangCode, 
                                   PublishInfo published, EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        CompaniesDAO copy;
        CompaniesDAO original;
        // Get Original
        original = getCompany(id, null);
        // Copy Original
        copyId = createCompany(
                defaultLangCode, // langCode
                original.getName(), // name
                original.getDescription(), // description
                original.getPhoto(), // photo
                original.getUrl(), // url
                editInfo, // Edit Info
                published // Publish Info
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        // Get copied data
        copy = getCompany(copyId, null);
        // Copy multi language key data
        MultiLanguageUtils.copyMultiLanguageKey(siteId, original.getMultiLangKeyId(), copy.getMultiLangKeyId());
        return copyId;
    }


    /**
     * Publishes / Unpublishes Company
     * @param id long Companies Identifier
     * @param published boolean Companies Published
     * @param userId long Companies User Id
     */
    public static void publishCompany(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        CompaniesDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info Company
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE COMPANIES " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Clears all single cache of this object
        companiesSingleCache.releasePattern(new CompaniesDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a Company
     * @param id long Companies Identifier
     * @param langCode String Companies Lang Code
     * @return Company DAO
     */
    public static CompaniesDAO getCompany(long id, String langCode) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        CompaniesDAO dao;
        // Create DAO
        dao = new CompaniesDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id, langCode);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (CompaniesDAO) companiesSingleCache.get(dao);
    }
    /**
     * Gets a Company
     * @param id long Companies Identifier
     * @param langCode String Companies Lang Code
     * @return Company DAO
     */
    public static CompaniesDAO getUncachedCompany(long id, String langCode) throws Exception {
        try {
            return datasource.getCompany(id, langCode);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param langCode String Companies Lang Code
     * @param search String Companies Search
     * @return Companies DAO
     */
    public static BulkCompaniesDAO getCompaniesFindByAll(String langCode, 
                                                         String search) throws Exception {
        // Local Variables
        BulkCompaniesDAO dao;
        BulkCompaniesDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkCompaniesDAO(BulkCompaniesDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(langCode, search);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkCompaniesDAO) companiesQueriesCache.get(dao);
    }


    /**
     * Description
     * @param langCode String Companies Lang Code
     * @param search String Companies Search
     * @param start int Companies Start
     * @param end int Companies End
     * @return Companies Bulk DTO
     */
    public static BulkCompaniesDAO getCompaniesBlockFindByAll(String langCode, 
                                                              String search, 
                                                              int start, int end) {
        // Local Variables
        BulkCompaniesDAO.AllParameters parameters;
        BulkCompaniesDAO key, result;
        // Create Bulk DTO Key
        key = new BulkCompaniesDAO(BulkCompaniesDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(langCode, search);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkCompaniesDAO) getBulkBlockQueryData(companiesQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Checks all the translations for specific fields in a Company
     * @param id Company id
     * @param fields Multi Language fields to search if exist translations
     * @throws Exception
     */
    public static String getCompanyTranslatedLanguages(long id, CompaniesDAO.MultiLanguageFields... fields) throws Exception{
        // Local Variables
        String query;
        // Create query
        query = "SELECT group_concat(lang_code) as translations FROM COMPANIES, `weezziserver`.multilang_translations " +
                "WHERE COMPANIES.id = " + id + " AND `weezziserver`.multilang_translations.id_mlk= COMPANIES.MLK_ID";
        // Append mandatory fields
        for(CompaniesDAO.MultiLanguageFields field : fields) {
            query += "\n AND length(`weezziserver`.multilang_translations." + field.getColumnName() + ") > 0";
        }
        try {
            // Get translations
            return GlobalDBManager.getQueryStringColumnValue("Merits_Merits", query, "TRANSLATIONS");
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
    }


    /**
     * Moves a Company
     * @param sourceId long Companies Source Id
     * @param destinationId long Companies Destination Id
     * @param direction String Companies Direction
     */
    public static void moveCompany(long sourceId, long destinationId, 
                                   String direction) throws Exception {
        // Local variables
        CompaniesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Company
            GlobalDBManager.executeSQL(new CompaniesDAO().getDBConnectionName(), "CALL MOVE_COMPANIES(" + sourceId + ", " + destinationId + ", '" + direction + "')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
        // Create DAO
        dao = new CompaniesDAO();
        // Create search parameters for destination Id
        parameters = new DAOInstantParameters(destinationId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the First ordering position a Company
     * @param sourceId long Companies Source Id
     */
    public static void moveFirstCompany(long sourceId) throws Exception {
        // Local variables
        CompaniesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Company
            GlobalDBManager.executeSQL(new CompaniesDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_COMPANIES(" + sourceId + ", 'first')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the Last ordering position a Company
     * @param sourceId long Companies Source Id
     */
    public static void moveLastCompany(long sourceId) throws Exception {
        // Local variables
        CompaniesDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Company
            GlobalDBManager.executeSQL(new CompaniesDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_COMPANIES(" + sourceId + ", 'last')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        companiesQueriesCache.clear();
        // Create DAO
        dao = new CompaniesDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        companiesSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    // PROJECTS Bean Methods ---------------------------------------------------


    /**
     * Creates a Project
     * @param langCode String Projects Lang Code
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
     * @return Project created Identifier
     */
    public static long createProject(String langCode, String name, 
                                     String headline, String description, 
                                     boolean hasDonations, boolean hasVolunteers, 
                                     long volunteersActual, 
                                     long volunteersWanted, long donationsActual, 
                                     long donationsWanted, 
                                     PublishInfo publishInfo, EditInfo editInfo, 
                                     TrashableInfo trashable) throws Exception {
        // Local variables
        long mlkId;
        ProjectsDAO projects;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        projects = new ProjectsDAO(0, name, headline, description, hasDonations, hasVolunteers, 
                                   volunteersActual, volunteersWanted, 
                                   donationsActual, donationsWanted, publishInfo, 
                                   editInfo, trashable);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        projects.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Project
            GlobalDBManager.create(projects);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        name, null, null, null, null, null, null, null, null, null,
                                        headline, null, null, null,
                                        description, null, null);
        } catch(Exception ex) {
            // Remove created
            removeProject(projects.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Add the created object to the cache
        projectsSingleCache.put(projects);
        // Return created Project Identifier
        return projects.getId();
    }


    /**
     * Creates a Project
     * @param langCode String Projects Lang Code
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
     * @return Project created Identifier
     */
    public static long createProject(String langCode, String name, 
                                     String headline, String description, 
                                     boolean hasDonations, boolean hasVolunteers, 
                                     long volunteersActual, 
                                     long volunteersWanted, long donationsActual, 
                                     long donationsWanted, Image photo, 
                                     ImageList imagesList, 
                                     PublishInfo publishInfo, EditInfo editInfo, 
                                     TrashableInfo trashable) throws Exception {
        // Local variables
        long mlkId;
        ProjectsDAO projects;
        WeezziCacheTransactionalRelease cacheTR;
        // Create DTO
        projects = new ProjectsDAO(0, name, headline, description, hasDonations, hasVolunteers, 
                                   volunteersActual, volunteersWanted, 
                                   donationsActual, donationsWanted, photo, 
                                   imagesList, publishInfo, editInfo, trashable);
        // Create multi language key
        mlkId = createMultilanguageKey(BaseContainer.siteId);
        // Set multi language key
        projects.setMultiLangKeyId(mlkId);
        // Call DB Manager Adder Method
        try {
            // Add Project
            GlobalDBManager.create(projects);
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // Create multi language translation
        try {
            // Create multilanguage translation
            createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                        null, // Module id
                                        mlkId,
                                        ContentArea.Custom,
                                        null, // Custom content area 
                                        langCode,
                                        name, null, null, null, null, null, null, null, null, null,
                                        headline, null, null, null,
                                        description, null, null);
        } catch(Exception ex) {
            // Remove created
            removeProject(projects.getId());
            // Throw exception
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Add the created object to the cache
        projectsSingleCache.put(projects);
        // Return created Project Identifier
        return projects.getId();
    }


    /**
     * Updates a Project trashable InTrash flag
     * @param id
     * @param siteId
     * @param inTrash
     * @throws Exception
     */
    public static void updateProjectInTrash(long id, long siteId, boolean inTrash) throws Exception{
        // Updates Product InTrash status
        try {
            // Update Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "UPDATE PROJECTS SET TRASHABLE_IN_TRASH = " + (inTrash?1:0) + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Clears all single cache of this object
        projectsSingleCache.releasePattern(new ProjectsDAO(id).getCacheUniqueKey());
    }
    
    
    /**
     * Updates a Project trashable InUse flag
     * @param id
     * @param siteId
     * @param inTrash
     * @throws Exception
     */
    public static void updateProjectInUse(long id, long siteId, boolean inUse) throws Exception{
        // Updates Product InUse status
        try {
            // Update Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "UPDATE PROJECTS SET TRASHABLE_IN_USE = " + (inUse?1:0) + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Clears all single cache of this object
        projectsSingleCache.releasePattern(new ProjectsDAO(id).getCacheUniqueKey());
    }
    
    
    /**
     * Updates a Project trashable Deleted flag
     * @param id
     * @param siteId
     * @param deleted
     * @throws Exception
     */
    public static void updateProjectDeleted(long id, long siteId, boolean deleted) throws Exception{
        // Updates Product InTrash status
        try {
            // Update Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "UPDATE PROJECTS SET TRASHABLE_DELETED = " + (deleted?1:0) + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Clears all single cache of this object
        projectsSingleCache.releasePattern(new ProjectsDAO(id).getCacheUniqueKey());
    }


    /**
     * ProjectUpdater
     * @param id
     * @param name
     * @param headline
     * @param description
     * @param hasDonations
     * @param hasVolunteers
     * @param volunteersActual
     * @param volunteersWanted
     * @param donationsActual
     * @param donationsWanted
     * @param photo
     * @param imagesList
     * @param publishInfo
     * @param trashable
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateProject(long id, String name, String headline, String description, boolean hasDonations, boolean hasVolunteers, long volunteersActual, long volunteersWanted, long donationsActual, long donationsWanted, Image photo, ImageList imagesList, PublishInfo publishInfo, TrashableInfo trashable, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ProjectsDAO dao;
        ProjectsDAO multiLangCheck;
        ProjectsUpdater updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ProjectsUpdater(id, name, headline, description, hasDonations, hasVolunteers, volunteersActual, volunteersWanted, donationsActual, donationsWanted, photo, imagesList, publishInfo, trashable, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getProject(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getName() == null) && (multiLangCheck.getHeadline() == null) && (multiLangCheck.getDescription() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            name, null, null, null, null, null, null, null, null, null,
                                            headline, null, null, null,
                                            description, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Project
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PROJECTS table", ex);
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Create DAO
        dao = new ProjectsDAO(id);
        // Release cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * ProjectUpdater ByAll
     * @param id
     * @param name
     * @param headline
     * @param description
     * @param hasDonations
     * @param hasVolunteers
     * @param volunteersWanted
     * @param donationsWanted
     * @param photo
     * @param imagesList
     * @param langCode Language Code
     * @param updateInfo Update Info
     */
    public static void updateProjectByAll(long id, String name, String headline, String description, boolean hasDonations, boolean hasVolunteers, long volunteersWanted, long donationsWanted, Image photo, ImageList imagesList, String langCode, UpdateInfo updateInfo) throws Exception {
        // Local variables
        DAOInstantParameters parameters;
        ProjectsDAO dao;
        ProjectsDAO multiLangCheck;
        ProjectsUpdaterByAll updater;
        WeezziCacheTransactionalRelease cacheTR;
        // Create Updater
        updater = new ProjectsUpdaterByAll(id, name, headline, description, hasDonations, hasVolunteers, volunteersWanted, donationsWanted, photo, imagesList, langCode, updateInfo);
        // Check if translation exists
        // Get previous cache object
        multiLangCheck = getProject(id, langCode);
        // Check if all the fields are null
        if ((multiLangCheck.getName() == null) && (multiLangCheck.getHeadline() == null) && (multiLangCheck.getDescription() == null)) {
            // Check if has a multilanguage key translation for the language code
            if (!hasMultilanguageTranslation(multiLangCheck.getMultiLangKeyId(), langCode, "Merits_Merits")) {
                // Create multilanguage translation
                createMultilanguageTranslation( BaseContainer.siteId, // Site Id
                                            null, // Module id
                                            multiLangCheck.getMultiLangKeyId(),
                                            ContentArea.Custom,
                                            null, // Custom content area 
                                            langCode,
                                            name, null, null, null, null, null, null, null, null, null,
                                            headline, null, null, null,
                                            description, null, null);
            }
        }
        // Call DB Manager Updater Method
        try {
            // Update Project
            GlobalDBManager.update(updater);
        } catch(Exception ex) {
            // Exception caught
            Console.error(BaseContainer.siteId, "Error updating PROJECTS table on updater \"ByAll\"", ex);
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Create DAO
        dao = new ProjectsDAO(id);
        // Release cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Removes a Project
     * @param id long Projects Identifier
     */
    public static void removeProject(long id) throws Exception {
            // Local Variables
        ProjectsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // REMOVE MEDIA FILES
        // Get DAO
        dao = getProject(id, null);
        // Removes files
        if (dao != null) {
            FilesContainer.deleteFile(dao.getPhoto());
            FilesContainer.deleteFile(dao.getImagesList());
        }
        // Remove Project
        try {
            // Delete Multilanguage Key Translations
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_TRANSLATIONS` WHERE ID_MLK = (SELECT MLK_ID FROM PROJECTS WHERE ID = " + id + ")");
            // Delete Multilanguage Key
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM `weezziserver`.`MULTILANG_KEYS` WHERE ID = (SELECT MLK_ID FROM PROJECTS WHERE ID = " + id + ")");
            // Delete Record
            GlobalDBManager.executeUpdateSQL("Merits_Merits", "DELETE FROM PROJECTS WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Clears all single cache of this object
        projectsSingleCache.releasePattern(new ProjectsDAO(id).getCacheUniqueKey());
    }


    /**
     * Copies a Project
     * @param id long Projects Identifier
     * @param defaultLangCode String Projects Default Lang Code
     * @param published PublishInfo Projects Published
     * @param editInfo EditInfo Projects Edit Info
     */
    public static long copyProject(long id, String defaultLangCode, 
                                   PublishInfo published, EditInfo editInfo) throws Exception {
        // Local Variables
        long copyId;
        ProjectsDAO copy;
        ProjectsDAO original;
        // Get Original
        original = getProject(id, null);
        // Copy Original
        copyId = createProject(
                defaultLangCode, // langCode
                original.getName(), // name
                original.getHeadline(), // headline
                original.getDescription(), // description
                original.getHasDonations(), // hasDonations
                original.getHasVolunteers(), // hasVolunteers
                original.getVolunteersActual(), // volunteersActual
                original.getVolunteersWanted(), // volunteersWanted
                original.getDonationsActual(), // donationsActual
                original.getDonationsWanted(), // donationsWanted
                original.getPhoto(), // photo
                original.getImagesList(), // imagesList
                published, // Publish Info
                editInfo, // Edit Info
                original.getTrashable() // trashable
        );
        // Add new file references
        FilesContainer.addFileReference(original.getPhoto());
        FilesContainer.addFileReference(original.getImagesList());
        // Get copied data
        copy = getProject(copyId, null);
        // Copy multi language key data
        MultiLanguageUtils.copyMultiLanguageKey(siteId, original.getMultiLangKeyId(), copy.getMultiLangKeyId());
        return copyId;
    }


    /**
     * Publishes / Unpublishes Project
     * @param id long Projects Identifier
     * @param published boolean Projects Published
     * @param userId long Projects User Id
     */
    public static void publishProject(long id, boolean published, long userId) throws Exception {
        // Local Variables
        String sql;
        ProjectsDAO dao;
        WeezziCacheTransactionalRelease cacheTR;
        // Update publishing info Project
        try {
            // Update Record
            if (published) {
                sql = "SET PUBLISH_INFO_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                        ", PUBLISH_INFO_USER = " + userId;
            } else {
                sql = "SET PUBLISH_INFO_DATE = null, PUBLISH_INFO_USER = null";
            }
            // Add editing info
            sql += ", EDIT_INFO_UPDATE_DATE = '" + CalendarUtilities.getFullStandardDate(System.currentTimeMillis()) + "'" +
                    ", EDIT_INFO_UPDATE_USER = " + userId;
            GlobalDBManager.executeUpdateSQL("Merits_Merits", " UPDATE PROJECTS " + sql + " WHERE ID = " + id);
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Clears all single cache of this object
        projectsSingleCache.releasePattern(new ProjectsDAO(id).getCacheUniqueKey());
    }


    /**
     * Gets a Project
     * @param id long Projects Identifier
     * @param langCode String Projects Lang Code
     * @return Project DAO
     */
    public static ProjectsDAO getProject(long id, String langCode) throws Exception {
        // Local Variables
        DAOInstantParameters parameters;
        ProjectsDAO dao;
        // Create DAO
        dao = new ProjectsDAO();
        // Create search parameters
        parameters = new DAOInstantParameters(id, langCode);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        return (ProjectsDAO) projectsSingleCache.get(dao);
    }
    /**
     * Gets a Project
     * @param id long Projects Identifier
     * @param langCode String Projects Lang Code
     * @return Project DAO
     */
    public static ProjectsDAO getUncachedProject(long id, String langCode) throws Exception {
        try {
            return datasource.getProject(id, langCode);
        } catch (NoDataFoundException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Description
     * @param langCode String Projects Lang Code
     * @return Projects DAO
     */
    public static BulkProjectsDAO getProjectsFindByAll(String langCode) throws Exception {
        // Local Variables
        BulkProjectsDAO dao;
        BulkProjectsDAO.AllParameters parameters;
        // Create DAO
        dao = new BulkProjectsDAO(BulkProjectsDAO.SearchType.All);
        // Create Parameters
        parameters = dao.new AllParameters(langCode);
        // Set dao parameters
        dao.setParameters(parameters);
        // Return data
        return (BulkProjectsDAO) projectsQueriesCache.get(dao);
    }


    /**
     * Description
     * @param langCode String Projects Lang Code
     * @param start int Projects Start
     * @param end int Projects End
     * @return Projects Bulk DTO
     */
    public static BulkProjectsDAO getProjectsBlockFindByAll(String langCode, 
                                                            int start, int end) {
        // Local Variables
        BulkProjectsDAO.AllParameters parameters;
        BulkProjectsDAO key, result;
        // Create Bulk DTO Key
        key = new BulkProjectsDAO(BulkProjectsDAO.SearchType.All);
        // Set method block size
        key.setBlockSize(100);
        // Create Parameters
        parameters = key.new AllParameters(langCode);
        // Set parameters
        key.setParameters(parameters);
        // Check start & end
        if (start < 1) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        // Get Blocks
        result = (BulkProjectsDAO) getBulkBlockQueryData(projectsQueriesCache, key, start, end - start);
        // Return result
        return result;
    }


    /**
     * Checks all the translations for specific fields in a Project
     * @param id Project id
     * @param fields Multi Language fields to search if exist translations
     * @throws Exception
     */
    public static String getProjectTranslatedLanguages(long id, ProjectsDAO.MultiLanguageFields... fields) throws Exception{
        // Local Variables
        String query;
        // Create query
        query = "SELECT group_concat(lang_code) as translations FROM PROJECTS, `weezziserver`.multilang_translations " +
                "WHERE PROJECTS.id = " + id + " AND `weezziserver`.multilang_translations.id_mlk= PROJECTS.MLK_ID";
        // Append mandatory fields
        for(ProjectsDAO.MultiLanguageFields field : fields) {
            query += "\n AND length(`weezziserver`.multilang_translations." + field.getColumnName() + ") > 0";
        }
        try {
            // Get translations
            return GlobalDBManager.getQueryStringColumnValue("Merits_Merits", query, "TRANSLATIONS");
        } catch(Exception ex) {
            // Finder Exception caught
            throw ex;
        }
    }


    /**
     * Moves a Project
     * @param sourceId long Projects Source Id
     * @param destinationId long Projects Destination Id
     * @param direction String Projects Direction
     */
    public static void moveProject(long sourceId, long destinationId, 
                                   String direction) throws Exception {
        // Local variables
        ProjectsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Project
            GlobalDBManager.executeSQL(new ProjectsDAO().getDBConnectionName(), "CALL MOVE_PROJECTS(" + sourceId + ", " + destinationId + ", '" + direction + "')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Create DAO
        dao = new ProjectsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
        // Create DAO
        dao = new ProjectsDAO();
        // Create search parameters for destination Id
        parameters = new DAOInstantParameters(destinationId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the First ordering position a Project
     * @param sourceId long Projects Source Id
     */
    public static void moveFirstProject(long sourceId) throws Exception {
        // Local variables
        ProjectsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Project
            GlobalDBManager.executeSQL(new ProjectsDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_PROJECTS(" + sourceId + ", 'first')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Create DAO
        dao = new ProjectsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }


    /**
     * Moves to the Last ordering position a Project
     * @param sourceId long Projects Source Id
     */
    public static void moveLastProject(long sourceId) throws Exception {
        // Local variables
        ProjectsDAO dao;
        DAOInstantParameters parameters;
        // Call DB Manager SQL Execute
        try {
            // Add Project
            GlobalDBManager.executeSQL(new ProjectsDAO().getDBConnectionName(), "CALL MOVE_FIRSTLAST_PROJECTS(" + sourceId + ", 'last')");
        } catch(Exception ex) {
            // Throw exception
            throw ex;
        }
        // CACHES
        projectsQueriesCache.clear();
        // Create DAO
        dao = new ProjectsDAO();
        // Create search parameters for source Id
        parameters = new DAOInstantParameters(sourceId);
        // Set search parameters
        dao.setParameters(parameters);
        // Retrieve from cache
        projectsSingleCache.releasePattern(dao.getCacheUniqueKey());
    }



    // =========================================================================
    // MESSAGING METHODS
    // =========================================================================



   // =========================================================================
    // WSCRIPT Object
    // =========================================================================

    
    /**
     * Gets wscripts object
     * @return
     */
    public WObject getWScriptObject() {
    	// Local Variables
    	WObject object;
    	WFunction function;
    	// OBJECT
    	object = new WObject("base");
    	// FUNCTIONS
        // getWalletFindByMasterWallet
        function = new WFunction("getWalletFindByMasterWallet", WArgumentType.SingleRecord) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletFindByMasterWallet();
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByTransactions
        function = new WFunction("getWalletRecordsFindByTransactions", WArgumentType.BulkData
            , new WFunctionArgument("idWallet", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByTransactions((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByTransactions
        function = new WFunction("getWalletRecordsFindByTransactions", WArgumentType.BulkData
            , new WFunctionArgument("idWallet", WArgumentType.Long), new WFunctionArgument("sinceId", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByTransactions((Long) arguments[0], (Long) arguments[1]);
                }
        };
        object.addFunction(function);
        // getWalletRecordFindByTransaction
        function = new WFunction("getWalletRecordFindByTransaction", WArgumentType.SingleRecord
            , new WFunctionArgument("id", WArgumentType.Long), new WFunctionArgument("idWallet", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordFindByTransaction((Long) arguments[0], (Long) arguments[1]);
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByAll
        function = new WFunction("getWalletRecordsFindByAll", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByAll();
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByAll
        function = new WFunction("getWalletRecordsFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("idVolunteer", WArgumentType.Long), new WFunctionArgument("idShop", WArgumentType.Long), new WFunctionArgument("search", WArgumentType.String), new WFunctionArgument("startDate", WArgumentType.String), new WFunctionArgument("endDate", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByAll((Long) arguments[0], (Long) arguments[1], (String) arguments[2], (String) arguments[3], (String) arguments[4]);
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByGetBalanceSPQ
        function = new WFunction("getWalletRecordsFindByGetBalanceSPQ", WArgumentType.SingleRecord
            , new WFunctionArgument("id", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByGetBalanceSPQ((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByTotalsSPQ
        function = new WFunction("getWalletRecordsFindByTotalsSPQ", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByTotalsSPQ();
                }
        };
        object.addFunction(function);
        // getWalletRecordsFindByMasterWalletSPQ
        function = new WFunction("getWalletRecordsFindByMasterWalletSPQ", WArgumentType.SingleRecord
            , new WFunctionArgument("id", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getWalletRecordsFindByMasterWalletSPQ((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getGoodTypesFindByAll
        function = new WFunction("getGoodTypesFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("langCode", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getGoodTypesFindByAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getGoodTypesGoodTypesList
        function = new WFunction("getGoodTypesGoodTypesList", WArgumentType.List) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getGoodTypesGoodTypesList();
                }
        };
        object.addFunction(function);
        // getVolunteersFindByAll
        function = new WFunction("getVolunteersFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("search", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteersFindByAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getVolunteerFindByLogin
        function = new WFunction("getVolunteerFindByLogin", WArgumentType.SingleRecord
            , new WFunctionArgument("loginEmail", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteerFindByLogin((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getVolunteerFindByWallet
        function = new WFunction("getVolunteerFindByWallet", WArgumentType.SingleRecord
            , new WFunctionArgument("idWallet", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteerFindByWallet((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getVolunteersFindByGetAllUsersSPQ
        function = new WFunction("getVolunteersFindByGetAllUsersSPQ", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteersFindByGetAllUsersSPQ();
                }
        };
        object.addFunction(function);
        // getVolunteersFindByUsersSPQ
        function = new WFunction("getVolunteersFindByUsersSPQ", WArgumentType.BulkData
            , new WFunctionArgument("search", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteersFindByUsersSPQ((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getVolunteersVolunteersList
        function = new WFunction("getVolunteersVolunteersList", WArgumentType.List) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getVolunteersVolunteersList();
                }
        };
        object.addFunction(function);
        // getShopsFindByGetAll
        function = new WFunction("getShopsFindByGetAll", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopsFindByGetAll();
                }
        };
        object.addFunction(function);
        // getShopsFindByGetAll
        function = new WFunction("getShopsFindByGetAll", WArgumentType.BulkData
            , new WFunctionArgument("search", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopsFindByGetAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopFindByWallet
        function = new WFunction("getShopFindByWallet", WArgumentType.SingleRecord
            , new WFunctionArgument("idWallet", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopFindByWallet((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopsShopsList
        function = new WFunction("getShopsShopsList", WArgumentType.List) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopsShopsList();
                }
        };
        object.addFunction(function);
        // getShopCashierFindByUsername
        function = new WFunction("getShopCashierFindByUsername", WArgumentType.SingleRecord
            , new WFunctionArgument("idShop", WArgumentType.Long), new WFunctionArgument("loginUsername", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopCashierFindByUsername((Long) arguments[0], (String) arguments[1]);
                }
        };
        object.addFunction(function);
        // getShopCashiersFindByAll
        function = new WFunction("getShopCashiersFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("idShop", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopCashiersFindByAll((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopGoodtypesFindByGoodTypes
        function = new WFunction("getShopGoodtypesFindByGoodTypes", WArgumentType.BulkData
            , new WFunctionArgument("idShop", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopGoodtypesFindByGoodTypes((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopGoodtypeFindByCheck
        function = new WFunction("getShopGoodtypeFindByCheck", WArgumentType.SingleRecord
            , new WFunctionArgument("idShop", WArgumentType.Long), new WFunctionArgument("idGoodtype", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopGoodtypeFindByCheck((Long) arguments[0], (Long) arguments[1]);
                }
        };
        object.addFunction(function);
        // getShopGoodtypesFindByShopGoodSPQ
        function = new WFunction("getShopGoodtypesFindByShopGoodSPQ", WArgumentType.BulkData
            , new WFunctionArgument("shopId", WArgumentType.Long), new WFunctionArgument("langCode", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopGoodtypesFindByShopGoodSPQ((Long) arguments[0], (String) arguments[1]);
                }
        };
        object.addFunction(function);
        // getShopTransactionFindByVolunteerWallet
        function = new WFunction("getShopTransactionFindByVolunteerWallet", WArgumentType.SingleRecord
            , new WFunctionArgument("idVolunteerWalletRecord", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopTransactionFindByVolunteerWallet((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopTransactionsFindByShop
        function = new WFunction("getShopTransactionsFindByShop", WArgumentType.BulkData
            , new WFunctionArgument("idShop", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopTransactionsFindByShop((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getShopTransactionsFindByShopCashier
        function = new WFunction("getShopTransactionsFindByShopCashier", WArgumentType.BulkData
            , new WFunctionArgument("idShop", WArgumentType.Long), new WFunctionArgument("idCashier", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getShopTransactionsFindByShopCashier((Long) arguments[0], (Long) arguments[1]);
                }
        };
        object.addFunction(function);
        // getOrganizationFindByWalletId
        function = new WFunction("getOrganizationFindByWalletId", WArgumentType.SingleRecord
            , new WFunctionArgument("idWallet", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getOrganizationFindByWalletId((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getOrganizationsFindByAll
        function = new WFunction("getOrganizationsFindByAll", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getOrganizationsFindByAll();
                }
        };
        object.addFunction(function);
        // getOrganizationsOrganizationsList
        function = new WFunction("getOrganizationsOrganizationsList", WArgumentType.List) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getOrganizationsOrganizationsList();
                }
        };
        object.addFunction(function);
        // getPaymentsCodeFindByGetPaymentCode
        function = new WFunction("getPaymentsCodeFindByGetPaymentCode", WArgumentType.SingleRecord
            , new WFunctionArgument("paymentCode", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getPaymentsCodeFindByGetPaymentCode((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getPaymentsCodeFindByGetLatest
        function = new WFunction("getPaymentsCodeFindByGetLatest", WArgumentType.SingleRecord
            , new WFunctionArgument("idVolunteer", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getPaymentsCodeFindByGetLatest((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getCountriesFindByAll
        function = new WFunction("getCountriesFindByAll", WArgumentType.BulkData) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getCountriesFindByAll();
                }
        };
        object.addFunction(function);
        // getCitiesFindByAll
        function = new WFunction("getCitiesFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("idCountry", WArgumentType.Long)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getCitiesFindByAll((Long) arguments[0]);
                }
        };
        object.addFunction(function);
        // getTeamFindByAll
        function = new WFunction("getTeamFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("langCode", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getTeamFindByAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getSponsorsFindByAll
        function = new WFunction("getSponsorsFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("search", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getSponsorsFindByAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
        // getCompaniesFindByAll
        function = new WFunction("getCompaniesFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("langCode", WArgumentType.String), new WFunctionArgument("search", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getCompaniesFindByAll((String) arguments[0], (String) arguments[1]);
                }
        };
        object.addFunction(function);
        // getProjectsFindByAll
        function = new WFunction("getProjectsFindByAll", WArgumentType.BulkData
            , new WFunctionArgument("langCode", WArgumentType.String)) {
                protected Object executeImplementation(PageContext pageContext, Object... arguments) throws Exception {
                    // Call container method
                return BaseContainer.getProjectsFindByAll((String) arguments[0]);
                }
        };
        object.addFunction(function);
		// Return object
		return object;
    }


}
