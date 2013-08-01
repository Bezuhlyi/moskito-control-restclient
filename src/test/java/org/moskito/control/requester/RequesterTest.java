package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;

/**
 * @author Vladyslav Bezuhlyi
 */
public class RequesterTest {

	public static void main(String[] args) {
		RequesterConfiguration configuration = new RequesterConfiguration();
		configuration.setUrlToRequest("http://localhost:9090/rest/control");

		Requester requester = new Requester(configuration);
	}

}
