package me.viniciuspiedade.restmars.model;

import java.util.Arrays;

public enum EnumDirection {

	NORTH("N", "W", "E"),
	SOUTH("S", "E", "W"),
	EAST("E", "N", "S"),
	WEST("W", "S", "N");
	
	private String id;
	private String leftid;
	private String rightid;
	
	private EnumDirection(String id, String leftid, String rightid){
		this.id = id;
		this.leftid = leftid;
		this.rightid = rightid;
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
}
