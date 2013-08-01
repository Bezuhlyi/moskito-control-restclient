package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;

/**
 * @author Vladyslav Bezuhlyi
 */
public class RequesterTest {

	public static void main(String[] args) {
		RequesterConfiguration configuration = new RequesterConfiguration();

		Requester requester = new Requester(configuration);
		requester.requestContent("http://localhost:9090/rest/control");
	}

}
