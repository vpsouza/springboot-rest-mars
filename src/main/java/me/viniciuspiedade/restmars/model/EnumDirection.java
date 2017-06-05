package me.viniciuspiedade.restmars.model;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum EnumDirection {

	NORTH("N", "W", "E", Operations.add),
	SOUTH("S", "E", "W", Operations.subtract),
	EAST("E", "N", "S", Operations.add),
	WEST("W", "S", "N", Operations.subtract);
	
	private String id;
	private String leftid;
	private String rightid;
	private UnaryOperator<Integer> movement;
	
	private EnumDirection(String id, String leftid, String rightid, UnaryOperator<Integer> movement){
		this.id = id;
		this.leftid = leftid;
		this.rightid = rightid;
		this.movement = movement;
	}
	
	public EnumDirection getLeft(){
		return this.getById(leftid);
	}
	
	public EnumDirection getRight(){
		return this.getById(rightid);
	}
	
	public String getId(){
		return this.id;
	}
	
	private EnumDirection getById(String strDir) {
		return Arrays.asList(EnumDirection.values()).stream().filter(ienum -> ienum.getId().equals(strDir)).findFirst().orElse(null);
	}
	
	public UnaryOperator<Integer> getMovement(){
		return this.movement;
	}
	
}

class Operations{
	static UnaryOperator<Integer> add = (axis) -> ++axis;
	
	static UnaryOperator<Integer> subtract = (axis) -> --axis;
}