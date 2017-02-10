package com.kaispring.types;

import java.util.HashMap;

import com.kaispring.structures.Node;

public class Choice {

	private HashMap<Integer, Class> options;
	
	public Choice() {
		options = new HashMap<>();
	}
	
	public void addOption(int key, Class choiceClass){
		if(false == options.containsKey(key))
			options.put(key, choiceClass);
	}
	
	public Node getSelected(int key){
		Node node=null;
		try {
			node = (Node) options.get(key).newInstance();
		} catch (InstantiationException e) { e.printStackTrace();
		} catch (IllegalAccessException e) { e.printStackTrace();
		}
		return node;
	}
}