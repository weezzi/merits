package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.system.modules.sites.container.SitesContainer;
import com.weezzi.system.modules.sites.dao.SiteTranslationKeysDAO;
import com.weezzi.system.modules.sites.uobjects.enums.TranslationKeyType;
import com.merits.modules.base.backoffice.forms.definitions.GoodTypeFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.GoodTypesDAO;


/**
 * <b>Title: </b> GoodType Form<br/>
 * <b>Description: </b> GoodType Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class GoodTypeForm extends GoodTypeFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		Long id = parameters.getId();
		GoodTypesDAO dao;
		if (id != null) {
			dao = BaseContainer.getGoodType(id, getSiteDefaultLanguage());
			name.setValue(dao.getName());
			setMultilangActiveTranslations(dao.getMultiLangKeyTranslations());
		}
	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		Long id = parameters.getId();
		if (id == null) {
			// IS CREATE
			BaseContainer.createGoodType(getSiteDefaultLanguage(), name.getValue(), getUpdateInfo());
		} else {
			// IS EDIT
			BaseContainer.updateGoodTypeByName(id, name.getValue(), getLanguageCode(), getUpdateInfo());
		}
		closeDialog();
		reloadTable("table");
	}


	// MULTI-LANGUAGE ---------------------------------------------------------

	
	/**
	 * 
	 */
	public void multiLanguageRequestHandler(String langCode, String previousLangCode, boolean savePrevious) throws Exception {
		// Local Variables
		GoodTypesDAO dao;
		Long id = parameters.getId();
		if (id == null) {
			return;
		}
		// Save
		if (savePrevious) {
			BaseContainer.updateGoodTypeByName(id, name.getValue(), previousLangCode, getUpdateInfo());
		}
		dao = BaseContainer.getGoodType(id, langCode);
		name.setValue(dao.getName());
		// Updates language selector
		updateLanguageSelector(langCode, dao.getMultiLangKeyTranslations());
		
	}


	// ACTIONS ----------------------------------------------------------------



	// AUTO-COMPLETE ACTIONS --------------------------------------------------





}
