import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBallPanel extends JPanel implements ActionListener {
    private int x = 50, y = 50;
    private int dx = 2, dy = 3;
    private final int radius = 20;
    private Timer timer;

    public BouncingBallPanel() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x + radius * 2 > getWidth()) dx = -dx;
        if (y < 0 || y + radius * 2 > getHeight()) dy = -dy;

        x += dx;
        y += dy;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new BouncingBallPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
