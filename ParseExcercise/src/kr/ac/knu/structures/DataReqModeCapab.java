package kr.ac.knu.structures;

public class DataReqModeCapab extends Node {
	int agentCount, managerCount;
	
	public DataReqModeCapab(){
		name="DataReqModeCapab";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new DataReqMode());
		children.add(new INT8("data-req-init-agent-count"));
		children.add(new INT8("data-req-init-manager-count"));
		
		for(int i=0; i < children.size(); i++)
		{
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
