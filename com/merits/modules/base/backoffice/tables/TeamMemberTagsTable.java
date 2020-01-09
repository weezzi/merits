package com.merits.modules.base.backoffice.tables;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.backoffice.tables.definitions.TeamMemberTagsTableDefinition;

import java.util.Vector;

import com.weezzi.core.context.TableContext;
import com.weezzi.core.data.Tree;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;
import com.weezzi.core.tables.TableColumnOrdering;
import java.util.Collection;


/**
 * <b>Title: </b> TeamMemberTags<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Builder
 * @version 1.0
 */
@SuppressWarnings("unused")
public class TeamMemberTagsTable extends TeamMemberTagsTableDefinition {



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
	public void doMoveAction(TableContext context, String sourceId, String destinationId, String direction) {
		// Local Variables
		
	}

	
	/**
	 * Publish Action
	 * @param context
	 * @param id Source Id
	 * @param published Published
	 */
	public boolean doPublishAction(TableContext context, String id, boolean published) {
		// Local Variables
		return false;
	}

	
	// RENDERS ----------------------------------------------------------------
	
	
	/**
	 * Gets data action
	 */
	public void doGetDataAction(TableContext context, int startIndex, int endIndex, String search, String categoryId) {
		// Local Variables
	}

	
	/**
	 * Renders a tree
	 */
	public Tree doGetTreeAction(TableContext context) {
		// Local Variables
		return null;
	}

}
