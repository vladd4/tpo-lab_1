import java.awt.*;
import java.awt.geom.Ellipse2D;

class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x;
    private int y;
    private int dx = 2;
    private int dy = 2;
    private Color color;
    private boolean justBounced = false;

    public Ball(Component c, Color color) {
        this.canvas = c;
        this.color = color;

        x = 1;
        y = 1;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public boolean hasJustBounced() {
        if (justBounced) {
            justBounced = false;
            return true;
        }
        return false;
    }

    public void move() {
        x += dx;
        y += dy;
        justBounced = false;

        if (x < 0 || x + XSIZE >= this.canvas.getWidth()) {
            dx = -dx;
            justBounced = true;
        }
        if (y < 0 || y + YSIZE >= this.canvas.getHeight()) {
            dy = -dy;
            justBounced = true;
        }

        this.canvas.repaint();
    }
}