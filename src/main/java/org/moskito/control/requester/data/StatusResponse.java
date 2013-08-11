package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class StatusResponse extends Response {

	private List<Application> applications;


	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "StatusResponse{" +
				"applications=" + applications +
				'}';
	}
}
