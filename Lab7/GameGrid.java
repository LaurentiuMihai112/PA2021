package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

import static java.lang.Thread.sleep;

public class GameGrid {
    Stage primaryStage;
    static Label timer = new Label("");
    List<Label> labels = new ArrayList<>();
    CreateGame game;
    Map<String, List<Token>> tokenSequence = new TreeMap<>();
    Stage stage;

    public GameGrid(Stage primaryStage, int numberOfPlayers) {
        //UI
      /*  this.primaryStage = primaryStage;
        primaryStage.setTitle("TSP Game");
        GridPane mainGrid = new GridPane();
        GridPane playersGrid = new GridPane();
        GridPane gameGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER_LEFT);
        gameGrid.setAlignment(Pos.CENTER);
        playersGrid.setAlignment(Pos.CENTER_LEFT);
        playersGrid.setPadding(new Insets(25, 25, 25, 25));
        gameGrid.setPadding(new Insets(25, 25, 25, 25));
        mainGrid.setPadding(new Insets(25, 25, 25, 25));
        mainGrid.add(playersGrid, 0, 0);
        mainGrid.add(gameGrid, 1, 0);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(65);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(5);
        mainGrid.getColumnConstraints().addAll(col1, col2, col3);
        int line = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            labels.add(new Label("Player" + line++));
        }
        line = 0;
        for (var label : labels) {
            label.setFont(Font.font("Roboto", FontWeight.BOLD, 16));
            label.setStyle("-fx-background-color: #8a8a8a;-fx-background-radius: 25%;-fx-padding: 3 3 3 3;");
            playersGrid.add(label, 0, line);
            line++;
        }
        playersGrid.setVgap(5);
        primaryStage.setScene(new Scene(mainGrid, 800, 800));
        primaryStage.show();*/
        //Starting game
    }

    private void updatePlayers(int turn) {
        int line = 0;
        for (var label : labels) {
            label.setStyle("-fx-background-color: #8a8a8a;-fx-background-radius: 25%;-fx-padding: 3 3 3 3;");
            if (line == turn)
                label.setStyle("-fx-background-color: #ff4242;-fx-background-radius: 25%;-fx-padding: 3 3 3 3;");
            line++;
        }
    }

}


