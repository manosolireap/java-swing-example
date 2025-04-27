import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class SoundButtonExample {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Sound Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create button
        JButton playButton = new JButton("Play Sound");
        frame.getContentPane().add(playButton);

        // Button click event
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("BAK.wav");
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    // Sound playing method
    public static void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
