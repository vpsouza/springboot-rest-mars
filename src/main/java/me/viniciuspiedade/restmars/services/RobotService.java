package me.viniciuspiedade.restmars.services;

import me.viniciuspiedade.restmars.exceptions.InvalidCommandException;
import me.viniciuspiedade.restmars.model.Map;

public interface RobotService {

	Map.Position moveRobot(String cmd) throws InvalidCommandException;
}
