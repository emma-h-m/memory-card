package controllers;

import java.nio.file.Paths;
import java.util.ArrayList;

/**
 
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Card;
import models.Deck;

public class MemoryGame_GUI extends Application {

    private Scene mainScene;
    private Scene themeScene;
    private Scene difficultyScene;
    private Scene gameScene;
    private Stage mainStage;
    private Deck deck;

    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;
        setupMainScene();
        mainStage.setTitle("Welcome to MemoryGame");
        mainStage.setScene(mainScene);
        mainStage.show();
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
        playButton.setStyle("-fx-background-color: #322947FF; -fx-text-fill: #1D1231FF; -fx-border-color: #1D1231FF; -fx-border-width: 2px;");
        playButton.setOnAction(e -> switchToThemeScene());

        // Set padding for the button container to adjust its position
        buttonContainer.setPadding(new Insets(245, 0, 0, 2)); // Adjust the bottom inset (20 in this example) to position the button lower
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
        layout.setStyle("-fx-background-color: #322947FF;");

        Text chooseThemeText = new Text("Choose the Theme:");
        chooseThemeText.setFont(Font.font("Palatino", FontWeight.BOLD, 30));
        chooseThemeText.setStyle("-fx-fill: #0C1126FF;");

        // HBox for buttons
        HBox buttonBox = new HBox(20);  // Increased space between buttons
        buttonBox.setAlignment(Pos.CENTER);

        // Button for Theme 1 (Earth)
        ImageView earthView = new ImageView(new Image("file:Documents/cardimages/spacecardback.png"));
        earthView.setFitHeight(170); // Increased size of the image
        earthView.setFitWidth(150);
        VBox earthBox = new VBox(5, earthView, new Text("Space"));
        earthBox.setAlignment(Pos.CENTER);
        Button theme1 = new Button();
        theme1.setGraphic(earthBox);
        theme1.setStyle("-fx-background-color: #322947FF; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
        theme1.setFont(new Font("Arial", 24));

        // Button for Theme 2 (Cats)
        ImageView catView = new ImageView(new Image("file:Documents/cardimages/catcardback.png"));
        catView.setFitHeight(170); // Increased size of the image
        catView.setFitWidth(150);
        VBox catBox = new VBox(5, catView, new Text("Cats"));
        catBox.setAlignment(Pos.CENTER);
        Button theme2 = new Button();
        theme2.setGraphic(catBox);
        theme2.setStyle("-fx-background-color: #322947FF; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
        theme2.setFont(new Font("Arial", 24));

        ImageView carView = new ImageView(new Image("file:Documents/cardimages/carcardback.png"));
        carView.setFitHeight(170); 
        carView.setFitWidth(150);
        VBox carBox = new VBox(5, carView, new Text("Cars"));
        carBox.setAlignment(Pos.CENTER);
        Button theme3 = new Button();
        theme3.setGraphic(carBox);
        theme3.setStyle("-fx-background-color: #322947FF; -fx-text-fill: #0C1126FF; -fx-padding: 10; -fx-border-color: #0C1126FF; -fx-border-width: 2;");
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
        if (difficultyScene == null) { // create the scene if it hasn't been created yet
            setupDifficultyScene();
        }
        mainStage.setScene(difficultyScene);
    }

    private void setupDifficultyScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #322947FF;");
        Text chooseDifficultyText = new Text("Choose the Difficulty:");
        chooseDifficultyText.setFont(Font.font("Palatino", FontWeight.BOLD, 30));
        chooseDifficultyText.setStyle("-fx-fill: #0C1126FF;");
        Button easyButton = new Button("Easy");
        easyButton.setFont(Font.font("Palatino", 24));
        easyButton.setStyle("-fx-background-color: #32CD32; -fx-text-fill: #0C1126FF;");
        easyButton.setOnAction(e -> startGame(true));
        Button hardButton = new Button("Hard");
        hardButton.setFont(Font.font("Palatino", 24));
        hardButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: #0C1126FF;");
        hardButton.setOnAction(e -> startGame(false));
        layout.getChildren().addAll(chooseDifficultyText, easyButton, hardButton);
        difficultyScene = new Scene(layout, 800, 600);
    }
    
    private void startGame(boolean isEasy) {
        int cardCount = isEasy ? 6 : 12;
        setupGameScene(cardCount);
        mainStage.setScene(gameScene);
    }
    
    private void setupGameScene(int cardCount) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #322947FF;");
        Text gameInfoText = new Text("You are playing " + (cardCount == 6 ? "Easy" : "Hard") + " mode.");
        gameInfoText.setFont(Font.font("Palatino", FontWeight.BOLD, 20));
        gameInfoText.setStyle("-fx-fill: #FFFFFF;");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);  
        scrollPane.setPrefHeight(400);  
        scrollPane.setStyle("-fx-background: #322947FF; -fx-background-color: #322947FF;");
        GridPane cardGrid = new GridPane();
        cardGrid.setHgap(10);
        cardGrid.setVgap(10);
        cardGrid.setAlignment(Pos.CENTER);
        int cardsPerColumn = cardCount == 6 ? 2 : 2;
        for (int i = 0; i < cardCount; i++) {
            Button card = new Button("Card " + (i + 1));
            card.setPrefSize(90, 140);  
            int column = i / cardsPerColumn;
            int row = i % cardsPerColumn;
            cardGrid.add(card, column, row);
        }
        scrollPane.setContent(cardGrid);
        layout.getChildren().addAll(gameInfoText, scrollPane);
        gameScene = new Scene(layout, 800, 600);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

