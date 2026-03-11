import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Calculator 
{
    int window_width=360;
    int window_height=440;

    Color light_gray=new Color(212,212,210);
    Color dark_grey=new Color(80,80,80);
    Color black=new Color(28,28,28);
    Color orange=new Color(255,149,0);

    JLabel label=new JLabel();//put text in the jlabel...the text can't be edited by the user
    JPanel top_panel=new JPanel();//putm jlabel in the jpanel
    JPanel bottom_panel=new JPanel();//panel for the buttons
    JFrame frame=new JFrame("Calculator App");//put the jpanel in the jframe

        String[] buttons = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "=", "√"};
    String[] topSymbols = {"AC", "+/-", "%"};

    //for operation on two numbers A and B//A*b,a+b,A-b etc
    String A="0";
    String operator=null;
    String B=null;

    public Calculator() 
    {
      //frame.setVisible(true);//makes window visible
      frame.setResizable(false);//cant resize the windwow
      frame.setSize(window_width, window_height);//sets frame size to given value
      frame.setLocationRelativeTo(null);//displays the window at centre nof screen
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());//sets componment north south east west in a frame

      label.setBackground(black);//sets background color
      label.setForeground(Color.white);//sets text color
      label.setFont(new Font("Arial",Font.PLAIN,75));//text font
      label.setHorizontalAlignment(JLabel.RIGHT);//displays text on right
      label.setText("0");//sets default text
      label.setOpaque(true);//makes label visible

      top_panel.setLayout(new BorderLayout());
      frame.add(top_panel.add(label),BorderLayout.NORTH);//add label to panel and thenm panel to windows

      bottom_panel.setLayout(new GridLayout(5,4));//makes a grid layout with 5 rows and 4 col
      bottom_panel.setBackground((black));
      frame.add(bottom_panel);

    //  Button listen=new Button();//creates object of button class

      for(int i=0;i<buttons.length;i++)
      {
        JButton button=new JButton();
        String text=buttons[i];
        button.setText(text);
        button.setFocusable(false);//removes box when user clicks on the button

        button.setBorder(new LineBorder(black, 1));//adds border between the buttons

        //conditions to give color of each rows
        if(Arrays.asList(topSymbols).contains(text))
        {
          button.setBackground(light_gray);
          button.setForeground(black);
        }

        else if(Arrays.asList(rightSymbols).contains(text))
        {
          button.setBackground(orange);
          button.setForeground(Color.white);
        }

        else
        {
          button.setBackground(dark_grey);
          button.setForeground(Color.white);
        }

        bottom_panel.add(button);
     //   button.addActionListener(listen);    //uses instance of class that implements ActionListener...here "listen"
        
        button.addActionListener(new ActionListener() 
        {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    JButton button=(JButton)e.getSource();//since we know the source here is button,we type cast object(e source) to JButton
                    String text=button.getText();//gets text from the button that WE set using setText();
                    System.out.println(text);
                          
                  if(Arrays.asList(topSymbols).contains(text))
                  {
                     if(text=="AC")
                     {
                        clearall();
                        label.setText("0");
                     }
                     else if(text=="+/-")
                     {
                        double number=Double.parseDouble(label.getText());
                        number*=-1;
                        label.setText(checkZero(number));
                     }
                     else if(text=="%")
                     {
                        double number=Double.parseDouble(label.getText());
                        number/=100;
                        label.setText(checkZero(number));
                     }
                  }

                  else if(Arrays.asList(rightSymbols).contains(text))
                  {
                    if(text=="=")
                     {                          
                       if(A!=null)    
                          B=label.getText();
                          double numA=Double.parseDouble(A);
                          double numB=Double.parseDouble(B);

                          if(operator == "+")
                            label.setText(checkZero(numA+numB));
                          if(operator == "-")
                            label.setText(checkZero(numA-numB));
                          if(operator == "÷")
                            label.setText(checkZero(numA/numB));
                          if(operator == "×")
                            label.setText(checkZero(numA*numB)); 
                                                       
                     }
                     else if("+-÷×√".contains(text))
                     {
                        if(operator==null)
                        {
                          A=label.getText();
                          label.setText("0");
                          B=null;
                        }
                        operator = text;

                        if(text == "√")
                            label.setText(checkZero((Math.sqrt(Double.parseDouble(A)))));
                     }
                  }

                  else//digits or .
                  {
                      if(text==".")
                      {
                          if(!label.getText().contains(text))
                              label.setText(label.getText()+text);
                      }
                      else if("0123456789".contains(text))
                      {
                          if(label.getText()=="0")
                              label.setText(text);
                          else
                              label.setText(label.getText()+text);//concats the newly pressed string to old one..eg 2+3=23
                      }
                  }
              }
        });   
     }
     frame.setVisible(true);//makes window visible
  }
  
  public void clearall()
  {
    A="0";
    operator=null;
    B=null;
  }

  public String checkZero(double num)
  {
    if(num % 1==0)
      return Integer.toString((int)num);
    return Double.toString(num);
  }
}
