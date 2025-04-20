import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class Particle {
    int x, y;
    double dx, dy;
    Color color;
    int life;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        this.dx = rand.nextDouble() * 4 - 2; // -2 to 2
        this.dy = rand.nextDouble() * 4 - 2;
        this.color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        this.life = 100 + rand.nextInt(100); // lifespan
    }

    public void update() {
        x += dx;
        y += dy;
        life--;
    }

    public boolean isAlive() {
        return life > 0;
    }
}

public class ParticleEffectDemo extends JPanel implements ActionListener, MouseListener {
    private final ArrayList<Particle> particles = new ArrayList<>();
    private final Timer timer = new Timer(16, this); // ~60fps

    public ParticleEffectDemo() {
        setBackground(Color.BLACK);
        addMouseListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            g.setColor(p.color);
            g.fillOval(p.x, p.y, 6, 6);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        particles.removeIf(p -> !p.isAlive());
        for (Particle p : particles) {
            p.update();
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < 50; i++) {
            particles.add(new Particle(e.getX(), e.getY()));
        }
    }

    // Unused mouse methods
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Particle Effect Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new ParticleEffectDemo());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
