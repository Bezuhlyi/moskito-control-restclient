package org.moskito.control.requester.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladyslav Bezuhlyi
 */
public class ContentParser {

	private Logger log = Logger.getLogger(this.getClass());

	public Map<String, String> parse(String content) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return (HashMap) gson.fromJson(content, HashMap.class);
	}

	//TODO: parse applications and nested components

}
