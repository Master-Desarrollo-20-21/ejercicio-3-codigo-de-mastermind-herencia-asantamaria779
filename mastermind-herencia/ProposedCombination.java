package mastermind;

class ProposedCombination extends Combination {
	
	ProposedCombination(String combination) {
		super(combination);
	}
	
	public int numberCoincidencesInColourAndPosition(SecretCombination secretCombination) {
		int numberOfCoincidences=0;
		for (int i=0;i<COMBINATION_LENGHT;i++)
			if (this.combination.charAt(i) == secretCombination.combination.charAt(i)) {
				numberOfCoincidences++;
			}
		return numberOfCoincidences;
	}

	public int numberCoincidencesInColourOnly(SecretCombination secretCombination) {
		int numberOfCoincidences=0;
		for (int i=0;i<COMBINATION_LENGHT;i++) {
			for (int j=0;j < COMBINATION_LENGHT;j++)
				if ((this.combination.charAt(i)==secretCombination.combination.charAt(j)) && (i!=j)) {
					numberOfCoincidences++;
				}
		}
		return numberOfCoincidences;
	}

	public void show() {		
		new Console().out(this.combination);
	}
}
