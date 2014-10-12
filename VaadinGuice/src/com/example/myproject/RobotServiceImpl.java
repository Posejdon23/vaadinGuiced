package com.example.myproject;

import com.google.inject.Singleton;

@Singleton
public class RobotServiceImpl implements RobotService {

	@Override
	public String moveForward(int distance) {
		System.out.println("Moved forward by " + distance);
		return "forward " + distance;
	}

	@Override
	public String moveBack(int distance) {
		System.out.println("Moved back by " + distance);
		return "back " + distance;
	}

	@Override
	public void turnLeft() {
		System.out.println("Turned left");
	}

	@Override
	public void turnRight() {
		System.out.println("Turned right");
	}

}
