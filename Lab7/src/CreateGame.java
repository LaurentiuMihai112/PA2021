
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateGame {
    int[][] matrixOfTokens;
    Integer numberOfPlayers;
    Integer numberOfTokens;
    List<String> players = new ArrayList<>();


    public CreateGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        numberOfTokens = 0;
        matrixOfTokens = new int[numberOfPlayers][numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add("Player" + (i + 1));
        }
        System.out.println(players);
        Random random = new Random();
        for (int i = 0; i < numberOfPlayers; i++) {
            matrixOfTokens[i][i] = 0;
            for (int j = i + 1; j < numberOfPlayers; j++) {
                //probability to create token or not
                if (random.nextDouble() < 0.1) {
                    numberOfTokens += 2;
                    matrixOfTokens[i][j] = random.nextInt(9) + 1;//value of token
                    matrixOfTokens[j][i] = random.nextInt(9) + 1;//value of token
                } else {
                    matrixOfTokens[i][j] = 0;//token doesnt exist
                    matrixOfTokens[j][i] = 0;//token doesnt exist
                }
            }
        }
    }

    public void printGameGrid() {
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_GREEN_BACKGROUND + "Tokens:" + ANSI_RESET);
        Integer tokenNumber = 1;
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (matrixOfTokens[i][j] != 0) {
                    System.out.print(tokenNumber + " : ");
                    tokenNumber++;
                    System.out.println(new Token(i, j, matrixOfTokens[i][j]));
                }
            }
        }
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(Integer numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

}
