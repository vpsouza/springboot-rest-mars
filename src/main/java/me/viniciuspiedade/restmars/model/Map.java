package me.viniciuspiedade.restmars.model;

import me.viniciuspiedade.restmars.exceptions.InvalidPositionException;

public class Map {

	private boolean isXAxis = false;
	private int x = 0;
	private int y = 0;
	private EnumDirection direction = EnumDirection.NORTH;
	
	public class Position {
		private int x;
		private int y;
		private String orientation;
		
		public Position(int x, int y, String orientation){
			this.x = x;
			this.y = y;
			this.orientation = orientation;
		}
		
		public int getX(){
			return this.x;
		}
		
		public int getY(){
			return this.y;
		}
		
		public String getOrientation(){
			return this.orientation;
		}
		
	}
	
	public EnumDirection getDirection() {
		return direction;
	}
	
	public void move() throws InvalidPositionException {
		int movement;
		
		if(isXAxis){
			movement = this.x = direction.getMovement().apply(this.x);
		} else {
			movement = this.y = direction.getMovement().apply(this.y);
		}
		
		if ( movement > 4 || movement < 0)
			throw new InvalidPositionException("Invalid position!");
	}
	
	public void change(EnumDirection direction){
		this.isXAxis = !isXAxis;
		this.direction = direction;
	}
	
	public Position getPosition(){
		return new Position(this.x, this.y, this.direction.getId());
	}

}
