package kr.ac.knu.message;

public class SampleMessage {
	private char[] sampleMessageAARQ;
	private char[] sampleMessagePRST;
	private char[] createdMessage;
	private char[] thermometer;
	private char[] weighingScale;
	private String createdString;
	int createdIndex;
	
	public SampleMessage(){
		String msg = "E2000032800000000001002A5079002680000000A000";
		msg+="8000000040000000008000000008414243444546474802BC0001010000000000";
		sampleMessageAARQ = new char[msg.length()];
		msg.getChars(0, msg.length(), sampleMessageAARQ, 0);
		//System.out.println(charMsg);
		
		String msgprst = "E700003E003C0054010100360000004900500D1D002c";
		msgprst+="F0000000000200240001001200030006007800500064";
		msgprst+="20071206121000000002000AF2582007120612100000";
		sampleMessagePRST = new char[msgprst.length()];
		msgprst.getChars(0, msgprst.length(), sampleMessagePRST, 0);
		
		String thermo = "E700002A00280008010100220000FFFFFFFF0D1D0018"; //0-10
		thermo += "F0000000000100100001000CFF0001722008050608300000";
		thermometer = new char[thermo.length()];
		thermo.getChars(0, thermo.length(), thermometer, 0);
		
		String wei = "E700005A00581236010100520000000000000D1D0048";
		wei += "F0000000000400400001000CFF0002FA2007120612100000";
		wei += "0003000CFF0000F320071206121000000001000CFF0002F82007120620050000";
		wei += "0003000CFF0000F22007120620050000";
		weighingScale = new char[wei.length()];
		wei.getChars(0, wei.length(), weighingScale, 0);
		
		createdString = new String();
		createdIndex=0;
	}
	
	public char[] getSampleWeighingScalePRST(){
		return weighingScale;
	}
	
	public char[] getSampleThermometerPRST(){
		return thermometer;
	}
	
	public char[] getSampleMessageAARQ(){
		return sampleMessageAARQ;
	}
	
	public char[] getSampleMessagePRST(){
		return sampleMessagePRST;
	}
	
	public String getCreatedMessage() {
		return createdString;
	}
	
	public int appendMessage(char[] chars){
		if(chars != null && chars.length > 0){
			createdString += String.valueOf(chars);
			createdIndex += chars.length;
		}
		return createdIndex;
	}
	
	public char[] buildMessage(){
		createdMessage  = new char[createdIndex];
		createdMessage = createdString.toCharArray();
		return createdMessage;
	}
	
	public void clearMessage(){
		createdMessage = null;
		createdIndex = 0;
		createdString = "";
	}
	
}
