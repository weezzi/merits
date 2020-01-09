package com.merits.modules.base.backoffice.forms;

import com.weezzi.core.data.GeoLocation;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.data.PublishInfo;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.merits.modules.base.backoffice.forms.definitions.CityFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.CitiesDAO;


/**
 * <b>Title: </b> City Form<br/>
 * <b>Description: </b> City Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class CityForm extends CityFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		CitiesDAO city;
		if (parameters.getId() != null) {
			city = BaseContainer.getCity(parameters.getId());
			name.setValue(city.getName());
			latitude.setValue(city.getGeoLocation().getLatitude());
			longitude.setValue(city.getGeoLocation().getLongitude());
		}
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		GeoLocation loc = new GeoLocation();
		loc.setLatitude(latitude.getValueAsFloat());
		loc.setLongitude(longitude.getValueAsFloat());
		if (parameters.getId() != null) {
			// UPDATE
			BaseContainer.updateCityByAll(
					parameters.getId(), 
					name.getValue(), 
					loc, 
					getUpdateInfo());
		} else {
			// CREATE
			BaseContainer.createCity(parameters.getCountryId(), name.getValue(), loc, getEditInfo(), new PublishInfo());
		}
		closeDialog();
		reloadTable("citiesTable");
	}


	// MULTI-LANGUAGE ---------------------------------------------------------

	
	/**
	 * 
	 */
	public void multiLanguageRequestHandler(String langCode, String previousLangCode, boolean savePrevious) throws Exception {
		// Local Variables
		
	}


	// ACTIONS ----------------------------------------------------------------



	// AUTO-COMPLETE ACTIONS --------------------------------------------------





}
