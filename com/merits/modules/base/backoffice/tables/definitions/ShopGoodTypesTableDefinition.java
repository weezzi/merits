package com.merits.modules.base.backoffice.tables.definitions;

//IMPORTS -------------------------------------------------------------------------

import java.util.Vector;

import com.weezzi.core.components.WeezziBackofficeComponentType;
import com.weezzi.core.components.data.*;
import com.weezzi.core.data.*;
import com.weezzi.core.tables.TableStatus;
import com.weezzi.core.tables.TableColumnOrdering;
import com.weezzi.core.tables.WeezziTable;
import com.weezzi.system.modules.wcontacts.uobjects.enums.ContactGender;
import com.weezzi.core.components.dynamicproperties.ComponentPropertyType;
import com.weezzi.core.components.dynamicproperties.DynamicComponentProperties;
import com.weezzi.core.components.exceptions.PropertyNotFoundException;
import com.weezzi.core.components.types.WeezziBackofficeTableComponent;
import com.weezzi.core.components.WeezziBackofficeComponentType;
import com.weezzi.core.components.WeezziBackOfficeComponent;
import com.weezzi.core.context.TableContext;
import com.weezzi.utils.extras.console.Console;
import java.util.Collection;


/**
 * <b>Title: </b> ShopGoodTypesTable<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public abstract class ShopGoodTypesTableDefinition extends WeezziTable {

	
	// CONSTRUCTORS -----------------------------------------------------------

	
	public ShopGoodTypesTableDefinition() {
		// Initialization
		super();
		this.setName("ShopGoodTypes");
	}
	

	// PUBLIC -----------------------------------------------------------------


    /**
     * Add row method
     * @param id long parameter
     * @param goodType GoodType string parameter
     */
    protected void addNonClickableRow(Long id, String goodType) {
        // Sets row as clickable
        setClickableRow(false);
        // Sets the row id
        setRowId(encryptData(id));
        // Adds a row start
        addRowStart();
        // GoodType Column
        addTitleColumnData(goodType);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id long parameter
     * @param goodType GoodType string parameter
     */
    protected void addRow(Long id, String goodType) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        // Adds a row start
        addRowStart();
        // GoodType Column
        addTitleColumnData(goodType);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id long parameter
     * @param clickId long parameter
     * @param goodType GoodType string parameter
     */
    protected void addRow(Long id, Long clickId, String goodType) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        setClickId("" + clickId);
        // Adds a row start
        addRowStart();
        // GoodType Column
        addTitleColumnData(goodType);
        // Adds the row end
        addRowEnd();
    }


		

	// GET DATA METHOD --------------------------------------------------------

	
	/**
	 * Gets data action
	 * @param context Context
	 * @param startIndex Start Index 
	 * @param endIndex End Index 
	 * @param search Search 
	 * @param categoryId Category Id 
	 */
	public abstract void doGetDataAction(TableContext context, int startIndex, int endIndex, String search, String categoryId);

	
	/**
	 * Processes get data action adding filters & ordering clauses
	 * @param context Context
	 * @param startIndex Start Index 
	 * @param endIndex End Index 
	 * @param search Search 
	 * @param categoryId Category Id 
	 * @param columnOrdering Column Ordering 
	 */
	public void doInternalGetDataAction(TableContext context, int startIndex, int endIndex, String search, String categoryId) throws Exception {
		// Local Variables
// Table does not has searchable or ordering fields
        // Call table get data
        doGetDataAction(context, startIndex, endIndex, search, categoryId);
		
	}
	

	// CUSTOM METHODS ---------------------------------------------------------


    /**
     * Remove Action
     * @param context
     * @param ids Remove row ids
     */
    public void doRemoveAction(TableContext context, Vector<String> ids) {
        // Local Variables
        Long id;
        Vector<Long> longIds = new Vector<Long>();
        for(String str : ids) {
            try {
                id = decryptDataAsLong(str);
                longIds.add(id);
            } catch (Exception e) {
                // Catch Exception
                Console.error("Error decrypting id \"" + str + "\" in table \"" + getName() + "\" remove action");
            }
        }
        // Call Id's remove action
        doRemoveAction(context, longIds);
    }


    /**
     * Remove action by Long Ids
     * @param context
     * @param ids
     */
    public abstract void doRemoveAction(TableContext context, Collection<Long> ids);


	// TABLE ACTIONS NOT USED -------------------------------------------------


    public void doMoveAction(String sourceId, String destinationId) {};
    public boolean doPublishAction(String sourceId, boolean published) {return false;};
	
}

