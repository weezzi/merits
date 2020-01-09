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
public abstract class TopupUserFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected OrganizationField organization;
    protected AmountField amount;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public TopupUserFormDefinition() {
		// Initialization
		super("TopupUser");
		this.parameters = new InputParameters(this);
        this.organization = new OrganizationField(this);
        this.amount = new AmountField(this);

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
     * Gets amount
     * @return the amount
     */
    public AmountField getAmount() {
        return amount;
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
		return TopupUserFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return TopupUserFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		TopupUserFormActions action = (TopupUserFormActions) formAction;
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
		return TopupUserFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return TopupUserFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		TopupUserFormAutoCompleteActions action = (TopupUserFormAutoCompleteActions) formAction;
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


	// Amount ................................................................

	public class AmountField extends WeezziFormField {
		
		// Constructor
		
		public AmountField(WeezziForm form) {
			super("amount", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("amount", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("amount");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("amount");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("amount");
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
                value = form.getParameterAsLong("amount");
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
            return form.getParameterAsLong("amount");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("amount");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("amount"));
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
            return form.getParameterAsLocation("amount");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("amount", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("amount", "Value", value);
            } else {
                form.setFieldPropertyValue("amount", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("amount", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("amount", "Value", value);
            } else {
                form.setFieldPropertyValue("amount", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("amount", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("amount", "Value", value);
            } else {
                form.setFieldPropertyValue("amount", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("amount", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("amount", "Value", value);
            } else {
                form.setFieldPropertyValue("amount", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("amount", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("amount", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("amount", "Value", CalendarUtilities.getStandardDate(defaultValue));
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

	

}

