package models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private String theme;
	private String difficulty;
	private ArrayList<Card> deck;

	public Deck(String themeSelection, String mode) {
		theme = themeSelection;
		difficulty = mode;
		deck = new ArrayList<Card>();
	}
	
	public ArrayList<Card> createDeck() {

		if (theme == "cat") {
			if (difficulty == "easy") {
				// Easy decks have 6 cards (3 pairs).
				deck.add(new Card("cat1", "blackcat.png"));
				deck.add(new Card("cat1", "blackcat.png"));
				
				deck.add(new Card("cat2", "orangecat.png"));
				deck.add(new Card("cat2", "orangecat.png"));
				
				deck.add(new Card("cat3", "siamesecat.png"));
				deck.add(new Card("cat3", "siamesecat.png"));
			} 
			
			else if (difficulty == "hard") {
				// Hard decks have 12 cards (6 pairs).
				deck.add(new Card("cat1", "blackcat.png"));
				deck.add(new Card("cat1", "blackcat.png"));
				
				deck.add(new Card("cat2", "orangecat.png"));
				deck.add(new Card("cat2", "orangecat.png"));
				
				deck.add(new Card("cat3", "siamesecat.png"));
				deck.add(new Card("cat3", "siamesecat.png"));
				
				deck.add(new Card("cat4", "graycat.png"));
				deck.add(new Card("cat4", "graycat.png"));
				
				deck.add(new Card("cat5", "calicocat.png"));
				deck.add(new Card("cat5", "calicocat.png"));
				
				deck.add(new Card("cat6", "whitegray.png"));
				deck.add(new Card("cat6", "whitegray.png"));
			}
		}

		else if (theme == "car") {
			if (difficulty == "easy") {
				deck.add(new Card("car1", "charger.png"));
				deck.add(new Card("car1", "charger.png"));
				
				deck.add(new Card("car2", "mazda.png"));
				deck.add(new Card("car2", "mazda.png"));
				
				deck.add(new Card("car3", "orangesupra.png"));
				deck.add(new Card("car3", "orangesupra.png"));
			} 
			
			else if (difficulty == "hard") {
				deck.add(new Card("car1", "charger.png"));
				deck.add(new Card("car1", "charger.png"));
				
				deck.add(new Card("car2", "mazda.png"));
				deck.add(new Card("car2", "mazda.png"));
				
				deck.add(new Card("car3", "orangesupra.png"));
				deck.add(new Card("car3", "orangesupra.png"));
				
				deck.add(new Card("car4", "sukicar.png"));
				deck.add(new Card("car4", "sukicar.png"));
				
				deck.add(new Card("car5", "fordescort.png"));
				deck.add(new Card("car5", "fordescort.png"));
				
				deck.add(new Card("car6", "stringray.png"));
				deck.add(new Card("car6", "stingray.png"));
			}
		}
		
		else if (theme == "space") {
			if (difficulty == "easy") {
				deck.add(new Card("space1", "saturn.png"));
				deck.add(new Card("space1", "saturn.png"));
				
				deck.add(new Card("space2", "earth_1.png"));
				deck.add(new Card("space2", "earth_1.png"));
				
				deck.add(new Card("space3", "sun.png"));
				deck.add(new Card("space3", "sun.png"));
			} 
			
			else if (difficulty == "hard") {
				deck.add(new Card("space1", "saturn.png"));
				deck.add(new Card("space1", "saturn.png"));
				
				deck.add(new Card("space2", "earth_1.png"));
				deck.add(new Card("space2", "earth_1.png"));
				
				deck.add(new Card("space3", "sun.png"));
				deck.add(new Card("space3", "sun.png"));
				
				deck.add(new Card("space4", "moon.png"));
				deck.add(new Card("space4", "moon.png"));
				
				deck.add(new Card("space5", "jupiter.png"));
				deck.add(new Card("space5", "jupiter.png"));
				
				deck.add(new Card("space6", "venus.png"));
				deck.add(new Card("space6", "venus.png"));
			}
		}
		return deck;
	}// end createDeck
	
	// Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

}
