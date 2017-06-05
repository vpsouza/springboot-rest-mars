package me.viniciuspiedade.restmars.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.viniciuspiedade.restmars.exceptions.InvalidCommandException;
import me.viniciuspiedade.restmars.model.Map;
import me.viniciuspiedade.restmars.model.Robot;

@Service("robotService")
public class RobotServiceImpl implements RobotService {

	@Override
	public Map.Position moveRobot(String cmd) throws InvalidCommandException{
		if(StringUtils.isEmpty(cmd) || !cmd.matches("(L*R*M*)+")){
			throw new InvalidCommandException("Invalid command received.");
		}
		
		return new Robot().move(cmd).getPositition();
	}
	
}
