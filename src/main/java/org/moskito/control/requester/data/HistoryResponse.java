package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class HistoryResponse extends Response {

	List<HistoryItem> historyItems;


	public List<HistoryItem> getHistoryItems() {
		return historyItems;
	}

	public void setHistoryItems(List<HistoryItem> historyItems) {
		this.historyItems = historyItems;
	}

	@Override
	public String toString() {
		return "HistoryResponse{" +
				"historyItems=" + historyItems +
				'}';
	}

}
