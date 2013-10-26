package org.moskito.control.restclient.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class HistoryItem {

	private String componentName;

	private long timestamp;

	private String iso8601timestamp;

	private Color oldStatus;

	private Color newStatus;

	private List<String> oldMessages;

	private List<String> newMessages;


	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getIso8601timestamp() {
		return iso8601timestamp;
	}

	public void setIso8601timestamp(String iso8601timestamp) {
		this.iso8601timestamp = iso8601timestamp;
	}

	public Color getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(Color oldStatus) {
		this.oldStatus = oldStatus;
	}

	public Color getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(Color newStatus) {
		this.newStatus = newStatus;
	}

	public List<String> getOldMessages() {
		return oldMessages;
	}

	public void setOldMessages(List<String> oldMessages) {
		this.oldMessages = oldMessages;
	}

	public List<String> getNewMessages() {
		return newMessages;
	}

	public void setNewMessages(List<String> newMessages) {
		this.newMessages = newMessages;
	}

	@Override
	public String toString() {
		return "HistoryItem{" +
				"componentName='" + componentName + '\'' +
				", timestamp=" + timestamp +
				", iso8601timestamp='" + iso8601timestamp + '\'' +
				", oldStatus=" + oldStatus +
				", newStatus=" + newStatus +
				", oldMessages=" + oldMessages +
				", newMessages=" + newMessages +
				'}';
	}

}
