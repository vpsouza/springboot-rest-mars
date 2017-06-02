package me.viniciuspiedade.restmars.model;

public class Robot {

	private Map theMap = new Map();
	
	public Robot(){
		
	}
	
	public void move(String cmd){
		cmd.chars().forEach(cmd -> cmd.);
	}
	
	private void executor(char operation){
		switch(operation){
			case 'L':
				theMap.change(theMap.getDirection().getLeft());
			case 'R':
				theMap.change(theMap.getDirection().getRight());
		}
	}
}
