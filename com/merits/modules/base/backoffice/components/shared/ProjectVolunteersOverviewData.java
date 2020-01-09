package com.merits.modules.base.backoffice.components.shared;

//IMPORTS -------------------------------------------------------------------------

import com.weezzi.core.data.*;
import com.weezzi.core.components.WeezziComponentData;
import com.weezzi.core.components.exceptions.PropertyNotFoundException;

/**
 * <b>Title: </b> ProjectVolunteersOverview Data<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class ProjectVolunteersOverviewData implements WeezziComponentData {

	// CONSTANTS --------------------------------------------------------------


    public static String ID = "Id";
	
	// PROPERTIES -------------------------------------------------------------

	
    private String Id;

	// CONSTRUCTORS -----------------------------------------------------------


	public ProjectVolunteersOverviewData() {
		// Initialization
	}
	
	
	// PUBLIC -----------------------------------------------------------------


	// Getters.................................................................
    
    
    /**
     * Gets Id Value
     */
    public String getId() {
        return Id;
    }



	// Setters.................................................................
    
    
    /**
     * Sets Id Value
     * @param Id
     */
    public void setId(String value) {
        Id = value;
    }

	
	
	// COMPONENT DATA METHODS ------------------------------------------------- 
	

	/**
	 * Gets Boolean parameter value
	 * @param propertyName Property name
	 */
	public Boolean getBoolean(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a integer parameter value
	 * @param propertyName Property name
	 */
	public Integer getInteger(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("Integer Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a long parameter value
	 * @param propertyName Property name
	 */
	public Long getLong(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("Long Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a string parameter value
	 * @param propertyName Property name
	 */
	public String getString(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}
        if (propertyName.equalsIgnoreCase(ID)) {
            return Id;
        }

		throw new PropertyNotFoundException("String Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a object parameter value
	 * @param propertyName Property name
	 */
	public Object getObject(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("Object Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a list parameter value
	 * @param propertyName Property name
	 */
	public List getList(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("List Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}


	/**
	 * Gets a tree parameter value
	 * @param propertyName Property name
	 */
	public Tree getTree(String propertyName) throws PropertyNotFoundException {
		// Check if it is not null
		if (propertyName == null) {
			throw new PropertyNotFoundException("Property name cannot be null");
		}

		throw new PropertyNotFoundException("Tree Property \"" + propertyName + "\" does not exist in ProjectVolunteersOverviewData component");
	}

	

}

