package controllers;

/**
 
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MemoryGame_GUI extends Application {
	private BorderPane all;
	private Label gameName;
	private Button continueButton;
	private Button newGameButton;
	
    public void start(Stage primaryStage) {
        // Create the root layout
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6;");

        Text welcomeText = new Text("Welcome to Memory Game");
        welcomeText.setFont(new Font(24));

        Button startButton = new Button("Start New Game");

        //ImageView earthCard = new ImageView(new Image("earth_1.png"));
        //ImageView jupiterCard = new ImageView(new Image("./jupiter.png"));

        // Create a horizontal box to hold the memory cards
        //HBox cardBox = new HBox(10, jupiterCard);
        //cardBox.setAlignment(Pos.CENTER);

        // Add everything to the root layout
        root.getChildren().addAll(welcomeText, startButton);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Memory Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
