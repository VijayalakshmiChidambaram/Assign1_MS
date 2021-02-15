import javax.swing.*;
import java.awt.*;

public class GameBoardView {

    public static void main (String[] args)
    {
        //Create a new Frame(GameBoard)
        JFrame frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setSize(350,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        //Creating a matrix of 100 cells
        panel.setLayout(new GridLayout(10,10,0,0));
        for (int i =0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                JButton button = new JButton();
                panel.add(button);
                button.setBackground(Color.lightGray);
            }
        }

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(panel);
        frame.setVisible(true);

    }

    }
