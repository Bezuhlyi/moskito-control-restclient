package org.moskito.control.requester.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.moskito.control.requester.data.Application;
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
		Map<String, String> responseMap = (HashMap) gson.fromJson(jsonResponse, HashMap.class);
		return parseResponse(responseMap);
	}

	private Response parseResponse(Map<String, String> responseMap) {
		Response response = new Response();


		return response;
	}

	private List<Application> parseApplications(Map<String, String> applicationsMap) {
		List<Application> applications = new LinkedList<Application>();

		return applications;
	}

	private List<Component> parseComponents(Map<String, String> componentsMap) {
		List<Component> components = new LinkedList<Component>();

		return components;
	}

}
