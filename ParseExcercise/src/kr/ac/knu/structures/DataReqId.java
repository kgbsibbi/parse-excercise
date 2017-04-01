package kr.ac.knu.structures;

public class DataReqId extends Node {
	
	public DataReqId(){
		name="DataReqId";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INTU16());
		startIndex = children.get(0).parse(message, startIndex);
		longParsedValue = children.get(0).getUnsignedParsedValue();
		
		if(longParsedValue == 0){
			parsedString +="data-req-id-manager-initiated-min";
		} else if (longParsedValue == 0xEFFF){
			parsedString +="data-req-id-manager-initiated-max";
		} else if (longParsedValue == 0xF000) {
			parsedString +="data-req-id-agent-initiated-confirmed";
		} else if (longParsedValue == 0xF001){
			parsedString +="data-req-id-agent-initiated-unconfirmed";
		}
		return startIndex;
	}
}
