package com.merits.modules.base.backoffice.tables;

//IMPORTS -------------------------------------------------------------------------

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collection;

import com.merits.modules.base.backoffice.tables.definitions.ProjectsTableDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.BulkProjectsDAO;
import com.merits.modules.base.dao.ProjectsDAO;
import com.weezzi.core.context.TableContext;
import com.weezzi.core.data.SystemColor;
import com.weezzi.core.data.Tree;
import com.weezzi.core.tables.TableStatus;
import com.weezzi.utils.extras.console.Console;

/**
 * <b>Title: </b> Projects<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ProjectsTable extends ProjectsTableDefinition {

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
	 *
	 * @param context
	 */
	public void doAddAction(TableContext context, String categoryId) {
		// Local Variables
	}

	/**
	 * Remove Action
	 *
	 * @param context
	 * @param ids     Remove row ids
	 */
	public void doRemoveAction(TableContext context, Collection<Long> ids) {
		// Local Variables

	}

	/**
	 * Copy Action
	 *
	 * @param context
	 * @param ids     Copy row ids
	 */
	public void doCopyAction(TableContext context, Collection<Long> ids) {
		// Local Variables

	}

	/**
	 * Move Action
	 *
	 * @param context
	 * @param sourceId      Source Id
	 * @param destinationId Destination Id
	 */
	public void doMoveAction(TableContext context, Long sourceId, Long destinationId, String direction) {
		// Local Variables
		try {
			BaseContainer.moveProject(sourceId, destinationId, direction);
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error error moving project", e);
		}

	}

	/**
	 * Publish Action
	 *
	 * @param context
	 * @param id        Source Id
	 * @param published Published
	 */
	public boolean doPublishAction(TableContext context, Long id, boolean published) {
		// Local Variables
		try {
			BaseContainer.publishProject(id, published, getBackofficeUserId());
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error error publishing project", e);
		}
		return false;
	}

	// RENDERS ----------------------------------------------------------------

	/**
	 * Gets data action
	 */
	public void doGetDataAction(TableContext context, int startIndex, int endIndex, String search, String categoryId) {
		// Local Variables
		String icons;
		BulkProjectsDAO projects;
		BigDecimal bdVolunteers;
		BigDecimal bdDonations;
		BigDecimal percentBar;
		MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
		// Get projects
		projects = BaseContainer.getProjectsBlockFindByAll(getSiteDefaultLanguage(), startIndex, endIndex);
		for (ProjectsDAO project : projects.data) {
			bdVolunteers = null;
			bdDonations = null;
			percentBar = BigDecimal.ZERO;
			icons = "";
			if (true || project.getHasVolunteers()) {
				icons += renderIcon("SysIconVolunteers", SystemColor.LightGray);
			}
			if (true || project.getHasDonations()) {
				icons += renderIcon("SysIconSales", SystemColor.LightGray);
			}
			if (project.getHasVolunteers()) {
				bdVolunteers = new BigDecimal(100 * (project.getVolunteersActual() / project.getVolunteersWanted()));
				percentBar = bdVolunteers;
			}
			if (project.getHasDonations()) {
				bdDonations = new BigDecimal(100 * (project.getDonationsActual() / project.getDonationsWanted()));
				percentBar = bdDonations;
				if (project.getHasVolunteers() && bdVolunteers != null) {
					percentBar.add(bdVolunteers).divide(new BigDecimal(2));
				}
			}
			addRow(project.getId(), project.getPublishInfo(), TableStatus.LightGray, project.getPhoto(), project.getName(), project.getDescription(),
					icons,
					renderPercentageBar(percentBar.floatValue(), SystemColor.Orange),
					project.getEditInfo());
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

