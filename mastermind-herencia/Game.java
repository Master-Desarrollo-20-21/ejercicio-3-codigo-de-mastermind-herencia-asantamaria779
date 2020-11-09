package mastermind;

class Game {

	final int MAX_ATTEMPS = 10;
	
	int numberOfAttemps;
	SecretCombination secretCombination;
	Result[] results;
	
	Game() {
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
	
	private Result calculateResult(ProposedCombination proposedCombination) {
		int numberOfBlacks=secretCombination.numberCoincidencesInColourAndPosition(proposedCombination);
		int numberOfWhites=secretCombination.numberCoincidencesInColourOnly(proposedCombination);
		return new Result(proposedCombination,numberOfBlacks,numberOfWhites);
	}

	private boolean isWinner(Result result) {
		return result.numberOfBlacks==ProposedCombination.length();
	}
	
	public void play() {
		
		boolean isWinner=false;
		do {
			this.showStateOfRound();
			ProposedCombination proposedCombination=new ProposedCombination();
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
