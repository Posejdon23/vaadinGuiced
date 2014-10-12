package com.example.myproject;
import com.google.inject.Inject;

public class RobotController {

	private RobotService robot;

	@Inject
	public RobotController(RobotService robot) {
		this.robot = robot;
	}

	public String moveForward(int distance) {
		return robot.moveForward(distance);
	}

	public String moveBack(int distance) {
		return robot.moveBack(distance);
	}

	public void turnLeft() {
		robot.turnLeft();
	}

	public void turnRight() {
		robot.turnRight();
	}

}
