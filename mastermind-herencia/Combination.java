package mastermind;

abstract class Combination {
	
	protected static final int LENGHT = 4;	
	
	protected String colours;
	
	Combination(String colours){
		this.colours=colours;		
	}
		
	protected static boolean isValidLength(String combination) {

		return combination.length()==LENGHT;		
	}

	protected static boolean areValidColours(String combination) {
		
		for(int i=0;i<combination.length();i++) {
			if (!Colour.isValid(combination.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	protected static String validColours() {
		
		return Colour.validColours();
	}
	
	protected static int length() {
		return LENGHT;
	}

	protected abstract void show();
}
