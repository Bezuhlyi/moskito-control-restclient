package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class Component {

	private String name;

	private String categoty;

	private Color color;

	private long lastUpdateTimestamp;

	private String iso8601timestamp;

	private List<String> messages;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoty() {
		return categoty;
	}

	public void setCategoty(String categoty) {
		this.categoty = categoty;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public long getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(long lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getIso8601timestamp() {
		return iso8601timestamp;
	}

	public void setIso8601timestamp(String iso8601timestamp) {
		this.iso8601timestamp = iso8601timestamp;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Component{" +
				"name='" + name + '\'' +
				", categoty='" + categoty + '\'' +
				", lastUpdateTimestamp=" + lastUpdateTimestamp +
				", iso8601timestamp='" + iso8601timestamp + '\'' +
				", messages=" + messages +
				'}';
	}

}
