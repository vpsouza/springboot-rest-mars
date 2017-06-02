package me.viniciuspiedade.restmars.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.viniciuspiedade.restmars.exceptions.InvalidCommandException;

@Service("robotService")
public class RobotServiceImpl implements RobotService {

	@Override
	public String moveRobot(String cmd) throws InvalidCommandException{
		if(StringUtils.isEmpty(cmd) || !cmd.matches("(L*R*M*)+")){
			throw new InvalidCommandException();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		try {
			new RobotServiceImpl().moveRobot("RLMLLMMMLLLRRM");
		} catch (InvalidCommandException e) {
			e.printStackTrace();
		}
	}

}
