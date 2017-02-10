package com.kaispring.structures;

public class ScanReportInfoFixed extends Node {

	public int parse(int[] message, int startIndex) { 
		length = message[startIndex++];
		
		children.add(new DataReqId());
		children.add(new INT16("scan-report-no"));
		children.add(new ObservationScanFixed());
		
		for(int i=0; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);
		return startIndex;
	}
}
