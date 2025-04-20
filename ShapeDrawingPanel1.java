import javax.swing.*;
import java.awt.*;

public class ShapeDrawingPanel1 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast to Graphics2D for better control
        Graphics2D g2 = (Graphics2D) g;

        // Set color and stroke
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));

        // Rectangle
        g2.drawRect(20, 20, 100, 60);

        // Oval
        g2.setColor(Color.RED);
        g2.drawOval(150, 20, 100, 60);

        // Line
        g2.setColor(Color.GREEN);
        g2.drawLine(20, 100, 250, 100);

        // Rounded Rectangle
        g2.setColor(Color.MAGENTA);
        g2.drawRoundRect(20, 120, 100, 60, 20, 20);

        // Arc
        g2.setColor(Color.ORANGE);
        g2.drawArc(150, 120, 100, 60, 0, 180);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Shapes Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);

        ShapeDrawingPanel1 panel = new ShapeDrawingPanel1();
        frame.add(panel);
        frame.setVisible(true);
    }
}
