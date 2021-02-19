import java.util.Scanner;
import java.util.Random;

public class Graph {

    static void DFS(int v, int n, int visited[], int m[][], int k) {
        visited[v] = k;
        for (int i = 0; i < n; i++) {
            if (m[v][i] == 1 && visited[i] == 0) {
                DFS(i, n, visited, m, k);
            }
        }
    }

    static void DFSTree(int v, int n, int m[][], int treeMatrix[][], int visited[]) {

        for (int i = 0; i < n; i++) {
            if (m[v][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                treeMatrix[v][i] = treeMatrix[i][v] = 1;
                DFSTree(i, n, m, treeMatrix, visited);

            }
        }
    }

    public static int grad(int m[][], int n, int x) {
        int d = 0;
        for (int i = 0; i < n; i++)
            d += m[x][i];
        return d;
    }

    public static void printMatrix(int m[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void randomizeMatrix(int m[][], int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                m[i][j] = rand.nextInt(2);
                m[j][i] = m[i][j];
            }
        }
    }

    public static int nrCompConexe(int m[][], int n, int visited[]) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                DFS(i, n, visited, m, k + 1);
                k++;
            }
        }
        return k;
    }

    public static void treeStructure(int v, int m[][], int n, int visited[], int level) {
        visited[v] = 1;
        System.out.println("node" + v);
        for (int i = 0; i < n; i++) {
            if (m[v][i] != 0 && visited[i] == 0) {
                for (int j = 0; j < 2 * level; j++) {
                    System.out.printf(" ");
                }
                if (grad(m, n, i) == 1) {
                    System.out.printf("-");
                } else {
                    System.out.printf("+");
                }
                level++;
                treeStructure(i, m, n, visited, level);
                level--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceti numarul de noduri: ");

        int n = sc.nextInt();
        sc.close();

        int m[][] = new int[n][n];
        randomizeMatrix(m, n);

        int visited[] = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }
        int a[][] = new int[n][n];
        int nrc = nrCompConexe(m, n, visited);
        if (nrc == 1) {
            System.out.println("Graful este conex, vom afisa matricea unui arbore partial daca numarul de noduri n<=10");
            if (n <= 10) {
                printMatrix(a, n);
            }
            visited[0] = -1;
            for (int i = 1; i < n; i++) {
                visited[i] = 0;
            }
            DFSTree(0, n, m, a, visited);
            for (int i = 0; i < n; i++) {
                visited[i] = 0;
            }
            treeStructure(0, a, n, visited, 1);
        } else {
            System.out.println("Graful nu este conex");
        }

    }
}
