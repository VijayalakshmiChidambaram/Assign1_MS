package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardView {

    private static List<JCellsButton> cells = new ArrayList<>();

    public static void main(String[] args) {
        drawPanel();
        generateRandomMinedCells(20);
    }

    private static void generateRandomMinedCells(int n)
    {
        Random r = new Random();
        for(int i = 0; i<n; ++i){
            int index = r.nextInt(100);
            JCellsButton button = cells.get(index);
            button.ismined = true;
        }
    }

    public static void drawPanel() {
        //Create a new Frame(GameBoard)
        JFrame frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        //Creating a matrix of 100 cells
        panel.setLayout(new GridLayout(10, 10, 0, 0));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JCellsButton button = new JCellsButton();
                button.addMouseListener(button);
                cells.add(button);
                panel.add(button);
                button.setBackground(Color.lightGray);
            }
        }

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

}
