package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;
import org.moskito.control.requester.parser.ContentParser;

/**
 * @author Vladyslav Bezuhlyi
 */
public class MoskitoControlRequesterTest {

	public static void main(String[] args) {
		RequesterConfiguration configuration = new RequesterConfiguration();
		ContentParser parser = new ContentParser();

		Requester requester = new Requester(configuration);
		String requestedContent = requester.requestContent("http://localhost:9090/rest/control");
		System.out.println(parser.parse(requestedContent));
	}

}
