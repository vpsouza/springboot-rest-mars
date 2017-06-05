package me.viniciuspiedade.restmars.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.viniciuspiedade.restmars.exceptions.InvalidCommandException;
import me.viniciuspiedade.restmars.model.Map;
import me.viniciuspiedade.restmars.services.RobotService;

@RestController
public class RobotController {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotController.class);
	
	@Autowired
	private RobotService robotService;

	@RequestMapping(path = "/rest/mars/{cmd}", method = RequestMethod.GET)
	public ResponseEntity<String> getAllSumarized(@PathVariable("cmd") String cmd ) throws InvalidCommandException {
		logger.info("getting position of robot for coordinates " + cmd + " ...");

		Map.Position position = robotService.moveRobot(cmd);
		
		return new ResponseEntity<String>("(" + position.getX() + "," + position.getY() + "," + position.getOrientation() + ")", HttpStatus.OK);
	}
}
