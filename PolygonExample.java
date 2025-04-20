import javax.swing.*;
import java.awt.*;

public class PolygonExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] xPoints = {50, 100, 75};
        int[] yPoints = {100, 100, 50};
        g.setColor(Color.BLUE);
        g.drawPolygon(xPoints, yPoints, 3); // Triangle

        int[] px = {150, 180, 210, 195, 165};
        int[] py = {80, 60, 80, 110, 110};
        g.setColor(Color.MAGENTA);
        g.fillPolygon(px, py, 5); // Filled pentagon
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new PolygonExample());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
