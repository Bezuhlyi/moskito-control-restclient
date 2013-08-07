package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;
import org.moskito.control.requester.parser.ResponseParser;

/**
 * @author Vladyslav Bezuhlyi
 */
public class MoskitoControlRequesterTest {

	public static void main(String[] args) {
		RequesterConfiguration configuration = new RequesterConfiguration();
		ResponseParser parser = new ResponseParser();

		Requester requester = new Requester(configuration);
		String requestedContent = requester.requestContent("http://localhost:9090/rest/control");
		System.out.println(parser.parseResponse(requestedContent));
	}

}
