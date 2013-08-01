package org.moskito.control.requester;

import org.apache.log4j.Logger;
import org.moskito.control.requester.config.RequesterConfiguration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Requester for running MoSKito Control application.
 *
 * @author Vladyslav Bezuhlyi
 */
public class Requester {

	private Logger log = Logger.getLogger(Requester.class);

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

	public String requestContent(String url) {
		try {
			URL connectionUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)connectionUrl.openConnection();
			connection.setConnectTimeout(10000 /*miliseconds*/);
			connection.setReadTimeout(50000 /*miliseconds*/);
			connection.setRequestMethod(HttpRequestMethod.GET);
			connection.setDoInput(true);
			log.debug("Establishing connection. URL: " + url);
			connection.connect();
			int responseCode = connection.getResponseCode();
			log.debug("Connection established. Response code is: " + responseCode);

			// TODO: reading work here

		} catch (MalformedURLException e) {
			log.warn(e.getMessage(), e);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
		} finally {
			// TODO: close streams
		}

		return null; // TODO: return real content
	}

}
