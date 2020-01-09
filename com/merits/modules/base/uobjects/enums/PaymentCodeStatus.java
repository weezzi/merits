package com.merits.modules.base.uobjects.enums;

//IMPORTS -------------------------------------------------------------------------

import java.io.Serializable;

import com.weezzi.core.data.Constant;
import com.weezzi.core.data.List;
import com.weezzi.core.data.ListItem;


/**
 * <b>Title: </b> PAYMENT_CODE_STATUS<br/>
 * <b>Description: </b> PAYMENT_CODE_STATUS<br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
public enum PaymentCodeStatus implements Constant, Serializable {


	// ENUMERATIONS -----------------------------------------------------------


    Valid("Valid", 1),
    Used("Used", 2),
    Canceled("Canceled", 3),
	;
	


	// CONSTANTS -------------------------------------------------------------

	
	public static final long serialVersionUID = 1l;


	// PROPERTIES -------------------------------------------------------------
	
	
	private String name;
	private int value;
	
	
	// CONSTRUCTORS -----------------------------------------------------------
	
	
	PaymentCodeStatus(String name, int value) {
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
	public static PaymentCodeStatus getByValue(Integer value) {
		// Check if is not null
		if (value == null) {
			return null;
		}
		// Check all values
		for(PaymentCodeStatus enu : values()) {
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
	public static PaymentCodeStatus getByName(String name) {
		// Check if is not null
		if (name == null) {
			return null;
		}
		// Check all values
		
		for(PaymentCodeStatus enu : values()) {
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
		for(PaymentCodeStatus value : values()) {
			list.addItem(new ListItem(value.getName(), value.getValue() + ""));
		}
		return list;
	}
	
}

