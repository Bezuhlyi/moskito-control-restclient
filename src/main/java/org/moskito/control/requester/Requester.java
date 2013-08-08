package org.moskito.control.requester;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.apache.log4j.Logger;
import org.moskito.control.requester.config.HttpRequestMethod;
import org.moskito.control.requester.config.RequesterConfiguration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
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
		InputStreamReader inputStreamReader = null;
		String content = null;
		try {
			URL connectionUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)connectionUrl.openConnection();
			connection.setConnectTimeout(10000 /*miliseconds*/);
			connection.setReadTimeout(50000 /*miliseconds*/);
			connection.setRequestMethod(HttpRequestMethod.GET);
			connection.setDoInput(true);
			log.debug("Establishing connection to URL: " + url);
			connection.connect();
			int responseCode = connection.getResponseCode();
			log.debug("Connection established. Response code is: " + responseCode);
			log.info("Using " + Charsets.UTF_8 + "charset for content reading.");
			inputStreamReader = new InputStreamReader(connection.getInputStream(), Charsets.UTF_8);
			content = CharStreams.toString(inputStreamReader);
		} catch (MalformedURLException e) {
			log.warn(e.getMessage(), e);
		} catch (ConnectException e) {
			log.warn(e.getMessage(), e);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
		} finally {
			if(inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					log.info("Connection was tried to be closed but had not been opened.");
				}
			}
			log.info("Result of content request: " + content);
			return content;
		}
	}

}
