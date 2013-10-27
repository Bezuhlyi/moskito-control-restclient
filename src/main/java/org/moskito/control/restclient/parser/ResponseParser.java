package org.moskito.control.restclient.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.moskito.control.restclient.data.response.ChartsResponse;
import org.moskito.control.restclient.data.response.HistoryResponse;
import org.moskito.control.restclient.data.response.StatusResponse;
import org.moskito.control.restclient.data.*;

import java.util.*;

/**
 * @author Vladyslav Bezuhlyi
 */
public class ResponseParser {

	private Logger log = Logger.getLogger(this.getClass());

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

/* Status parsing */

    /**
     * Parses status response.
     * @param jsonResponse JSON response.
     * @return {@link StatusResponse} or <code>null</code> if jsonResponse is null.
     */
	public StatusResponse parseStatusResponse(String jsonResponse) {
		Map responseMap = gson.fromJson(jsonResponse, HashMap.class);
		return parseStatusResponse(responseMap);
	}

	private StatusResponse parseStatusResponse(Map responseMap) {
        if(responseMap == null) {
            return null;
        }

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

/* History parsing */

    /**
     * Parses history response.
     * @param jsonResponse JSON response.
     * @return {@link HistoryResponse} or <code>null</code> if jsonResponse is null.
     */
	public HistoryResponse parseHistoryResponse(String jsonResponse) {
		Map responseMap = gson.fromJson(jsonResponse, HashMap.class);
		return parseHistoryResponse(responseMap);
	}

	private HistoryResponse parseHistoryResponse(Map responseMap) {
        if(responseMap == null) {
            return null;
        }

        HistoryResponse historyResponse = new HistoryResponse();

		historyResponse.setProtocolVersion(((Double) responseMap.get("protocolVersion")).intValue());
		historyResponse.setCurrentServerTimestamp(((Double) responseMap.get("currentServerTimestamp")).longValue());
		historyResponse.setHistoryItems(parseHistoryItems((List<Map>) responseMap.get("historyItems")));

		return historyResponse;
	}

	private List<HistoryItem> parseHistoryItems(List<Map> historyItems) {
		List<HistoryItem> result = new LinkedList<HistoryItem>();

		for (Map item : historyItems) {
			HistoryItem historyItem = new HistoryItem();
			historyItem.setTimestamp(((Double) item.get("timestamp")).longValue());
			historyItem.setIso8601timestamp((String) item.get("isoTimestamp"));
			historyItem.setOldStatus(Color.valueOf((String) item.get("oldStatus")));
			historyItem.setNewStatus(Color.valueOf((String) item.get("newStatus")));
			historyItem.setComponentName((String) item.get("componentName"));
			historyItem.setOldMessages((List<String>) item.get("oldMessages"));
			historyItem.setNewMessages((List<String>) item.get("newMessages"));
			result.add(historyItem);
		}

		return result;
	}

/* Charts parsing */

    /**
     * Parses charts response.
     * @param jsonResponse JSON response.
     * @return {@link ChartsResponse} or <code>null</code> if jsonResponse is null.
     */
    public ChartsResponse parseChartsResponse(String jsonResponse) {
        Map responseMap = gson.fromJson(jsonResponse, HashMap.class);
        return parseChartsResponse(responseMap);
    }

    private ChartsResponse parseChartsResponse(Map responseMap) {
        if(responseMap == null) {
            return null;
        }

        ChartsResponse chartsResponse = new ChartsResponse();

        chartsResponse.setProtocolVersion(((Double) responseMap.get("protocolVersion")).intValue());
        chartsResponse.setCurrentServerTimestamp(((Double) responseMap.get("currentServerTimestamp")).longValue());
        chartsResponse.setCharts(parseCharts((List<Map>) responseMap.get("charts")));

        return chartsResponse;
    }

    private List<Chart> parseCharts(List<Map> charts) {
        List<Chart> result = new LinkedList<Chart>();

        for (Map item : charts) {
            Chart chart = new Chart();
            chart.setName((String) item.get("name"));
            chart.setLines(parsePoints((List<Map>) item.get("points")));
            // when lines are ready setting their names
            chart.setLinesNames((List<String>) item.get("lineNames"));
            result.add(chart);
        }

        return result;
    }

    private List<Line> parsePoints(List<Map> points) {
        List<Line> result = new LinkedList<Line>();

        // every point in response turns into number of points how many values by line it has
        int linesAmount = ((List) points.get(0).get("values")).size();
        for (int lineIndex = 0; lineIndex < linesAmount; lineIndex++) {
            Line line = new Line();
            List<Point> linePoints = new LinkedList<Point>();
            for (Map item : points) {
                Point point = new Point();
                List<String> pointValues = (List<String>) item.get("values");
                point.setX((String) item.get("caption"));
                point.setY(pointValues.get(lineIndex));
                point.setTimestamp(((Double) item.get("timestamp")).longValue());
                linePoints.add(point);
            }
            line.setPoints(linePoints);
            result.add(line);
        }

        // lines names will be set separately
        return result;
    }

}
