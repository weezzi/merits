package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.merits.modules.base.backoffice.forms.definitions.CompanyFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.CompaniesDAO;
import com.weezzi.core.data.PublishInfo;

/**
 * <b>Title: </b> Company Form<br/>
 * <b>Description: </b> Company Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class CompanyForm extends CompanyFormDefinition {

    // FORM METHODS -----------------------------------------------------------

    /**
     * Form render
     */
    public void formRender() throws Exception {
        // Local Variables
        CompaniesDAO daoCompany;
        // Check if is a edit or a add
        if (parameters.getId() != null) {
            daoCompany = BaseContainer.getCompany(parameters.getId(), getLanguageCode());
            name.setValue(daoCompany.getName());
            url.setValue(daoCompany.getUrl());
            photo.setImage(daoCompany.getPhoto());
            publishInfo.setSelected(daoCompany.getPublishInfo().isPublished());
            description.setValue(daoCompany.getDescription());
            setCustomTitle("Edit");
        } else {
            setCustomTitle("Add");
        }
    }

    /**
     * Form submit
     */
    public void formSubmit() throws Exception {
        // Local Variables
        CompaniesDAO daoCompany;
        // Get parameters
        if (parameters.getId() != null) {
            // UPDATE
            // Get sponsor
            daoCompany = BaseContainer.getCompany(parameters.getId(), getLanguageCode());
            // Update data
            BaseContainer.updateCompanyByAll(
                    parameters.getId(),
                    name.getValue(),
                    description.getValue(),
                    photo.getImageAndReleaseUnused(daoCompany.getPhoto()),
                    url.getValue(), getLanguageCode(),
                    getUpdateInfo());
        } else {
            // CREATE
            BaseContainer.createCompany(getLanguageCode(),name.getValue(),description.getValue(), photo.getImage(), url.getValue(), getEditInfo(), new PublishInfo());
        }
        // Close dialog and update table
        closeDialog();
        reloadTable();
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
