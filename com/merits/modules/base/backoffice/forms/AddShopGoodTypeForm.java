package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.weezzi.core.data.List;
import com.weezzi.core.wzi.engine.exceptions.ComponentNotFoundException;
import com.weezzi.utils.extras.console.Console;
import com.merits.modules.base.backoffice.forms.definitions.AddShopGoodTypeFormDefinition;
import com.merits.modules.base.container.BaseContainer;


/**
 * <b>Title: </b> AddShopGoodType Form<br/>
 * <b>Description: </b> AddShopGoodType Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class AddShopGoodTypeForm extends AddShopGoodTypeFormDefinition {


	// FORM METHODS -----------------------------------------------------------

	
	/**
	 * Form render
	 */
	public void formRender() throws Exception {
		// Local Variables
		good.setValue(BaseContainer.getGoodTypesGoodTypesList());

	}


	/**
	 * Form submit
	 */
	public void formSubmit() throws Exception {
		// Local Variables
		if (BaseContainer.getShopGoodtypeFindByCheck(parameters.getId(), good.getLongValue()) != null) {
			showErrorDialog("Shop already has that good type");
			return;
		};
		BaseContainer.createShopGoodtype(parameters.getId(), good.getLongValue());
		closeDialog();
		reloadTable("table2");
		
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
