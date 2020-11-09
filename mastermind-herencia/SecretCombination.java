package mastermind;

import java.util.Random;

class SecretCombination extends Combination {
	
	SecretCombination() {
		super(makeRandom());
	}
	
	private static String makeRandom() {
		String combination="";
		do {
			char colour=Colour.validColours().toCharArray()[new Random().nextInt(Colour.values().length)];
			if (combination.indexOf(colour)==-1) {
				combination+=colour;
			}
		} while (combination.length()<LENGHT);
		//new Console().out("\nCOMBINACIÓN SECRETA: "+combination +"\n");
		return combination;
	}

	public int numberCoincidencesInColourAndPosition(ProposedCombination proposedCombination) {
		int numberOfCoincidences=0;
		for (int i=0;i<LENGHT;i++)
			if (this.colours.charAt(i) == proposedCombination.colours.charAt(i)) {
				numberOfCoincidences++;
			}
		return numberOfCoincidences;
	}

	public int numberCoincidencesInColourOnly(ProposedCombination proposedCombination) {
		int numberOfCoincidences=0;
		for (int i=0;i<LENGHT;i++) {
			for (int j=0;j < LENGHT;j++)
				if ((this.colours.charAt(i)==proposedCombination.colours.charAt(j)) && (i!=j)) {
					numberOfCoincidences++;
				}
		}
		return numberOfCoincidences;
	}

	public void show() {
		String combinationEncoded="";
		for (int i=0;i<LENGHT;i++) {
			combinationEncoded+='x';
		}
		new Console().out(combinationEncoded + "\n");
	}
}
