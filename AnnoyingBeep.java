import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

/**
 * Schedule a task that executes once every second.
 */

public class AnnoyingBeep {
    Toolkit toolkit;
    Timer timer;

    public AnnoyingBeep() {
	toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
	               0,        //initial delay
	               1*1000);  //subsequent rate
    }

    class RemindTask extends TimerTask {
	int numWarningBeeps = 30;

        public void run() {
            int x = 0;
	    if (numWarningBeeps > 0) {
	        toolkit.beep();
        System.out.printf("%d\n", x);
        numWarningBeeps--;
        x++;
        } 
        else {
	        toolkit.beep(); 
                System.out.println("Time's up!");
	        //timer.cancel(); //Not necessary because we call System.exit
	        System.exit(0);   //Stops the AWT thread (and everything else)
        }
        x++;
        }
    }

    public static void main(String args[]) {
	System.out.println("About to schedule task.");
        new AnnoyingBeep();
	System.out.println("Task scheduled.");
    }
}