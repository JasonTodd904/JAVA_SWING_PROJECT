
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JPanel 
{
    private App frame;
    public GameOver(App frame) 
    {
        this.frame=frame;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);
        JLabel label=new JLabel("GAME OVER");
        label.setFont(new Font("ARIAL",Font.BOLD,50));
        label.setVisible(true);
        label.setForeground(Color.black);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label,BorderLayout.CENTER);

        JButton button=new JButton("RESTART");
        button.setFocusable(false);
        this.add(button,BorderLayout.SOUTH);
        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                frame.switchPanel();
            }
        });
    }
}
