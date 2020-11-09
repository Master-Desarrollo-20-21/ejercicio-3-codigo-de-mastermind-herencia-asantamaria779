package mastermind;
	
public enum Colour {
	RED ('r'),
	BLUE ('b'),       
	YELLOW ('y'),
	GREEN ('g'),
	ORANGE ('o'),
	PINK ('p');

	private char colour;
	
	Colour(char colour) {
		this.colour=colour;
	}
	
	public static boolean isValid(char colour) {
		
		for (Colour c : Colour.values()) {
			if (c.colour == colour) return true;
		}
		
		return false;
	}
	
	public static String validColours() {
		String validColours="";
		for (Colour c : Colour.values()) {
			validColours+=c.colour;
		}
		return validColours;
		
	}

}
	   				