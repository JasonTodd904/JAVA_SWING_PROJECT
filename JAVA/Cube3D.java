import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Cube3D extends JPanel implements ActionListener {
    private Timer timer = new Timer(16, this);
    private double angle = 0;

    private double[][] cube = {
        {-1, -1, -1}, {1, -1, -1}, {1, 1, -1}, {-1, 1, -1},
        {-1, -1,  1}, {1, -1,  1}, {1, 1,  1}, {-1, 1,  1}
    };

    private int[][] edges = {
        {0,1}, {1,2}, {2,3}, {3,0},
        {4,5}, {5,6}, {6,7}, {7,4},
        {0,4}, {1,5}, {2,6}, {3,7}
    };

    public Cube3D() {
        setBackground(Color.BLACK);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int w = getWidth() / 2;
        int h = getHeight() / 2;

        g2d.setColor(Color.WHITE);
        for (int[] edge : edges) {
            double[] p1 = rotateY(cube[edge[0]], angle);
            double[] p2 = rotateY(cube[edge[1]], angle);
            int[] p1_2D = project(p1, w, h);
            int[] p2_2D = project(p2, w, h);
            g2d.draw(new Line2D.Double(p1_2D[0], p1_2D[1], p2_2D[0], p2_2D[1]));
        }
    }

    private double[] rotateY(double[] point, double angle) {
        double x = point[0];
        double z = point[2];
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new double[]{
            x * cos - z * sin,
            point[1],
            x * sin + z * cos
        };
    }

    private int[] project(double[] point3D, int w, int h) {
        double scale = 100 / (point3D[2] + 3); // perspective division
        int x = (int) (point3D[0] * scale + w);
        int y = (int) (point3D[1] * scale + h);
        return new int[]{x, y};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.02;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Cube in Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Cube3D());
        frame.setVisible(true);
    }
}
