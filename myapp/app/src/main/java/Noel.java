import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;


public class Noel {

  public static void main(String[] args) {

    TimerTask task = new TimerTask() {
      public void run() {
        System.out.println("Time: " + LocalDateTime.now());
      }
    };
    Timer timer = new Timer("Timer");
    long delay = 0;
    long period = 1000;
    timer.scheduleAtFixedRate(task, delay, period);

    // Wait for a while
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Cancel
    timer.cancel();
  }

}
