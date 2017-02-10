package com.kaispring.structures;

public class PhdAssociationInformation extends Node{
	
	public int parse(int[] message, int startIndex) { 
		children.add(new ProtocolVersion());
		children.add(new EncodingRules());
		children.add(new NomenclatureVersion());
		children.add(new FunctionalUnits());
		children.add(new SystemType());
		children.add(new OCTETString());
		children.add(new ConfigId());
		children.add(new DataReqModeCapab());
		children.add(new AttributeList());
		
		for(int i=0; i < children.size(); i++)
		{
			startIndex = children.get(i).parse(message, startIndex);
		}
		return startIndex;
	}
}
