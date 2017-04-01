package kr.ac.knu.structures;

public class APDU extends Node {
	private Choice choice;
	public APDU(){
		name="APDU";
		choice = new Choice();
		choice.addOption(0xE200, AARQ.class);
		choice.addOption(0xE300, AARE.class);
		choice.addOption(0xE400, RLRQ.class);
		choice.addOption(0xE500, RLRE.class);
		choice.addOption(0xE600, ABRT.class);
		choice.addOption(0xE700, PRST.class);
	}
	
	public int parse(char[] message, int startIndex){
		children.add(new INT16("CHOICE.id"));
		children.add(new INT16("CHOICE.length"));
		
		startIndex = children.get(0).parse(message, startIndex);
		parsedValue = children.get(0).getParsedValue();
		Node node = choice.getSelected(parsedValue);
		if(node != null ){
			children.add(node);
		}
		
		for(int i=1; i < children.size(); i++)
			startIndex = children.get(i).parse(message, startIndex);

		return startIndex;
	}
	
	public void print(int level){
		super.print(level);
		System.out.println("\n---------------------------------------------------------");
	}
}
