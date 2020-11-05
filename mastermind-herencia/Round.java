package mastermind;

class Round {

	final int MAX_ATTEMPS = 10;
	
	int numberOfAttemps;
	SecretCombination secretCombination;
	Result[] results;
	
	Round() {
		this.numberOfAttemps=0;
		this.secretCombination = new SecretCombination();
		this.results = new Result[10];
	}
	
	private void showStateOfRound() {
		new Console().out("\n"+numberOfAttemps+" attempt(s):\n");
		secretCombination.show();
		for(int i=0;i<this.numberOfAttemps;i++) {		
			results[i].show();
		}
	}
	
	public ProposedCombination proposeCombination() {
		
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
		return new ProposedCombination(combination);
	}
	
	private Result calculateResult(ProposedCombination proposedCombination) {
		int numberOfBlacks=proposedCombination.numberCoincidencesInColourAndPosition(secretCombination);
		int numberOfWhites=proposedCombination.numberCoincidencesInColourOnly(secretCombination);
		return new Result(proposedCombination,numberOfBlacks,numberOfWhites);
	}

	private boolean isWinner(Result result) {
		return result.numberOfBlacks==ProposedCombination.length();
	}
	
	public void play() {
		
		boolean isWinner=false;
		do {
			this.showStateOfRound();
			ProposedCombination proposedCombination=this.proposeCombination();
			Result result=this.calculateResult(proposedCombination);
			isWinner=this.isWinner(result);
			results[numberOfAttemps]=result;
			this.numberOfAttemps++;
		} while (!(this.numberOfAttemps==MAX_ATTEMPS || isWinner));
		this.showStateOfRound();
		if (isWinner) {
			new Console().out("You've won!!! ;-)\n");
		}
		else {
			new Console().out("You've lost!!! :-(\n");
		}
	}
}
