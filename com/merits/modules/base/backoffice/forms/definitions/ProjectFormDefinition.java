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
public abstract class ProjectFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected Imageselector1Field imageselector1;
    protected NameField name;
    protected HasDonationsField hasDonations;
    protected HasVolunteersField hasVolunteers;
    protected OrderNumberField orderNumber;
    protected PublishInfoField publishInfo;
    protected Label1Field label1;
    protected VolunteersWantedField volunteersWanted;
    protected VolunteersActualField volunteersActual;
    protected Label2Field label2;
    protected DonationsWantedField donationsWanted;
    protected DonationsActualField donationsActual;
    protected HeadlineField headline;
    protected DescriptionField description;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public ProjectFormDefinition() {
		// Initialization
		super("Project");
		this.parameters = new InputParameters(this);
        this.imageselector1 = new Imageselector1Field(this);
        this.name = new NameField(this);
        this.hasDonations = new HasDonationsField(this);
        this.hasVolunteers = new HasVolunteersField(this);
        this.orderNumber = new OrderNumberField(this);
        this.publishInfo = new PublishInfoField(this);
        this.label1 = new Label1Field(this);
        this.volunteersWanted = new VolunteersWantedField(this);
        this.volunteersActual = new VolunteersActualField(this);
        this.label2 = new Label2Field(this);
        this.donationsWanted = new DonationsWantedField(this);
        this.donationsActual = new DonationsActualField(this);
        this.headline = new HeadlineField(this);
        this.description = new DescriptionField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



    /**
     * Gets imageselector1
     * @return the imageselector1
     */
    public Imageselector1Field getImageselector1() {
        return imageselector1;
    }


    /**
     * Gets name
     * @return the name
     */
    public NameField getName() {
        return name;
    }


    /**
     * Gets hasDonations
     * @return the hasDonations
     */
    public HasDonationsField getHasDonations() {
        return hasDonations;
    }


    /**
     * Gets hasVolunteers
     * @return the hasVolunteers
     */
    public HasVolunteersField getHasVolunteers() {
        return hasVolunteers;
    }


    /**
     * Gets orderNumber
     * @return the orderNumber
     */
    public OrderNumberField getOrderNumber() {
        return orderNumber;
    }


    /**
     * Gets publishInfo
     * @return the publishInfo
     */
    public PublishInfoField getPublishInfo() {
        return publishInfo;
    }


    /**
     * Gets label1
     * @return the label1
     */
    public Label1Field getLabel1() {
        return label1;
    }


    /**
     * Gets volunteersWanted
     * @return the volunteersWanted
     */
    public VolunteersWantedField getVolunteersWanted() {
        return volunteersWanted;
    }


    /**
     * Gets volunteersActual
     * @return the volunteersActual
     */
    public VolunteersActualField getVolunteersActual() {
        return volunteersActual;
    }


    /**
     * Gets label2
     * @return the label2
     */
    public Label2Field getLabel2() {
        return label2;
    }


    /**
     * Gets donationsWanted
     * @return the donationsWanted
     */
    public DonationsWantedField getDonationsWanted() {
        return donationsWanted;
    }


    /**
     * Gets donationsActual
     * @return the donationsActual
     */
    public DonationsActualField getDonationsActual() {
        return donationsActual;
    }


    /**
     * Gets headline
     * @return the headline
     */
    public HeadlineField getHeadline() {
        return headline;
    }


    /**
     * Gets description
     * @return the description
     */
    public DescriptionField getDescription() {
        return description;
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
		return ProjectFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return ProjectFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		ProjectFormActions action = (ProjectFormActions) formAction;
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
		return ProjectFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return ProjectFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		ProjectFormAutoCompleteActions action = (ProjectFormAutoCompleteActions) formAction;
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
        public Long getId() throws Exception {
            if (form.getContext().getServletContext() != null) {
                return form.getContext().getServletContext().getParameterEncryptedAsLong("Id");
            } else {
                return form.getContext().getFormContext().getParameterEncryptedAsLong("Id");
            }
        }

	}

	
	// FIELDS CLASSES .......................................................
		

	// Imageselector1 ................................................................


	public class Imageselector1Field extends WeezziFormField {
		
		// Constructor
		
		public Imageselector1Field(WeezziForm form) {
			super("imageselector1", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("imageselector1", "__RowIsVisible__", visible);
        }
        
        					
		// Images .........................................................
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImage() {
            // Local Variables
        	return getParameterAsMediaImage("imageselector1");
        }
		
		
        /**
         * Gets Media image
         * @return Image
         */
        public Image getImageAndReleaseUnused(Image oldImage) {
            // Local Variables
            Image image = getParameterAsMediaImage("imageselector1");
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
            return getParameterAsMediaImageList("imageselector1");
        }
		
		
        /**
         * Gets Media image list
         * @return ImageList
         */
        public ImageList getImagesAndReleaseUnused(ImageList oldList) {
            // Local Variables
            ImageList list = getParameterAsMediaImageList("imageselector1");
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
        	return getParameterAsMediaImageWithLabels("imageselector1");
        }


        /**
         * Gets Media image with labels
         * @return ImageWithLabels
         */
        public ImageWithLabels getImageWithLabelAndReleaseUnused(ImageWithLabels oldImage) {
            // Local Variables
            ImageWithLabels image = getParameterAsMediaImageWithLabels("imageselector1");
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
        	return getParameterAsMediaImageWithLabelsList("imageselector1");
        }


        /**
         * Gets Media images with labels list
         * @return ImageWithLabelsList
         */
        public ImageWithLabelsList getImageWithLabelListsAndReleaseUnused(ImageWithLabelsList oldList) {
            // Local Variables
            ImageWithLabelsList list = getParameterAsMediaImageWithLabelsList("imageselector1");
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
                form.setFieldPropertyValue("imageselector1", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImage(ImageWithLabels image) throws ComponentNotFoundException {
            if (image != null) {
                form.setFieldPropertyValue("imageselector1", "Images", image);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("imageselector1", "Images", images);
            }
        }


        /**
         * Sets Media images
         * @param images
         */
        public void setImages(ImageWithLabelsList images) throws ComponentNotFoundException {
            if (images != null) {
                form.setFieldPropertyValue("imageselector1", "Images", images);
            }
        }
        

	}

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


	// HasDonations ................................................................

	public class HasDonationsField extends WeezziFormField {
		
		// Constructor
		
		public HasDonationsField(WeezziForm form) {
			super("hasDonations", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("hasDonations", "__RowIsVisible__", visible);
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public PublishInfo getPublishInfo() throws ParameterNotFoundException, InvalidParameterDataException {
            if (form.getParameterAsBoolean("hasDonations", false)) {
                return new PublishInfo(getBackofficeUserId());
            } else {
                return new PublishInfo();
            }
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public boolean isSelected() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsBoolean("hasDonations", false);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         */
        public void setSelected(boolean selected) throws ComponentNotFoundException {
            form.setFieldPropertyValue("hasDonations", "Selected", selected);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         * @param defaultValue Default select value
         */
        public void setSelected(Boolean selected, boolean defaultValue) throws ComponentNotFoundException {
            if (selected != null) {
                form.setFieldPropertyValue("hasDonations", "Selected", selected);
            } else {
                form.setFieldPropertyValue("hasDonations", "Selected", defaultValue);
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


	// HasVolunteers ................................................................

	public class HasVolunteersField extends WeezziFormField {
		
		// Constructor
		
		public HasVolunteersField(WeezziForm form) {
			super("hasVolunteers", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("hasVolunteers", "__RowIsVisible__", visible);
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public PublishInfo getPublishInfo() throws ParameterNotFoundException, InvalidParameterDataException {
            if (form.getParameterAsBoolean("hasVolunteers", false)) {
                return new PublishInfo(getBackofficeUserId());
            } else {
                return new PublishInfo();
            }
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public boolean isSelected() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsBoolean("hasVolunteers", false);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         */
        public void setSelected(boolean selected) throws ComponentNotFoundException {
            form.setFieldPropertyValue("hasVolunteers", "Selected", selected);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         * @param defaultValue Default select value
         */
        public void setSelected(Boolean selected, boolean defaultValue) throws ComponentNotFoundException {
            if (selected != null) {
                form.setFieldPropertyValue("hasVolunteers", "Selected", selected);
            } else {
                form.setFieldPropertyValue("hasVolunteers", "Selected", defaultValue);
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


	// OrderNumber ................................................................

	public class OrderNumberField extends WeezziFormField {
		
		// Constructor
		
		public OrderNumberField(WeezziForm form) {
			super("orderNumber", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("orderNumber", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("orderNumber");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("orderNumber");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("orderNumber");
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
                value = form.getParameterAsLong("orderNumber");
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
            return form.getParameterAsLong("orderNumber");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("orderNumber");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("orderNumber"));
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
            return form.getParameterAsLocation("orderNumber");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("orderNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("orderNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("orderNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("orderNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("orderNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("orderNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("orderNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("orderNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("orderNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("orderNumber", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("orderNumber", "Value", value);
            } else {
                form.setFieldPropertyValue("orderNumber", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("orderNumber", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("orderNumber", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("orderNumber", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// PublishInfo ................................................................

	public class PublishInfoField extends WeezziFormField {
		
		// Constructor
		
		public PublishInfoField(WeezziForm form) {
			super("publishInfo", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("publishInfo", "__RowIsVisible__", visible);
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public PublishInfo getPublishInfo() throws ParameterNotFoundException, InvalidParameterDataException {
            if (form.getParameterAsBoolean("publishInfo", false)) {
                return new PublishInfo(getBackofficeUserId());
            } else {
                return new PublishInfo();
            }
        }


        /**
         * Checks if the checkbox is selected
         * @return boolean Is selected
         */
        public boolean isSelected() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsBoolean("publishInfo", false);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         */
        public void setSelected(boolean selected) throws ComponentNotFoundException {
            form.setFieldPropertyValue("publishInfo", "Selected", selected);
        }


        /**
         * Sets selected value
         * @param selected Sets selected
         * @param defaultValue Default select value
         */
        public void setSelected(Boolean selected, boolean defaultValue) throws ComponentNotFoundException {
            if (selected != null) {
                form.setFieldPropertyValue("publishInfo", "Selected", selected);
            } else {
                form.setFieldPropertyValue("publishInfo", "Selected", defaultValue);
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


	// Label1 ................................................................

	public class Label1Field extends WeezziFormField {
		
		// Constructor
		
		public Label1Field(WeezziForm form) {
			super("label1", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label1", "__RowIsVisible__", visible);
        }


        /**
         * Sets visible
         * @param visible Sets visible
         */
        public void setVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label1", "Visible", visible);
        }


        /**
         * Sets text
         * @param text Sets text
         */
        public void setText(String text) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label1", "Text", text);
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


	// VolunteersWanted ................................................................

	public class VolunteersWantedField extends WeezziFormField {
		
		// Constructor
		
		public VolunteersWantedField(WeezziForm form) {
			super("volunteersWanted", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersWanted", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("volunteersWanted");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("volunteersWanted");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("volunteersWanted");
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
                value = form.getParameterAsLong("volunteersWanted");
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
            return form.getParameterAsLong("volunteersWanted");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("volunteersWanted");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("volunteersWanted"));
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
            return form.getParameterAsLocation("volunteersWanted");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersWanted", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("volunteersWanted", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("volunteersWanted", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// VolunteersActual ................................................................

	public class VolunteersActualField extends WeezziFormField {
		
		// Constructor
		
		public VolunteersActualField(WeezziForm form) {
			super("volunteersActual", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersActual", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("volunteersActual");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("volunteersActual");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("volunteersActual");
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
                value = form.getParameterAsLong("volunteersActual");
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
            return form.getParameterAsLong("volunteersActual");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("volunteersActual");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("volunteersActual"));
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
            return form.getParameterAsLocation("volunteersActual");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersActual", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersActual", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersActual", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("volunteersActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersActual", "Value", value);
            } else {
                form.setFieldPropertyValue("volunteersActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("volunteersActual", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("volunteersActual", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("volunteersActual", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// Label2 ................................................................

	public class Label2Field extends WeezziFormField {
		
		// Constructor
		
		public Label2Field(WeezziForm form) {
			super("label2", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label2", "__RowIsVisible__", visible);
        }


        /**
         * Sets visible
         * @param visible Sets visible
         */
        public void setVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label2", "Visible", visible);
        }


        /**
         * Sets text
         * @param text Sets text
         */
        public void setText(String text) throws ComponentNotFoundException {
            form.setFieldPropertyValue("label2", "Text", text);
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


	// DonationsWanted ................................................................

	public class DonationsWantedField extends WeezziFormField {
		
		// Constructor
		
		public DonationsWantedField(WeezziForm form) {
			super("donationsWanted", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsWanted", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("donationsWanted");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("donationsWanted");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("donationsWanted");
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
                value = form.getParameterAsLong("donationsWanted");
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
            return form.getParameterAsLong("donationsWanted");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("donationsWanted");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("donationsWanted"));
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
            return form.getParameterAsLocation("donationsWanted");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsWanted", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsWanted", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsWanted", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsWanted", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("donationsWanted", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("donationsWanted", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// DonationsActual ................................................................

	public class DonationsActualField extends WeezziFormField {
		
		// Constructor
		
		public DonationsActualField(WeezziForm form) {
			super("donationsActual", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsActual", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("donationsActual");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("donationsActual");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("donationsActual");
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
                value = form.getParameterAsLong("donationsActual");
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
            return form.getParameterAsLong("donationsActual");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("donationsActual");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("donationsActual"));
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
            return form.getParameterAsLocation("donationsActual");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsActual", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsActual", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsActual", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("donationsActual", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsActual", "Value", value);
            } else {
                form.setFieldPropertyValue("donationsActual", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("donationsActual", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("donationsActual", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("donationsActual", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// Headline ................................................................

	public class HeadlineField extends WeezziFormField {
		
		// Constructor
		
		public HeadlineField(WeezziForm form) {
			super("headline", form);
		}

		// Methods
		
		
		/**
		 * Sets column row visible
		 * @param boolean Visible 
		 */
		public void setRowVisible(boolean visible) throws ComponentNotFoundException {
			form.setFieldPropertyValue("headline", "__RowIsVisible__", visible);
		}

		
		/**
		 * Gets Headline field value
		 * @return field value
		 */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("headline");
        }

        
		/**
		 * Sets Headline field value
		 * @param value Id value
		 * @return field value
		 */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("headline", "Value", value);
        }
	}


	// Description ................................................................

	public class DescriptionField extends WeezziFormField {
		
		// Constructor
		
		public DescriptionField(WeezziForm form) {
			super("description", form);
		}

		// Methods
		
		
		/**
		 * Sets column row visible
		 * @param boolean Visible 
		 */
		public void setRowVisible(boolean visible) throws ComponentNotFoundException {
			form.setFieldPropertyValue("description", "__RowIsVisible__", visible);
		}

		
		/**
		 * Gets Description field value
		 * @return field value
		 */
        public String getValue() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameter("description");
        }

        
		/**
		 * Sets Description field value
		 * @param value Id value
		 * @return field value
		 */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("description", "Value", value);
        }
	}

	

}

