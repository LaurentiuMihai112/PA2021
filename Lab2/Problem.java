import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Problem {
    private int numberOfSources, numberOfDestinations;
    private Destination[] destinations;
    private Source[] sources;


    public Problem(int numberOfSources, int numberOfDestinations) {
        this.numberOfSources = numberOfSources;
        this.numberOfDestinations = numberOfDestinations;
        destinations = new Destination[numberOfDestinations];
        int totalDemand = 0;
        Random rand = new Random();
        Random rand1 = new Random();
        for (int i = 0; i < numberOfDestinations; i++) {
            int d = rand.nextInt(75);
            destinations[i] = new Destination("D" + i, d);
            totalDemand += d;
        }
        sources = new Source[numberOfSources];
        int totalSupply = 0;
        while (totalDemand > totalSupply) {
            for (int i = 0; i < numberOfSources; i++) {
                int s = rand.nextInt(totalDemand / numberOfDestinations), t = rand1.nextInt(2);
                if (t == 1) {
                    sources[i] = new Warehouse("S" + i, s);
                } else {
                    sources[i] = new Factory("S" + i, s);
                }
                totalSupply += s;
            }
        }
        for (int i = 0; i < numberOfSources; i++) {
            int[] prices = new int[numberOfDestinations];
            for (int j = 0; j < numberOfDestinations; j++) {
                int p = rand.nextInt(10);
                prices[j] = (p + 1);
            }
            sources[i].setPrice(prices);
        }
    }

    public Problem() {
        try {
            File myFile1 = new File("names.txt");
            File myFile2 = new File("prices.txt");
            Scanner myScan1 = new Scanner(myFile1);
            numberOfDestinations = myScan1.nextInt();
            String space = myScan1.nextLine();
            destinations = new Destination[numberOfDestinations];
            for (int i = 0; i < numberOfDestinations; i++) {
                destinations[i] = new Destination(myScan1.next(), myScan1.nextInt());
                space = myScan1.nextLine();
            }
            numberOfSources = myScan1.nextInt();
            sources = new Source[numberOfSources];
            for (int i = 0; i < numberOfSources; i++) {
                String nume = myScan1.next();
                int s = myScan1.nextInt(), t = myScan1.nextInt();
                if (t == 1) {
                    sources[i] = new Warehouse(nume, s);
                } else {
                    sources[i] = new Factory(nume, s);
                }
                if (myScan1.hasNextLine())
                    space = myScan1.nextLine();

            }
            myScan1.close();
            Scanner myScan2 = new Scanner(myFile2);
            for (int i = 0; i < numberOfSources; i++) {
                int[] prices = new int[numberOfDestinations];
                for (int j = 0; j < numberOfDestinations; j++) {
                    prices[j] = myScan2.nextInt();
                }
                sources[i].setPrice(prices);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        String info = "";
        if (!(numberOfDestinations > 20 || numberOfSources > 20)) {
            info += "numberOfSources = " + numberOfSources + "\nnumberOfDestinations = " + numberOfDestinations + '\n';
            info += "Source name : type : supply\n";
            for (int i = 0; i < numberOfSources; i++) {
                info += sources[i].getName() + " " + sources[i].getType() + " " + "Supply : " + sources[i].getSupply() + "\n";
            }
            info += "Destinations : Demands\n";
            for (int i = 0; i < numberOfDestinations; i++) {
                info += destinations[i].getName() + " " + destinations[i].getDemand() + "\n";
            }
            for (int i = 0; i < numberOfSources; i++) {
                int v[] = sources[i].getPrice();
                info += "Prices S" + i + " : ";
                for (int j = 0; j < numberOfDestinations; j++) {
                    info += v[j] + " ";
                }
                info += "\n";
            }
        } else {
            return " ";
        }
        return info + "\n";
    }


    public void solution() {
        int total = 0;
        long ts = System.nanoTime();
        for (int i = 0; i < numberOfSources; i++) {
            int supply = sources[i].getSupply();
            int[] prices = sources[i].getPrice();
            while (supply > 0) {
                int min = Integer.MAX_VALUE, dest = 0, d = 0, price = 0;
                for (int j = 0; j < numberOfDestinations; j++) {
                    if (prices[j] < min && destinations[j].getDemand() > 0) {
                        min = prices[j];
                        price = prices[j];
                        dest = j;
                        d = destinations[dest].getDemand();

                    }
                }
                if (min == Integer.MAX_VALUE)
                    break;
                if (d <= supply && d != 0) {
                    total += price * d;
                    if (!(numberOfDestinations > 20 || numberOfSources > 20)) {
                        System.out.println(sources[i].getName() + " -> " + destinations[dest].getName() + " " + d + " unitati * cost " + price + " = " + price * d);
                    }
                    sources[i].setSupply(supply - d);
                    supply -= d;
                    destinations[dest].setDemand(0);

                } else {
                    total += supply * price;
                    if (!(numberOfDestinations > 20 || numberOfSources > 20)) {
                        System.out.println(sources[i].getName() + " -> " + destinations[dest].getName() + " " + supply + " unitati * cost " + price + " = " + supply * price);

                    }
                    destinations[dest].setDemand(d - supply);
                    supply = 0;
                    sources[i].setSupply(0);
                }
            }
        }
        System.out.println("Total cost = " + total);
        long tf = System.nanoTime();
        long t = tf - ts;
        System.out.println("Timp in nanosecunde : " + t);
    }
}

