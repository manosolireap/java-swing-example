import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClickToDrawCircle extends JPanel {
    private java.util.List<Point> points = new ArrayList<>();

    public ClickToDrawCircle() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (Point p : points) {
            g.fillOval(p.x - 10, p.y - 10, 20, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Click to Draw Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new ClickToDrawCircle());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
