package com.kaispring.message;

import com.kaispring.out.Terminal;
import com.kaispring.out.XML;
import com.kaispring.structures.APDU;

public class Message {
	
	public static void main(String[] args){
		int[] message1 = new int[27];// Blood Pressure Monitor
		int[] message2 = new int[23]; // Thermometer
		
		message1[0] = 0xE200;
		message1[1] = 0x0032;
		message1[2] = 0x8000; message1[3] = 0x000;
		message1[4] = 0x0001; message1[5] = 0x002A;
		message1[6] = 0x5079; 
		message1[7] = 0x0026;
		message1[8] = 0x8000; message1[9] = 0x0000;
		message1[10] = 0xA000;
		message1[11] = 0x8000;message1[12] = 0x0;   
		message1[13] = 0x4000;message1[14] = 0x0;
		message1[15] = 0x0080;message1[16] = 0x0;   
		message1[17] = 0x0008;
		message1[18] = 0x4142;message1[19] = 0x4344;
		message1[20] = 0x4566;message1[21] = 0x4748;
		message1[22] = 0x02BC;
		message1[23] = 0x0001;
		message1[24] = 0x0100;
		message1[25] = 0x0;message1[26] = 0x0;
		
		// Thermometer Data Reporting
		message2[0] = 0xE700; 
		message2[1] = 0x002A;
		message2[2] = 0x0028; 
		message2[3] = 0x0008;
		message2[4] = 0x0101;
		message2[5] = 0x0022;
		message2[6] = 0x0000; 
		message2[7] = 0xFFFF;message2[8] = 0xFFFF;
		message2[9] = 0x0D1D;
		message2[10] = 0x0018;
		message2[11] = 0xF000;
		message2[12] = 0x0000;
		message2[13] = 0x0001;
		message2[14] = 0x0010;
		message2[15] = 0x0001;
		message2[16] = 0x000C;
		message2[17] = 0xFB38;message2[18] = 0x7520;
		message2[19] = 0x2008;message2[20] = 0x0506;
		message2[21] = 0x0830;message2[22] = 0x0000;
		
		
		APDU apdu= new APDU();
		apdu.parse(message2, 0);
		
		XML xml = new XML(apdu);
		Terminal terminal = new Terminal(apdu);
	}
}
