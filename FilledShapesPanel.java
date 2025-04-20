import javax.swing.*;
import java.awt.*;

public class FilledShapesPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(20, 20, 80, 50); // Filled rectangle

        g.setColor(Color.PINK);
        g.fillOval(120, 20, 80, 50); // Filled oval

        g.setColor(Color.YELLOW);
        g.fillRoundRect(220, 20, 80, 50, 20, 20); // Filled rounded rect
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Filled Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 120);
        frame.add(new FilledShapesPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
