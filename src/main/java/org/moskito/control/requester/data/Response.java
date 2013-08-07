package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class Response {

	private int protocolVersion;

	private int currentServerTimestamp;

	private List<Application> applications;


	public int getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public int getCurrentServerTimestamp() {
		return currentServerTimestamp;
	}

	public void setCurrentServerTimestamp(int currentServerTimestamp) {
		this.currentServerTimestamp = currentServerTimestamp;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
