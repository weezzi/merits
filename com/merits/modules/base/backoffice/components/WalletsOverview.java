package com.merits.modules.base.backoffice.components;

import java.util.HashMap;
import com.merits.core.MeritsUtils;

//IMPORTS -------------------------------------------------------------------------

import com.merits.modules.base.backoffice.components.definitions.WalletsOverviewDefinition;
import com.merits.modules.base.container.BaseContainer;
import com.merits.modules.base.dao.BulkWalletRecordsTotalsSPQ;
import com.merits.modules.base.dao.WalletRecordsMasterWalletSPQ;
import com.merits.modules.base.dao.WalletRecordsTotalsSPQ;
import com.merits.modules.base.dao.WalletsDAO.MasterWalletParameters;
import com.merits.modules.base.uobjects.enums.WalletType;
import com.weezzi.utils.extras.console.Console;
import com.weezzi.webserver.simel.AttributeMapper;
import com.weezzi.webserver.simel.Expression;


/**
 * <b>Title: </b> WalletsOverview<br/>
 * <b>Description: </b> <br/>
 *
 * @author Auto-generated by Weezzi Site Builder
 * @version 1.0
 */
public class WalletsOverview extends WalletsOverviewDefinition {


	// CONSTANTS ---------------------------------------------------------------

	
	// INITIALIZATION ----------------------------------------------------------
	
	
	public void customComponentInitialization() {
		addStyle("Styles");
	};


	// BROWSER OUTPUT ----------------------------------------------------------


	/**
	 * Generate Start Output
	 * @return String
	 */
	public String getStartOutput() {
		// Local Variables
		float value;
		float pct;
		float totalValue = 0;
		Expression expr;
		AttributeMapper map;
		BulkWalletRecordsTotalsSPQ totals;
		WalletRecordsMasterWalletSPQ master = null;
		HashMap<WalletType, Float> values = new HashMap<WalletType, Float>();
		// Get Expression
		expr = getHTMLExpression("Default");
		map = expr.getAttributeMapper();
		// Fill defaults
		for(WalletType type : WalletType.values()) {
			values.put(type, 0f);
		}
		// Get totals
		try {
			totals = BaseContainer.getWalletRecordsFindByTotalsSPQ();
			for(WalletRecordsTotalsSPQ total : totals.data) {
				values.put(total.getWalletType(), total.getTotalValue());
				totalValue += total.getTotalValue();
			}
			master = BaseContainer.getWalletRecordsFindByMasterWalletSPQ(MeritsUtils.getMasterWallet());
		} catch (Exception e) {
			// Catch Exception
			Console.error("Error getting wallets totals", e);
		}
		// Add attributes
		map.addAttribute("WALLET_ALL", MeritsUtils.formatNumber((int) totalValue) + String.format("%.2f",totalValue - ((int) totalValue)).substring(1));
		for(WalletType type : WalletType.values()) {
			value = values.get(type);
			if (totalValue > 0) {
				pct = value / totalValue;
			} else {
				pct = 0;
			}
			map.addAttribute("WALLET_" + type.getValue(), MeritsUtils.formatNumber((int) value) + String.format("%.2f",value - ((int) value)).substring(1));
			if (pct > 0) {
				map.addAttribute("BAR_SIZE_" + type.getValue(), (int) ((pct)*800));
			} else {
				map.addAttribute("BAR_SIZE_" + type.getValue(), 0);
			}
			map.addAttribute("BAR_PCT_" + type.getValue(), (int) (pct*100));
			
		}
		map.addAttribute("MASTER_BURN", "0");
		map.addAttribute("MASTER_CREATES", "0");
		map.addAttribute("MASTER_REDEEMS", "0");
		if (master.getBurns() != null) {
			map.addAttribute("MASTER_BURN", MeritsUtils.formatNumber(master.getBurns()) + String.format("%.2f",master.getBurns() - master.getBurns().intValue()).substring(1));
		}
		if (master.getCreates() != null) {
			map.addAttribute("MASTER_CREATES", MeritsUtils.formatNumber(master.getCreates())+ String.format("%.2f",master.getCreates() - master.getCreates().intValue()).substring(1));
		}
		if (master.getRedeems() != null) {
			map.addAttribute("MASTER_REDEEMS", MeritsUtils.formatNumber(master.getRedeems())+ String.format("%.2f",master.getRedeems() - master.getRedeems().intValue()).substring(1));
		}
// Render
		return expr.render(map);
	}

	
	// PRIVATE ----------------------------------------------------------------


}

