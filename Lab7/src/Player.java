
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player implements Runnable, Comparable<Player> {
    private final Game game;
    private final String name;
    private final List<Token> sequence = new ArrayList<>();
    private boolean humanPlayer = false;

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    public List<Token> getSequence() {
        return sequence;
    }


    @Override
    public void run() {
        synchronized (this) {
            if (!this.humanPlayer) {
                if (sequence.size() == 0) {
                    findToken();
                } else {
                    int maxCurrentValue = -1;
                    int column = 0;
                    var secondNumber = sequence.get(sequence.size() - 1).secondNumber;
                    for (int j = 0; j < game.gameGrid.getNumberOfPlayers(); j++) {
                        if (game.gameGrid.matrixOfTokens[secondNumber][j] != 0 && game.gameGrid.matrixOfTokens[secondNumber][j] > maxCurrentValue) {
                            maxCurrentValue = game.gameGrid.matrixOfTokens[secondNumber][j];
                            column = j;
                        }
                    }
                    if (maxCurrentValue == -1) {
                        findToken();
                    } else {
                        sequence.add(new Token(secondNumber, column, game.gameGrid.matrixOfTokens[secondNumber][column]));
                        game.gameGrid.matrixOfTokens[secondNumber][column] = 0;
                        game.gameGrid.setNumberOfTokens(game.gameGrid.getNumberOfTokens() - 1);
                    }
                }
            } else {
                game.gameGrid.printGameGrid();
                System.out.print("Make your choice : ");
                Scanner scanner = new Scanner(System.in);
                int tokenNumber = scanner.nextInt();
                while (!isValid(tokenNumber)) {
                    System.out.print("Not a valid token, please enter a valid token number : ");
                    tokenNumber = scanner.nextInt();
                }
                for (int i = 0; i < game.gameGrid.numberOfPlayers; i++) {
                    for (int j = 0; j < game.gameGrid.numberOfPlayers; j++) {
                        if (game.gameGrid.matrixOfTokens[i][j] != 0) {
                            tokenNumber--;
                            if (tokenNumber == 0) {
                                sequence.add(new Token(i, j, game.gameGrid.matrixOfTokens[i][j]));
                                game.gameGrid.matrixOfTokens[i][j] = 0;
                                game.gameGrid.setNumberOfTokens(game.gameGrid.getNumberOfTokens() - 1);
                            }
                        }
                    }
                }
            }
            this.notifyAll();
        }
    }

    private boolean isValid(Integer number) {
        return (number >= 1 && number <= game.gameGrid.getNumberOfTokens());
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

    public void setHumanPlayer(boolean humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}

