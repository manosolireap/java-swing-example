import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    private final int TILE_SIZE = 20;
    private final int WIDTH = 30;
    private final int HEIGHT = 20;
    private final int DELAY = 300;

    private final LinkedList<Point> snake = new LinkedList<>();
    private Point food;
    private String direction = "RIGHT";
    private boolean gameOver = false;
    private Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initGame();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initGame() {
        snake.clear();
        snake.add(new Point(5, 5));
        spawnFood();
    }

    private void spawnFood() {
        Random rand = new Random();
        do {
            food = new Point(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
        } while (snake.contains(food));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Game over message
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case "UP": newHead.y--; break;
            case "DOWN": newHead.y++; break;
            case "LEFT": newHead.x--; break;
            case "RIGHT": newHead.x++; break;
        }

        // Check collisions
        if (newHead.x < 0 || newHead.x >= WIDTH || newHead.y < 0 || newHead.y >= HEIGHT || snake.contains(newHead)) {
            gameOver = true;
            timer.stop();
            repaint();
            return;
        }

        snake.addFirst(newHead);

        if (newHead.equals(food)) {
            spawnFood();
        } else {
            snake.removeLast();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String newDir = switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> "UP";
            case KeyEvent.VK_DOWN -> "DOWN";
            case KeyEvent.VK_LEFT -> "LEFT";
            case KeyEvent.VK_RIGHT -> "RIGHT";
            default -> direction;
        };

        // Prevent snake from reversing
        if (!isOpposite(newDir)) {
            direction = newDir;
        }
    }

    private boolean isOpposite(String newDir) {
        return (direction.equals("UP") && newDir.equals("DOWN")) ||
                (direction.equals("DOWN") && newDir.equals("UP")) ||
                (direction.equals("LEFT") && newDir.equals("RIGHT")) ||
                (direction.equals("RIGHT") && newDir.equals("LEFT"));
    }

    // Unused methods
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
