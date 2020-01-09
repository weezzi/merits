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
public abstract class TeamFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected PhotoField photo;
    protected NameField name;
    protected PositionField position;
    protected DescriptionField description;
    protected LinkInstagramField linkInstagram;
    protected LinkFacebookField linkFacebook;
    protected LinkTwitterField linkTwitter;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public TeamFormDefinition() {
		// Initialization
		super("Team");
		this.parameters = new InputParameters(this);
        this.photo = new PhotoField(this);
        this.name = new NameField(this);
        this.position = new PositionField(this);
        this.description = new DescriptionField(this);
        this.linkInstagram = new LinkInstagramField(this);
        this.linkFacebook = new LinkFacebookField(this);
        this.linkTwitter = new LinkTwitterField(this);

	}
	
	
	// PUBLIC -----------------------------------------------------------------



    /**
     * Gets photo
     * @return the photo
     */
    public PhotoField getPhoto() {
        return photo;
    }


    /**
     * Gets name
     * @return the name
     */
    public NameField getName() {
        return name;
    }


    /**
     * Gets position
     * @return the position
     */
    public PositionField getPosition() {
        return position;
    }


    /**
     * Gets description
     * @return the description
     */
    public DescriptionField getDescription() {
        return description;
    }


    /**
     * Gets linkInstagram
     * @return the linkInstagram
     */
    public LinkInstagramField getLinkInstagram() {
        return linkInstagram;
    }


    /**
     * Gets linkFacebook
     * @return the linkFacebook
     */
    public LinkFacebookField getLinkFacebook() {
        return linkFacebook;
    }


    /**
     * Gets linkTwitter
     * @return the linkTwitter
     */
    public LinkTwitterField getLinkTwitter() {
        return linkTwitter;
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
		return TeamFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return TeamFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		TeamFormActions action = (TeamFormActions) formAction;
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
		return TeamFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return TeamFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		TeamFormAutoCompleteActions action = (TeamFormAutoCompleteActions) formAction;
		// Check action
		switch(action) {

		}
		return null;
	}


	// MULTI-LANGUAGE METHODS -------------------------------------------------
    // Name ..........................................................
    
    
    /**
     * Handler for the multi-language request to be implemented in form class
     * @param langCode Current Language Code
     * @param previousLangCode Previous Language Code
     * @param savePrevious If previous data should be saved
     */
    public abstract void multiLanguageRequestHandler(String langCode, String previousLangCode, boolean savePrevious) throws Exception;
    
    
    /**
     * Form multi-language handler
     * @throws Exception
     * @return
     */
    public void formMultiLanguage(String langCode, String previousLangCode, boolean savePrevious) throws Exception {
        multiLanguageRequestHandler(langCode, previousLangCode, savePrevious);
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


	// Position ................................................................

	public class PositionField extends WeezziFormField {
		
		// Constructor
		
		public PositionField(WeezziForm form) {
			super("position", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("position", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("position");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("position");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("position");
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
                value = form.getParameterAsLong("position");
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
            return form.getParameterAsLong("position");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("position");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("position"));
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
            return form.getParameterAsLocation("position");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("position", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("position", "Value", value);
            } else {
                form.setFieldPropertyValue("position", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("position", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("position", "Value", value);
            } else {
                form.setFieldPropertyValue("position", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("position", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("position", "Value", value);
            } else {
                form.setFieldPropertyValue("position", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("position", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("position", "Value", value);
            } else {
                form.setFieldPropertyValue("position", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("position", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("position", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("position", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// LinkInstagram ................................................................

	public class LinkInstagramField extends WeezziFormField {
		
		// Constructor
		
		public LinkInstagramField(WeezziForm form) {
			super("linkInstagram", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkInstagram", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("linkInstagram");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("linkInstagram");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("linkInstagram");
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
                value = form.getParameterAsLong("linkInstagram");
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
            return form.getParameterAsLong("linkInstagram");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("linkInstagram");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("linkInstagram"));
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
            return form.getParameterAsLocation("linkInstagram");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkInstagram", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkInstagram", "Value", value);
            } else {
                form.setFieldPropertyValue("linkInstagram", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkInstagram", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkInstagram", "Value", value);
            } else {
                form.setFieldPropertyValue("linkInstagram", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkInstagram", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkInstagram", "Value", value);
            } else {
                form.setFieldPropertyValue("linkInstagram", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkInstagram", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkInstagram", "Value", value);
            } else {
                form.setFieldPropertyValue("linkInstagram", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkInstagram", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("linkInstagram", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("linkInstagram", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// LinkFacebook ................................................................

	public class LinkFacebookField extends WeezziFormField {
		
		// Constructor
		
		public LinkFacebookField(WeezziForm form) {
			super("linkFacebook", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkFacebook", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("linkFacebook");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("linkFacebook");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("linkFacebook");
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
                value = form.getParameterAsLong("linkFacebook");
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
            return form.getParameterAsLong("linkFacebook");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("linkFacebook");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("linkFacebook"));
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
            return form.getParameterAsLocation("linkFacebook");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkFacebook", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkFacebook", "Value", value);
            } else {
                form.setFieldPropertyValue("linkFacebook", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkFacebook", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkFacebook", "Value", value);
            } else {
                form.setFieldPropertyValue("linkFacebook", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkFacebook", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkFacebook", "Value", value);
            } else {
                form.setFieldPropertyValue("linkFacebook", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkFacebook", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkFacebook", "Value", value);
            } else {
                form.setFieldPropertyValue("linkFacebook", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkFacebook", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("linkFacebook", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("linkFacebook", "Value", CalendarUtilities.getStandardDate(defaultValue));
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


	// LinkTwitter ................................................................

	public class LinkTwitterField extends WeezziFormField {
		
		// Constructor
		
		public LinkTwitterField(WeezziForm form) {
			super("linkTwitter", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkTwitter", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("linkTwitter");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("linkTwitter");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("linkTwitter");
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
                value = form.getParameterAsLong("linkTwitter");
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
            return form.getParameterAsLong("linkTwitter");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("linkTwitter");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("linkTwitter"));
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
            return form.getParameterAsLocation("linkTwitter");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkTwitter", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkTwitter", "Value", value);
            } else {
                form.setFieldPropertyValue("linkTwitter", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkTwitter", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkTwitter", "Value", value);
            } else {
                form.setFieldPropertyValue("linkTwitter", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkTwitter", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkTwitter", "Value", value);
            } else {
                form.setFieldPropertyValue("linkTwitter", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("linkTwitter", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkTwitter", "Value", value);
            } else {
                form.setFieldPropertyValue("linkTwitter", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("linkTwitter", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("linkTwitter", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("linkTwitter", "Value", CalendarUtilities.getStandardDate(defaultValue));
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

