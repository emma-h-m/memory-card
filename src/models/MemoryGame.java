package models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The MemoryGame class administrates Memory Game, a game where a number
 * of cards are placed face down and the player flips two of the cards over
 * in an attempt to find two cards that are the same. If the selected
 * cards are the same, the two cards are removed. If the selected cards are not
 * the same, the cards are flipped back over. The game ends when the player 
 * finds all of the matching cards. This version of Memory Game supports
 * three distinct themes of cards and two difficulties, easy and hard.
 */
public class MemoryGame {
	private String userName;
	private ArrayList<Card> deck;
	private String difficulty;
	private String theme;
	//private int score = 0;
	private int numGuesses;
	private boolean match = false;
	private boolean playAgain = true;
	
	
	// Variables for testing
	//public Card card1, card2;
	
	/**
	 * The constructor for MemoryGame assigns values to the theme and
	 * difficulty of the game. It creates and instantiates a Deck 
	 * object with the appropriate theme and difficulty. It also creates a
	 * Stats object for the game. 
	 * 
	 * 
	 * @param themeSelection The user selected theme.
	 * @param mode The user selected difficulty.
	 */
	public MemoryGame(String themeSelection, String mode) {
		theme = themeSelection;
		difficulty = mode;
		numGuesses = 0;
		Deck deckObject = new Deck(theme, difficulty);
		deckObject.createDeck();
		deck = deckObject.getDeck();
		
	}
	
	/**
	 * The playGame() method shuffles the deck of cards, and then
	 * copmares the two cards selected by the user to determine if
	 * they are a match. The cards are a match, they are removed from
	 * the deck. This is repeated until the all of the cards are removed
	 * from the deck. At that point, the statistics of the game will be
	 * added to the Stats object and the user will be asked if they want
	 * to play again. If the user chooses yes, then the user will prompted
	 * to select a theme and a difficulty before beginning a new round.
	 *  If the user chooses no, the game will end.
	 */
	public void playGame() { 
		
		while (playAgain) {
			System.out.println("Started");
			// Shuffle the deck
			//deck.shuffle();

			// Lay the cards out on the table.
			// TBA (Maybe this happens in GUI?)

			// Start the game.
			while (deck.size() > 0) {
				//int i = 0; //testing
				// The player picks a card
				//Card card1 = chooseCard();
				//card1 = deck.get(i);//testing
				
				// The player picks another card
				//Card card2 = chooseCard();
				//card2 = deck.get(i + 1);//testing
	
				// The game compares the cards
				//compareCards(card1, card2);

				// If it's a match, increase the score and remove the cards from the deck.
				if (match) {
					//score++;
					//deck.remove(card1);
					//deck.remove(card2);
				}
				// else {do nothing?}

				// Increment numGuesses
				numGuesses++;
			}

			// The end of the while loop means all of the cards are gone,
			// so the game is over.
			endGame();
			
		}
	}
	
	public void incGuesses() {
		numGuesses++;
	}


	// This method sets match to true if the cards have the same title.
	// If they don't, match is set to false.
	public boolean compareCards(Card card1, Card card2) {
		if (card1.getTitle() == card2.getTitle()) {
			return true;
		} else {
			return false;
		}
	} 

	
	/*
	 * When the game is over, the user can either start a new game, or quit. 
	 * If they start a new game, the playAgain variable needs to be set to true. 
	 * This will make sure the game runs again.
	 */
	private void endGame() {
		// Add score/numGuesses to Stats object
		//stats.addScore(theme, difficulty, numGuesses); 
		
		// Ask if user wants to play again.
		// playAgain = userInput(); <- Need to get user input for this
		playAgain = false;//testing
		if (playAgain) {
		
		// String themeSelection = userInput(); <- Need to get user input for this
		// String mode = userInput(); <- Need to get user input for this
		// newGame(themeSelection, mode);
		}
		else {
			// exit the game
		}
		
	}
	
	// Resets all the important stuff.
	private void newGame(String themeSelection, String mode) {
		theme = themeSelection;
		difficulty = mode;
		Deck deckObject = new Deck(theme, difficulty);
		deckObject.createDeck();
		deck = deckObject.getDeck();
		//score = 0;
		numGuesses = 0;
		playAgain = true;
	}
	
	// Getters
	/**
	 * A getter method. 
	 * @return Returns the deck as an Array List of Card objects.
	 */
	public ArrayList<Card> getGameDeck(){
		return deck; 
	}
	
	/**
	 * A getter method.
	 * @return Returns the difficulty of the game as a String.
	 */
	public String getGameDifficulty() {
		return difficulty;
	}
	
	/**
	 * A getter method.
	 * @return Returns the theme of the game as a String.
	 */
	public String getGameTheme() {
		return theme;
	}
	
	/**
	 * A getter method.
	 * @return Returns the number of guesses the player needed to
	 * find all of the matching cards.
	 */
	public int getGameNumGuesses() {
		return numGuesses;
	}
	
	/**
	 * A getter method. Only used for testing.
	 * @return Returns the boolean variable "match", which is used
	 * to help determine if two cards are a match.
	 */
	public boolean getGameMatch() {
		return match;
	}
	
	/**
	 * A getter method. Only used for testing.
	 * @return Returns the boolean variable playAgain, which is used
	 * when determining if the player wants to play another round
	 * of Memory Game.
	 */
	public boolean getGamePlayAgain() {
		return playAgain;
	}
	
}
