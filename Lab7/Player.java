package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable, Comparable<Player> {
    private Game game;
    private String name;
    private List<Token> sequence = new ArrayList<>();

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    public List<Token> getSequence() {
        return sequence;
    }


    @Override
    public void run() {
        if (sequence.size() == 0) {
            findToken();
        } else {
            boolean found = false;
            var secondNumber = sequence.get(sequence.size() - 1).secondNumber;
            for (int j = 0; j < game.gameGrid.getNumberOfPlayers(); j++) {
                if (game.gameGrid.matrixOfTokens[secondNumber][j] != 0) {
                    sequence.add(new Token(secondNumber, j, game.gameGrid.matrixOfTokens[secondNumber][j]));
                    found = true;
                    game.gameGrid.matrixOfTokens[secondNumber][j] = 0;
                    game.gameGrid.setNumberOfTokens(game.gameGrid.getNumberOfTokens() - 1);
                    break;
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                findToken();
            }
        }
    }

    private void findToken() {
        boolean found = false;
        Random random = new Random();
        int line, column;
        line = random.nextInt(game.gameGrid.numberOfPlayers);
        column = random.nextInt(game.gameGrid.numberOfPlayers);
        while (!found) {
            if (game.gameGrid.matrixOfTokens[line][column] != 0) {
                found = true;
                sequence.add(new Token(line, column, game.gameGrid.matrixOfTokens[line][column]));
                game.gameGrid.matrixOfTokens[line][column] = 0;
                game.gameGrid.setNumberOfTokens(game.gameGrid.getNumberOfTokens() - 1);
            }
            line = random.nextInt(game.gameGrid.numberOfPlayers);
            column = random.nextInt(game.gameGrid.numberOfPlayers);
        }
    }

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}

