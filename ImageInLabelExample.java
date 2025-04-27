import javax.swing.*;
import java.awt.*;

public class ImageInLabelExample {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Image in JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Load image (must be in the same folder or provide full path)
        ImageIcon imageIcon = new ImageIcon("turnip.jpg"); // Replace with your image file

        // Create label and set icon
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Center the image

        // Add label to frame
        frame.add(imageLabel, BorderLayout.CENTER);

        // Show frame
        frame.setVisible(true);
    }
}
