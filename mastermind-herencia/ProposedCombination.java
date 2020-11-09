package mastermind;

class ProposedCombination extends Combination {
	
	ProposedCombination() {
		super(proposeCombination());
	}
	
	private static String proposeCombination() {
		
		String combination;
		boolean validCombination;
		Console console = new Console();		
		do {
			validCombination = true;
			combination = console.readString("Propose a combination: ");			
			if (!ProposedCombination.isValidLength(combination)) {
				validCombination = false;
				console.out("Wrong proposed combination length\n");
			}
			if (!ProposedCombination.areValidColours(combination)) {
				validCombination = false;
				console.out("Wrong colors, they must be: " + ProposedCombination.validColours() + "\n");
			}			
		} while (!validCombination);
		return combination;
	}
	
	public void show() {		
		new Console().out(this.colours);
	}
}
