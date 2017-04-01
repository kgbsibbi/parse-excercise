package kr.ac.knu.message;

import kr.ac.knu.config.Config;
import kr.ac.knu.out.Terminal;
//import kr.ac.knu.out.XML;
import kr.ac.knu.structures.APDU;

public class MessageTest {

	public static void main(String[] args) {
		//Config.configId=700;
		Config.configId=800; //thermometer
		SampleMessage message = new SampleMessage();
		
		APDU thermometer = new APDU();
		thermometer.parse(message.getSampleThermometerPRST(), 0);
		Terminal terminal = new Terminal(thermometer);
		
		/*APDU apduaarq= new APDU();
		apduaarq.parse(message.getSampleMessageAARQ(),0);
		Terminal terminal = new Terminal(apduaarq);
		APDU apduprst = new APDU();
		apduprst.parse(message.getSampleMessagePRST(), 0);
		Terminal terminal2 = new Terminal(apduprst);*/
		//XML xml = new XML(apdu);
	}

}