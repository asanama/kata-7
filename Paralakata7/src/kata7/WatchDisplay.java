package kata7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel{
    public BufferedImage background;
    public Point[] points = new Point[0];

    public WatchDisplay() throws FileNotFoundException, IOException{
        background = ImageIO.read(new FileInputStream("C:\\Users\\Ale\\Documentos\\Paralakata7\\background.png"));
    }

   public void paint(Point[] points) {
        this.points = points;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.white);
        int width = 1;
        int ox = getWidth()/2;
        int oy = getHeight()/2;
        for (Point point : points) {
            g2(g).setStroke(new BasicStroke(width));
            width += 2;
            g2(g).drawLine(ox, oy, ox - point.x, oy - point.y);
        }
    }

    private Graphics2D g2(Graphics g) {
        return (Graphics2D) g;
    }
}
