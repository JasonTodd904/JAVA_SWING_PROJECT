
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App extends JFrame
{
    final int width=800;
    public static void main(String[] args) throws Exception 
    {   
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new App();
            }
        });
    }

    App()
    {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setBackground(Color.black);
       setPreferredSize(new Dimension(800,500));
       pack();
       setLocationRelativeTo(null);
       setContentPane(new GamePanel(this));
       setVisible(true);
       requestFocusInWindow();
    }

    public void switchPanel()
       {
           PlayPanel pp=new PlayPanel(this);
           this.setContentPane(pp);
           this.revalidate();
           this.repaint();
           this.setVisible(true);
           pp.requestFocusInWindow();
       }
    
    public void gameoverPanel()
    {
        GameOver game=new GameOver(this);
        this.setContentPane(game);
        revalidate();
        repaint();
        setVisible(true);
        game.requestFocusInWindow();
    }
}
