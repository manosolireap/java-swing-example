import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventExample1 extends JFrame implements MouseListener {

    JLabel label;

    public MouseEventExample1() {
        setTitle("Mouse Event Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        label = new JLabel("Interact with the panel", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.addMouseListener(this); // Register mouse listener

        add(label, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released");
    }

    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered Panel");
    }

    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited Panel");
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseEventExample1());
    }
}
