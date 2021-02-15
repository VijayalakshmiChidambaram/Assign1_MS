import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private static JFrame frame;
    private static String gameTitle;
    int piece;

    public GameWindow(int height, int width, int grid_size, String gameTitle, GameBoardView game) {
        GameWindow.gameTitle = gameTitle;
        frame = new JFrame(gameTitle);
        frame.setPreferredSize(new Dimension(height, width));
        frame.setMinimumSize(new Dimension(height, width));
        frame.setMaximumSize(new Dimension(height, width));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Add a layout manager

       /* int col = 10;
        int row = 10;

      JButton[][] button = new JButton[row][col];
       for(int i = 0; i <= row; i++) {
                for (int j = 0; j <= col ; j++) {
                    button[i][j] = new JButton();
                    button[i][j].setSize(frame.getHeight() / col, frame.getWidth() / row);
                    frame.add(button[i][j]);
                    button[i][j].setLocation(j * frame.getHeight() / col, i * frame.getWidth() / row);
                    frame.add(panel);
                    //frame.pack();
                    frame.setVisible(true);
                }

                                          }

        JButton[][] button = new JButton[row][col];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                button[i][j] = new JButton();
            }
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                panel.add(button[i][j]);

            }
        }
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); */
    }

}