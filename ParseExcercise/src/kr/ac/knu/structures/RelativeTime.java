package kr.ac.knu.structures;

public class RelativeTime extends Node{
	public RelativeTime(){
		name="RelativeTime";
	}
	
	public int parse(char[] message, int startIndex){
		return startIndex+8;
	}
}
