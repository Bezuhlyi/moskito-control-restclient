package org.moskito.control.restclient.http;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import com.google.common.io.CharStreams;
import org.apache.log4j.Logger;
import org.moskito.control.restclient.config.HttpRequestMethod;
import org.moskito.control.restclient.config.RequesterConfiguration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * HTTP-requester for MoSKito Control REST interface.
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
		HttpURLConnection connection = null;
        url = url.replaceAll("\\+", "%20"); // to handle spaces in URL properly
		try {
			URL connectionUrl = new URL(url);
			connection = (HttpURLConnection)connectionUrl.openConnection();
			connection.setConnectTimeout(configuration.getConnectTimeout());
			connection.setReadTimeout(configuration.getReadTimeout());
			connection.setRequestMethod(HttpRequestMethod.GET);
			connection.setDoInput(true);
            if (configuration.isBasicAuthEnabled()) {
                String authorization = configuration.getLogin() + ":" + configuration.getPassword();
                String encoded = BaseEncoding.base64().encode(authorization.getBytes());
                connection.setRequestProperty("Authorization", "Basic " + encoded);
            }
			log.debug("Establishing connection to URL: " + url);
			connection.connect();
			int responseCode = connection.getResponseCode();
			log.debug("Connection established. Response code is: " + responseCode);
			log.info("Using " + Charsets.UTF_8 + " charset for content reading.");
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
            if (connection != null) {
                connection.disconnect();
            }
            log.info("Result of content request: " + content);
		}
	    return content;
	}

}
