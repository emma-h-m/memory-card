package models;

public class Stats {
	private double easyCatAvg, hardCatAvg, easyCarAvg, hardCarAvg, easyGalaxyAvg, hardGalaxyAvg = 0;
	private int easyCatNumGames, hardCatNumGames, easyCarNumGames, hardCarNumGames, easyGalaxyNumGames,
			hardGalaxyNumGames = 0;
	private int easyCatRawScore, hardCatRawScore, easyCarRawScore, hardCarRawScore, easyGalaxyRawScore,
			hardGalaxyRawScore = 0;
	private int easyCatHighScore, hardCatHighScore, easyCarHighScore, hardCarHighScore, easyGalaxyHighScore,
			hardGalaxyHighScore = 0;

	// Constructor
	public Stats() {
		// Do we need a constructor? I'm not sure.
	}

	public void addScore(String theme, String difficulty, int numGuesses) {
		if (theme == "cat") {
			if (difficulty == "easy") {
				easyCatNumGames++;
				easyCatRawScore += numGuesses;
				easyCatAvg = easyCatRawScore / easyCatNumGames;
				if (easyCatHighScore == 0) {
					easyCatHighScore = numGuesses;
				} else if (numGuesses < easyCatHighScore) {
					easyCatHighScore = numGuesses;
				}

			}

			else { // difficulty == "hard"
				hardCatNumGames++;
				hardCatRawScore += numGuesses;
				hardCatAvg = hardCatRawScore / hardCatNumGames;
				if (hardCatHighScore == 0) {
					hardCatHighScore = numGuesses;
				} else if (numGuesses < hardCatHighScore) {
					hardCatHighScore = numGuesses;
				}
			}
		} // end of cat if statements

		else if (theme == "car") {
			if (difficulty == "easy") {
				easyCarNumGames++;
				easyCarRawScore += numGuesses;
				easyCarAvg = easyCarRawScore / easyCarNumGames;
				if (easyCarHighScore == 0) {
					easyCarHighScore = numGuesses;
				} else if (numGuesses < easyCarHighScore) {
					easyCarHighScore = numGuesses;
				}

			}

			else { // difficulty == "hard"
				hardCarNumGames++;
				hardCarRawScore += numGuesses;
				hardCarAvg = hardCarRawScore / hardCarNumGames;
				if (hardCarHighScore == 0) {
					hardCarHighScore = numGuesses;
				} else if (numGuesses < hardCarHighScore) {
					hardCarHighScore = numGuesses;
				}
			}
		} // end of car if statememts

		else { // theme == "galaxy"
			if (difficulty == "easy") {
				easyGalaxyNumGames++;
				easyGalaxyRawScore += numGuesses;
				easyGalaxyAvg = easyGalaxyRawScore / easyGalaxyNumGames;
				if (easyGalaxyHighScore == 0) {
					easyGalaxyHighScore = numGuesses;
				} else if (numGuesses < easyGalaxyHighScore) {
					easyGalaxyHighScore = numGuesses;
				}

			}

			else { // difficulty == "hard"
				hardGalaxyNumGames++;
				hardGalaxyRawScore += numGuesses;
				hardGalaxyAvg = hardGalaxyRawScore / hardGalaxyNumGames;
				if (hardGalaxyHighScore == 0) {
					hardGalaxyHighScore = numGuesses;
				} else if (numGuesses < hardGalaxyHighScore) {
					hardGalaxyHighScore = numGuesses;
				}
			}
		} // end of galaxy if statements
	}// end of addScore()

	
	// Getters
	public int getEasyCatHighScore() {
		return easyCatHighScore;
	}

	public double getEasyCatAvg() {
		return easyCatAvg;
	}

	public int getHardCatHighScore() {
		return hardCatHighScore;
	}

	public double getHardCatAvg() {
		return hardCatAvg;
	}

	public int getEasyCarHighScore() {
		return easyCarHighScore;
	}

	public double getEasyCarAvg() {
		return easyCarAvg;
	}

	public int getHardCarHighScore() {
		return hardCarHighScore;
	}

	public double getHardCarAvg() {
		return hardCarAvg;
	}

	public int getEasyGalaxyHighScore() {
		return easyGalaxyHighScore;
	}

	public double getEasyGalaxyAvg() {
		return easyGalaxyAvg;
	}

	public int getHardGalaxyHighScore() {
		return hardGalaxyHighScore;
	}

	public double getHardGalaxyAvg() {
		return hardGalaxyAvg;
	}

}// end of file
