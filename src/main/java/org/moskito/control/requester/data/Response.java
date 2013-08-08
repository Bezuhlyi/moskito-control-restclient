package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class Response {

	private int protocolVersion;

	private long currentServerTimestamp;

	private List<Application> applications;


	public int getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public long getCurrentServerTimestamp() {
		return currentServerTimestamp;
	}

	public void setCurrentServerTimestamp(long currentServerTimestamp) {
		this.currentServerTimestamp = currentServerTimestamp;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Response{" +
				"protocolVersion=" + protocolVersion +
				", currentServerTimestamp=" + currentServerTimestamp +
				", applications=" + applications +
				'}';
	}

}
