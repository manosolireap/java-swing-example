import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class AdvancedDrawingPanel extends JPanel {
    private BufferedImage image;

    public AdvancedDrawingPanel() {
        try {
            // Load image (use any image path or URL here)
            image = ImageIO.read(new File("turnip.jpg")); // Replace with an actual image path
        } catch (IOException e) {
            System.out.println("turnip.jpg");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gradient Background
        GradientPaint gradient = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.LIGHT_GRAY);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Draw image
        if (image != null) {
            g2.drawImage(image, 10, 10, 100, 100, this);
        }

        // Draw a filled ellipse with stroke
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Ellipse2D.Double(130, 30, 100, 60));
        g2.fill(new Ellipse2D.Double(130, 30, 100, 60));

        // Draw a custom path (heart shape-ish)
        g2.setColor(Color.MAGENTA);
        Path2D path = new Path2D.Double();
        path.moveTo(200, 150);
        path.curveTo(180, 130, 160, 160, 200, 200);
        path.curveTo(240, 160, 220, 130, 200, 150);
        g2.fill(path);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Advanced Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new AdvancedDrawingPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
