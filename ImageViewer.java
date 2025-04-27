import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;

public class ImageViewer extends JFrame {

    private JLabel imageLabel;
    private JButton prevButton, nextButton;
    private File[] imageFiles;
    private int currentIndex = 0;

    public ImageViewer(String folderPath) {
        super("Image Viewer");

        // Get image files from folder using an anonymous inner class instead of lambda
        File dir = new File(folderPath);
        imageFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lower = name.toLowerCase();
                return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") || lower.endsWith(".gif");
            }
        });

        if (imageFiles == null || imageFiles.length == 0) {
            JOptionPane.showMessageDialog(this, "No images found in the folder.");
            System.exit(0);
        }

        // UI Components
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        // Button Listeners without lambdas
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showImage(currentIndex - 1);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showImage(currentIndex + 1);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        showImage(currentIndex);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showImage(int index) {
        if (index >= 0 && index < imageFiles.length) {
            currentIndex = index;
            ImageIcon icon = new ImageIcon(imageFiles[currentIndex].getAbsolutePath());

            // Optional: Resize image to fit label
            Image image = icon.getImage().getScaledInstance(
                    imageLabel.getWidth(),
                    imageLabel.getHeight(),
                    Image.SCALE_SMOOTH
            );
            imageLabel.setIcon(new ImageIcon(image));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer("images"); // Replace "images" with your folder name
            }
        });
    }
}
