package sample;

import javafx.stage.Stage;

import java.util.*;

import static java.lang.Thread.sleep;

public class Game {
    CreateGame gameGrid;
    Map<String, List<Token>> tokenSequence = new TreeMap<>();
    Stage stage;
    GameGrid grid;

    public Game(Stage stage, int numberOfPlayers) {
        this.stage = stage;

        this.gameGrid = new CreateGame(numberOfPlayers);
        int turn = 0;
        Player[] player = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player(this, gameGrid.players.get(turn));
        }
        while (gameGrid.getNumberOfTokens() > 0) {
            Runnable runnable = player[turn];
            Thread playerThread = new Thread(runnable);
            playerThread.start();
            try {
                playerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameGrid.printGameGrid();
            System.out.println("Number of tokens left :" + gameGrid.getNumberOfTokens());
            System.out.println(gameGrid.players.get(turn));
            tokenSequence.put(gameGrid.players.get(turn), new ArrayList<>());
            tokenSequence.get(gameGrid.players.get(turn)).addAll(player[turn].getSequence());
            turn++;
            turn = turn % numberOfPlayers;
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(tokenSequence);
        System.out.println();
        gameWinner();

    }

    public void gameWinner() {
        Map<String, Integer> scores = new HashMap<>();
        Integer maxScore = 0;
        String winner = "";
        for (var player : gameGrid.players) {
            if (tokenSequence.get(player) != null) {
                System.out.println(player);
                scores.putIfAbsent(player, 0);
                System.out.println(tokenSequence.get(player));

                for (int i = 0; i < tokenSequence.get(player).size(); i++) {
                    scores.put(player, scores.get(player) + tokenSequence.get(player).get(i).value);
                }
                if (tokenSequence.get(player).size() == gameGrid.numberOfPlayers) {
                    scores.put(player, scores.get(player) + 10);
                }
                System.out.println(scores.get(player) + " score");
                if (scores.get(player) > maxScore) {
                    maxScore = scores.get(player);
                    winner = player;
                }
            }
        }
        System.out.println("The winner is : " + winner);
    }

}
