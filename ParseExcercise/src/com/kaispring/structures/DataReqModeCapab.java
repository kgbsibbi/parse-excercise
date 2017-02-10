package com.kaispring.structures;

import com.kaispring.types.INT8;

public class DataReqModeCapab extends Node {
	int agentCount, managerCount;
	
	public int parse(int[] message, int startIndex){
		children.add(new DataReqMode());
		
		for(int i=0; i < children.size(); i++)
		{
			startIndex = children.get(i).parse(message, startIndex);
		}
		agentCount = INT8.getValue(message[startIndex], true);
		managerCount = INT8.getValue(message[startIndex], false);
		
		parsedString+="data-req-init-agent-count="+agentCount+" "
				+ "data-req-init-manager-count=" + managerCount;
		infoString = parsedString;
		
		startIndex++;
		return startIndex;
	}
}
