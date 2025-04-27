import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnalogClock extends JPanel
        implements Runnable{

    private static final long serialVersionUID = 1L;
    int xs, ys, xm, ym, xh, yh;
    Thread localThread=new Thread(this);

    public AnalogClock(){
        this.setDoubleBuffered(true);
        localThread.start();
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);
        int side = getWidth() > getHeight()
                ? getHeight() : getWidth();
        g2d.scale(side / 250, side / 250);
        setAllRenderingHints(g2d);
        drawClockFace(g2d);
        drawClockHands(g2d);
    }

    @Override
    public void run() {
        while (true) {
            try {

                int s = Calendar.getInstance().
                        get(Calendar.SECOND);
                xs = (int) (Math.cos(s * Math.PI / 30 -
                        Math.PI / 2) * 80 + 0);
                ys = (int) (Math.sin(s * Math.PI / 30 -
                        Math.PI / 2) * 80 + 0);

                int m = Calendar.getInstance().
                        get(Calendar.MINUTE);
                xm = (int) (Math.cos(m * Math.PI / 30 -
                        Math.PI / 2) * 75 + 0);
                ym = (int) (Math.sin(m * Math.PI / 30 -
                        Math.PI / 2) * 75 + 0);

                int h = Calendar.getInstance().
                        get(Calendar.HOUR_OF_DAY);
                xh = (int) (Math.cos((h * 30 + m / 2) * Math.PI / 180 -
                        Math.PI / 2) * 60 + 0);
                yh = (int) (Math.sin((h * 30 + m / 2) * Math.PI / 180 -
                        Math.PI / 2) * 60 + 0);
                repaint();
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

    }

    private void setAllRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);

    }

    private void drawClockFace(Graphics2D g2d) {
        g2d.setPaint(Color.white);
        g2d.fill(new Arc2D.Double(-110, -110, 220, 220, 0,
                360, Arc2D.CHORD));
        g2d.setColor(Color.darkGray);
        g2d.setStroke(new BasicStroke(4.0f));
        g2d.draw(new Arc2D.Double(-110, -110, 220, 220, 0,
                360, Arc2D.CHORD));

        for (int i = 0; i < 60; i++) {
            if ((i % 5) != 0) {
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.setColor(Color.darkGray);
                g2d.drawLine(92, 0, 96, 0);
            } else {
                g2d.setColor(new Color(255, 22, 10));
                g2d.setStroke(new BasicStroke(2.0f));
                g2d.drawLine(88, 0, 96, 0);
            }
            g2d.rotate((Math.PI / 180.0) * 6.0);
        }
    }

    private void drawClockHands(Graphics2D g2d) {
        g2d.setColor(new Color(220, 22, 10));
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.drawLine(0, 0, xh, yh);
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.drawLine(0, 0, xm, ym);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.drawLine(0, 0, xs, ys);
        g2d.setColor(Color.black);
        g2d.fillOval(-5, -5, 10, 10);
        g2d.setColor(Color.white);
        g2d.fillOval(-2, -2, 4, 4);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        AnalogClock a = new AnalogClock();
        f.add(a, BorderLayout.CENTER);
        f.setVisible(true);

    }

}