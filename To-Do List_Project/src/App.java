import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                TodoListGui gui = new TodoListGui();
                JFrame frame = new JFrame("TO-DO-List");
                frame.setLayout(new BorderLayout());
                frame.setPreferredSize(new Dimension(350,520));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.getContentPane().add(gui.header(),BorderLayout.NORTH);
                frame.getContentPane().setBackground(Color.black);
                frame.add(gui.taskbutton(),BorderLayout.SOUTH);
                frame.add(gui);
                frame.setVisible(true);
            }
        });
    }
}
