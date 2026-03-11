import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Button extends JFrame implements ActionListener
{
     JButton button;
     JLabel label;
    Button()
    {
        button=new JButton();
        label=new JLabel();
        button.setBounds(400,400,80,40);   
        button.addActionListener(this);//listens to response
        button.setText("Button");//displays text on button
        button.setForeground(Color.red);//sets text color within button
        button.setFocusable(false);//removes border around text
        //can add image by using image icon

        ImageIcon icon=new ImageIcon("C:\\Users\\KIIT0001\\Desktop\\OTHERS\\image\\six.jpg");
        label.setIcon(icon);
        label.setBounds(150,150,200,200);
        label.setVisible(false);

            this.setSize(500,500);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes window on clicking X
            this.setLayout(null); 
            this.add(button);
            this.add(label);            
    }

    @Override
   public void actionPerformed(ActionEvent e) //throws new UnsupportedOperationException("Not supported yet.");
    {
        
        if(e.getSource()==button)
        {
            System.out.println("Button Clicked!!!");
            button.setEnabled(false);//if button is clicked once it gets disabled
            label.setVisible(true);
        }
    }
}
