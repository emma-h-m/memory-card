package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
/**
 
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Card;
import models.Deck;
import models.MemoryGame;
import models.Stats;

/**
 * This class acts as the user interface for Memory Game. All of the neccessary
 * user inputs are provided by this class.
 */
public class MemoryGame_GUI extends Application {
	private Scene mainScene;
	private Scene themeScene;
	private Scene difficultyScene;
	private Scene gameScene;
	
	private Scene endGameScene;
	private GridPane leaderboard;
	
	private Stage mainStage;
	private MemoryGame game;
	private String theme;
	private Card card1, card2;
	private int numSel = 0;
	private boolean match = false;
	private ArrayList<Button> buttonArray = new ArrayList<Button>();
	private int index1, index2;
	private boolean flippedOver1, flippedOver2 = false;
	private int numMatches = 0;
	private Stats stats = new Stats();
	private Deck deck;
	private boolean playAgain = false;
	private boolean isAnimating = false;
	private GridPane cardGrid;
	private String difficulty;

	@Override
	public void start(Stage primaryStage) {
		this.mainStage = primaryStage;
		setupMainScene();
		mainStage.setTitle("Welcome to MemoryGame");
		mainStage.setScene(mainScene);
		mainStage.show();
		mainStage.setResizable(false);
	}

	private void setupMainScene() {
		VBox root = new VBox(20);
		Image backgroundImage = new Image("file:Documents/cardimages/welcomescreen.png");
		String backgroundImageUrl = "url('" + backgroundImage.getUrl() + "')";
		String style = "-fx-background-image: " + backgroundImageUrl + ";";
		root.setAlignment(Pos.CENTER);
		root.setStyle(style);
		// Create a StackPane to contain the play button
		StackPane buttonContainer = new StackPane();
		Button playButton = new Button("Start New Game");
		playButton.setPadding(new Insets(10, 7, 10, 7));
		playButton.setFont(Font.font("Palatino", FontWeight.BOLD, 14));
		playButton.setStyle(
				"-fx-background-color: #322947FF; -fx-text-fill: #1D1231FF; -fx-border-color: #1D1231FF; -fx-border-width: 2px;");
		playButton.setOnAction(e -> switchToThemeScene());
		// Set padding for the button container to adjust its position
		buttonContainer.setPadding(new Insets(245, 0, 0, 2)); // Adjust the bottom inset (20 in this example) to
																// position the button lower
		buttonContainer.getChildren().add(playButton);
		root.getChildren().add(buttonContainer);
		mainScene = new Scene(root, 800, 600);
	}

	private void switchToThemeScene() {
		if (themeScene == null) { // create the scene if it hasn't been created yet
			setupThemeScene();
		}
		mainStage.setScene(themeScene);
	}

	private void setupThemeScene() {
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #272744;");
		Text chooseThemeText = new Text("Choose the Theme:");
		chooseThemeText.setFont(Font.font("Palatino", FontWeight.BOLD, 30));
		chooseThemeText.setStyle("-fx-fill: #0C1126FF;");
		// HBox for buttons
		HBox buttonBox = new HBox(20); // Increased space between buttons
		buttonBox.setAlignment(Pos.CENTER);
		// Button for Theme 1 (Earth)
		ImageView earthView = new ImageView(new Image("file:Documents/cardimages/spacecardback.png"));
		earthView.setFitHeight(170); // Increased size of the image
		earthView.setFitWidth(150);
		VBox earthBox = new VBox(5, earthView, new Text("Space"));
		earthBox.setAlignment(Pos.CENTER);
		Button theme1 = new Button();
		theme1.setGraphic(earthBox);
		theme1.setStyle(
				"-fx-background-color: #272744; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
		theme1.setFont(new Font("Arial", 24));
		// Button for Theme 2 (Cats)
		ImageView catView = new ImageView(new Image("file:Documents/cardimages/catcardback.png"));
		catView.setFitHeight(170); // Increased size of the image
		catView.setFitWidth(150);
		VBox catBox = new VBox(5, catView, new Text("Cats"));
		catBox.setAlignment(Pos.CENTER);
		Button theme2 = new Button();
		theme2.setGraphic(catBox);
		theme2.setStyle(
				"-fx-background-color: #272744; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
		theme2.setFont(new Font("Arial", 24));
		ImageView carView = new ImageView(new Image("file:Documents/cardimages/carcardback.png"));
		carView.setFitHeight(170);
		carView.setFitWidth(150);
		VBox carBox = new VBox(5, carView, new Text("Cars"));
		carBox.setAlignment(Pos.CENTER);
		Button theme3 = new Button();
		theme3.setGraphic(carBox);
		theme3.setStyle(
				"-fx-background-color: #272744; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
		theme3.setFont(new Font("Arial", 24));
		theme1.setOnAction(e -> switchToDifficultyScene(1));
		theme2.setOnAction(e -> switchToDifficultyScene(2));
		theme3.setOnAction(e -> switchToDifficultyScene(3));
		// Adding buttons to the HBox
		buttonBox.getChildren().addAll(theme1, theme2, theme3);
		// Add the HBox to the main VBox
		layout.getChildren().addAll(chooseThemeText, buttonBox);
		themeScene = new Scene(layout, 800, 600);
	}

	private void switchToDifficultyScene(int themeNumber) {
		setupDifficultyScene(themeNumber);
		mainStage.setScene(difficultyScene);
	}

	private void setupDifficultyScene(int themeNumber) {
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #272744;");
		Text chooseDifficultyText = new Text("Choose the Difficulty:");
		chooseDifficultyText.setFont(Font.font("Palatino", FontWeight.BOLD, 30));
		chooseDifficultyText.setStyle("-fx-fill: #0C1126FF;");
		Button easyButton = new Button("Easy");
		easyButton.setFont(Font.font("Palatino", 24));
		easyButton.setStyle("-fx-background-color: #32CD32; -fx-text-fill: #0C1126FF;");
		easyButton.setOnAction(e -> startGame(true, themeNumber));
		Button hardButton = new Button("Hard");
		hardButton.setFont(Font.font("Palatino", 24));
		hardButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: #0C1126FF;");
		hardButton.setOnAction(e -> startGame(false, themeNumber));
		layout.getChildren().addAll(chooseDifficultyText, easyButton, hardButton);
		difficultyScene = new Scene(layout, 800, 600);
	}

	private void startGame(boolean isEasy, int themeNumber) {
		int cardCount = isEasy ? 6 : 12;
		difficulty = isEasy ? "easy" : "hard";
		setupGameScene(cardCount, themeNumber, difficulty);
		mainStage.setScene(gameScene);
	}

	private void setupGameScene(int cardCount, int themeNumber, String difficulty) {
		if (themeNumber == 1)
			theme = "space";
		else if (themeNumber == 2)
			theme = "cat";
		else
			theme = "car";
		System.out.println(theme);
		game = new MemoryGame(theme, difficulty);
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #272744;");
		Text gameInfoText = new Text("You are playing " + (cardCount == 6 ? "Easy" : "Hard") + " mode.");
		gameInfoText.setFont(Font.font("Palatino", FontWeight.BOLD, 20));
		gameInfoText.setStyle("-fx-fill: #FFFFFF;");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);
		scrollPane.setPrefHeight(400);
		scrollPane.setStyle("-fx-background: #272744; -fx-background-color: #322947FF;");
		cardGrid = new GridPane();
		int gap = cardCount == 6 ? 20 : 10;
		int Vgap = cardCount == 6 ? 35 : 10;
		cardGrid.setHgap(Vgap);
		cardGrid.setVgap(gap);
		cardGrid.setAlignment(Pos.CENTER);
		// Create deck and lay out the cards.
		deck = new Deck(themeNumber == 1 ? "space" : (themeNumber == 2 ? "cat" : "car"), difficulty);
		ArrayList<Card> shuffledDeck = deck.createDeck(); // Create and shuffle the deck
		Collections.shuffle(shuffledDeck);
		int cardsPerColumn = cardCount == 6 ? 2 : 2;
		for (int i = 0; i < cardCount; i++) {
			String cardBackImage = themeNumber == 1 ? "spacecardback.png"
					: (themeNumber == 2 ? "catcardback.png" : "carcardback.png");
			ImageView imageView = new ImageView(new Image("file:Documents/cardimages/" + cardBackImage));
			imageView.setFitWidth(100);
			imageView.setFitHeight(140);
			Button cardButton = new Button();
			cardButton.setGraphic(imageView);
			cardButton.setStyle("-fx-background-color: #272744;");
			Card card = shuffledDeck.get(i);
			// Get the ImageView from the graphic of the button
			ImageView cardFrontView = new ImageView(new Image("file:Documents/cardimages/" + card.getPath()));
			cardFrontView.setFitWidth(100);
			cardFrontView.setFitHeight(140);
			cardFrontView.setVisible(false); // Initially hide the front of the card
			RotateTransition rotator = createRotator(cardButton, cardFrontView); // Pass the Button and ImageView of the
																					// Card
			StackPane cardPane = new StackPane(imageView, cardFrontView);
			cardButton.setGraphic(cardPane);
			cardButton.setOnAction(e -> {
				if (!flippedOver2 && !cardButton.isDisabled()) { // Check if no animation is ongoing and the card is not
																	// disabled
					rotator.play();
					if (numSel == 0) {
						index1 = buttonArray.indexOf(cardButton);
						card1 = shuffledDeck.get(index1);
						flippedOver1 = true;
					} else if (numSel == 1) {
						index2 = buttonArray.indexOf(cardButton);
						if (index1 == index2)
							return; // Prevent matching the same card
						card2 = shuffledDeck.get(index2);
						flippedOver2 = true;
						checkForMatch(); // Check for a match when the second card is flipped
					}
					numSel = (numSel + 1) % 2; // Toggles between 0 and 1 for selecting cards
				}
			});
			int column = i / cardsPerColumn;
			int row = i % cardsPerColumn;
			cardGrid.add(cardButton, column, row);
			buttonArray.add(cardButton);
		}
		scrollPane.setContent(cardGrid);
		layout.getChildren().addAll(gameInfoText, scrollPane);
		gameScene = new Scene(layout, 800, 600);
	}

	private void checkForMatch() {
		if (game.compareCards(card1, card2)) {
			handleMatch(); // Handle match scenario
		} else {
			handleNoMatch(); // Handle no match scenario
		}
	}

	private void handleMatch() {
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
		pause.setOnFinished(event -> {
			buttonArray.get(index1).setDisable(true);
			buttonArray.get(index2).setDisable(true);
			Pane placeholder1 = new Pane();
			placeholder1.setPrefSize(115, 142);
			Pane placeholder2 = new Pane();
			placeholder2.setPrefSize(115, 142);
			cardGrid.getChildren().remove(buttonArray.get(index1));
			cardGrid.add(placeholder1, GridPane.getColumnIndex(buttonArray.get(index1)),
					GridPane.getRowIndex(buttonArray.get(index1)));
			cardGrid.getChildren().remove(buttonArray.get(index2));
			cardGrid.add(placeholder2, GridPane.getColumnIndex(buttonArray.get(index2)),
					GridPane.getRowIndex(buttonArray.get(index2)));
			game.incGuesses();
			numMatches++;
			System.out.println("Number of matches made: " + numMatches);
			resetCardState();

			// Check the game state after each match
			checkGameState();
		});
		pause.play();
	}

	private void handleNoMatch() {
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
		pause.setOnFinished(event -> {
			// Flip both cards back
			flipCardBack(index1);
			flipCardBack(index2);
			resetCardState();
		});
		pause.play();
	}

	private void resetCardState() {
		numSel = 0;
		flippedOver1 = false;
		flippedOver2 = false;
	}

	// tried adding functionality for game over screen/popup but did not work,
	// troubleshooting
	private void checkGameState() {
		System.out.println("Difficulty = " + difficulty);
		if (numMatches == 3 && difficulty.equals("easy") || numMatches == 6 && difficulty.equals("hard")) {
			stats.addScore(theme, difficulty, game.getGameNumGuesses());
			// All matches found, switch to end game screen
			displayEndGamePopup();
		}
	}

	private void displayEndGamePopup() {
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);
		scrollPane.setPrefHeight(400);
		scrollPane.setStyle("-fx-background: #272744; -fx-background-color: #322947FF;");
		
		
		VBox endGameBox = new VBox();
		endGameBox.setAlignment(Pos.CENTER);
		Text congratsText = new Text("Congratlations! You have found all matches!");
		
		setupLeaderboard();
		leaderboard.setAlignment(Pos.CENTER);
		
		Text againText = new Text("Would you like to play again?");
		congratsText.setFont(Font.font("Palatino", FontWeight.BOLD, 20));
		congratsText.setStyle("-fx-fill: #FFFFFF;");
		againText.setFont(Font.font("Palatino", FontWeight.BOLD, 20));
		againText.setStyle("-fx-fill: #FFFFFF;");
		Button yesButton = new Button("Yes");
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(e->{
			System.exit(0);
		});
		HBox yesQuit = new HBox();
		yesQuit.setSpacing(15);
		yesQuit.setAlignment(Pos.CENTER);
		yesQuit.getChildren().addAll(yesButton, quitButton);
		
		
		yesButton.setOnAction( e -> {
			buttonArray = new ArrayList<Button>();
			numMatches = 0;
			flippedOver1 = false;
			flippedOver2 = false;
			themeScene = null;
			start(mainStage);
		});
		endGameBox.getChildren().addAll(congratsText, leaderboard, againText, yesQuit);
		
		scrollPane.setContent(endGameBox);
		endGameScene = new Scene(scrollPane, 800, 600);
		mainStage.setScene(endGameScene);
		/*
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Game Over");
		alert.setHeaderText(null);
		alert.setContentText("Congratulations! You have found all matches.");
		alert.show();
		*/
	}

	private void flipCardBack(int index) {
		Button cardButton = buttonArray.get(index);
		RotateTransition rotator = createRotator(cardButton,
				(ImageView) ((StackPane) cardButton.getGraphic()).getChildren().get(1));
		rotator.play();
	}

	private RotateTransition createRotator(Button cardButton, ImageView cardFrontView) {
		// First half of the rotation (0 to 90 degrees)
		RotateTransition firstHalf = new RotateTransition(Duration.millis(500), cardButton);
		firstHalf.setAxis(Rotate.Y_AXIS);
		firstHalf.setFromAngle(0);
		firstHalf.setToAngle(90);
		firstHalf.setInterpolator(Interpolator.LINEAR);
		// Second half of the rotation (90 to 180 degrees)
		RotateTransition secondHalf = new RotateTransition(Duration.millis(500), cardButton);
		secondHalf.setAxis(Rotate.Y_AXIS);
		secondHalf.setFromAngle(90);
		secondHalf.setToAngle(0);
		secondHalf.setInterpolator(Interpolator.LINEAR);
		// Toggle visibility of the card front when the first half of rotation finishes
		firstHalf.setOnFinished(e -> {
			cardFrontView.setVisible(!cardFrontView.isVisible());
			secondHalf.play(); // Start the second half of rotation
		});
		// Chain the second half of rotation to play after the first half
		firstHalf.setAutoReverse(false);
		firstHalf.setCycleCount(1);
		secondHalf.setAutoReverse(true);
		secondHalf.setCycleCount(1);
		return firstHalf;
	}
	
	private void setupLeaderboard() {
		leaderboard = new GridPane();
		leaderboard.setGridLinesVisible(true);
		String spaceEasy = stats.getEasySpaceHighScore() + "";
		String spaceHard = stats.getHardSpaceHighScore() + "";
		String catEasy = stats.getEasyCatHighScore() + "";
		String catHard = stats.getHardCatHighScore() + "";
		String carEasy = stats.getEasyCarHighScore() + "";
		String carHard = stats.getHardCarHighScore() + "";
		
		
		//Column 0
		leaderboard.add(new Text("Leaderboard"), 0, 0); //Span col 2 and 3
		leaderboard.add(new Text("Theme"), 0, 1);
		leaderboard.add(new Text("Space"), 0, 3);
		leaderboard.add(new Text("Cat"), 0, 4);
		leaderboard.add(new Text("Car"), 0, 5);
		
		//Column 1
		leaderboard.add(new Text("High Score"), 1, 1); //Span col 3
		leaderboard.add(new Text("Easy"), 1, 2);
		leaderboard.add(new Text(spaceEasy), 1, 3);
		leaderboard.add(new Text(catEasy), 1, 4);
		leaderboard.add(new Text(carEasy), 1, 5);
		
		//Column 2
		leaderboard.add(new Text("Hard"), 2, 2);
		leaderboard.add(new Text(spaceHard), 2, 3);
		leaderboard.add(new Text(catHard), 2, 4);
		leaderboard.add(new Text(carHard), 2, 5);	
	}

	/**
	 * The main method of the MemoryGame_GUI class.
	 * 
	 * @param args Needed to run the main method.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}