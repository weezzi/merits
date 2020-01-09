package com.merits.modules.base.uobjects.enums;

//IMPORTS -------------------------------------------------------------------------

import java.io.Serializable;

import com.weezzi.core.data.Constant;
import com.weezzi.core.data.List;
import com.weezzi.core.data.ListItem;


/**
 * <b>Title: </b> WALLET_OPERATION<br/>
 * <b>Description: </b> WALLET_OPERATION<br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
public enum WalletOperation implements Constant, Serializable {


	// ENUMERATIONS -----------------------------------------------------------


    TransferSend("TransferSend", 1),
    TransferReceive("TransferReceive", 2),
    Create("Create", 3),
    Kill("Kill", 4),
    Burned("Burned", 5),
	;
	


	// CONSTANTS -------------------------------------------------------------

	
	public static final long serialVersionUID = 1l;


	// PROPERTIES -------------------------------------------------------------
	
	
	private String name;
	private int value;
	
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	
	WalletOperation(String name, int value) {
		this.name = name;
    	this.value = value;
    }
    
    
	// Getter -----------------------------------------------------------------
	
	
	/**
	 * Get constant name
	 * @return the constant name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Get constant value
	 * @return the constant value
	 */
	public int getValue() {
		return value;
	}
	

	/**
	 * Gets a enumeration by its value
	 * @param value
	 * @return
	 */
	public static WalletOperation getByValue(Integer value) {
		// Check if is not null
		if (value == null) {
			return null;
		}
		// Check all values
		for(WalletOperation enu : values()) {
			if (enu.getValue() == value) {
				return enu;
			}
		}
		// Not found
		return null;
	}
	
	
	/**
	 * Gets a constant by its value
	 * @param value
	 * @return
	 */
	public static WalletOperation getByName(String name) {
		// Check if is not null
		if (name == null) {
			return null;
		}
		// Check all values
		
		for(WalletOperation enu : values()) {
			if (enu.getName().equals(name)) {
				return enu;
			}
		}
		// Not found
		return null;
	}
	
	
	/**
	 * Gets the constants as a list
	 * @return
	 */
	public static List getAsList() {
		// Local Variables
		List list = new List();
		// Check all values
		for(WalletOperation value : values()) {
			list.addItem(new ListItem(value.getName(), value.getValue() + ""));
		}
		return list;
	}
	
}
