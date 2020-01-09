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
public abstract class SponsorFormDefinition extends WeezziForm {


	// CONSTANTS --------------------------------------------------------------


	// PROPERTIES -------------------------------------------------------------

    
    protected PhotoField photo;
    protected NameField name;
    protected UrlField url;

    protected InputParameters parameters;
	
    
	// CONSTRUCTORS -----------------------------------------------------------

	
	public SponsorFormDefinition() {
		// Initialization
		super("Sponsor");
		this.parameters = new InputParameters(this);
        this.photo = new PhotoField(this);
        this.name = new NameField(this);
        this.url = new UrlField(this);

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
     * Gets url
     * @return the url
     */
    public UrlField getUrl() {
        return url;
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
		return SponsorFormActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getActionByName(String actionName) {
		// Local Variables
		return SponsorFormActions.valueOf(actionName);
	}


	public void processAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		SponsorFormActions action = (SponsorFormActions) formAction;
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
		return SponsorFormAutoCompleteActions.values();
	}


	/**
	 * Gets a action by its name
	 * @param actionName Action Name
	 * @return Servlet action or null if not found
	 */
	public WeezziServletAction getAutoCompleteActionByName(String actionName) {
		// Local Variables
		return SponsorFormAutoCompleteActions.valueOf(actionName);
	}


	public AutoCompleteList processAutoCompleteAction(WeezziServletAction formAction) throws Throwable {
		// Local Variables
		SponsorFormAutoCompleteActions action = (SponsorFormAutoCompleteActions) formAction;
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


	// Url ................................................................

	public class UrlField extends WeezziFormField {
		
		// Constructor
		
		public UrlField(WeezziForm form) {
			super("url", form);
		}

		// Methods


        /**
         * Sets column row visible
         * @param boolean Visible
         */
        public void setRowVisible(boolean visible) throws ComponentNotFoundException {
            form.setFieldPropertyValue("url", "__RowIsVisible__", visible);
        }


        /**
         * Gets input value as a String
         * @return String String value
         */
        public String getValue() throws ParameterNotFoundException {
            return form.getParameter("url");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public Integer getValueAsInteger() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsInteger("url");
        }


        /**
         * Gets input value as an integer
         * @return Integer Integer value
         */
        public int getValueAsInteger(int defaultValue) {
            Integer value = null;
            try {
                value = form.getParameterAsInteger("url");
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
                value = form.getParameterAsLong("url");
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
            return form.getParameterAsLong("url");
        }


        /**
         * Gets input value as an float
         * @return Float Float value
         */
        public Float getValueAsFloat() throws ParameterNotFoundException, InvalidParameterDataException {
            return form.getParameterAsFloat("url");
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
                return new SimpleDateFormat("yyyy-MM-dd").parse(form.getParameter("url"));
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
            return form.getParameterAsLocation("url");
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(String value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("url", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(String value, String defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("url", "Value", value);
            } else {
                form.setFieldPropertyValue("url", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(int value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("url", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Integer value, int defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("url", "Value", value);
            } else {
                form.setFieldPropertyValue("url", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(long value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("url", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Long value, long defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("url", "Value", value);
            } else {
                form.setFieldPropertyValue("url", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(float value) throws ComponentNotFoundException {
            form.setFieldPropertyValue("url", "Value", value);
        }


        /**
         * Sets value
         * @param value Value
         * @param defaultValue Default value
         */
        public void setValue(Float value, float defaultValue) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("url", "Value", value);
            } else {
                form.setFieldPropertyValue("url", "Value", defaultValue);
            }
        }


        /**
         * Sets value
         * @param value Value
         */
        public void setValue(Timestamp value) throws ComponentNotFoundException {
            if (value != null) {
                form.setFieldPropertyValue("url", "Value", CalendarUtilities.getStandardDate(value));
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
                form.setFieldPropertyValue("url", "Value", CalendarUtilities.getStandardDate(value));
            } else {
                form.setFieldPropertyValue("url", "Value", CalendarUtilities.getStandardDate(defaultValue));
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

