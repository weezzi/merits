package com.merits.modules.base.site.components.definitions;

//IMPORTS -------------------------------------------------------------------------

import java.util.Vector;

import com.weezzi.core.data.*;
import com.weezzi.core.components.WeezziComponentData;
import com.weezzi.core.components.data.ComponentData;
import com.weezzi.core.components.dynamicproperties.ComponentPropertyType;
import com.weezzi.core.components.dynamicproperties.DynamicComponentProperties;
import com.weezzi.core.components.exceptions.InvalidComponentDataException;
import com.weezzi.core.components.WeezziSiteComponentType;
import com.weezzi.core.components.WeezziSiteComponent;


/**
 * <b>Title: </b> CashiersPaymentRequest<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public abstract class CashiersPaymentRequestDefinition extends WeezziSiteComponent {


	// ENUMERATIONS -----------------------------------------------------------
	
	
	private enum Properties implements DynamicComponentProperties {

		
		// PROPERTIES -------------------------------------------------------------
		
		
		Default(ComponentPropertyType.String),
		;


		// ENUM IMPLEMENTATION ----------------------------------------------------
		
		
		// Properties

		private ComponentPropertyType type;


		/**
		 * Default constructor
		 * @param type
		 */
		Properties(ComponentPropertyType type) {
			this.type = type;
		}


		/**
		 * Gets Property type
		 * @return
		 */
		public ComponentPropertyType getType() {
			return type;
		}


		/**
		 * Gets Property type by name
		 * @return
		 */
		public ComponentPropertyType getType(String name) {
			return valueOf(name).getType();
		}

	}
	
	
	// PROPERTIES --------------------------------------------------------------

	
	/* Auto Generated Properties */
	
	protected WeezziComponentData componentData;
	
	
	// CONSTRUCTORS ------------------------------------------------------------


	/**
	 * Default Constructor
	 */
	public CashiersPaymentRequestDefinition() {
		// Initializes component
		setComponentName("CashiersPaymentRequest");
		// Set Component Type
		
		// Set Properties
		setComponentProperties(Properties.Default);
		// Set Component to Skip Body
		setSkipBodyComponent(true);
		// Set Component Editable status
		setEditable(false);
		// Reset Component Data
		resetComponentPropertiesValue();
	}
	

	// COMPONENT PROPERTIES ----------------------------------------------------------
	
	
	/**
	 * Generates Dynamic Component Default Properties
	 * @param component Component Data  
	 */
	public void generateDefaultProperties(ComponentData component) {
	}


    // Component data setter --------------------------------------------------
    
    
    /**
     * Sets component data by its object
     * @param data component data
     */
    public void setComponentData(WeezziComponentData data) throws InvalidComponentDataException {
        this.componentData = data;

    }


	// INITIALIZE --------------------------------------------------------------


	/**
	 * Set component properties to their default values
	 */
	public void resetComponentPropertiesValue() {
   	}



	// Getters -----------------------------------------------------------------



	// Setters -----------------------------------------------------------------



	// BROWSER OUTPUT ----------------------------------------------------------


	public void componentInitialization() {
		// Custom Component Initialization
		customComponentInitialization();
	}


	protected abstract void customComponentInitialization();


	public void doComponentAdjustments(ComponentData tag) {
	}


	/**
	 * This is filled automatically from the parameter types given to the tag
	 */
	public Vector<Long> getDictionaryKeyIds() {
		return null;
	}


	/**
	 * This is filled automatically from the parameter types given to the tag
	 */
	public Vector<Long> getSiteDocumentIds() {
		return null;
	}
	

	// NO END OUTPUT ----------------------------------------------------------


	/**
	 * Tag has no end output so create empty method
	 */
	public String getEndOutput() {
		return null;
	}

}

