package com.kaispring.structures;

import java.util.ArrayList;

public class Node {
	protected String name;
	protected int length;
	protected int parsedValue;
	protected String parsedString=null;
	protected String infoString=null;
	protected ArrayList<Node> children;
	
	public Node(){
		this.name = getClass().getSimpleName();
		this.length = 0;
		children = new ArrayList<Node>();
		parsedString = new String();
		infoString = new String();
	}
	
	public int getParsedValue(){
		return parsedValue;
	}
	
	public String getParsedString(){
		return parsedString;
	}
	
	public String getInfoString(){
		return infoString;
	}

	public int parse(int[] message, int startIndex) { 
		return 0;
	}
	
	protected void printMyInfo(int level){
		// Name and Length
		for(int i=0; i < level; i++)
			System.out.print("--");
		System.out.print("+" + name);
		if(length>0) System.out.print(".length=" + length);
		System.out.print("\n");;
		
		// Value and info
		if(parsedString.length()>0){
			for(int i=0; i < level; i++)
				System.out.print("  ");
			System.out.println(":"+infoString);
		}
	}
	
	public void print(int level){
		printMyInfo(level);
		if(children != null){
			for(Node child : children)
			{
				child.print(level+1);
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
}
