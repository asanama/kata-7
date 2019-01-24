package kata7;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer {
    private final Watch watch;
    private final WatchDisplay Display;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.Display = watchDisplay;
        this.Display.paint(pointsOf(watch));
        this.watch.add(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        Display.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointsAngle(watch.getSeconds(), 150);
        points[1] = pointsAngle(watch.getMinutes(), 100);
        points[2] = pointsAngle(watch.getHours(), 50);
        return points;
    }

    private Point pointsAngle(double angle, int length){
        return new Point((int)(Math.cos(angle)*length), (int)(Math.sin(angle)*length));
    }
}
