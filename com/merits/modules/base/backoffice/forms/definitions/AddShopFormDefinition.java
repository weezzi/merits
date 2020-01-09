package com.merits.modules.base.backoffice.forms.definitions;

//IMPORTS --------------------------------------------------------------------

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.sql.Timestamp;

import com.weezzi.core.containers.FilesContainer;
import com.weezzi.core.context.BackofficeWZIContext;
import com.weezzi.core.data.*;
import com.weezzi.utils.*;
import com.weezzi.core.charts.WeezziChart;
import com.weezzi.core.charts.WeezziPieChart;
import com.weezzi.core.data.exceptions.InvalidJavascriptValueException;
import com.weezzi.core.data.exceptions.MaximumListSizeReachedException;
import com.weezzi.core.exceptions.InvalidParameterDataException;
import com.weezzi.core.exceptions.ParameterNotFoundException;
import com.weezzi.core.forms.WeezziEvent;
import com.weezzi.core.forms.WeezziForm;
import com.weezzi.core.forms.WeezziFormField;
import com.weezzi.core.servlets.base.WeezziServletAction;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.CalendarUtilities;
import com.weezzi.system.modules.wcontacts.uobjects.enums.ContactGender;

import com.weezzi.utils.extras.console.Console;

/**
 * <b>Title: </b> <br/>
 * <b>Description: </b> <br/>
 * <b>Copyright: </b>Copyright (c) 2012 Weezzi Enterprise<br/>
 * <b>Company: </b><A HREF="http://www.weezzienterprise.com">Weezzi Enterprise</A><br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public abstract class AddShopFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected NameField name;
    protected ShopUrlField shopUrl;
    protected ShopPhoneField shopPhone;
    protected ShopEmailField shopEmail;
    protected OwnerUsernameField ownerUsername;
    protected OwnerPasswordField ownerPassword;
    protected MediaField media;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public AddShopFormDefinition() {
		// Initialization
		super("AddShop");
		this.parameters = new InputParameters(this);
        this.name = new NameField(this);
        this.shopUrl = new ShopUrlField(this);
        this.shopPhone = new ShopPhoneField(this);
        this.shopEmail = new ShopEmailField(this);
        this.ownerUsername = new OwnerUsernameField(this);
        this.ownerPassword = new OwnerPasswordField(this);
        this.media = new MediaField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



    /**
     * Gets name
     * @return the name
     */
    public NameField getName() {
        return name;
    }


    /**
     * Gets shopUrl
     * @return the shopUrl
     */
    public ShopUrlField getShopUrl() {
        return shopUrl;
    }


    /**
     * Gets shopPhone
     * @return the shopPhone
     */
    public ShopPhoneField getShopPhone() {
        return shopPhone;
    }


    /**
     * Gets shopEmail
     * @return the shopEmail
     */
    public ShopEmailField getShopEmail() {
        return shopEmail;
    }


    /**
     * Gets ownerUsername
     * @return the ownerUsername
     */
    public OwnerUsernameField getOwnerUsername() {
        return ownerUsername;
    }


    /**
     * Gets ownerPassword
     * @return the ownerPassword
     */
    public OwnerPasswordField getOwnerPassword() {
        return ownerPassword;
    }


    /**
     * Gets media
     * @return the media
     */
    public MediaField getMedia() {
        return media;
    }


	// Initialize .............................................................


	public void initialize() throws Exception {

	}


	// Actions ................................................................


	/**
	 * Gets all servlet actions
	 * @return All Actions
	 */
	public WeezziServletAction[] getActions() {
		// Local Variables
		return AddShopFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return AddShopFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddShopFormActions action = (AddShopFormActions) formAction;
		// Check action
		switch(action) {

		}
	}


	// Groups .................................................................


	// Events .................................................................


	// Auto-Complete ..........................................................


	/**
	 * Gets all auto-complete actions
	 * @return All Actions
	 */
	public WeezziServletAction[] getAutoCompleteActions() {
		// Local Variables
		return AddShopFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return AddShopFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddShopFormAutoCompleteActions action = (AddShopFormAutoCompleteActions) formAction;
		// Check action
		switch(action) {

		}
		return null;
	}


	// MULTI-LANGUAGE METHODS -------------------------------------------------
    
    
    /**
     * Form multi-language handler
     * @throws Exception
     * @return
     */
    public void formMultiLanguage(String langCode, String previousLangCode, boolean savePrevious) throws Exception {
    }


	// AUTO-COMPLETE METHODS --------------------------------------------------


	// FORM INPUT PARAMETERS --------------------------------------------------

	/**
	 * Gets multi screen id
	 * @return
	 */
	protected String getMultiScreenId() {
		// Local Variables
		BackofficeWZIContext backofficeContext;
		// Check context
		if (getContext().getFormContext() != null) {
			// Check if is backoffice
			if (getContext().getFormContext() instanceof BackofficeWZIContext) {
				backofficeContext = (BackofficeWZIContext) getContext().getFormContext();
				if (backofficeContext.getActiveScreen() != null) {
					return backofficeContext.getActiveScreen().getName(); 
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else if (getContext().getServletContext() != null) {
			return getContext().getServletContext().getParameter("__#WBS#__");
		}
		return null;
	}

	
	/**
	 * Gets form input parameters parameters
	 * @return the parameters
	 */
	public InputParameters getParameters() {
		return parameters;
	}

	
	// INPUT PARAMETERS CLASS .......................................................
	
	
	protected class InputParameters {

		
		// PROPERTIES ---------------------------------------------------------
		
		
		private WeezziForm form;
		
		
		// CONSTRUCTOR --------------------------------------------------------
		
		
		/**
		 * Default constructor
		 * @param form Form
		 */
		public InputParameters(WeezziForm form) {
			this.form = form;
		}

		
		// PARAMETERS ---------------------------------------------------------


	}

	
	// FIELDS CLASSES .......................................................
		


	// Name ................................................................

	public class NameField extends WeezziFormField {
		
		// Constructor
		
		public NameField(WeezziForm form) {
			super("name", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("name", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("name");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("name");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("name");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("name");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("name");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("name");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("name"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("name");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("name", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", value);
            } else {
                form.setFieldPropertyValue("name", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("name", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", value);
            } else {
                form.setFieldPropertyValue("name", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("name", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", value);
            } else {
                form.setFieldPropertyValue("name", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("name", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", value);
            } else {
                form.setFieldPropertyValue("name", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("name", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("name", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}


	// ShopUrl ................................................................

	public class ShopUrlField extends WeezziFormField {
		
		// Constructor
		
		public ShopUrlField(WeezziForm form) {
			super("shopUrl", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopUrl", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("shopUrl");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("shopUrl");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("shopUrl");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("shopUrl");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("shopUrl");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("shopUrl");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("shopUrl"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("shopUrl");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopUrl", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", value);
            } else {
                form.setFieldPropertyValue("shopUrl", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopUrl", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", value);
            } else {
                form.setFieldPropertyValue("shopUrl", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopUrl", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", value);
            } else {
                form.setFieldPropertyValue("shopUrl", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopUrl", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", value);
            } else {
                form.setFieldPropertyValue("shopUrl", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopUrl", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("shopUrl", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}


	// ShopPhone ................................................................

	public class ShopPhoneField extends WeezziFormField {
		
		// Constructor
		
		public ShopPhoneField(WeezziForm form) {
			super("shopPhone", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopPhone", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("shopPhone");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("shopPhone");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("shopPhone");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("shopPhone");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("shopPhone");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("shopPhone");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("shopPhone"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("shopPhone");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopPhone", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", value);
            } else {
                form.setFieldPropertyValue("shopPhone", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopPhone", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", value);
            } else {
                form.setFieldPropertyValue("shopPhone", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopPhone", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", value);
            } else {
                form.setFieldPropertyValue("shopPhone", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopPhone", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", value);
            } else {
                form.setFieldPropertyValue("shopPhone", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopPhone", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("shopPhone", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}


	// ShopEmail ................................................................

	public class ShopEmailField extends WeezziFormField {
		
		// Constructor
		
		public ShopEmailField(WeezziForm form) {
			super("shopEmail", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopEmail", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("shopEmail");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("shopEmail");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("shopEmail");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("shopEmail");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("shopEmail");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("shopEmail");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("shopEmail"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("shopEmail");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopEmail", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", value);
            } else {
                form.setFieldPropertyValue("shopEmail", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopEmail", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", value);
            } else {
                form.setFieldPropertyValue("shopEmail", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopEmail", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", value);
            } else {
                form.setFieldPropertyValue("shopEmail", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("shopEmail", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", value);
            } else {
                form.setFieldPropertyValue("shopEmail", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("shopEmail", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("shopEmail", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}


	// OwnerUsername ................................................................

	public class OwnerUsernameField extends WeezziFormField {
		
		// Constructor
		
		public OwnerUsernameField(WeezziForm form) {
			super("ownerUsername", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerUsername", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("ownerUsername");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("ownerUsername");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("ownerUsername");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("ownerUsername");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("ownerUsername");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("ownerUsername");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("ownerUsername"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("ownerUsername");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerUsername", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("ownerUsername", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}


	// OwnerPassword ................................................................

	public class OwnerPasswordField extends WeezziFormField {
		
		// Constructor
		
		public OwnerPasswordField(WeezziForm form) {
			super("ownerPassword", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerPassword", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("ownerPassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("ownerPassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("ownerPassword");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return long long value
         */
        public long getValueAsLong(long defaultValue) {
            Long value = null;
            try {
                value = form.getParameterAsLong("ownerPassword");
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an long
         * @return Long Long value
         */
        public Long getValueAsLong() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("ownerPassword");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("ownerPassword");
        }


        /**
         * Gets input value as an float
         * @return float float value
         */
        public float getValueAsFloat(float defaultValue) {
            Float value = null;
            try {
                value = getValueAsFloat();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Date
         * @return Date Date value
         */
        public Date getValueAsDate() throws ParameterNotFoundException, InvalidParameterDataException {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("ownerPassword"));
            } catch(Exception e) {
                return null;
            }
        }


        /**
         * Gets input value as an date
         * @return Date Date value
         */
        public Date getValueAsDate(Date defaultValue) {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp() throws ParameterNotFoundException, InvalidParameterDataException {
            Date value = null;
            try {
                value = getValueAsDate();
            } catch(Exception e) {
            }
            if (value != null) {
                return new Timestamp(value.getTime());
            } else {
                return null;
            }
        }


        /**
         * Gets input value as an Timestamp
         * @return Timestamp Timestamp value
         */
        public Timestamp getValueAsTimestamp(Timestamp defaultValue) {
            Timestamp value = null;
            try {
                value = getValueAsTimestamp();
            } catch(Exception e) {
            }
            if (value == null) {
                return defaultValue;
            } else {
                return value;
            }
        }


        /**
         * Gets input value as location
         * @return GeoLocation GeoLocation value
         */
        public GeoLocation getValueAsLocation() {
            return form.getParameterAsLocation("ownerPassword");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("ownerPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("ownerPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", CalendarUtilities.getStandardDate(value));
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(GeoLocation value) throws ComponentNotFoundException {
            if (value != null) {
                setValue(value.getLocationName());
            }
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Timestamp value, Timestamp defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("ownerPassword", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("ownerPassword", "Value", CalendarUtilities.getStandardDate(defaultValue));
            }
        }
			

		/**
		 * Gets a parameter part value
		 * @return value
		 */
		private String getParameterPartValue(String value, String partName) {
			// Local variables
			int startIndex;
			int endIndex;
			// Check if value is not null
			if (value == null) {
				return null;
			}
			startIndex = value.indexOf("|" + partName + ">>");
			endIndex = value.indexOf("<<" + partName + "|");
			if ((startIndex >= 0) && (endIndex >= 0)) {
				return value.substring(startIndex+6, endIndex);
			}
			return null;
		}
	}

	// Media ................................................................


	public class MediaField extends WeezziFormField {
		
		// Constructor
		
		public MediaField(WeezziForm form) {
			super("media", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("media", "__RowIsVisible__", visible);
        }
        
        					
		// Images .........................................................
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImage() {
            // Local Variables
        	return getParameterAsMediaImage("media");
        }
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImageAndReleaseUnused(Image oldImage) {
            // Local Variables
            Image image = getParameterAsMediaImage("media");
            if ((oldImage != null) && (oldImage.getDocumentId() == 0)) {
            	if ((image == null) || (image.getFileId() != oldImage.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldImage.getFileId());
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldImage.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return image;
        }

		
        /**
         * Gets Media image list
         * @return ImageList
         */
        public ImageList getImages() {
            // Local Variables
            return getParameterAsMediaImageList("media");
        }
		
		
        /**
         * Gets Media image list
         * @return ImageList
         */
        public ImageList getImagesAndReleaseUnused(ImageList oldList) {
            // Local Variables
            ImageList list = getParameterAsMediaImageList("media");
            if (oldList != null) {
            	for(Image oldImage : oldList.getList()) {
            		if ((list == null) || ((oldImage.getDocumentId() == 0) && (!list.hasFileId(oldImage.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldImage.getFileId());
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldImage.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Gets Media image with labels
         * @return ImageWithLabels
         */
        public ImageWithLabels getImageWithLabel() {
            // Local Variables
        	return getParameterAsMediaImageWithLabels("media");
        }


        /**
         * Gets Media image with labels
         * @return ImageWithLabels
         */
        public ImageWithLabels getImageWithLabelAndReleaseUnused(ImageWithLabels oldImage) {
            // Local Variables
            ImageWithLabels image = getParameterAsMediaImageWithLabels("media");
            if ((oldImage != null) && (oldImage.getDocumentId() == 0)) {
            	if ((image == null) || (image.getFileId() != oldImage.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldImage.getFileId());
						//delete image labels
						oldImage.deleteLabels();
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldImage.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return image;
        }


        /**
         * Gets Media images with labels list
         * @return ImageWithLabelsList
         */
        public ImageWithLabelsList getImageWithLabelLists() {
            // Local Variables
        	return getParameterAsMediaImageWithLabelsList("media");
        }


        /**
         * Gets Media images with labels list
         * @return ImageWithLabelsList
         */
        public ImageWithLabelsList getImageWithLabelListsAndReleaseUnused(ImageWithLabelsList oldList) {
            // Local Variables
            ImageWithLabelsList list = getParameterAsMediaImageWithLabelsList("media");
            if (oldList != null) {
            	for(ImageWithLabels oldImage : oldList.getList()) {
            		if ((list == null) || ((oldImage.getDocumentId() == 0) && (!list.hasFileId(oldImage.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldImage.getFileId());
							//delete image labels
							oldImage.deleteLabels();
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldImage.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImage(Image image) throws ComponentNotFoundException {
            if (image != null) {
                form.setFieldPropertyValue("media", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImage(ImageWithLabels image) throws ComponentNotFoundException {
            if (image != null) {
                form.setFieldPropertyValue("media", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("media", "Images", images);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageWithLabelsList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("media", "Images", images);
            }
        }
        
        
        // Documents ......................................................


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocument() {
            // Local Variables
        	return getParameterAsMediaDocument("media");
        }


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocumentAndReleaseUnused(Document oldDocument) {
            // Local Variables
            Document document = getParameterAsMediaDocument("media");
            if ((oldDocument != null) && (oldDocument.getDocumentId() == 0)) {
            	if ((document == null) || (document.getFileId() != oldDocument.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldDocument.getFileId());
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldDocument.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return document;
        }


        /**
         * Gets Media documents
         * @return DocumentList
         */
        public DocumentList getDocuments() {
            // Local Variables
        	return getParameterAsMediaDocumentList("media");
        }


        /**
         * Gets Media documents
         * @return DocumentList
         */
        public DocumentList getDocumentsAndReleaseUnused(DocumentList oldList) {
            // Local Variables
            DocumentList list = getParameterAsMediaDocumentList("media");
            if (oldList != null) {
            	for(Document oldDocument : oldList.getList()) {
            		if ((list == null) || ((oldDocument.getDocumentId() == 0) && (!list.hasFileId(oldDocument.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldDocument.getFileId());
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldDocument.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Gets Media document with labels
         * @return DocumentWithLabels
         */
        public DocumentWithLabels getDocumentWithLabels() {
            // Local Variables
        	return getParameterAsMediaDocumentWithLabels("media");
        }


        /**
         * Gets Media document with labels
         * @return DocumentWithLabels
         */
        public DocumentWithLabels getDocumentWithLabelsAndReleaseUnused(DocumentWithLabels oldDocument) {
            // Local Variables
            DocumentWithLabels document = getParameterAsMediaDocumentWithLabels("media");
            if ((oldDocument != null) && (oldDocument.getDocumentId() == 0)) {
            	if ((document == null) || (document.getFileId() != oldDocument.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldDocument.getFileId());
						//delete document labels
						oldDocument.deleteLabels();
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldDocument.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return document;
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public DocumentWithLabelsList getDocumentWithLabelsList() {
            // Local Variables
        	return getParameterAsMediaDocumentWithLabelsList("media");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public DocumentWithLabelsList getDocumentWithLabelsListAndReleaseUnused(DocumentWithLabelsList oldList) {
            // Local Variables
            DocumentWithLabelsList list = getParameterAsMediaDocumentWithLabelsList("media");
            if (oldList != null) {
            	for(DocumentWithLabels oldDocument : oldList.getList()) {
            		if ((list == null) || ((oldDocument.getDocumentId() == 0) && (!list.hasFileId(oldDocument.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldDocument.getFileId());
							//delete document labels
							oldDocument.deleteLabels();
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldDocument.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Sets Media files
         * @param files
         */
        public void setDocument(Document document) throws ComponentNotFoundException {
            if (document != null) {
                form.setFieldPropertyValue("media", "Files", document);
            }
        }


        /**
         * Sets Media files
         * @param files
         */
        public void setDocument(DocumentWithLabels document) throws ComponentNotFoundException {
            if (document != null) {
                form.setFieldPropertyValue("media", "Files", document);
            }
        }


        /**
         * Sets Media documents
         * @param documents
         */
        public void setDocuments(DocumentList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("media", "Files", documents);
            }
        }


        /**
         * Sets Media documents
         * @param files
         */
        public void setDocuments(DocumentWithLabelsList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("media", "Files", documents);
            }
        }

        
        // Videos .........................................................


        /**
         * Gets a Media video
         * @return Video
         */
        public Video getVideo() {
            // Local Variables
        	return getParameterAsMediaVideo("media");
        }


        /**
         * Gets Media video
         * @return video
         */
        public Video getVideoAndReleaseUnused(Video oldVideo) {
            // Local Variables
            Video video = getParameterAsMediaVideo("media");
            if ((oldVideo != null) && (oldVideo.getDocumentId() == 0)) {
            	if ((video == null) || (video.getPreviewFileId() != oldVideo.getPreviewFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldVideo.getPreviewFileId());
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldVideo.getPreviewFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return video;
        }


        /**
         * Gets Media videos
         * @return VideoWithLabelsList
         */
        public VideoWithLabels getVideoWithLabels() {
            // Local Variables
        	return getParameterAsMediaVideoWithLabels("media");
        }


        /**
         * Gets Media video
         * @return video
         */
        public VideoWithLabels getVideoAndReleaseUnused(VideoWithLabels oldVideo) {
            // Local Variables
            VideoWithLabels video = getParameterAsMediaVideoWithLabels("media");
            if ((oldVideo != null) && (oldVideo.getDocumentId() == 0)) {
            	if ((video == null) || (video.getPreviewFileId() != oldVideo.getPreviewFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldVideo.getPreviewFileId());
						//delete video labels
						oldVideo.deleteLabels();
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldVideo.getPreviewFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return video;
        }


        /**
         * Gets Media videos
         * @return VideoWithLabelsList
         */
        public VideoList getVideoList() {
            // Local Variables
        	return getParameterAsMediaVideoList("media");
        }


        /**
         * Gets Media video list
         * @return VideoList
         */
        public VideoList getVideoListAndReleaseUnused(VideoList oldList) {
            // Local Variables
            VideoList list = getParameterAsMediaVideoList("media");
            if (oldList != null) {
            	for(Video oldVideo : oldList.getList()) {
            		if ((list == null) || ((oldVideo.getDocumentId() == 0) && (!list.hasPreviewFileId(oldVideo.getPreviewFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldVideo.getPreviewFileId());
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldVideo.getPreviewFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Gets Media videos
         * @return VideoWithLabelsList
         */
        public VideoWithLabelsList getVideosWithLabelsList() {
            // Local Variables
        	return getParameterAsMediaVideoWithLabelsList("media");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public VideoWithLabelsList getVideoWithLabelsListAndReleaseUnused(VideoWithLabelsList oldList) {
            // Local Variables
            VideoWithLabelsList list = getParameterAsMediaVideoWithLabelsList("media");
            if (oldList != null) {
            	for(VideoWithLabels oldVideo : oldList.getList()) {
            		if ((list == null) || ((oldVideo.getDocumentId() == 0) && (!list.hasPreviewFileId(oldVideo.getPreviewFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldVideo.getPreviewFileId());
							//delete video labels
							oldVideo.deleteLabels();
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldVideo.getPreviewFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideo(Video video) throws ComponentNotFoundException {
            if (video != null) {
                form.setFieldPropertyValue("media", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabels video) throws ComponentNotFoundException {
            if (video != null) {
                form.setFieldPropertyValue("media", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("media", "Videos", videos);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabelsList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("media", "Videos", videos);
            }
        }

        
        // Sounds .........................................................
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSound() {
            // Local Variables
        	return getParameterAsMediaSound("media");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSoundAndReleaseUnused(Sound oldSound) {
            // Local Variables
            Sound sound = getParameterAsMediaSound("media");
            if ((oldSound != null) && (oldSound.getDocumentId() == 0)) {
            	if ((sound == null) || (sound.getFileId() != oldSound.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldSound.getFileId());
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldSound.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return sound;
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabels getSoundWithLabels() {
            // Local Variables
        	return getParameterAsMediaSoundWithLabels("media");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabels getSoundWithLabels(SoundWithLabels oldSound) {
            // Local Variables
            SoundWithLabels sound = getParameterAsMediaSoundWithLabels("media");
            if ((oldSound != null) && (oldSound.getDocumentId() == 0)) {
            	if ((sound == null) || (sound.getFileId() != oldSound.getFileId())) {
	            	try {
						FilesContainer.deleteFile(getSiteId(), oldSound.getFileId());
						//delete sound labels
						oldSound.deleteLabels();
					} catch (Exception e) {
						// Catch Exception
						Console.error("Error deleting internal file with id \"" + oldSound.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
					}
				}
            }            
        	return sound;
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundList getSounds() {
            // Local Variables
        	return getParameterAsMediaSoundList("media");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundList getSoundListAndRemoveUnused(SoundList oldList) {
            // Local Variables
            SoundList list = getParameterAsMediaSoundList("media");
            if (oldList != null) {
            	for(Sound oldSound : oldList.getList()) {
            		if ((list == null) || ((oldSound.getDocumentId() == 0) && (!list.hasFileId(oldSound.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldSound.getFileId());
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldSound.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabelsList getSoundsWithLabels() {
            // Local Variables
        	return getParameterAsMediaSoundWithLabelsList("media");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabelsList getSoundsWithLabelsAndRemoveUnused(SoundWithLabelsList oldList) {
            // Local Variables
            SoundWithLabelsList list = getParameterAsMediaSoundWithLabelsList("media");
            if (oldList != null) {
            	for(SoundWithLabels oldSound : oldList.getList()) {
            		if ((list == null) || ((oldSound.getDocumentId() == 0) && (!list.hasFileId(oldSound.getFileId())))) {
                    	try {
        					FilesContainer.deleteFile(getSiteId(), oldSound.getFileId());
							//delete sound labels
							oldSound.deleteLabels();
        				} catch (Exception e) {
        					// Catch Exception
        					Console.error("Error deleting internal file with id \"" + oldSound.getFileId() + "\" on site \"" + getSiteId() + "\"", e);
        				}
            		}
            	}
            }            
        	return list;
        }
        


        /**
         * Sets Media sound
         * @param sound
         */
        public void setSound(Sound sound) throws ComponentNotFoundException {
            if (sound != null) {
                form.setFieldPropertyValue("media", "Sounds", sound);
            }
        }


        /**
         * Sets Media sound
         * @param sound
         */
        public void setSound(SoundWithLabels sound) throws ComponentNotFoundException {
            if (sound != null) {
                form.setFieldPropertyValue("media", "Sounds", sound);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("media", "Sounds", sounds);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundWithLabelsList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("media", "Sounds", sounds);
            }
        }

	}
	

}

