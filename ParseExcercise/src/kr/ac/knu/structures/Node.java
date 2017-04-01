package kr.ac.knu.structures;

import java.util.ArrayList;

public class Node {
	protected String name;
	protected int length;
	protected int parsedValue;
	protected long longParsedValue;
	protected String parsedString=null;
	protected ArrayList<Node> children;
	
	public Node(){
		name = "Node";
		length = 0;
		parsedValue=0;
		longParsedValue= 0;
		children = new ArrayList<>();
		parsedString = new String();
	}
	
	public int getParsedValue(){
		return parsedValue;
	}
	
	public long getUnsignedParsedValue(){
		return longParsedValue;
	}
	
	public String getParsedString(){
		return parsedString;
	}
	
	public int parse(char[] message, int startIndex) {
		return startIndex;
	}
	
	protected void printMyInfo(int level){
		System.out.print("\n");
		for(int i=0; i < level; i++)
			System.out.print("--");
		System.out.print("+" + name + ":" + parsedString);
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
