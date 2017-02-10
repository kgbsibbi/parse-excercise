package com.kaispring.structures;

import com.kaispring.types.Choice;

public class APDU extends Node {
	private Choice choice;
	
	public APDU(){
		super();
		choice = new Choice();
		choice.addOption(0xE200, AARQApdu.class);
		choice.addOption(0xE300, AAREApdu.class);
		choice.addOption(0xE400, RLRQApdu.class);
		choice.addOption(0xE500, RLREApdu.class);
		choice.addOption(0xE600, ABRTApdu.class);
		choice.addOption(0xE700, PRSTApdu.class);
	}
	
	public int parse(int[] message, int startIndex) { 
		parsedValue = message[startIndex++];
		length = message[startIndex++];
		Node node = choice.getSelected(parsedValue);
		parsedString=String.valueOf(node.getName());
		
		infoString+= "CHOICE(" + parsedString+")";
		if(node != null ){
			children.add(node);
			for(int i=0; i < children.size(); i++)
				startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
	
	public void print(int level){
		super.print(level);
		System.out.println("----------------------------------------");
	}
	
	public Choice getChoices(){
		return choice;
	}
}
