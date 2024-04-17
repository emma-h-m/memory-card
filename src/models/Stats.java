package models;

/**
 * The Stats class maintains a record of numerous statiscal data
 * that is pertinent to the Memory Game, such as number of games played,
 * high scores, etc...
 */
public class Stats {
	private double easyCatAvg, hardCatAvg, easyCarAvg, hardCarAvg, easyGalaxyAvg, hardGalaxyAvg = 0;
	private int easyCatNumGames, hardCatNumGames, easyCarNumGames, hardCarNumGames, easyGalaxyNumGames,
			hardGalaxyNumGames = 0;
	private int easyCatRawScore, hardCatRawScore, easyCarRawScore, hardCarRawScore, easyGalaxyRawScore,
			hardGalaxyRawScore = 0;
	private int easyCatHighScore, hardCatHighScore, easyCarHighScore, hardCarHighScore, easyGalaxyHighScore,
			hardGalaxyHighScore = 0;

	// Constructor
	/**
	 * The constructor for the Stats class is currently unused.
	 */
	public Stats() {

	}
	
	/**
	 * The addScore() method updates the Stats object with the score of the most
	 * recently played game. It increments the number of games played, calculates 
	 * the average score for the given difficulty, and updates the high score, if
	 * necessary. 
	 * 
	 * @param theme Used to determine which theme was played.
	 * @param difficulty Used to determine which difficulty was played.
	 * @param numGuesses Used for the calculation of averages and high scores.
	 */
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
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyCatHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getEasyCatHighScore() {
		return easyCatHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyCatAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getEasyCatAvg() {
		return easyCatAvg;
	}
	
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardCatHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getHardCatHighScore() {
		return hardCatHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardCatAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getHardCatAvg() {
		return hardCatAvg;
	}
	
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyCarHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getEasyCarHighScore() {
		return easyCarHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyCarAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getEasyCarAvg() {
		return easyCarAvg;
	}
	
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardCarHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getHardCarHighScore() {
		return hardCarHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardCarAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getHardCarAvg() {
		return hardCarAvg;
	}
	
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyGalaxyHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getEasyGalaxyHighScore() {
		return easyGalaxyHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return easyGalaxyAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getEasyGalaxyAvg() {
		return easyGalaxyAvg;
	}
	
	/**
	 * A getter method. Returns the high score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardGalaxyHighScore, the current high score for the difficulty
	 * and theme.
	 */
	public int getHardGalaxyHighScore() {
		return hardGalaxyHighScore;
	}
	
	/**
	 * A getter method. Returns the average score for the difficulty and
	 * theme that are in the title of the method.
	 * @return hardGalaxyAverage, the current average score for the difficulty
	 * and theme.
	 */
	public double getHardGalaxyAvg() {
		return hardGalaxyAvg;
	}

}// end of file
