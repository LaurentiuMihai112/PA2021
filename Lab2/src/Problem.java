import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Problem {
    protected int numberOfSources, numberOfDestinations;
    protected Destination[] destinations;
    protected Source[] sources;


    /**
     * Creates random instances of the problem, having a given number of sources and destinations
     */
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

    /**
     * Creates the instance given in the example
     */
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

    public Problem(int numberOfLocations) {
        this.numberOfSources = 0;
        this.numberOfDestinations = 0;
        this.sources = new Source[numberOfLocations];
        this.destinations = new Destination[numberOfLocations];
    }

    public Problem(Problem other) {
        this.numberOfSources = other.numberOfSources;
        this.numberOfDestinations = other.numberOfDestinations;
        this.sources = other.sources;
        this.destinations = other.destinations;
    }

    public void addSource(Source newSource) {
        for (int i = 0; i < numberOfSources; i++)
            if (sources[i].equals(newSource)) {
                System.out.println("Already existing source " + sources[i]);
                return;
            }
        if (newSource.getType() == SourceType.FACTORY)
            sources[numberOfSources] = new Factory(newSource.getName(), newSource.getSupply());
        else
            sources[numberOfSources] = new Warehouse(newSource.getName(), newSource.getSupply());
        this.numberOfSources++;
    }

    public void addDestination(Destination newDestination) {
        for (int i = 0; i < numberOfDestinations; i++)
            if (destinations[i].equals(newDestination)) {
                System.out.println("Already existing destination");
                return;
            }
        destinations[numberOfDestinations] = newDestination;
        this.numberOfDestinations++;
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
}

