package kr.ac.knu.structures;

import java.util.HashMap;
import java.util.Iterator;

public class Choice {

	private HashMap<Integer, Class> options;
	
	public Choice() {
		options = new HashMap<>();
	}
	
	public void addOption(int key, Class choiceClass){
		if(false == options.containsKey(key))
			options.put(key, choiceClass);
	}
	
	public void print(){
		Iterator<Class> it = options.values().iterator();
		while(it.hasNext())
			System.out.println(it.next().getName());
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