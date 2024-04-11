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
        HBox buttonBox = new HBox(10);  
        buttonBox.setAlignment(Pos.CENTER);

        // button for Theme 1
        String earthImagePath = "file:earth_1.png";
        printImagePath(earthImagePath);
        ImageView earthView = new ImageView(new Image(earthImagePath));
        earthView.setFitHeight(50);
        earthView.setFitWidth(50); 
        Button theme1 = new Button("Planets", earthView);
        theme1.setFont(new Font("Arial", 16));

        // button for Theme 2 (Cats)
        String catImagePath = "file:graycat.png";
        printImagePath(catImagePath);
        ImageView catView = new ImageView(new Image(catImagePath));
        catView.setFitHeight(50); 
        catView.setFitWidth(50); 
        Button theme2 = new Button("Cats", catView);
        theme2.setFont(new Font("Arial", 16));

        // Placeholder for Theme 3
        Button theme3 = new Button("Theme 3 (Coming Soon)");
        theme3.setFont(new Font("Arial", 16));

        // Adding buttons to the HBox
        buttonBox.getChildren().addAll(theme1, theme2, theme3);

        // Placeholders for loading each theme
        theme1.setOnAction(e -> loadTheme(1));
        theme2.setOnAction(e -> loadTheme(2));
        theme3.setOnAction(e -> {}); // No action for the third button yet

        // Add the HBox to the main VBox
        layout.getChildren().addAll(chooseThemeText, buttonBox);
        themeScene = new Scene(layout, 800, 600);
    }

    private void printImagePath(String imagePath) {
        String path = Paths.get(imagePath.replace("file:", "")).toAbsolutePath().toString();
        System.out.println("Looking for image at: " + path);
    }

    private void loadTheme(int themeNumber) {
        System.out.println("Loading Theme " + themeNumber);
        // theme loading yet to implement
    }

    public static void main(String[] args) {
        launch(args);
    }
}

