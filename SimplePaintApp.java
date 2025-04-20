import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimplePaintApp extends JFrame {

    private DrawArea drawArea;
    private JButton clearButton;
    private JComboBox<String> colorPicker;

    public SimplePaintApp() {
        setTitle("Simple Paint App");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawArea = new DrawArea();
        clearButton = new JButton("Clear");

        String[] colors = {"Black", "Red", "Blue", "Green", "Orange", "Magenta"};
        colorPicker = new JComboBox<>(colors);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Color:"));
        topPanel.add(colorPicker);
        topPanel.add(clearButton);

        clearButton.addActionListener(e -> drawArea.clear());
        colorPicker.addActionListener(e -> drawArea.setColor(getSelectedColor()));

        add(topPanel, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);

        setVisible(true);
    }

    private Color getSelectedColor() {
        String selected = (String) colorPicker.getSelectedItem();
        switch (selected) {
            case "Red": return Color.RED;
            case "Blue": return Color.BLUE;
            case "Green": return Color.GREEN;
            case "Orange": return Color.ORANGE;
            case "Magenta": return Color.MAGENTA;
            default: return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimplePaintApp::new);
    }
}

class DrawArea extends JPanel {

    private java.util.List<Point> points = new ArrayList<>();
    private Color currentColor = Color.BLACK;

    public DrawArea() {
        setBackground(Color.WHITE);
        MouseAdapter mouseHandler = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }

            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void setColor(Color color) {
        currentColor = color;
    }

    public void clear() {
        points.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
