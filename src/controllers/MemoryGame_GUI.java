package controllers;

import java.nio.file.Paths;

/**
 
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MemoryGame_GUI extends Application {

    private Scene mainScene;
    private Scene themeScene;
    private Stage mainStage;

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
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6;");

        Text welcomeText = new Text("Welcome to Memory Game");
        welcomeText.setFont(new Font("Arial", 24));

        Button playButton = new Button("Start New Game");
        playButton.setFont(new Font("Arial", 16));
        playButton.setOnAction(e -> switchToThemeScene());

        root.getChildren().addAll(welcomeText, playButton);
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
        layout.setStyle("-fx-background-color: #ADD8E6;");

        Text chooseThemeText = new Text("Choose the Theme:");
        chooseThemeText.setFont(new Font("Arial", 24));

        // HBox for buttons
        HBox buttonBox = new HBox(20);  // Increased space between buttons
        buttonBox.setAlignment(Pos.CENTER);

        // Button for Theme 1 (Earth)
        ImageView earthView = new ImageView(new Image("file:earth_1.png"));
        earthView.setFitHeight(150); // Increased size of the image
        earthView.setFitWidth(150);
        VBox earthBox = new VBox(5, earthView, new Text("Planets"));
        earthBox.setAlignment(Pos.CENTER);
        Button theme1 = new Button();
        theme1.setGraphic(earthBox);
        theme1.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 2;");
        theme1.setFont(new Font("Arial", 24));

        // Button for Theme 2 (Cats)
        ImageView catView = new ImageView(new Image("file:graycat.png"));
        catView.setFitHeight(150); // Increased size of the image
        catView.setFitWidth(150);
        VBox catBox = new VBox(5, catView, new Text("Cats"));
        catBox.setAlignment(Pos.CENTER);
        Button theme2 = new Button();
        theme2.setGraphic(catBox);
        theme2.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 2;");
        theme2.setFont(new Font("Arial", 24));

        // Placeholder for Theme 3
        Button theme3 = new Button("Theme 3 (Coming Soon)");
        theme3.setFont(new Font("Arial", 16));
        theme3.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 2;");
        
        theme1.setOnAction(e -> loadTheme(1));
        theme2.setOnAction(e -> loadTheme(2));
        theme3.setOnAction(e -> loadTheme(3));

        // Adding buttons to the HBox
        buttonBox.getChildren().addAll(theme1, theme2, theme3);

        // Add the HBox to the main VBox
        layout.getChildren().addAll(chooseThemeText, buttonBox);
        themeScene = new Scene(layout, 800, 600);
    }


    private void loadTheme(int themeNumber) {
        System.out.println("Loading Theme " + themeNumber);
        // theme loading yet to implement
    }

    public static void main(String[] args) {
        launch(args);
    }
}

