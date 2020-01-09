package com.merits.modules.base.backoffice.forms;

//IMPORTS --------------------------------------------------------------------

import com.merits.modules.base.backoffice.forms.definitions.ProjectFormDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.ProjectsDAO;

/**
 * <b>Title: </b> Project Form<br/>
 * <b>Description: </b> Project Form<br/>
 *
 * @author Luis
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ProjectForm extends ProjectFormDefinition {

    // FORM METHODS -----------------------------------------------------------

    /**
     * Form render
     */
    public void formRender() throws Exception {
        // Local Variables
        ProjectsDAO daoProject;
        // Check if is a edit or a add
        if (parameters.getId() != null) {
            daoProject = BaseContainer.getProject(parameters.getId(), getLanguageCode());
            name.setValue(daoProject.getName());
            description.setValue(daoProject.getDescription());
            hasDonations.setSelected(daoProject.getHasDonations());
            donationsWanted.setValue(daoProject.getDonationsWanted());
            donationsActual.setValue(daoProject.getDonationsActual());
            hasVolunteers.setSelected(daoProject.getHasVolunteers());
            volunteersWanted.setValue(daoProject.getVolunteersWanted());
            volunteersActual.setValue(daoProject.getVolunteersActual());
            orderNumber.setValue(daoProject.getOrderNumber());
            publishInfo.setSelected(daoProject.getPublishInfo().isPublished());
            setCustomTitle("Edit");
        } else {
            setCustomTitle("Add");
        }
        donationsActual.setEnabled(false);
        volunteersActual.setEnabled(false);
    }

    /**
     * Form submit
     */
    public void formSubmit() throws Exception {
        // Local Variables
        ProjectsDAO daoProject;
        if (hasDonations.isSelected() && (donationsWanted == null ||  donationsWanted.getValueAsLong() == 0)) {
            showErrorDialog("If accepting donations, the value of wanted donations must be filled.");
        }
        if (hasVolunteers.isSelected() && (volunteersWanted == null ||  volunteersWanted.getValueAsLong() == 0)) {
            showErrorDialog("If accepting volunteers, the value of wanted volunteers must be filled.");
        }
        if (parameters.getId() != null) {
            daoProject = BaseContainer.getProject(parameters.getId(), getLanguageCode());
            BaseContainer.updateProject(parameters.getId(), name.getValue(), headline.getValue(), description.getValue(), hasDonations.isSelected(),
                    hasVolunteers.isSelected(), daoProject.getVolunteersActual(), volunteersWanted.getValueAsLong(), daoProject.getDonationsActual(),
                    donationsWanted.getValueAsLong(), imageselector1.getImage(),
                    imageselector1.getImages(), getPublishInfo().getPublishInfo(), null, getLanguageCode(), getUpdateInfo());
        } else {
            BaseContainer.createProject(getLanguageCode(), name.getValue(), headline.getValue(), description.getValue(), hasDonations.isSelected(),
                    hasVolunteers.isSelected(), 0, volunteersWanted.getValueAsLong(), 0, donationsWanted.getValueAsLong(), imageselector1.getImage(),
                    imageselector1.getImages(), getPublishInfo().getPublishInfo(), getEditInfo(), null);

        }
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
