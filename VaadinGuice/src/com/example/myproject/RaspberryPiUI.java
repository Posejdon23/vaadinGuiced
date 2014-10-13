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
public class RaspberryPiUI extends ScopedUI {

	private Button moveBack;
	private Button moveForward;
	private Button turnLeft;
	private Button turnRight;

	@Override
	protected void init(VaadinRequest request) {

	}

	@Inject
	public RaspberryPiUI(final RobotController robot) {
		moveForward = new Button("Move forward");
		moveBack = new Button("Move back");
		turnLeft = new Button("Turn left");
		turnRight = new Button("Turn right");
		final VerticalLayout layout = new VerticalLayout(moveForward, moveBack,
				turnLeft, turnRight);
		setContent(layout);
		addListeners(robot, layout);
	}

	private void addListeners(final RobotController robot,
			final VerticalLayout layout) {
		moveForward.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorForward();

			}
		});
		moveBack.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorReverse();
			}
		});
		turnLeft.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorLeft();

			}
		});
		turnRight.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorRight();
			}
		});
	}
}