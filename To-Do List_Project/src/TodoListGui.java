import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TodoListGui extends JPanel
{
    JPanel headerPanel=new JPanel();
    JLabel label=new JLabel("To-Do-List");
    JButton button;
    JTextArea textArea;

    public TodoListGui() 
    {    
        this.setBackground(Color.black);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 25));
        textArea.setMaximumSize(new Dimension(300, 25));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(new EmptyBorder(5,5,5,5));
        this.add(textArea);
    }

    public Component header() 
    {   
        label.setFont(new Font("Arial",Font.BOLD,30));
        label.setBackground(Color.GRAY);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        headerPanel.setBorder((new LineBorder(Color.lightGray, 10)));
        headerPanel.setPreferredSize(new Dimension(100,80));
        headerPanel.add(label, BorderLayout.CENTER);
        return headerPanel;
    }

    public Component taskbutton()
    {
        button=new JButton("ADD TASK");
        button.setBorder(new EmptyBorder(10,10,10,10));
        button.setBorder(new LineBorder(Color.lightGray,10));
        button.setFocusable(false);

        button.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.BLACK);
            }
            
        });

        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
               check();
               System.out.println("click");
            }
            
        });
        return button;   
    }

    public void check() 
{
    String text = textArea.getText().trim();
    if (text.isEmpty()) return;

    JCheckBox checkBox = new JCheckBox();
    JLabel taskLabel = new JLabel(text); // fixed here
    checkBox.setBackground(Color.BLACK);    
    checkBox.setBorder(new LineBorder(Color.red,2));
    checkBox.setOpaque(true);
    taskLabel.setBackground(Color.WHITE);
    taskLabel.setOpaque(true);

    final String originalText = text;

    checkBox.addActionListener(e -> {
        if (checkBox.isSelected()) {
            taskLabel.setText("<html><strike>" + originalText + "</strike></html>");
        } else {
            taskLabel.setText(originalText);
        }
    });

    JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    taskPanel.setBackground(Color.black);
    taskPanel.setMaximumSize(new Dimension(340, 30));
    taskPanel.setBorder(new LineBorder(Color.BLACK,5));
    taskPanel.setBackground(Color.black);

    taskPanel.add(checkBox);
    taskPanel.add(taskLabel); 

    this.add(taskPanel);
    this.revalidate();
    this.repaint();

    textArea.setText("");
    textArea.requestFocusInWindow();
}
}
