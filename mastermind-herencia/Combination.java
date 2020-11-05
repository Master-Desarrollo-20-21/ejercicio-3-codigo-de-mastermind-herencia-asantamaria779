package mastermind;

abstract class Combination {
	
	protected static final int COMBINATION_LENGHT = 4;	
	
	protected String combination;
	
	Combination(String combination){
		this.combination=combination;		
	}
		
	protected static boolean isValidLength(String combination) {

		return combination.length()==COMBINATION_LENGHT;		
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
		return COMBINATION_LENGHT;
	}

	protected abstract void show();
}
