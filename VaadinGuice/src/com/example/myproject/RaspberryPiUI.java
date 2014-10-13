package com.example.myproject;

import org.vaadin.addons.guice.ui.ScopedUI;

import com.google.inject.Inject;
import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
		Label emptyLeft = new Label("<hr/>", ContentMode.HTML);
		Label emptyRight = new Label("<hr/>", ContentMode.HTML);
		moveForward = new Button("Move forward");
		moveBack = new Button("Move back");
		turnLeft = new Button("Turn left");
		turnRight = new Button("Turn right");
		final HorizontalLayout hTop = new HorizontalLayout(emptyLeft,
				moveForward, emptyRight);
		final HorizontalLayout hBot = new HorizontalLayout(turnLeft, moveBack,
				turnRight);
		final VerticalLayout layout = new VerticalLayout(hTop, hBot);
		hTop.setExpandRatio(emptyLeft, 1.0f);
		hTop.setExpandRatio(moveForward, 1.0f);
		hTop.setExpandRatio(emptyRight, 1.0f);
		emptyLeft.setHeight("100px");
		emptyRight.setHeight("100px");
		addListeners(robot, layout);
		setContent(layout);
	}

	private void addListeners(final RobotController robot,
			final VerticalLayout layout) {
		moveForward.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorForward();
				Notification.show("motorForward", Type.TRAY_NOTIFICATION);
			}
		});
		moveBack.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorReverse();
				Notification.show("motorReverse", Type.TRAY_NOTIFICATION);
			}
		});
		turnLeft.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorLeft();
				Notification.show("motorLeft", Type.TRAY_NOTIFICATION);
			}
		});
		turnRight.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				robot.motorRight();
				Notification.show("motorRight", Type.TRAY_NOTIFICATION);
			}
		});
		moveForward.setHeight("100px");
		moveBack.setHeight("100px");
		turnLeft.setHeight("100px");
		turnRight.setHeight("100px");
		moveForward.setClickShortcut(KeyCode.W);
		moveBack.setClickShortcut(KeyCode.S);
		turnLeft.setClickShortcut(KeyCode.A);
		turnRight.setClickShortcut(KeyCode.D);
	}
}