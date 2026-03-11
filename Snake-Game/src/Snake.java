import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class Snake extends JPanel implements ActionListener,KeyListener//if u extend JPanel that means now this class itself is JPanel hence we use this keyword to refer to instance of this class
{

    private class Tile
    {
        int x;
        int y;

        public Tile(int x, int y) 
        {
            this.x = x;
            this.y = y;
        }

    }

    int window_height=600;
    int window_width=600;
    int tileSize=25;
    int velocityX;
    int velocityY;
    Boolean gameOver=false;

    JFrame frame=new JFrame("Snake Game");
    JLabel label=new JLabel();
    JPanel gamePanel=new JPanel();

    Tile snake;//SNAKE

    Tile food;//FOOD

    Random random;//for FOOD

    Timer gameloop;

    ArrayList<Tile> snakebody;
    public Snake() 
    {
        frame.setSize(window_width, window_height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(window_width,window_height));//hint of how big u want it to be
       // frame.setLayout(new BorderLayout());

        //label for game over pannel
       gamePanel.setLayout(new BorderLayout());
       label.setBackground(Color.gray);
       label.setText("Game Over");
       label.setFont(new Font("ARIAL",Font.BOLD,30));
       label.setForeground(Color.white);
       label.setHorizontalAlignment(JLabel.CENTER);
       label.setVisible(true);
       label.setOpaque(true);
       gamePanel.setBackground(Color.black);
       gamePanel.add(label,BorderLayout.CENTER);

        velocityX=0;
        velocityY=0;

        snake =new Tile(5,5);
        food =new Tile(10,10);
        random=new Random();
        placeFood();
        addKeyListener(this);//add key listener to JPanel that is Snake class(Snake game)
        setFocusable(true);

        snakebody = new ArrayList<Tile>();

        gameloop=new Timer(100, this);
        gameloop.start();

        setBackground(Color.BLACK);
        frame.add(this);
        frame.pack();//ill adjust myself to fit the needs
        frame.setVisible(true);
       
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g); 
    }

    public void draw(Graphics g)
    {
        //grid
        for(int i=0;i<24;i++)
        {
            g.drawLine(i*tileSize, 0, i*tileSize, window_height);
            g.drawLine(0, i*tileSize, window_width, i*tileSize);
        }
        //snake head
        g.setColor(Color.green);
        g.fillRect(snake.x*tileSize, snake.y*tileSize, tileSize, tileSize);  

        //food
        g.setColor(Color.red);
        g.fillOval(food.x*tileSize, food.y*tileSize, tileSize, tileSize);

        //snakebody
        for(int i=0;i<snakebody.size();i++)
        {
            Tile newPart=snakebody.get(i);
            g.setColor(Color.green);
            g.fillRect(newPart.x*tileSize, newPart.y*tileSize, tileSize, tileSize);
        }
    }

    public void placeFood()
    {
        food.x=random.nextInt(window_width/tileSize);
        food.y=random.nextInt(window_height/tileSize);
    }

    public boolean collision(Tile tile1,Tile tile2)
    {
        return tile1.x==tile2.x && tile2.y==tile1.y;
    }

    public void movesnake()
    {
        //check if there is collision
        if(collision(snake, food))
        {
            snakebody.add(new Tile(food.x, food.y));
            placeFood();
        }

        //move snake body
        for(int i=snakebody.size()-1;i>=0;i--)//normal array stuff in reverse as we move from tail to head
        {
            Tile snakepart=snakebody.get(i);
            if(i==0)//if only one element exists then add the element and give it position of head and then increment head by 1
            {
                //giving position of head
                snakepart.x=snake.x;
                snakepart.y=snake.y;
            }
            else
            {
                //each segment moves to the position of the segment directly in front of it
                Tile prevSnake=snakebody.get(i-1);
                snakepart.x=prevSnake.x;
                snakepart.y=prevSnake.y;
            }
        }

        //increment head by velocity(1)
        snake.x+=velocityX;
        snake.y+=velocityY;

        //game over conditions
            //hits own body
        for(int i=0;i<snakebody.size();i++)
        {
            Tile snakepart=snakebody.get(i);
            if(collision(snake, snakepart))
                gameOver=true;
        }
            //out of bounds
        if(snake.x*tileSize < 0 || snake.x*tileSize > window_width || snake.y*tileSize < 0 || snake.y*tileSize>window_height)
            gameOver=true;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        movesnake();
        repaint();
       if(gameOver==true)
       {
           gameloop.stop();
           //add new panel that says game over
           frame.getContentPane().removeAll();
           frame.getContentPane().add(gamePanel);
           frame.revalidate();
           frame.repaint();
       }
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_UP && velocityY != 1)
        {
            velocityX=0;velocityY-=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN && velocityY !=-1)
        {
            velocityX=0;velocityY+=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT && velocityX != 1)
        {
            velocityX-=1;velocityY=0;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT && velocityX != -1)
        {
            velocityX+=1;velocityY=0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
