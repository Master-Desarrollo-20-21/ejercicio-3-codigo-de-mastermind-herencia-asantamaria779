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
		} while (combination.length()<COMBINATION_LENGHT);
		new Console().out("\nCOMBINACIÓN SECRETA: "+combination +"\n");
		return combination;
	}
				
	public void show() {
		String combinationEncoded="";
		for (int i=0;i<COMBINATION_LENGHT;i++) {
			combinationEncoded+='x';
		}
		new Console().out(combinationEncoded + "\n");
	}
}
