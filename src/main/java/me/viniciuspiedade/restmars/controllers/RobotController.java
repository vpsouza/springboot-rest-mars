package me.viniciuspiedade.restmars.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
	
	private static final Logger logger = LoggerFactory.getLogger(RobotController.class);

	@RequestMapping(path = "/rest/mars/{cmd}", method = RequestMethod.GET)
	public ResponseEntity<String> getAllSumarized(@PathVariable("cmd") String cmd ) {
		logger.info("returning all summarized products...");

		return null;
	}
}
