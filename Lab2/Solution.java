public class Solution {
    /**
     * A greedy algorithm that determines a feasible solution to a given instance of the problem
     * Describes details about the solution
     */
    public void solution(Problem myProblem) {
        int total = 0;
        long ts = System.nanoTime();
        for (int i = 0; i < myProblem.numberOfSources; i++) {
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
}
