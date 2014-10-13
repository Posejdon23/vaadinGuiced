package com.example.myproject;

import com.google.inject.Inject;

public class RobotController {

	private RobotService robot;
	private RobotState robotState;

	public RobotState getRobotState() {
		return robotState;
	}

	@Inject
	public RobotController(RobotService robot) {
		this.robot = robot;
		robotState = RobotState.NotLoaded;
	}

	public void motorForward() {
		robot.motorForward();
	}

	public void motorReverse() {
		robot.motorReverse();
	}

	public void motorLeft() {
		robot.motorLeft();
	}

	public void motorRight() {
		robot.motorRight();
	}

	public void motorStop() {
		robot.motorStop();
	}

	public void loadRobot() {
		robot.loadRobot();
		robotState = RobotState.Loaded;
	}

	public void camUp() {
		robot.camUp();
	}

	public void camDown() {
		robot.camDown();
	}

	public void camLeft() {
		robot.camLeft();
	}

	public void camRight() {
		robot.camRight();
	}
}
