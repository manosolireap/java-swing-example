import javax.swing.*;
import java.awt.*;

public class TextDrawingExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Serif", Font.BOLD, 24));
        g.drawString("Hello Swing!", 50, 80);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.add(new TextDrawingExample());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
