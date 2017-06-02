package me.viniciuspiedade.restmars.model;

import me.viniciuspiedade.restmars.exceptions.InvalidPositionException;

public class Map {

	private int x = 0;
	private int y = 0;
	private EnumDirection direction = EnumDirection.NORTH;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public EnumDirection getDirection() {
		return direction;
	}
	
	public void move() throws InvalidPositionException {
		if(x > 5 || y > 5){
			throw new InvalidPositionException();
		}
	}
	
	public void change(EnumDirection direction){
		this.direction = direction;
	}
	
}
