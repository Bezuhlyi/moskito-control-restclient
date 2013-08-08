package org.moskito.control.requester.data;

import java.util.List;

/**
 * @author Vladyslav Bezuhlyi
 */
public class Application {

	private String name;

	private ApplicationColor applicationColor;

	private List<Component> components;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationColor getApplicationColor() {
		return applicationColor;
	}

	public void setApplicationColor(ApplicationColor applicationColor) {
		this.applicationColor = applicationColor;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Application{" +
				"name='" + name + '\'' +
				", applicationColor=" + applicationColor +
				", components=" + components +
				'}';
	}

}
