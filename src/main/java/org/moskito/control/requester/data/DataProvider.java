package org.moskito.control.requester.data;

import org.moskito.control.requester.Requester;
import org.moskito.control.requester.parser.ResponseParser;

/**
 * Singleton. Instance that can be asked to provide data from specified running MoSKito Control application.
 *
 * @author Vladyslav Bezuhlyi
 */
public class DataProvider {

	private Requester requester;

	private ResponseParser parser;


	public DataProvider(Requester requester, ResponseParser parser) {
		this.requester = requester;
		this.parser = parser;
	}


	public void setRequester(Requester requester) {
		this.requester = requester;
	}

	public void setParser(ResponseParser parser) {
		this.parser = parser;
	}

	public StatusResponse getStatusResponse(String url) {
		return parser.parseStatusResponse(requester.requestContent(url));
	}

}
