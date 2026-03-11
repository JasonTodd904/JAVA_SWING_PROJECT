
import javax.swing.SwingUtilities;


public class App {
    public static void main(String[] args) throws Exception 
    {
        SwingUtilities.invokeLater(new Runnable() //ensures that gui nis updated in thread safe manner
        {
            public void run()
            {
                 new MorseCodeGui().setVisible(true);
            }  
        });
    }
}
