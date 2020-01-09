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
public abstract class AddVolunteerFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected FirstNameField firstName;
    protected LastNameField lastName;
    protected VolunteerUsernameField volunteerUsername;
    protected VolunteePasswordField volunteePassword;
    protected ImageField image;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public AddVolunteerFormDefinition() {
		// Initialization
		super("AddVolunteer");
		this.parameters = new InputParameters(this);
        this.firstName = new FirstNameField(this);
        this.lastName = new LastNameField(this);
        this.volunteerUsername = new VolunteerUsernameField(this);
        this.volunteePassword = new VolunteePasswordField(this);
        this.image = new ImageField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



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
     * Gets volunteerUsername
     * @return the volunteerUsername
     */
    public VolunteerUsernameField getVolunteerUsername() {
        return volunteerUsername;
    }


    /**
     * Gets volunteePassword
     * @return the volunteePassword
     */
    public VolunteePasswordField getVolunteePassword() {
        return volunteePassword;
    }


    /**
     * Gets image
     * @return the image
     */
    public ImageField getImage() {
        return image;
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
		return AddVolunteerFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return AddVolunteerFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddVolunteerFormActions action = (AddVolunteerFormActions) formAction;
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
		return AddVolunteerFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return AddVolunteerFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddVolunteerFormAutoCompleteActions action = (AddVolunteerFormAutoCompleteActions) formAction;
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


	// VolunteerUsername ................................................................

	public class VolunteerUsernameField extends WeezziFormField {
		
		// Constructor
		
		public VolunteerUsernameField(WeezziForm form) {
			super("volunteerUsername", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteerUsername", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("volunteerUsername");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("volunteerUsername");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("volunteerUsername");
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
                value = form.getParameterAsLong("volunteerUsername");
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
            return form.getParameterAsLong("volunteerUsername");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("volunteerUsername");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("volunteerUsername"));
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
            return form.getParameterAsLocation("volunteerUsername");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteerUsername", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteerUsername", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteerUsername", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteerUsername", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("volunteerUsername", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("volunteerUsername", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// VolunteePassword ................................................................

	public class VolunteePasswordField extends WeezziFormField {
		
		// Constructor
		
		public VolunteePasswordField(WeezziForm form) {
			super("volunteePassword", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteePassword", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("volunteePassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("volunteePassword");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("volunteePassword");
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
                value = form.getParameterAsLong("volunteePassword");
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
            return form.getParameterAsLong("volunteePassword");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("volunteePassword");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("volunteePassword"));
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
            return form.getParameterAsLocation("volunteePassword");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteePassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteePassword", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteePassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteePassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteePassword", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteePassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteePassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteePassword", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteePassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteePassword", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteePassword", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteePassword", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteePassword", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("volunteePassword", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("volunteePassword", "Value", CalendarUtilities.getStandardDate(defaultValue));
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

	// Image ................................................................


	public class ImageField extends WeezziFormField {
		
		// Constructor
		
		public ImageField(WeezziForm form) {
			super("image", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("image", "__RowIsVisible__", visible);
        }
        
        					
		// Images .........................................................
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImage() {
            // Local Variables
        	return getParameterAsMediaImage("image");
        }
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImageAndReleaseUnused(Image oldImage) {
            // Local Variables
            Image image = getParameterAsMediaImage("image");
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
            return getParameterAsMediaImageList("image");
        }
		
		
        /**
         * Gets Media image list
         * @return ImageList
         */
        public ImageList getImagesAndReleaseUnused(ImageList oldList) {
            // Local Variables
            ImageList list = getParameterAsMediaImageList("image");
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
        	return getParameterAsMediaImageWithLabels("image");
        }


        /**
         * Gets Media image with labels
         * @return ImageWithLabels
         */
        public ImageWithLabels getImageWithLabelAndReleaseUnused(ImageWithLabels oldImage) {
            // Local Variables
            ImageWithLabels image = getParameterAsMediaImageWithLabels("image");
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
        	return getParameterAsMediaImageWithLabelsList("image");
        }


        /**
         * Gets Media images with labels list
         * @return ImageWithLabelsList
         */
        public ImageWithLabelsList getImageWithLabelListsAndReleaseUnused(ImageWithLabelsList oldList) {
            // Local Variables
            ImageWithLabelsList list = getParameterAsMediaImageWithLabelsList("image");
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
                form.setFieldPropertyValue("image", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImage(ImageWithLabels image) throws ComponentNotFoundException {
            if (image != null) {
                form.setFieldPropertyValue("image", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("image", "Images", images);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageWithLabelsList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("image", "Images", images);
            }
        }
        
        
        // Documents ......................................................


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocument() {
            // Local Variables
        	return getParameterAsMediaDocument("image");
        }


        /**
         * Gets Media document
         * @return Document
         */
        public Document getDocumentAndReleaseUnused(Document oldDocument) {
            // Local Variables
            Document document = getParameterAsMediaDocument("image");
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
        	return getParameterAsMediaDocumentList("image");
        }


        /**
         * Gets Media documents
         * @return DocumentList
         */
        public DocumentList getDocumentsAndReleaseUnused(DocumentList oldList) {
            // Local Variables
            DocumentList list = getParameterAsMediaDocumentList("image");
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
        	return getParameterAsMediaDocumentWithLabels("image");
        }


        /**
         * Gets Media document with labels
         * @return DocumentWithLabels
         */
        public DocumentWithLabels getDocumentWithLabelsAndReleaseUnused(DocumentWithLabels oldDocument) {
            // Local Variables
            DocumentWithLabels document = getParameterAsMediaDocumentWithLabels("image");
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
        	return getParameterAsMediaDocumentWithLabelsList("image");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public DocumentWithLabelsList getDocumentWithLabelsListAndReleaseUnused(DocumentWithLabelsList oldList) {
            // Local Variables
            DocumentWithLabelsList list = getParameterAsMediaDocumentWithLabelsList("image");
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
                form.setFieldPropertyValue("image", "Files", document);
            }
        }


        /**
         * Sets Media files
         * @param files
         */
        public void setDocument(DocumentWithLabels document) throws ComponentNotFoundException {
            if (document != null) {
                form.setFieldPropertyValue("image", "Files", document);
            }
        }


        /**
         * Sets Media documents
         * @param documents
         */
        public void setDocuments(DocumentList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("image", "Files", documents);
            }
        }


        /**
         * Sets Media documents
         * @param files
         */
        public void setDocuments(DocumentWithLabelsList documents) throws ComponentNotFoundException {
            if (documents != null) {
                form.setFieldPropertyValue("image", "Files", documents);
            }
        }

        
        // Videos .........................................................


        /**
         * Gets a Media video
         * @return Video
         */
        public Video getVideo() {
            // Local Variables
        	return getParameterAsMediaVideo("image");
        }


        /**
         * Gets Media video
         * @return video
         */
        public Video getVideoAndReleaseUnused(Video oldVideo) {
            // Local Variables
            Video video = getParameterAsMediaVideo("image");
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
        	return getParameterAsMediaVideoWithLabels("image");
        }


        /**
         * Gets Media video
         * @return video
         */
        public VideoWithLabels getVideoAndReleaseUnused(VideoWithLabels oldVideo) {
            // Local Variables
            VideoWithLabels video = getParameterAsMediaVideoWithLabels("image");
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
        	return getParameterAsMediaVideoList("image");
        }


        /**
         * Gets Media video list
         * @return VideoList
         */
        public VideoList getVideoListAndReleaseUnused(VideoList oldList) {
            // Local Variables
            VideoList list = getParameterAsMediaVideoList("image");
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
        	return getParameterAsMediaVideoWithLabelsList("image");
        }


        /**
         * Gets Media documents
         * @return DocumentWithLabelsList
         */
        public VideoWithLabelsList getVideoWithLabelsListAndReleaseUnused(VideoWithLabelsList oldList) {
            // Local Variables
            VideoWithLabelsList list = getParameterAsMediaVideoWithLabelsList("image");
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
                form.setFieldPropertyValue("image", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabels video) throws ComponentNotFoundException {
            if (video != null) {
                form.setFieldPropertyValue("image", "Videos", video);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("image", "Videos", videos);
            }
        }


        /**
         * Sets Media videos
         * @param videos
         */
        public void setVideos(VideoWithLabelsList videos) throws ComponentNotFoundException {
            if (videos != null) {
                form.setFieldPropertyValue("image", "Videos", videos);
            }
        }

        
        // Sounds .........................................................
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSound() {
            // Local Variables
        	return getParameterAsMediaSound("image");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public Sound getSoundAndReleaseUnused(Sound oldSound) {
            // Local Variables
            Sound sound = getParameterAsMediaSound("image");
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
        	return getParameterAsMediaSoundWithLabels("image");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabels getSoundWithLabels(SoundWithLabels oldSound) {
            // Local Variables
            SoundWithLabels sound = getParameterAsMediaSoundWithLabels("image");
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
        	return getParameterAsMediaSoundList("image");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundList getSoundListAndRemoveUnused(SoundList oldList) {
            // Local Variables
            SoundList list = getParameterAsMediaSoundList("image");
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
        	return getParameterAsMediaSoundWithLabelsList("image");
        }
        
        
        /**
         * Gets Media sounds
         * @return SoundWithLabelsList
         */
        public SoundWithLabelsList getSoundsWithLabelsAndRemoveUnused(SoundWithLabelsList oldList) {
            // Local Variables
            SoundWithLabelsList list = getParameterAsMediaSoundWithLabelsList("image");
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
                form.setFieldPropertyValue("image", "Sounds", sound);
            }
        }


        /**
         * Sets Media sound
         * @param sound
         */
        public void setSound(SoundWithLabels sound) throws ComponentNotFoundException {
            if (sound != null) {
                form.setFieldPropertyValue("image", "Sounds", sound);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("image", "Sounds", sounds);
            }
        }


        /**
         * Sets Media sounds
         * @param sounds
         */
        public void setSounds(SoundWithLabelsList sounds) throws ComponentNotFoundException {
            if (sounds != null) {
                form.setFieldPropertyValue("image", "Sounds", sounds);
            }
        }

	}
	

}

