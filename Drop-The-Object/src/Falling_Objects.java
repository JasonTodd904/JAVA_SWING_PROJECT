
import java.awt.Color;
import java.awt.Graphics;

class FallingObject {
    int x, y;
    int width = 30;
    int height = 30;
    int fallSpeed;

    public FallingObject(int x, int y, int width,int height,int fallspeed) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.fallSpeed=fallspeed;
    }

    public void update() {
        y += fallSpeed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }

    public boolean isOffScreen(int panelHeight) {
        return y > panelHeight;
    }
}

