import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class basic 
{
    public static void main(String args[])
    {
        Border border=BorderFactory.createLineBorder(Color.green,4);

        JLabel label=new JLabel();
        label.setText("Here comes the Text");
        //FOR THE TEXT
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.GREEN);//set text color
        label.setFont(new Font("Arial",Font.BOLD,20));//set text font,type and size
       // label.setHorizontalAlignment(SwingConstants.CENTER);//sets text in centre of window

       //IMAGE
       label.setIconTextGap(-25);
       label.setBackground(Color.BLACK);
       label.setOpaque(true);
       //sets position of icon + image
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment(JLabel.CENTER);
       //Border
       label.setBorder(border);
       //sets label co ordinates
       label.setBounds(10, 10, 250, 250);
        
        JFrame frame=new JFrame();
        frame.setTitle("JFRAME TITLE");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes window on clicking X
     //   frame.setResizable(false);
        frame.setLayout(null);//sets label to certain co-ordinate using setBounds  as in line 34
        frame.add(label);//adds label to layout 
        //frame.pack();//to make window the size of content,always write after add label
        
        ImageIcon image=new ImageIcon("C:\\Users\\KIIT0001\\Desktop\\OTHERS\\image\\six.jpg");
        frame.setIconImage(image.getImage());  //change frame icon  
        label.setIcon(image);
       // frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setBackground(new Color(0,0,0));

        new Button();
    }
}