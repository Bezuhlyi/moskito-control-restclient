package org.moskito.control.requester.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.moskito.control.requester.data.Application;
import org.moskito.control.requester.data.Color;
import org.moskito.control.requester.data.Component;
import org.moskito.control.requester.data.StatusResponse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav Bezuhlyi
 */
public class ResponseParser {

	private Logger log = Logger.getLogger(this.getClass());


	public StatusResponse parseStatusResponse(String jsonResponse) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map responseMap = (HashMap) gson.fromJson(jsonResponse, HashMap.class);
		return parseStatusResponse(responseMap);
	}

	private StatusResponse parseStatusResponse(Map responseMap) {
		StatusResponse statusResponse = new StatusResponse();

		statusResponse.setProtocolVersion(((Double) responseMap.get("protocolVersion")).intValue());
		statusResponse.setCurrentServerTimestamp(((Double) responseMap.get("currentServerTimestamp")).longValue());
		statusResponse.setApplications(parseApplications((List<Map>) responseMap.get("applications")));

		return statusResponse;
	}

	private List<Application> parseApplications(List<Map> applications) {
		List<Application> result = new LinkedList<Application>();

		for (Map item : applications) {
			Application application = new Application();
			application.setName((String) item.get("name"));
			application.setApplicationColor(Color.valueOf((String) item.get("applicationColor")));
			application.setComponents(parseComponents((List<Map>) item.get("components")));
			result.add(application);
		}

		return result;
	}

	private List<Component> parseComponents(List<Map> components) {
		List<Component> result = new LinkedList<Component>();

		for (Map item : components) {
			Component component = new Component();
			component.setName((String) item.get("name"));
			component.setCategoty((String) item.get("category"));
			component.setColor(Color.valueOf((String) item.get("color")));
			component.setMessages((List<String>) item.get("messages"));
			component.setLastUpdateTimestamp(((Double) item.get("lastUpdateTimestamp")).longValue());
			component.setIso8601timestamp((String) item.get("ISO8601Timestamp"));
			result.add(component);
		}

		return result;
	}

}
