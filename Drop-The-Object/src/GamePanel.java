import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePanel extends JPanel
{
    private App frame;

    public GamePanel(App frame)
    {
        this.frame=frame;

        this.setBackground(new Color(11, 26, 54));
        this.setMaximumSize(new Dimension(800, 500));

        JLabel startLabel=new JLabel("Drop   The   Object"/*/"<html>" +
                            "<span style='font-size:50px;'>DROP</span><br>" +
                            "<span style='font-size:20px;'>THE</span><br>" +
                            "<span style='font-size:45px;'>OBJECT</span>" +
                            "</html>"*/
                            );
        startLabel.setHorizontalAlignment(JLabel.CENTER);
        startLabel.setVerticalAlignment(JLabel.CENTER);


        startLabel.setForeground(new Color(0, 220, 0)); 
        startLabel.setFont(new Font("ARIAL",Font.BOLD,40));
        startLabel.setBounds(190, 80, 400, 300);
        startLabel.setVerticalAlignment(SwingConstants.TOP);

        JButton startButton=new JButton("START");
        startButton.setPreferredSize(new Dimension(100,250));
        startButton.setBackground(new Color(120, 90, 200));
        startButton.setFont(new Font("ARIAL",Font.BOLD,20));
        startButton.setFocusable(false);
        startButton.setBounds(320, 300, 100, 40);

          
        startButton.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    frame.switchPanel();
                    System.out.println("Click!!!");
                }
             });
            
        this.setLayout(null);
        this.add(startLabel);
        this.add(startButton);
    }

   @Override
    protected void paintComponent(Graphics g) 
    {
            ImageIcon bkg = new ImageIcon(getClass().getResource("/giphy.gif"));
            super.paintComponent(g);
            g.drawImage(bkg.getImage(),0,0,getWidth(),getHeight(),this);  // Draw the GIF at top-left corner      
    }
}
