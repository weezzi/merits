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
public abstract class AddShopGoodTypeFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected GoodField good;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public AddShopGoodTypeFormDefinition() {
		// Initialization
		super("AddShopGoodType");
		this.parameters = new InputParameters(this);
        this.good = new GoodField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



    /**
     * Gets good
     * @return the good
     */
    public GoodField getGood() {
        return good;
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
		return AddShopGoodTypeFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return AddShopGoodTypeFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddShopGoodTypeFormActions action = (AddShopGoodTypeFormActions) formAction;
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
		return AddShopGoodTypeFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return AddShopGoodTypeFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		AddShopGoodTypeFormAutoCompleteActions action = (AddShopGoodTypeFormAutoCompleteActions) formAction;
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
		


	// Good ................................................................

	public class GoodField extends WeezziFormField {
		
		// Constructor
		
		public GoodField(WeezziForm form) {
			super("good", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "__RowIsVisible__", visible);
        }


        /**
         * Gets List string value 
         * @return field String value
         */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("good");
        }


        /**
         * Gets List long value 
         * @return field Long value
         */
        public Long getLongValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsLong("good");
        }


        /**
         * Gets List int value 
         * @return field Integer value
         */
        public Integer getIntegerValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("good");
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            form.setFieldPropertyValue("good", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options good
         * @param options List options
         */
        public void setValue(List options) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("good", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Constant selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" + selectedId.getValue());
            }
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Long selectedId, long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(List options, Integer selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(List options, Integer selectedId, int defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +defaultId);
            } 
        }


        /**
         * Sets List Options good
         * @param options List options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, String selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            form.setFieldPropertyValue("good", "SelectedOptionId", selectedId);
        }


        /**
         * Sets List Options good
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, String selectedId, String defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", selectedId);
            } else {
                form.setFieldPropertyValue("good", "SelectedOptionId", defaultId);
            } 
        }


        /**
         * Sets List Options good
         * @param options Tree options
         * @param selectedId List options selected id
         */
        public void setValue(Tree options, Long selectedId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" + selectedId);
            }
        }


        /**
         * Sets List Options good
         * @param options Tree options
         * @param selectedId List options selected id
         * @param defaultId List default id
         */
        public void setValue(Tree options, Long selectedId, Long defaultId) throws ComponentNotFoundException {
            form.setFieldPropertyValue("good", "Options", options);
            if (selectedId != null) {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +selectedId);
            } else {
                form.setFieldPropertyValue("good", "SelectedOptionId", "" +defaultId);
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

