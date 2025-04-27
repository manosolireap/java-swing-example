
// need jlayer-1.0.1.jar: from https://github.com/umjammer/jlayer

//import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;

public class MP3PlayerExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton playButton = new JButton("Play MP3");
        frame.getContentPane().add(playButton);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> playMP3("music.mp3")).start();
            }
        });

        frame.setVisible(true);
    }

    public static void playMP3(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            //Player player = new Player(fis);
            //player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
