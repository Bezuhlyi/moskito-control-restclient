package org.moskito.control.restclient.config;

/**
 * Configuration for MoSKito Control requester.
 *
 * @author Vladyslav Bezuhlyi
 */
public class RequesterConfiguration {

	/* milliseconds */
	private int connectTimeout = 10000;

	/* milliseconds */
	private int readTimeout = 50000;


	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
}
