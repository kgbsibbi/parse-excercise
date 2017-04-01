package kr.ac.knu.structures;

import kr.ac.knu.config.Config;

public class ConfigId extends Node {
	
	public ConfigId(){
		name="ConfigId";
	}
	
	public int parse(char[] message, int startIndex) {
		children.add(new INT16("value"));
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		//Save Device Configuration id. for example 700 means Blood Pressure Monitor
		Config.configId = parsedValue;
		
		if (parsedValue == 0)
			parsedString+="manager-config-response";
		else if( parsedValue > 0 && parsedValue < 16384)
			parsedString+="standard-config";
		else if( parsedValue > 16383 && parsedValue < 32768)
			parsedString+="extended-config";
		else
			parsedString+="reserved";

		return startIndex;
	}
}
