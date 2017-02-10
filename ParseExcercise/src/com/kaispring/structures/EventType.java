package com.kaispring.structures;

import java.util.HashMap;
import java.util.Map;

public class EventType extends Node {
	private Map<Integer, String> typeMap;
	private Map<Integer, Class> infoClassMap;
	public EventType(){
		typeMap = new HashMap<>();
		typeMap.put(3356, "MDC_NOTI_CONFIG");
		typeMap.put(3357, "MDC_NOTI_SCAN_REPORT_FIXED");
		typeMap.put(3358, "MDC_NOTI_SCAN_REPORT_VAR");
		typeMap.put(3359, "MDC_NOTI_SCAN_REPORT_MP_FIXED");
		typeMap.put(3360, "MDC_NOTI_SCAN_REPORT_MP_VAR");
		/*typeMap.put(3361, "MDC_NOTI_SEGMENT_DATA");
		typeMap.put(3362, "MDC_NOTI_UNBUF_SCAN_REPORT_VAR");
		typeMap.put(3363, "MDC_NOTI_UNBUF_SCAN_REPORT_FIXED");
		typeMap.put(3364, "MDC_NOTI_UNBUF_SCAN_REPORT_GROUPED");
		typeMap.put(3365, "MDC_NOTI_UNBUF_SCAN_REPORT_MP_VAR");
		typeMap.put(3366, "MDC_NOTI_UNBUF_SCAN_REPORT_MP_FIXED");
		typeMap.put(3367, "MDC_NOTI_UNBUF_SCAN_REPORT_MP_GROUPED");
		typeMap.put(3368, "MDC_NOTI_BUF_SCAN_REPORT_VAR");
		typeMap.put(3369, "MDC_NOTI_BUF_SCAN_REPORT_FIXED");
		typeMap.put(3370, "MDC_NOTI_BUF_SCAN_REPORT_GROUPED");
		typeMap.put(3371, "MDC_NOTI_BUF_SCAN_REPORT_MP_VAR");
		typeMap.put(3372, "MDC_NOTI_BUF_SCAN_REPORT_MP_FIXED");
		typeMap.put(3373, "MDC_NOTI_BUF_SCAN_REPORT_MP_GROUPE");*/
		
		infoClassMap = new HashMap<>();
		infoClassMap.put(3357, ScanReportInfoFixed.class);
		
	}
	public int parse(int[] message, int startIndex) { 
		parsedValue = message[startIndex++];
		parsedString = typeMap.get(parsedValue);
		if(parsedString == null)
			parsedString = "UNDEFINED";
		infoString = "event-type=" + parsedString;
		return startIndex;
	}
	
	public Node getEventInfoParameter(){
		try {
			return (Node) infoClassMap.get(parsedValue).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
