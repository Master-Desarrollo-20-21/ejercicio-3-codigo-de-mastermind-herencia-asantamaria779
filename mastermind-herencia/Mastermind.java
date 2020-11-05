package mastermind;

class Mastermind {

	 private void play() {
		 do {
			 new Console().out("\n---- MASTERMIND -----\n");
			 new Round().play();
		 } while(this.resume());
	}

	private boolean resume() {
		String answer;
		do {
			answer = new Console().readString("RESUME? (y/n): ");
		} while (!answer.equals("y") && !answer.equals("n"));
		return answer.equals("y");
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}
}
