package main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Random;

public class GameBoardView<cells> {

    private JFrame frame;
    private static JCellsButton [][] cells = new JCellsButton[10][10];

    public static void main(String[] args) {
        GameBoardView game = new GameBoardView();
        game.gameStatus();
        generateRandomMinedCells(20);
    }

    private static void generateRandomMinedCells(int n)
    {
        Random r = new Random();
        for(int i = 0; i<n; ++i){
            int row = r.nextInt(9);
            int col = r.nextInt(9);
            JCellsButton button = cells[row][col];
            button.isMined = true;
        }
    }

    public GameBoardView() {
        //Create a new Frame(GameBoard)
        frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        //Creating a matrix of 100 cells
        panel.setLayout(new GridLayout(10, 10, 0, 0));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JCellsButton button = new JCellsButton(i,j);
                button.addMouseListener(button);
                cells[i][j] = button;
                panel.add(button);
                button.setBackground(Color.lightGray);
            }
        }

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void gameStatus()
    {
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 30));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        frame.setVisible(true);
    }
}
