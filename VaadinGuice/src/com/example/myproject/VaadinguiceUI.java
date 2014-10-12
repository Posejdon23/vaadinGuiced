package com.example.myproject;

import org.vaadin.addons.guice.ui.ScopedUI;

import com.google.inject.Inject;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadinguice")
public class VaadinguiceUI extends ScopedUI {

	private int i = 0;

	@Inject
	public VaadinguiceUI(final RobotController robot) {
		Button button = new Button("Move forward injected robot");
		final VerticalLayout layout = new VerticalLayout(button);
		setContent(layout);

		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label(robot.moveForward(i++)));

			}
		});
	}

	@Override
	protected void init(VaadinRequest request) {

	}
}