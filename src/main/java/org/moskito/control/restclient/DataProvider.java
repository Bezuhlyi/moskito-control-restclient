package org.moskito.control.restclient;

import org.moskito.control.restclient.data.response.ChartsResponse;
import org.moskito.control.restclient.data.response.HistoryResponse;
import org.moskito.control.restclient.data.response.StatusResponse;
import org.moskito.control.restclient.http.Requester;
import org.moskito.control.restclient.parser.ResponseParser;

/**
 * Singleton. Instance that can be asked to provide data from specified MoSKito Control application.
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

    /**
     * Provides current status data of applications monitored by MoSKito Control.
     *
     * @param url MoSKito Control URL to request status.
     * @return {@link StatusResponse} or <code>null</code> in case of data retrieving error.
     */
	public StatusResponse getStatusResponse(String url) {
		return parser.parseStatusResponse(requester.requestContent(url));
	}

    /**
     * Provides current history data of application monitored by MoSKito Control.
     *
     * @param url MoSKito Control URL to request history.
     * @param applicationName application name (as per config, letters' case matters).
     * @return {@link HistoryResponse} or <code>null</code> in case of data retrieving error.
     */
	public HistoryResponse getHistoryResponse(String url, String applicationName) {
		String fullUrl = url + "/" + applicationName;
		return parser.parseHistoryResponse(requester.requestContent(fullUrl));
	}

    /**
     * Provides current charts data of specific application monitored by MoSKito Control.
     *
     * @param url MoSKito Control URL to request charts by points (!).
     * @param applicationName application name (as per config, letters' case matters).
     * @return {@link ChartsResponse} or <code>null</code> in case of data retrieving error.
     */
    public ChartsResponse getChartsResponse(String url, String applicationName) {
		String fullUrl = url + "/" + applicationName;
        return parser.parseChartsResponse(requester.requestContent(fullUrl));
    }

}
