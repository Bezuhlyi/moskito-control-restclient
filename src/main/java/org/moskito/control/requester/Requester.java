package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;

/**
 * Requester for running MoSKito Control application.
 *
 * @author Vladyslav Bezuhlyi
 */
public class Requester {

	private RequesterConfiguration configuration;


	public Requester(RequesterConfiguration configuration) {
		this.configuration = configuration;
	}


	public RequesterConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(RequesterConfiguration configuration) {
		this.configuration = configuration;
	}
}
