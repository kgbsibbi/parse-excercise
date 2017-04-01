package kr.ac.knu.structures;

public class TimeStamp extends Node{

	public TimeStamp(){
		name="TimeStamp";
	}
	
	public int parse(char[] message, int startIndex){
		char[] time = new char[18];
		System.arraycopy(message, startIndex, time, 0, 8);
		System.arraycopy(message, startIndex+8, time, 9, 8);
		time[8] = 'T'; time[17]='0';
		parsedValue=0;
		parsedString += String.valueOf(time);
		startIndex+=16;
		return startIndex;
	}
}
