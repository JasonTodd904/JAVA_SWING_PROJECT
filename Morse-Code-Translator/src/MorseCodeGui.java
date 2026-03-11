import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class MorseCodeGui extends JFrame implements KeyListener
{
    private MorseCodeController controller;

    private JTextArea inputText,morseCode;
    public MorseCodeGui()
    {
        super("Morse Code Translator");
        this.setResizable(false);
        this.setSize(460,560);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.black);
        this.setLocationRelativeTo(null);

        addComponents();

        controller=new MorseCodeController();
    }

    private void addComponents()
    {
        JLabel label=new JLabel("Morse Code Translator");
        label.setFont(new Font("Arial",Font.BOLD,30));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0,460,100);
        this.add(label);

        //text Input by user
        JLabel text=new JLabel("Text");
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,15));
        text.setBounds(20, 100, 200, 30);

        inputText = new JTextArea();
        inputText.setFont(new Font("Arial",Font.ITALIC,15));
        //creates padding around input box
        inputText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //makes it so that line wraps around whenm reaches end of box
        inputText.setLineWrap(true);
        //makes sure words dont split when wrapped
        inputText.setWrapStyleWord(true);
        inputText.addKeyListener(this);//makes it so that we listen for keys in this box

        //add scrolling ability to input area
        JScrollPane scroll=new JScrollPane(inputText);
        scroll.setBounds(20,132,410,150);
        
//**************************************************************************************************//
        JLabel morseText=new JLabel("Morse Code");
        morseText.setForeground(Color.white);
        morseText.setFont(new Font("Arial",Font.ITALIC,15));       
        morseText.setBounds(20,308,200,30);
        
        morseCode=new JTextArea();
        morseCode.setFont(new Font("Arial",Font.ITALIC,15));
        morseCode.setEditable(false);
         //creates padding around input box
        morseCode.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //makes it so that line wraps around whenm reaches end of box
        morseCode.setLineWrap(true);
        //makes sure words dont split when wrapped
        morseCode.setWrapStyleWord(true);

        JScrollPane morseCodeScroll=new JScrollPane(morseCode);
        morseCodeScroll.setBounds(20,350,410,150);        

        this.add(label);       
        this.add(text);       
        this.add(scroll);
        this.add(morseText);
        this.add(morseCodeScroll);       
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()!=KeyEvent.VK_SHIFT)
        {
            String t=inputText.getText();
            morseCode.setText(controller.translate(t));
        }
    }
}
