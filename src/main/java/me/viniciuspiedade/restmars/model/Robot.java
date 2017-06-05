package me.viniciuspiedade.restmars.model;

import me.viniciuspiedade.restmars.exceptions.InvalidPositionException;

public class Robot {

	private Map theMap = new Map();
	
	public Robot(){
		
	}
	
	public Robot move(String cmd){
		cmd.chars().forEach(charCmd -> executor((char)charCmd));
		return this;
	}
	
	public Map.Position getPositition(){
		return this.theMap.getPosition();
	}
	
	private void executor(char operation) throws InvalidPositionException{
		switch(operation){
			case 'L':
				theMap.change(theMap.getDirection().getLeft());
				break;
			case 'R':
				theMap.change(theMap.getDirection().getRight());
				break;
			default:
				theMap.move();
		}
	}
}
