package org.moskito.control.requester;

import org.moskito.control.requester.config.RequesterConfiguration;
import org.moskito.control.requester.data.Application;
import org.moskito.control.requester.data.Component;
import org.moskito.control.requester.data.DataProvider;
import org.moskito.control.requester.data.HistoryItem;
import org.moskito.control.requester.data.HistoryResponse;
import org.moskito.control.requester.data.StatusResponse;
import org.moskito.control.requester.parser.ResponseParser;

/**
 * @author Vladyslav Bezuhlyi
 */
public class MoskitoControlRequesterTest {

	public static void main(String[] args) {
		/* Configuration. */
		RequesterConfiguration configuration = new RequesterConfiguration();
		Requester requester = new Requester(configuration);
		ResponseParser parser = new ResponseParser();
		DataProvider dataProvider = new DataProvider(requester, parser);

		/* Using status response. Just for demo. */
//		StatusResponse statusResponse = dataProvider.getStatusResponse("http://localhost:9090/rest/control");
		StatusResponse statusResponse = dataProvider.getStatusResponse("http://server04.test.anotheria.net:8999/moskito-control/rest/control");

		System.out.println(statusResponse.getProtocolVersion());
		System.out.println(statusResponse.getCurrentServerTimestamp());
		for(Application application : statusResponse.getApplications()) {
			System.out.println(application.getName());
			System.out.println(application.getApplicationColor().toString());
			for(Component component : application.getComponents()) {
				System.out.println(component.getName());
				System.out.println(component.getCategoty());
				System.out.println(component.getColor());
				for(String message : component.getMessages()) {
					System.out.println(message);
				}
				System.out.println(component.getLastUpdateTimestamp());
				System.out.println(component.getIso8601timestamp());
			}
		}


		/* Using history response. Just for demo. */
		HistoryResponse historyResponse = dataProvider.getHistoryResponse("http://server04.test.anotheria.net:8999/moskito-control/rest/history", "FirstApp");

		System.out.println(historyResponse.getProtocolVersion());
		System.out.println(historyResponse.getCurrentServerTimestamp());
		for(HistoryItem historyItem : historyResponse.getHistoryItems()) {
			System.out.println(historyItem.getTimestamp());
			System.out.println(historyItem.getIso8601timestamp());
			System.out.println(historyItem.getOldStatus());
			System.out.println(historyItem.getNewStatus());
			System.out.println(historyItem.getComponentName());
			for (String message : historyItem.getOldMessages()) {
				System.out.println(message);
			}
			for (String message : historyItem.getNewMessages()) {
				System.out.println(message);
			}
		}

		/* Readable views of responses. toString() of every nested element is being used. Just for test. */
		System.out.println("\nFull view of status response: ");
		System.out.println(statusResponse);
		System.out.println("\nFull view of history response: ");
		System.out.println(historyResponse);
	}

}
