package mastermind;

class Result {
	
	ProposedCombination proposedCombination;
	int numberOfBlacks;
	int numberOfWhites;
	
	Result (ProposedCombination proposedCombination, int numberOfBlacks, int numberOfWhites) {
		this.proposedCombination = proposedCombination;
		this.numberOfBlacks = numberOfBlacks;
		this.numberOfWhites = numberOfWhites;
	}
	public void show() {
		
		this.proposedCombination.show();
		new Console().out(" --> " + this.numberOfBlacks + " blacks and " + this.numberOfWhites + " whites\n");		
	}

}
