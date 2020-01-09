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
public abstract class EditVolunteerFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected OrganizationField organization;
    protected FirstNameField firstName;
    protected LastNameField lastName;
    protected UserNameField userName;
    protected UserPasswordField userPassword;
    protected BlockedField blocked;
    protected CardTypeField cardType;
    protected CardNumberField cardNumber;
    protected PhotoField photo;
    protected MobileField mobile;
    protected AddressField address;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public EditVolunteerFormDefinition() {
		// Initialization
		super("EditVolunteer");
		this.parameters = new InputParameters(this);
        this.organization = new OrganizationField(this);
        this.firstName = new FirstNameField(this);
        this.lastName = new LastNameField(this);
        this.userName = new UserNameField(this);
        this.userPassword = new UserPasswordField(this);
        this.blocked = new BlockedField(this);
        this.cardType = new CardTypeField(this);
        this.cardNumber = new CardNumberField(this);
        this.photo = new PhotoField(this);
        this.mobile = new MobileField(this);
        this.address = new AddressField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



    /**
     * Gets organization
     * @return the organization
     */
    public OrganizationField getOrganization() {
        return organization;
    }


    /**
     * Gets firstName
     * @return the firstName
     */
    public FirstNameField getFirstName() {
        return firstName;
    }


    /**
     * Gets lastName
     * @return the lastName
     */
    public LastNameField getLastName() {
        return lastName;
    }


    /**
     * Gets userName
     * @return the userName
     */
    public UserNameField getUserName() {
        return userName;
    }


    /**
     * Gets userPassword
     * @return the userPassword
     */
    public UserPasswordField getUserPassword() {
        return userPassword;
    }


    /**
     * Gets blocked
     * @return the blocked
     */
    public BlockedField getBlocked() {
        return blocked;
    }


    /**
     * Gets cardType
     * @return the cardType
     */
    public CardTypeField getCardType() {
        return cardType;
    }


    /**
     * Gets cardNumber
     * @return the cardNumber
     */
    public CardNumberField getCardNumber() {
        return cardNumber;
    }


    /**
     * Gets photo
     * @return the photo
     */
    public PhotoField getPhoto() {
        return photo;
    }


    /**
     * Gets mobile
     * @return the mobile
     */
    public MobileField getMobile() {
        return mobile;
    }


    /**
     * Gets address
     * @return the address
     */
    public AddressField getAddress() {
        return address;
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
		return EditVolunteerFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return EditVolunteerFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		EditVolunteerFormActions action = (EditVolunteerFormActions) formAction;
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
		return EditVolunteerFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return EditVolunteerFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		EditVolunteerFormAutoCompleteActions action = (EditVolunteerFormAutoCompleteActions) formAction;
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

        
        
        /**
        /**
         * Gets Id parameter
         * @return
         * @throws Exception
         */
        public long getId() throws Exception {
            if (form.getContext().getServletContext() != null) {
                return form.getContext().getServletContext().getParameterRequiredEncryptedAsLong("Id");
            } else {
                return form.getContext().getFormContext().getParameterRequiredEncryptedAsLong("Id");
            }
        }

	}

	
	// FIELDS CLASSES .......................................................
		


	// Organization ................................................................

	public class OrganizationField extends WeezziFormField {
		
		// Constructor
		
		public OrganizationField(WeezziForm form) {
			super("organization", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "__RowIsVisible__", visible);
        }


        /**
         * Gets List string value 
         * @return field String value
         */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("organization");
        }


        /**
         * Gets List long value 
         * @return field Long value
         */
        public Long getLongValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("organization");
        }


        /**
         * Gets List int value 
         * @return field Integer value
         */
        public Integer getIntegerValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("organization");
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            form.setFieldPropertyValue("organization", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options organization
         * @param options List options
         */
        public void setValue(List options) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("organization", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Constant selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" + selectedId.getValue());
            }
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Long selectedId, long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Integer selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Integer selectedId, int defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options organization
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            form.setFieldPropertyValue("organization", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options organization
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("organization", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options organization
         * @param options Tree options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options organization
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, Long selectedId, Long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("organization", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("organization", "SelectedOptionId", "" +defaultId);
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


	// FirstName ................................................................

	public class FirstNameField extends WeezziFormField {
		
		// Constructor
		
		public FirstNameField(WeezziForm form) {
			super("firstName", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("firstName", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("firstName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("firstName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("firstName");
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
                value = form.getParameterAsLong("firstName");
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
            return form.getParameterAsLong("firstName");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("firstName");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("firstName"));
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
            return form.getParameterAsLocation("firstName");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("firstName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("firstName", "Value", value);
            } else {
                form.setFieldPropertyValue("firstName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("firstName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("firstName", "Value", value);
            } else {
                form.setFieldPropertyValue("firstName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("firstName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("firstName", "Value", value);
            } else {
                form.setFieldPropertyValue("firstName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("firstName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("firstName", "Value", value);
            } else {
                form.setFieldPropertyValue("firstName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("firstName", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("firstName", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("firstName", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// LastName ................................................................

	public class LastNameField extends WeezziFormField {
		
		// Constructor
		
		public LastNameField(WeezziForm form) {
			super("lastName", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("lastName", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("lastName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("lastName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("lastName");
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
                value = form.getParameterAsLong("lastName");
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
            return form.getParameterAsLong("lastName");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("lastName");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("lastName"));
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
            return form.getParameterAsLocation("lastName");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("lastName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("lastName", "Value", value);
            } else {
                form.setFieldPropertyValue("lastName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("lastName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("lastName", "Value", value);
            } else {
                form.setFieldPropertyValue("lastName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("lastName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("lastName", "Value", value);
            } else {
                form.setFieldPropertyValue("lastName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("lastName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("lastName", "Value", value);
            } else {
                form.setFieldPropertyValue("lastName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("lastName", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("lastName", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("lastName", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// UserName ................................................................

	public class UserNameField extends WeezziFormField {
		
		// Constructor
		
		public UserNameField(WeezziForm form) {
			super("userName", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userName", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("userName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("userName");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("userName");
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
                value = form.getParameterAsLong("userName");
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
            return form.getParameterAsLong("userName");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("userName");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("userName"));
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
            return form.getParameterAsLocation("userName");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userName", "Value", value);
            } else {
                form.setFieldPropertyValue("userName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userName", "Value", value);
            } else {
                form.setFieldPropertyValue("userName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userName", "Value", value);
            } else {
                form.setFieldPropertyValue("userName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userName", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userName", "Value", value);
            } else {
                form.setFieldPropertyValue("userName", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userName", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("userName", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("userName", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// UserPassword ................................................................

	public class UserPasswordField extends WeezziFormField {
		
		// Constructor
		
		public UserPasswordField(WeezziForm form) {
			super("userPassword", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userPassword", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("userPassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("userPassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("userPassword");
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
                value = form.getParameterAsLong("userPassword");
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
            return form.getParameterAsLong("userPassword");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("userPassword");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("userPassword"));
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
            return form.getParameterAsLocation("userPassword");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("userPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("userPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("userPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("userPassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userPassword", "Value", value);
            } else {
                form.setFieldPropertyValue("userPassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("userPassword", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("userPassword", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("userPassword", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// Blocked ................................................................

	public class BlockedField extends WeezziFormField {
		
		// Constructor
		
		public BlockedField(WeezziForm form) {
			super("blocked", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("blocked", "__RowIsVisible__", visible);
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public boolean isSelected() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsBoolean("blocked", false);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         */
        public void setSelected(boolean selected) throws ComponentNotFoundException {
            form.setFieldPropertyValue("blocked", "Selected", selected);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         * @param defaultValue Default select value
         */
        public void setSelected(Boolean selected, boolean defaultValue) throws ComponentNotFoundException {
            if (selected != null) {
                form.setFieldPropertyValue("blocked", "Selected", selected);
            } else {
                form.setFieldPropertyValue("blocked", "Selected", defaultValue);
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


	// CardType ................................................................

	public class CardTypeField extends WeezziFormField {
		
		// Constructor
		
		public CardTypeField(WeezziForm form) {
			super("cardType", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "__RowIsVisible__", visible);
        }


        /**
         * Gets List string value 
         * @return field String value
         */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("cardType");
        }


        /**
         * Gets List long value 
         * @return field Long value
         */
        public Long getLongValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("cardType");
        }


        /**
         * Gets List int value 
         * @return field Integer value
         */
        public Integer getIntegerValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("cardType");
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            form.setFieldPropertyValue("cardType", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options cardType
         * @param options List options
         */
        public void setValue(List options) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Constant selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" + selectedId.getValue());
            }
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Long selectedId, long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Integer selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Integer selectedId, int defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options cardType
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            form.setFieldPropertyValue("cardType", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options cardType
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options cardType
         * @param options Tree options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options cardType
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, Long selectedId, Long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardType", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("cardType", "SelectedOptionId", "" +defaultId);
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


	// CardNumber ................................................................

	public class CardNumberField extends WeezziFormField {
		
		// Constructor
		
		public CardNumberField(WeezziForm form) {
			super("cardNumber", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardNumber", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("cardNumber");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("cardNumber");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("cardNumber");
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
                value = form.getParameterAsLong("cardNumber");
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
            return form.getParameterAsLong("cardNumber");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("cardNumber");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("cardNumber"));
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
            return form.getParameterAsLocation("cardNumber");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("cardNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("cardNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("cardNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("cardNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("cardNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("cardNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("cardNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("cardNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("cardNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("cardNumber", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("cardNumber", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("cardNumber", "Value", CalendarUtilities.getStandardDate(defaultValue));
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

	// Photo ................................................................


	public class PhotoField extends WeezziFormField {
		
		// Constructor
		
		public PhotoField(WeezziForm form) {
			super("photo", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("photo", "__RowIsVisible__", visible);
        }
        
        					
		// Images .........................................................
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImage() {
            // Local Variables
        	return getParameterAsMediaImage("photo");
        }
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImageAndReleaseUnused(Image oldImage) {
            // Local Variables
            Image image = getParameterAsMediaImage("photo");
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
            return getParameterAsMediaImageList("photo");
        }
		
		
        /**
         * Gets Media image list
         * @return ImageList
         */
        public ImageList getImagesAndReleaseUnused(ImageList oldList) {
            // Local Variables
            ImageList list = getParameterAsMediaImageList("photo");
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
        	return getParameterAsMediaImageWithLabels("photo");
        }


        /**
         * Gets Media image with labels
         * @return ImageWithLabels
         */
        public ImageWithLabels getImageWithLabelAndReleaseUnused(ImageWithLabels oldImage) {
            // Local Variables
            ImageWithLabels image = getParameterAsMediaImageWithLabels("photo");
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
        	return getParameterAsMediaImageWithLabelsList("photo");
        }


        /**
         * Gets Media images with labels list
         * @return ImageWithLabelsList
         */
        public ImageWithLabelsList getImageWithLabelListsAndReleaseUnused(ImageWithLabelsList oldList) {
            // Local Variables
            ImageWithLabelsList list = getParameterAsMediaImageWithLabelsList("photo");
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
                form.setFieldPropertyValue("photo", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImage(ImageWithLabels image) throws ComponentNotFoundException {
            if (image != null) {
                form.setFieldPropertyValue("photo", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("photo", "Images", images);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageWithLabelsList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("photo", "Images", images);
            }
        }
        
        
        // Documents ......................................................


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocument() {
            // Local Variables
        	return getParameterAsMediaDocument("photo");
        }


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocumentAndReleaseUnused(Document oldDocument) {
            // Local Variables
            Document document = getParameterAsMediaDocument("photo");
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
        	return getParameterAsMediaDocumentList("photo");
        }


        /**
         * Gets Media documents
         * @return DocumentList
         */
        public DocumentList getDocumentsAndReleaseUnused(DocumentList oldList) {
            // Local Variables
            DocumentList list = getParameterAsMediaDocumentList("photo");
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
        	return getParameterAsMediaDocumentWithLabels("photo");
        }


        /**
         * Gets Media document with labels
         * @return DocumentWithLabels
         */
        public DocumentWithLabels getDocumentWithLabelsAndReleaseUnused(DocumentWithLabels oldDocument) {
            // Local Variables
            DocumentWithLabels document = getParameterAsMediaDocumentWithLabels("photo");
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
        	return getParameterAsMediaDocumentWithLabelsList("photo");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public DocumentWithLabelsList getDocumentWithLabelsListAndReleaseUnused(DocumentWithLabelsList oldList) {
            // Local Variables
            DocumentWithLabelsList list = getParameterAsMediaDocumentWithLabelsList("photo");
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
                form.setFieldPropertyValue("photo", "Files", document);
            }
        }


        /**
         * Sets Media files
         * @param files
         */
        public void setDocument(DocumentWithLabels document) throws ComponentNotFoundException {
            if (document != null) {
                form.setFieldPropertyValue("photo", "Files", document);
            }
        }


        /**
         * Sets Media documents
         * @param documents
         */
        public void setDocuments(DocumentList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("photo", "Files", documents);
            }
        }


        /**
         * Sets Media documents
         * @param files
         */
        public void setDocuments(DocumentWithLabelsList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("photo", "Files", documents);
            }
        }

        
        // Videos .........................................................


        /**
         * Gets a Media video
         * @return Video
         */
        public Video getVideo() {
            // Local Variables
        	return getParameterAsMediaVideo("photo");
        }


        /**
         * Gets Media video
         * @return video
         */
        public Video getVideoAndReleaseUnused(Video oldVideo) {
            // Local Variables
            Video video = getParameterAsMediaVideo("photo");
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
        	return getParameterAsMediaVideoWithLabels("photo");
        }


        /**
         * Gets Media video
         * @return video
         */
        public VideoWithLabels getVideoAndReleaseUnused(VideoWithLabels oldVideo) {
            // Local Variables
            VideoWithLabels video = getParameterAsMediaVideoWithLabels("photo");
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
        	return getParameterAsMediaVideoList("photo");
        }


        /**
         * Gets Media video list
         * @return VideoList
         */
        public VideoList getVideoListAndReleaseUnused(VideoList oldList) {
            // Local Variables
            VideoList list = getParameterAsMediaVideoList("photo");
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
        	return getParameterAsMediaVideoWithLabelsList("photo");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public VideoWithLabelsList getVideoWithLabelsListAndReleaseUnused(VideoWithLabelsList oldList) {
            // Local Variables
            VideoWithLabelsList list = getParameterAsMediaVideoWithLabelsList("photo");
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
                form.setFieldPropertyValue("photo", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabels video) throws ComponentNotFoundException {
            if (video != null) {
                form.setFieldPropertyValue("photo", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("photo", "Videos", videos);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabelsList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("photo", "Videos", videos);
            }
        }

        
        // Sounds .........................................................
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSound() {
            // Local Variables
        	return getParameterAsMediaSound("photo");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSoundAndReleaseUnused(Sound oldSound) {
            // Local Variables
            Sound sound = getParameterAsMediaSound("photo");
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
        	return getParameterAsMediaSoundWithLabels("photo");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabels getSoundWithLabels(SoundWithLabels oldSound) {
            // Local Variables
            SoundWithLabels sound = getParameterAsMediaSoundWithLabels("photo");
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
        	return getParameterAsMediaSoundList("photo");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundList getSoundListAndRemoveUnused(SoundList oldList) {
            // Local Variables
            SoundList list = getParameterAsMediaSoundList("photo");
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
        	return getParameterAsMediaSoundWithLabelsList("photo");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabelsList getSoundsWithLabelsAndRemoveUnused(SoundWithLabelsList oldList) {
            // Local Variables
            SoundWithLabelsList list = getParameterAsMediaSoundWithLabelsList("photo");
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
                form.setFieldPropertyValue("photo", "Sounds", sound);
            }
        }


        /**
         * Sets Media sound
         * @param sound
         */
        public void setSound(SoundWithLabels sound) throws ComponentNotFoundException {
            if (sound != null) {
                form.setFieldPropertyValue("photo", "Sounds", sound);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("photo", "Sounds", sounds);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundWithLabelsList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("photo", "Sounds", sounds);
            }
        }

	}

	// Mobile ................................................................

	public class MobileField extends WeezziFormField {
		
		// Constructor
		
		public MobileField(WeezziForm form) {
			super("mobile", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("mobile", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("mobile");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("mobile");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("mobile");
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
                value = form.getParameterAsLong("mobile");
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
            return form.getParameterAsLong("mobile");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("mobile");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("mobile"));
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
            return form.getParameterAsLocation("mobile");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("mobile", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("mobile", "Value", value);
            } else {
                form.setFieldPropertyValue("mobile", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("mobile", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("mobile", "Value", value);
            } else {
                form.setFieldPropertyValue("mobile", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("mobile", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("mobile", "Value", value);
            } else {
                form.setFieldPropertyValue("mobile", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("mobile", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("mobile", "Value", value);
            } else {
                form.setFieldPropertyValue("mobile", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("mobile", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("mobile", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("mobile", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// Address ................................................................

	public class AddressField extends WeezziFormField {
		
		// Constructor
		
		public AddressField(WeezziForm form) {
			super("address", form);
		}

		// Methods
		
		
		/**
		 * Sets column row visible
		 * @param boolean Visible 
		 */
		public void setRowVisible(boolean visible) throws ComponentNotFoundException {
			form.setFieldPropertyValue("address", "__RowIsVisible__", visible);
		}

		
		/**
		 * Gets Address field value
		 * @return field value
		 */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("address");
        }

        
		/**
		 * Sets Address field value
		 * @param value Id value
		 * @return field value
		 */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("address", "Value", value);
        }
	}

	

}

