package com.merits.modules.base.site.components.definitions;

//IMPORTS -------------------------------------------------------------------------

import java.util.Vector;

import com.weezzi.core.data.*;
import com.weezzi.core.sites.components.ComponentPropertiesDefinition;
import com.weezzi.core.sites.components.ComponentStyleDefinition;
import com.weezzi.core.sites.components.MediaType;
import com.weezzi.core.sites.components.TextEditableOptions;
import com.weezzi.core.sites.components.fields.ComponentFieldButton;
import com.weezzi.core.sites.components.fields.ComponentFieldMedia;
import com.weezzi.core.sites.components.fields.ComponentFieldText;
import com.weezzi.core.sites.components.fields.ComponentTextType;
import com.weezzi.core.sites.components.fields.FieldContentType;
import com.weezzi.core.sites.components.fields.StyleFieldsGroup;
import com.weezzi.core.sites.components.properties.ComponentDefinitionPropertyType;
import com.weezzi.core.sites.components.properties.ComponentProperty;
import com.weezzi.core.components.SiteComponentType;
import com.weezzi.core.components.WeezziComponentData;
import com.weezzi.core.components.data.ComponentData;
import com.weezzi.core.components.data.ComponentType;
import com.weezzi.core.components.dynamicproperties.ComponentPropertyType;
import com.weezzi.core.components.dynamicproperties.DynamicComponentProperties;
import com.weezzi.core.components.exceptions.InvalidComponentDataException;
import com.weezzi.core.components.WeezziSiteComponentType;
import com.weezzi.core.components.WeezziSiteComponent;


/**
 * <b>Title: </b> HomeHeader<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public abstract class HomeHeaderDefinition extends WeezziSiteComponent {


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
	public HomeHeaderDefinition() {
		// Initializes component
		setComponentName("HomeHeader");
		// Set Component Type
		setComponentType(SiteComponentType.Intro);
		// Set Properties
		setComponentProperties(Properties.Default);
		// Set Component to Skip Body
		setSkipBodyComponent(true);
		// Set Component Editable status
		setEditable(true);
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

	public ComponentPropertiesDefinition createDefaultPropertiesDefinition() {
		// Local Variables
		ComponentPropertiesDefinition definition;
		definition = new ComponentPropertiesDefinition(getComponentName(), ComponentType.ProjectSite, null, 0);
		definition.addProperty(new ComponentProperty("Background", ComponentDefinitionPropertyType.BackgroundColorImage));
		definition.addProperty(new ComponentProperty("ImageFX", ComponentDefinitionPropertyType.ImageEffects));

		definition.addField(new ComponentFieldText(new TextEditableOptions(false), false, "title", ComponentTextType.Small, FieldContentType.Title));
		definition.addField(new ComponentFieldText(new TextEditableOptions(false), false, "desc", ComponentTextType.Medium, FieldContentType.ShortDescription));
		definition.addField(new ComponentFieldButton("button", true, false, true, true, 1));
		return definition;
	}


	public Vector<ComponentStyleDefinition> createDefaultStylesDefinition(ComponentPropertiesDefinition definition) {
		// Local Variables
		StyleFieldsGroup group;
		ComponentStyleDefinition style;
		Vector<ComponentStyleDefinition> styles = new Vector<ComponentStyleDefinition>();
		// Default
		style = new ComponentStyleDefinition("Default", getComponentName(), ComponentType.ProjectSite, 0);
		style.setIsSystemKey(false);
		group = new StyleFieldsGroup("Default");
		group.addAllFields(definition);
		style.addGroup(group);
		styles.add(style);
		// Return styles
		return styles;
	}
}

