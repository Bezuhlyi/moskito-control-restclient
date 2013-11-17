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

    /**
     * Is HTTP basic auth enabled.
     */
    private boolean basicAuthEnabled;

    private String login;

    private String password;


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

    public boolean isBasicAuthEnabled() {
        return basicAuthEnabled;
    }

    public void setBasicAuthEnabled(boolean basicAuthEnabled) {
        this.basicAuthEnabled = basicAuthEnabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
