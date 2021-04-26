import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    Problem problem;

    public Solution(Problem myProblem) {
        this.problem = myProblem;
    }

    /**
     * A greedy algorithm that determines a feasible solution to a given instance of the problem
     * Describes details about the solution
     */
    public void greedyAlgorithm() {
        Problem myProblem = new Problem(problem);
        int total = 0;
        long ts = System.nanoTime();
        for (
                int i = 0;
                i < myProblem.numberOfSources; i++) {
            int supply = myProblem.sources[i].getSupply();
            int[] prices = myProblem.sources[i].getPrice();
            while (supply > 0) {
                int min = Integer.MAX_VALUE, dest = 0, d = 0, price = 0;
                for (int j = 0; j < myProblem.numberOfDestinations; j++) {
                    if (prices[j] < min && myProblem.destinations[j].getDemand() > 0) {
                        min = prices[j];
                        price = prices[j];
                        dest = j;
                        d = myProblem.destinations[dest].getDemand();

                    }
                }
                if (min == Integer.MAX_VALUE)
                    break;
                if (d <= supply && d != 0) {
                    total += price * d;
                    if (!(myProblem.numberOfDestinations > 20 || myProblem.numberOfSources > 20)) {
                        System.out.println(myProblem.sources[i].getName() + " -> " + myProblem.destinations[dest].getName() + " " + d + " unitati * cost " + price + " = " + price * d);
                    }
                    myProblem.sources[i].setSupply(supply - d);
                    supply -= d;
                    myProblem.destinations[dest].setDemand(0);

                } else {
                    total += supply * price;
                    if (!(myProblem.numberOfDestinations > 20 || myProblem.numberOfSources > 20)) {
                        System.out.println(myProblem.sources[i].getName() + " -> " + myProblem.destinations[dest].getName() + " " + supply + " unitati * cost " + price + " = " + supply * price);

                    }
                    myProblem.destinations[dest].setDemand(d - supply);
                    supply = 0;
                    myProblem.sources[i].setSupply(0);
                }
            }
        }
        System.out.println("Total cost = " + total);
        long tf = System.nanoTime();
        long t = tf - ts;
        System.out.println("Timp in nanosecunde : " + t);
    }

    /**
     * A efficient algorithm that determines the best (minimal) solution to a given instance of the problem
     * Describes details about the solution
     */
    public void minimalSolution() {
        Problem myProblem = new Problem(problem);
        long ts = System.nanoTime();
        Queue<Token> pricesPriorityQueue = new PriorityQueue<>();
        int i, j;
        for (i = 0; i < myProblem.numberOfSources; i++) {
            for (j = 0; j < myProblem.numberOfDestinations; j++) {
                pricesPriorityQueue.add(new Token(myProblem.sources[i], myProblem.destinations[j], myProblem.sources[i].getPrice()[j]));
            }
        }
        int totalPrice = 0;
        while (!pricesPriorityQueue.isEmpty()) {
            Token currentToken = pricesPriorityQueue.poll();
            if (currentToken.source.getSupply() != 0 && currentToken.destination.getDemand() != 0) {
                if (!(myProblem.numberOfDestinations > 30 || myProblem.numberOfSources > 30)) {
                    System.out.println(currentToken);
                }
                if (currentToken.source.getSupply() > currentToken.destination.getDemand()) {
                    totalPrice += currentToken.price * currentToken.destination.getDemand();
                    if (!(myProblem.numberOfDestinations > 30 || myProblem.numberOfSources > 30)) {
                        System.out.println(currentToken.source.getName() + " -> " + currentToken.destination.getName() + " " + currentToken.destination.getDemand() + " unitati * cost " + currentToken.price + " = " + currentToken.destination.getDemand() * currentToken.price);
                    }
                    currentToken.source.setSupply(currentToken.source.getSupply() - currentToken.destination.getDemand());
                    currentToken.destination.setDemand(0);
                } else {
                    totalPrice += currentToken.price * currentToken.source.getSupply();
                    if (!(myProblem.numberOfDestinations > 30 || myProblem.numberOfSources > 30)) {
                        System.out.println(currentToken.source.getName() + " -> " + currentToken.destination.getName() + " " + currentToken.source.getSupply() + " unitati * cost " + currentToken.price + " = " + currentToken.source.getSupply() * currentToken.price);
                    }
                    currentToken.destination.setDemand(currentToken.destination.getDemand() - currentToken.source.getSupply());
                    currentToken.source.setSupply(0);
                }
            }
        }
        System.out.println("Total cost = " + totalPrice);
        long tf = System.nanoTime();
        long t = tf - ts;
        System.out.println("Timp in nanosecunde : " + t);
    }
}
