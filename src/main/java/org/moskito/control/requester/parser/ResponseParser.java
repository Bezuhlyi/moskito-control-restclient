package org.moskito.control.requester.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.moskito.control.requester.data.Application;
import org.moskito.control.requester.data.ApplicationColor;
import org.moskito.control.requester.data.Component;
import org.moskito.control.requester.data.Response;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav Bezuhlyi
 */
public class ResponseParser {

	private Logger log = Logger.getLogger(this.getClass());


	public Response parseResponse(String jsonResponse) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map responseMap = (HashMap) gson.fromJson(jsonResponse, HashMap.class);
		return parseResponse(responseMap);
	}

	private Response parseResponse(Map responseMap) {
		Response response = new Response();

		int protocolVersion = ((Double) responseMap.get("protocolVersion")).intValue();
		long timestamp = ((Double) responseMap.get("currentServerTimestamp")).longValue();
		List<Application> applications = parseApplications((List<Map>) responseMap.get("applications"));

		response.setProtocolVersion(protocolVersion);
		response.setCurrentServerTimestamp(timestamp);
		response.setApplications(applications);
        return response;
	}

	private List<Application> parseApplications(List<Map> applications) {
		List<Application> result = new LinkedList<Application>();


		for (Map item : applications) {
			Application application = new Application();

			String name = (String) item.get("name");
			ApplicationColor color = ApplicationColor.valueOf((String) item.get("applicationColor"));
			List<Component> components = parseComponents((List<Map>) item.get("components"));

			application.setName(name);
			application.setApplicationColor(color);
			application.setComponents(components);
			result.add(application);
		}

		return result;
	}

	private List<Component> parseComponents(List components) {
		List<Component> result = new LinkedList<Component>();

		return result;
	}

}
