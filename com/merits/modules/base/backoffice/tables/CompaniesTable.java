package com.merits.modules.base.backoffice.tables;

//IMPORTS -------------------------------------------------------------------------

import java.util.Collection;

import com.merits.modules.base.backoffice.tables.definitions.CompaniesTableDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.BulkCompaniesDAO;
import com.merits.modules.base.dao.CompaniesDAO;
import com.weezzi.core.context.TableContext;
import com.weezzi.core.data.PublishInfo;
import com.weezzi.core.data.Tree;
import com.weezzi.utils.extras.console.Console;


/**
 * <b>Title: </b> Companies<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public class CompaniesTable extends CompaniesTableDefinition {



	// TABLE SPECIFIC ---------------------------------------------------------


	/**
	 * Initializes the table
	 */
	public void initializeTable() {
		// Local Variables
		
	}

	/**
	 * Wraps up table finalization
	 */
	public void finalizeTable() {
		// Local Variables
		
	}
	
	
	// ACTIONS ----------------------------------------------------------------
	
	
	/**
	 * Add Action
	 * @param context
	 */
	public void doAddAction(TableContext context, String categoryId) {
		// Local Variables
		showFormDialog("Company", null);
	}


	/**
	 * Remove Action
	 * @param context
	 * @param ids Remove row ids 
	 */
	public void doRemoveAction(TableContext context, Collection<Long> ids) {
		// Local Variables
		
	}


	/**
	 * Copy Action
	 * @param context
	 * @param ids Copy row ids 
	 */
	public void doCopyAction(TableContext context, Collection<Long> ids) {
		// Local Variables
		
	}


	/**
	 * Move Action
	 * @param context
	 * @param sourceId Source Id
	 * @param destinationId Destination Id
	 */
	public void doMoveAction(TableContext context, Long sourceId, Long destinationId, String direction) {
		// Local Variables
		try {
			BaseContainer.moveCompany(sourceId, destinationId, direction);
		} catch (Exception e) {
			// Cacth error
			Console.error("Error moving company", e);
		}
	}

	
	/**
	 * Publish Action
	 * @param context
	 * @param id Source Id
	 * @param published Published
	 */
	public boolean doPublishAction(TableContext context, Long id, boolean published) {
		// Local Variables
		try {
			if (published) {
				// PUBLISH
				BaseContainer.updateCompanyByPublish(id, new PublishInfo(getBackofficeUserId()), getUpdateInfo());
			} else {
				// UNPUBLISH
				BaseContainer.updateCompanyByPublish(id, new PublishInfo(), getUpdateInfo());
			}
		} catch (Exception e) {
			Console.error("Error publishing/unpublishing company", e);
		}
		return false;
	}

	
	// RENDERS ----------------------------------------------------------------
	
	
	/**
	 * Gets data action
	 */
	public void doGetDataAction(TableContext context, int startIndex, int endIndex, String search, String categoryId) {
		// Local Variables
		BulkCompaniesDAO daoCompanies = BaseContainer.getCompaniesBlockFindByAll(getSiteDefaultLanguage(),search, startIndex, endIndex);
		// Write companies
		for(CompaniesDAO daoCompany : daoCompanies.data) {
			addRow(daoCompany.getId(), daoCompany.getPublishInfo(), daoCompany.getPhoto(), daoCompany.getName(), daoCompany.getDescription(), daoCompany.getEditInfo());
		}
	}

	
	/**
	 * Renders a tree
	 */
	public Tree doGetTreeAction(TableContext context) {
		// Local Variables
		return null;
	}

}

