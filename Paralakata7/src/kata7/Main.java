package kata7;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.swing.JFrame;

public class Main extends JFrame{

    private Main() throws IOException{
        System.out.println(LocalDateTime.now().getHour() + "  " + LocalDateTime.now().getMinute() + "   " + LocalDateTime.now().getSecond());
        Watch watch =  new Watch();
        WatchDisplay display = new WatchDisplay();
        new WatchPresenter(watch, display);
        this.setTitle("Reloj");
        this.setBounds(100,100, 400, 425);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(display);
    }

    private void execute() {
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main().execute();
    }
}
