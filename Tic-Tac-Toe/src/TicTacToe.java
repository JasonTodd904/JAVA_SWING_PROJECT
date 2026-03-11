import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe 
{
  int board_width=500;
  int board_height=500;


   JFrame frame=new JFrame("Tic-Tac-Toe");
   JPanel board_panel=new JPanel();
   JPanel panel=new JPanel();
   JLabel label=new JLabel();
   JButton[][] button=new JButton[3][3];

   String playerX="X";
   String playerY="O";
   String curr_player=playerX;
   Boolean gameOver=false;
   int turns=0;

    public TicTacToe() 
    {
      frame.setSize(board_width, board_height);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new BorderLayout());

      label.setText("Tic-Tac-Toe");
      label.setBackground(Color.BLACK);
      label.setForeground(Color.white);
      label.setFont(new Font("ARIAL",Font.BOLD,30));
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setOpaque(true);

      board_panel.setLayout(new GridLayout(3, 3));
      board_panel.setBackground(Color.BLACK);
      //board_panel.setBorder(new LineBorder(Color.WHITE,1));

      panel.setLayout(new BorderLayout());
      panel.add(label);
      frame.add(panel,BorderLayout.NORTH);
      frame.add(board_panel);

      for(int row=0;row<3;row++)
        for(int col=0;col<3;col++)
        {
          JButton tile=new JButton();
          tile.setBorder(new LineBorder(Color.WHITE,2));
          tile.setBackground(Color.BLACK);
          button[row][col]=tile;
          board_panel.add(tile);

          tile.setFocusable(false);
          tile.addActionListener(new ActionListener() 
          {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                  if(gameOver)
                    return;

                  if(e.getSource()==tile)
                  {
                    if(tile.getText() == "")
                    {
                    tile.setText(curr_player);
                    tile.setFont(new Font("ARIAL",Font.BOLD,30));
                    tile.setForeground(Color.WHITE);
                    System.out.println("Click!!"); 
                    check();
                    changePlayer();  
                      if(turns==9)
                      {
                        System.out.println("IT'S A TIE");
                        return;
                      }
                    }
                  }
              }
            });
          }
      frame.setVisible(true);
    }

    public void changePlayer()
    {
      if(curr_player == "X")
        curr_player=playerY;
      else if(curr_player == "O")
        curr_player=playerX;
      turns++;
    }

    public void check()//check who wins
    {

       //if(!isBoardFull())   
      // {
          //horizontal
            for(int i=0;i<3;i++)
            {
              if(button[i][0].getText()=="")
                continue;

              if(button[i][0].getText() == button[i][1].getText() && button[i][0].getText()==button[i][2].getText())
                  gameOver=true;
            }

            //vertical
            for(int j=0;j<3;j++)
            {
              if(button[0][j].getText()=="")
                continue;

              if(button[0][j].getText() == button[1][j].getText() && button[0][j].getText()==button[2][j].getText())
                gameOver=true;
            }

            //diagonally
            int k=0;
              if(button[k][0].getText() != "")
                  if(button[k][k].getText() == button[k+1][k+1].getText() && button[k][0].getText()==button[k+2][k+2].getText())
                      gameOver=true;
            int l=2;
              if(button[0][l].getText() != "")
                  if(button[0][l].getText() == button[l-1][l-1].getText() && button[0][l].getText()==button[l][0].getText())
                      gameOver=true;
      }
}