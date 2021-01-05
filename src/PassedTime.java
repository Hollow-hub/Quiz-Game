import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author Katsikas Stefanos
 * @author Gkountelos Dimitrios
 * this class implements the
 * logic of the time and how to
 * count it
 * @version 0.0.1
 */

public class PassedTime {

    //some variables
    private Date startDate1;
    private Date startDate2;
    private Date endDate1;
    private Date endDate2;

    private int startingSeconds1=6;
    private int startingSeconds2=6;

    /**
     * timer of player1
     */
    java.util.Timer MyTimer1 = new java.util.Timer();
    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            if (startingSeconds1 == 1) {
//                this.MyTimer1.cancel();
                stop1();
            }
            startingSeconds1--;
            System.out.println("Seconds1:" + startingSeconds1);
        }
    };

    /**
     * timer of player2
     */

    java.util.Timer MyTimer2 = new java.util.Timer();
    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            if (startingSeconds2 == 1) {
//                MyTimer2.cancel();
                stop2();
            }
            startingSeconds2--;
            System.out.println("Seconds2:" + startingSeconds2);
        }
    };

    /**
     * starting point of counting seconds for player1
     */
    public void start1(){
        MyTimer1.scheduleAtFixedRate(task1,1000,1000);
        startDate1 = new Date();
    }

    /**
     * starting point of counting seconds for player2
     */
    public void start2(){
        MyTimer2.scheduleAtFixedRate(task2,1000,1000);
        startDate2 = new Date();
    }

    /**
     * stop point of counting seconds for player1
     */
    public void stop1(){
        MyTimer1.cancel();
        endDate1 = new Date();
    }

    /**
     * stop point of counting seconds for player2
     */
    public void stop2(){
        MyTimer2.cancel();
        endDate2 = new Date();
    }

    /**
     * @return the seconds (player1) that have remained
     */
    public int getSeconds1(){
        return (int) (endDate1.getTime() - startDate1.getTime());
    }

    /**
     * @return the seconds (player2) that have remained
     */
    public int getSeconds2(){
        return (int) (endDate2.getTime() - startDate2.getTime());
    }
}
