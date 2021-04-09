import static java.lang.Thread.sleep;

public class Timer implements Runnable {
    @Override
    public void run() {
        int minutes = 10, seconds = 0;
        while (true) {
            if (seconds % 15 == 0) {
                System.out.print("Time left -> ");
                if (minutes < 10) {
                    System.out.print("0" + minutes);
                } else {
                    System.out.print(minutes);
                }
                System.out.print(":");
                if (seconds < 10) {
                    System.out.println("0" + seconds);
                } else {
                    System.out.println(seconds);
                }
            }
            if (seconds == 0) {
                minutes--;
                seconds = 59;
            } else {
                seconds--;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (minutes == 10) {
                System.out.println("Game over! No winners");
                System.exit(0);
            }
        }
    }
}

