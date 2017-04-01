package kr.ac.knu.structures;

public class ScanReportInfoFixed extends Node {

	public ScanReportInfoFixed(){
		name="ScanReportInfoFixed";
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("event-info.length"));
		children.add(new DataReqId());
		children.add(new INT16("scan-report-no"));
		children.add(new INT16("obs-scan-fixed.count"));
		children.add(new INT16("obs-scan-fixed.length"));
		
		for(int i=0; i< children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		parsedValue = children.get(3).getParsedValue();
		
		int size = children.size();
		for(int i=0; i < parsedValue; i++){
			children.add(new ObservationScanFixed());
			startIndex = children.get(size+i).parse(message, startIndex);
		}		
		return startIndex;
	}
}
