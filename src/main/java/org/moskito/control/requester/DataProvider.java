package org.moskito.control.requester;

/**
 * Instance that can be asked to provide data from specified running MoSKito Control application.
 *
 * @author Vladyslav Bezuhlyi
 */
public class DataProvider {

	private static DataProvider instance = new DataProvider();

	public static DataProvider getInstance() {
		return instance;
	}

	private DataProvider() {
	}
}
