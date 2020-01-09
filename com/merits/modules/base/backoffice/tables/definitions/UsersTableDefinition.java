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
 * <b>Title: </b> UsersTable<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public abstract class UsersTableDefinition extends WeezziTable {

	
	// CONSTRUCTORS -----------------------------------------------------------

	
	public UsersTableDefinition() {
		// Initialization
		super();
		this.setName("Users");
	}
	

	// PUBLIC -----------------------------------------------------------------


    /**
     * Add row method
     * @param id string parameter
     * @param type Type string parameter
     * @param nameImage Name image data parameter
     * @param nameTitle Name title data parameter
     * @param nameDescription Name description data parameter
     * @param button Button dictionary key parameter
     * @param button Button link data parameter
     * @param button Button script data parameter
     */
    protected void addNonClickableRow(String id, String type, Image nameImage, String nameTitle, String nameDescription, String buttonDictionaryKey, String buttonLink, String buttonScript) {
        // Sets row as clickable
        setClickableRow(false);
        // Sets the row id
        setRowId(encryptData(id));
        // Adds a row start
        addRowStart();
        // Type Column
        addTitleColumnData(type);
        // Name Column
        addImageTitleAndDescriptionColumnData(nameImage, nameTitle, nameDescription);
        // Button Column
        addButtonColumnData(buttonDictionaryKey, buttonLink, buttonScript);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id string parameter
     * @param type Type string parameter
     * @param nameImage Name image data parameter
     * @param nameTitle Name title data parameter
     * @param nameDescription Name description data parameter
     * @param button Button dictionary key parameter
     * @param button Button link data parameter
     * @param button Button script data parameter
     */
    protected void addRow(String id, String type, Image nameImage, String nameTitle, String nameDescription, String buttonDictionaryKey, String buttonLink, String buttonScript) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        // Adds a row start
        addRowStart();
        // Type Column
        addTitleColumnData(type);
        // Name Column
        addImageTitleAndDescriptionColumnData(nameImage, nameTitle, nameDescription);
        // Button Column
        addButtonColumnData(buttonDictionaryKey, buttonLink, buttonScript);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id string parameter
     * @param clickId string parameter
     * @param type Type string parameter
     * @param nameImage Name image data parameter
     * @param nameTitle Name title data parameter
     * @param nameDescription Name description data parameter
     * @param button Button dictionary key parameter
     * @param button Button link data parameter
     * @param button Button script data parameter
     */
    protected void addRow(String id, String clickId, String type, Image nameImage, String nameTitle, String nameDescription, String buttonDictionaryKey, String buttonLink, String buttonScript) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        setClickId(clickId);
        // Adds a row start
        addRowStart();
        // Type Column
        addTitleColumnData(type);
        // Name Column
        addImageTitleAndDescriptionColumnData(nameImage, nameTitle, nameDescription);
        // Button Column
        addButtonColumnData(buttonDictionaryKey, buttonLink, buttonScript);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id string parameter
     * @param type Type string parameter
     * @param nameImage Name image data parameter
     * @param nameTitle Name title data parameter
     * @param nameDescription Name description data parameter
     * @param button Button dictionary key parameter
     * @param button Button link data parameter
     * @param button Button script data parameter
     */
    protected void addRow(String id, String type, String nameImage, String nameTitle, String nameDescription, String buttonDictionaryKey, String buttonLink, String buttonScript) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        // Adds a row start
        addRowStart();
        // Type Column
        addTitleColumnData(type);
        // Name Column
        addImageTitleAndDescriptionColumnData(nameImage, nameTitle, nameDescription);
        // Button Column
        addButtonColumnData(buttonDictionaryKey, buttonLink, buttonScript);
        // Adds the row end
        addRowEnd();
    }


    /**
     * Add row method
     * @param id string parameter
     * @param clickId string parameter
     * @param type Type string parameter
     * @param nameImage Name image data parameter
     * @param nameTitle Name title data parameter
     * @param nameDescription Name description data parameter
     * @param button Button dictionary key parameter
     * @param button Button link data parameter
     * @param button Button script data parameter
     */
    protected void addRow(String id, String clickId, String type, String nameImage, String nameTitle, String nameDescription, String buttonDictionaryKey, String buttonLink, String buttonScript) {
        // Sets row as clickable
        setClickableRow(true);
        // Sets the row id
        setRowId(encryptData(id));
        setClickId(clickId);
        // Adds a row start
        addRowStart();
        // Type Column
        addTitleColumnData(type);
        // Name Column
        addImageTitleAndDescriptionColumnData(nameImage, nameTitle, nameDescription);
        // Button Column
        addButtonColumnData(buttonDictionaryKey, buttonLink, buttonScript);
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


	// TABLE ACTIONS NOT USED -------------------------------------------------


    public void doMoveAction(String sourceId, String destinationId) {};
    public boolean doPublishAction(String sourceId, boolean published) {return false;};
	
}
