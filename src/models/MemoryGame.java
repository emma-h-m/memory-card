package models;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame {
	private String userName;
	private ArrayList<Card> deck;
	private String difficulty;
	private String theme;
	//private int score = 0;
	private int numGuesses = 0;
	private boolean match = false;
	private boolean playAgain = true;
	private Stats stats;
	
	// Variables for testing
	public Card card1, card2;

	public MemoryGame(String themeSelection, String mode) {
		theme = themeSelection;
		difficulty = mode;
		Deck deckObject = new Deck(theme, difficulty);
		deck = deckObject.createDeck();
		stats = new Stats();
	}

	public void playGame() {
		
		while (playAgain) {
			System.out.println("Started");
			// Shuffle the deck
			//Collections.shuffle(deck);

			// Lay the cards out on the table.
			// TBA (Maybe this happens in GUI?)

			// Start the game.
			while (deck.size() > 0) {
				int i = 0; //testing
				// The player picks a card
				//Card card1 = chooseCard();
				card1 = deck.get(i);//testing
				
				// The player picks another card
				//Card card2 = chooseCard();
				card2 = deck.get(i + 1);//testing
	
				// The game compares the cards
				compareCards(card1, card2);

				// If it's a match, increase the score and remove the cards from the deck.
				if (match) {
					//score++;
					deck.remove(card1);
					deck.remove(card2);
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

	// Returns the card that user selected
	private Card chooseCard() {
		
		// return userSelectedCard();
		
		// Placeholder code
		Card card = new Card("", ""); 
		return card;
	}

	// This method sets match to true if the cards have the same title.
	// If they don't, match is set to false.
	public void compareCards(Card card1, Card card2) {
		if (card1.getTitle() == card2.getTitle()) {
			match = true;
		} else {
			match = false;
		}
	} // Note: We need to make sure the user can't select the same card twice.
	  // We can do that by disabling the first selection in the GUI, or we can
	  // add another variable to the cards and compare the title AND the variable
	  // to make sure it's not the same exact card.

	
	/*
	 * When the game is over, the user can either start a new game, or quit. 
	 * If they start a new game, the playAgain variable needs to be set to true. 
	 * This will make sure the game runs again.
	 */
	private void endGame() {
		// Add score/numGuesses to Stats object
		stats.addScore(theme, difficulty, numGuesses); 
		
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
	public void newGame(String themeSelection, String mode) {
		theme = themeSelection;
		difficulty = mode;
		Deck deckObject = new Deck(theme, difficulty);
		deck = deckObject.createDeck();
		//score = 0;
		numGuesses = 0;
		playAgain = true;
	}
	
	// Getters
	public ArrayList<Card> getGameDeck(){
		return deck; 
	}
	public String getGameDifficulty() {
		return difficulty;
	}
	public String getGameTheme() {
		return theme;
	}
	public int getGameNumGuesses() {
		return numGuesses;
	}
	public boolean getGameMatch() {
		return match;
	}
	public boolean getGamePlayAgain() {
		return playAgain;
	}
	public Stats getGameStats() {
		return stats;
	}
}
