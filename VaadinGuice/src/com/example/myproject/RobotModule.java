package com.example.myproject;

import org.vaadin.addons.guice.servlet.VGuiceApplicationServlet;

import com.google.inject.servlet.ServletModule;

public class RobotModule extends ServletModule {

	// @Override
	// protected void configure() {
	//
	// }

	@Override
	protected void configureServlets() {
		bind(RobotService.class).to(RobotServiceImpl.class);
		serve("/*").with(VGuiceApplicationServlet.class);

	}

}
