package org.moskito.control.restclient.data;

/**
 * @author Vladyslav Bezuhlyi
 */
public class Response {

	private int protocolVersion;

	private long currentServerTimestamp;


	public int getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public long getCurrentServerTimestamp() {
		return currentServerTimestamp;
	}

	public void setCurrentServerTimestamp(long currentServerTimestamp) {
		this.currentServerTimestamp = currentServerTimestamp;
	}

	@Override
	public String toString() {
		return "Response{" +
				"protocolVersion=" + protocolVersion +
				", currentServerTimestamp=" + currentServerTimestamp +
				'}';
	}
}
