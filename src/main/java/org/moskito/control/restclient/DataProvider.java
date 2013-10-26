package org.moskito.control.restclient;

import org.moskito.control.restclient.data.response.ChartsResponse;
import org.moskito.control.restclient.data.response.HistoryResponse;
import org.moskito.control.restclient.data.response.StatusResponse;
import org.moskito.control.restclient.http.Requester;
import org.moskito.control.restclient.parser.ResponseParser;

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

	public HistoryResponse getHistoryResponse(String url, String applicationName) {
		String fullUrl = url + "/" + applicationName;
		return parser.parseHistoryResponse(requester.requestContent(fullUrl));
	}

    public ChartsResponse getChartsResponse(String url, String applicationName) {
		String fullUrl = url + "/" + applicationName;
        return parser.parseChartsResponse(requester.requestContent(fullUrl));

    }

}
