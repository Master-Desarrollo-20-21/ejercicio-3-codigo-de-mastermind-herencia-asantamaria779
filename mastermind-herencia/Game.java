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
	
	private void showStateOfGame() {
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
	
	public void play() {
		
		boolean isWinner=false;
		do {
			this.showStateOfGame();
			ProposedCombination proposedCombination=new ProposedCombination();
			Result result=this.calculateResult(proposedCombination);
			isWinner=result.isWinner();
			results[numberOfAttemps]=result;
			this.numberOfAttemps++;
		} while (!(this.numberOfAttemps==MAX_ATTEMPS || isWinner));
		this.showStateOfGame();
		if (isWinner) {
			new Console().out("You've won!!! ;-)\n");
		}
		else {
			new Console().out("You've lost!!! :-(\n");
		}
	}
}
