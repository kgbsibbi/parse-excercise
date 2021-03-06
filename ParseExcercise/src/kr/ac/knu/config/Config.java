package kr.ac.knu.config;

import kr.ac.knu.structures.bloodpressure.*;
import kr.ac.knu.structures.thermometer.AttrValueMapHandle;

public class Config {
	public static int configId;
	
	public static Class getClass(int handle){
		if(configId == 700){ // blood pressure
			if(handle == 1)
				return AttrValueMapHandle1.class;
			else if (handle == 2)
				return AttrValueMapHandle2.class;
			else
				return Object.class;
		}
		else if(configId == 800){ // thermometer
			return AttrValueMapHandle.class;
		}
		else if(configId == 1500) { // weighing scale
			if(handle == 1)
				return kr.ac.knu.structures.weighingscale.AttrValueMapHandler1.class;
			else if (handle == 3)
				return kr.ac.knu.structures.weighingscale.AttrValueMapHandler3.class;
			else return Object.class;
		}
			return Object.class;
	}

}
