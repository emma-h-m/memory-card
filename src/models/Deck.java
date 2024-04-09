package models;

import java.util.ArrayList;

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
				deck.add(new Card("cat1", "cat1.png"));
				deck.add(new Card("cat1", "cat1.png"));
				
				deck.add(new Card("cat2", "cat2.png"));
				deck.add(new Card("cat2", "cat2.png"));
				
				deck.add(new Card("cat3", "cat3.png"));
				deck.add(new Card("cat3", "cat3.png"));
				
				//deck.add(new Card("cat4", "cat4.png"));
				//deck.add(new Card("cat4", "cat4.png"));
				//
				//deck.add(new Card("cat5", "cat5.png"));
				//deck.add(new Card("cat5", "cat5.png"));
				//
				//deck.add(new Card("cat6", "cat6.png"));
				//deck.add(new Card("cat6", "cat6.png"));
			} 
			
			else if (difficulty == "hard") {
				// Hard decks have 12 cards (6 pairs).
				deck.add(new Card("cat1", "cat1.png"));
				deck.add(new Card("cat1", "cat1.png"));
				
				deck.add(new Card("cat2", "cat2.png"));
				deck.add(new Card("cat2", "cat2.png"));
				
				deck.add(new Card("cat3", "cat3.png"));
				deck.add(new Card("cat3", "cat3.png"));
				
				deck.add(new Card("cat4", "cat4.png"));
				deck.add(new Card("cat4", "cat4.png"));
				
				deck.add(new Card("cat5", "cat5.png"));
				deck.add(new Card("cat5", "cat5.png"));
				
				deck.add(new Card("cat6", "cat6.png"));
				deck.add(new Card("cat6", "cat6.png"));
				
				//deck.add(new Card("cat7", "cat7.png"));
				//deck.add(new Card("cat7", "cat7.png"));
				//
				//deck.add(new Card("cat8", "cat8.png"));
				//deck.add(new Card("cat8", "cat8.png"));
				//
				//deck.add(new Card("cat9", "cat9.png"));
				//deck.add(new Card("cat9", "cat9.png"));
				//
				//deck.add(new Card("cat10", "cat10.png"));
				//deck.add(new Card("cat10", "cat10.png"));
				//
				//deck.add(new Card("cat11", "cat11.png"));
				//deck.add(new Card("cat11", "cat11.png"));
				//
				//deck.add(new Card("cat12", "cat12.png"));
				//deck.add(new Card("cat12", "cat12.png"));
			}
		}

		else if (theme == "car") {
			if (difficulty == "easy") {
				deck.add(new Card("car1", "car1.png"));
				deck.add(new Card("car1", "car1.png"));
				
				deck.add(new Card("car2", "car2.png"));
				deck.add(new Card("car2", "car2.png"));
				
				deck.add(new Card("car3", "car3.png"));
				deck.add(new Card("car3", "car3.png"));
				
				//deck.add(new Card("car4", "car4.png"));
				//deck.add(new Card("car4", "car4.png"));
				//
				//deck.add(new Card("car5", "car5.png"));
				//deck.add(new Card("car5", "car5.png"));
				//
				//deck.add(new Card("car6", "car6.png"));
				//deck.add(new Card("car6", "car6.png"));
			} 
			
			else if (difficulty == "hard") {
				deck.add(new Card("car1", "car1.png"));
				deck.add(new Card("car1", "car1.png"));
				
				deck.add(new Card("car2", "car2.png"));
				deck.add(new Card("car2", "car2.png"));
				
				deck.add(new Card("car3", "car3.png"));
				deck.add(new Card("car3", "car3.png"));
				
				deck.add(new Card("car4", "car4.png"));
				deck.add(new Card("car4", "car4.png"));
				
				deck.add(new Card("car5", "car5.png"));
				deck.add(new Card("car5", "car5.png"));
				
				deck.add(new Card("car6", "car6.png"));
				deck.add(new Card("car6", "car6.png"));
				
				//deck.add(new Card("car7", "car7.png"));
				//deck.add(new Card("car7", "car7.png"));
				//
				//deck.add(new Card("car8", "car8.png"));
				//deck.add(new Card("car8", "car8.png"));
				//
				//deck.add(new Card("car9", "car9.png"));
				//deck.add(new Card("car9", "car9.png"));
				//
				//deck.add(new Card("car10", "car10.png"));
				//deck.add(new Card("car10", "car10.png"));
				//
				//deck.add(new Card("car11", "car11.png"));
				//deck.add(new Card("car11", "car11.png"));
				//
				//deck.add(new Card("car12", "car12.png"));
				//deck.add(new Card("car12", "car12.png"));
			}
		}
		
		else if (theme == "galaxy") {
			if (difficulty == "easy") {
				deck.add(new Card("galaxy1", "galaxy1.png"));
				deck.add(new Card("galaxy1", "galaxy1.png"));
				
				deck.add(new Card("galaxy2", "galaxy2.png"));
				deck.add(new Card("galaxy2", "galaxy2.png"));
				
				deck.add(new Card("galaxy3", "galaxy3.png"));
				deck.add(new Card("galaxy3", "galaxy3.png"));
				
				//deck.add(new Card("galaxy4", "galaxy4.png"));
				//deck.add(new Card("galaxy4", "galaxy4.png"));
				//
				//deck.add(new Card("galaxy5", "galaxy5.png"));
				//deck.add(new Card("galaxy5", "galaxy5.png"));
				//
				//deck.add(new Card("galaxy6", "galaxy6.png"));
				//deck.add(new Card("galaxy6", "galaxy6.png"));
			} 
			
			else if (difficulty == "hard") {
				deck.add(new Card("galaxy1", "galaxy1.png"));
				deck.add(new Card("galaxy1", "galaxy1.png"));
				
				deck.add(new Card("galaxy2", "galaxy2.png"));
				deck.add(new Card("galaxy2", "galaxy2.png"));
				
				deck.add(new Card("galaxy3", "galaxy3.png"));
				deck.add(new Card("galaxy3", "galaxy3.png"));
				
				deck.add(new Card("galaxy4", "galaxy4.png"));
				deck.add(new Card("galaxy4", "galaxy4.png"));
				
				deck.add(new Card("galaxy5", "galaxy5.png"));
				deck.add(new Card("galaxy5", "galaxy5.png"));
				
				deck.add(new Card("galaxy6", "galaxy6.png"));
				deck.add(new Card("galaxy6", "galaxy6.png"));
				
				//deck.add(new Card("galaxy7", "galaxy7.png"));
				//deck.add(new Card("galaxy7", "galaxy7.png"));
				//
				//deck.add(new Card("galaxy8", "galaxy8.png"));
				//deck.add(new Card("galaxy8", "galaxy8.png"));
				//
				//deck.add(new Card("galaxy9", "galaxy9.png"));
				//deck.add(new Card("galaxy9", "galaxy9.png"));
				//
				//deck.add(new Card("galaxy10", "galaxy10.png"));
				//deck.add(new Card("galaxy10", "galaxy10.png"));
				//
				//deck.add(new Card("galaxy11", "galaxy11.png"));
				//deck.add(new Card("galaxy11", "galaxy11.png"));
				//
				//deck.add(new Card("galaxy12", "galaxy12.png"));
				//deck.add(new Card("galaxy12", "galaxy12.png"));
			}
		}
		return deck;
	}// end createDeck

}
