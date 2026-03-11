import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayPanel extends JPanel implements KeyListener
{
    int frameCount=0;
    Random rand=new Random();
    ArrayList<FallingObject> object=new ArrayList<>();
    
    private App frame;
    int x=(800-50)/2;
    int velocityX=0;
    int s=5;

    Timer timer;
    boolean gameOver=false;
    long currtime;

    public PlayPanel(App frame)
    {   
        this.frame=frame;
        this.setToolTipText("this is game pannel");
        this.setBackground(Color.black);
    
            currtime=System.currentTimeMillis();

            timer=new Timer(10, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    if(gameOver)
                    {
                        frame.gameoverPanel();
                        timer.stop();
                        return;
                    }
                    move();

                    for(FallingObject obj: object)
                    {
                        if(collision(x, 400, 50, 50, obj.x, obj.y, obj.width, obj.height))
                            gameOver=true;
                        obj.update();
                    }

                    
                    frameCount++;
                    if (frameCount % 15 == 0)
                    { // Add new object every 30 frames (~every 0.3s)
                        long time=System.currentTimeMillis();
                        if((time-currtime) >=5000)
                           {
                            if(s <= 10)
                                 s++;
                         //   frameCount-=10;
                           }
                        int speed = rand.nextInt(s) + 2;
                        int Xcord = rand.nextInt(800 - 50 - 3 + 1) + 3;
                        object.add(new FallingObject(Xcord, 0, 20, 20,speed));
                        currtime=time;
                    }
                } 
            });
            timer.start();
            this.addKeyListener(this);
            this.setFocusable(true);
    }   
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);        
        super.paintComponent(g);
        g.fillRect(x, 400, 50, 50);//to bring square in center
        

        g.setColor(Color.red);
        for(FallingObject obj : object)
            g.fillOval(obj.x,obj.y,obj.width,obj.height);
    }

    public void move()
    {   
        if(x >= getWidth()-56|| x<=6)
            gameOver=true;

        x+=velocityX;
        revalidate();
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) 
    {
        velocityX=10;
        if(e.getKeyCode() == KeyEvent.VK_A && velocityX>0)
            velocityX*=-1; 
        if(e.getKeyCode() == KeyEvent.VK_D && velocityX<0)
            velocityX*=-1;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
            velocityX=0; 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean collision(int x1, int y1, int w1, int h1,int x2, int y2, int w2, int h2) 
    {
            return x1 < x2 + w2 &&
                x1 + w1 > x2 &&
                y1 < y2 + h2 &&
                y1 + h1 > y2;
    }
}
