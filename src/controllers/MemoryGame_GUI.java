package controllers;

/**
 
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        if (themeScene == null) { // Only create the scene if it hasn't been created yet
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

        Button theme1 = new Button("Theme 1");
        theme1.setFont(new Font("Arial", 16));
        Button theme2 = new Button("Theme 2");
        theme2.setFont(new Font("Arial", 16));
        Button theme3 = new Button("Theme 3");
        theme3.setFont(new Font("Arial", 16));

        // Placeholders for loading each theme
        theme1.setOnAction(e -> loadTheme(1));
        theme2.setOnAction(e -> loadTheme(2));
        theme3.setOnAction(e -> loadTheme(3));

        layout.getChildren().addAll(chooseThemeText, theme1, theme2, theme3);
        themeScene = new Scene(layout, 800, 600);
    }

    private void loadTheme(int themeNumber) {
        System.out.println("Loading Theme " + themeNumber);
        // Add your theme loading logic here
    }

    public static void main(String[] args) {
        launch(args);
    }
}

