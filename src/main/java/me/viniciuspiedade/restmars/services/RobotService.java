package me.viniciuspiedade.restmars.services;

import me.viniciuspiedade.restmars.exceptions.InvalidCommandException;

public interface RobotService {

	String moveRobot(String cmd) throws InvalidCommandException;
}
