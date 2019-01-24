package kata7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;


public class Watch {
    private static final double Seconds = (2 * Math.PI)/60;
    private static final double Minutes = Seconds/ 60;
    private static final double Hours = Minutes / 24;

    private double CurrentSeconds =  (Math.PI / 2) + Seconds * LocalDateTime.now().getSecond();
    private double CurrentMinutes =  (Math.PI / 2) +LocalDateTime.now().getMinute() *Seconds;
    private double CurrentHours =  (Math.PI / 2) + (LocalDateTime.now().getHour()  % 12)  *(2* Math.PI/12) ;

    private final List<Observer> observers = new ArrayList<>();
    private final Timer timer;
    public Watch(){
        System.out.println(Seconds+" " + Minutes + " " + Hours);
        System.out.println(this.CurrentHours + "  " + this.CurrentMinutes + "  " +this.CurrentSeconds + "  ");
        timer = new Timer();
        timer.schedule(timerTask(),0,1000);
    }

    private TimerTask timerTask(){
        return new TimerTask(){
            @Override
            public void run() {
                go();
                update();
            }
        };
    }

    public void go(){
        CurrentSeconds = (CurrentSeconds + Seconds) % (2*Math.PI);
        CurrentMinutes = (CurrentMinutes + Minutes)% (2*Math.PI);
        CurrentHours = (CurrentHours + Hours)% (2*Math.PI);
        System.out.println(this.CurrentHours + "  " + this.CurrentMinutes + "  " +this.CurrentSeconds + "  ");
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public void update(){
        for (Observer observer : observers)
            observer.update(null, null);
    }

    public double getSeconds() {
        return CurrentSeconds;
    }

    public double getMinutes() {
        return CurrentMinutes;
    }

    public double getHours() {
        return CurrentHours;
    }
}
