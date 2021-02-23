package main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Random;

public class GameBoardView {

    private JFrame frame;
    private JCellsButton [][] allCells = new JCellsButton[10][10];

    public static void main(String[] args) {
        GameBoardView game = new GameBoardView();
        game.score();
        game.gameStatus();
    }

    public boolean isValidCellPosition(int row, int col)
    {
        if(row < 0 || col < 0 || row > 9 || col > 9)
            return false;
        return true;
    }

    private boolean isAdjMinedCell(JCellsButton cell) {
        return cell.isMined;
    }

    //Create a new Frame(GameBoard) and grid
    public GameBoardView() {

        frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        //Creating a matrix of 100 cells
        panel.setLayout(new GridLayout(10, 10, 0, 0));

        //Randomly generate Mined cells
        Random r = new Random();
        for(int i = 0; i<20; ++i){
            int row = r.nextInt(9);
            int col = r.nextInt(9);
            MinedCell minedCell = new MinedCell(row,col);
            minedCell.addMouseListener(minedCell);
            minedCell.setBackground(Color.lightGray);
            allCells[row][col] = minedCell;
        }

        //Calculate the Adjacent cells and set all other cells to Empty cells
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //Set only those locations that are not mined cells
                if(allCells[i][j]==null) {
                    int count = 0;
                    for(int k=-1; k<2; ++k){
                        for(int l=-1; l<2; ++l){
                            //Validation check for cell index going out of bounds
                            if(isValidCellPosition(i+k, j+l)){
                                if(allCells[i+k][j+l] == null){
                                    //Set any null locations to Empty cells
                                    EmptyCell emptyCell = new EmptyCell((i+k),(j+l));
                                    emptyCell.addMouseListener(emptyCell);
                                    emptyCell.setBackground(Color.lightGray);
                                    allCells[i+k][j+l] = emptyCell;
                                }
                                else{
                                    if(isAdjMinedCell(allCells[i+k][j+l])){
                                        count += 1;
                                    }
                                }
                            }
                        }
                    }
                    //If found any adjacent mined cells, set the count on the cell
                    if(count>0){
                        AdjacentCell adjacentCell = new AdjacentCell(i,j);
                        adjacentCell.adjacentMinedCellCount = count;
                        adjacentCell.addMouseListener(adjacentCell);
                        adjacentCell.setBackground(Color.lightGray);
                        allCells[i][j] = adjacentCell;
                    }
                }
            }
        }

        //Add all the cells to the panel
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                panel.add(allCells[i][j]);
            }
        }

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

    //Create a score board and Reset button at the top of the screen
    public void score()
    {
        JPanel scorePanel = new JPanel();
        scorePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        frame.add(scorePanel, BorderLayout.NORTH);
        scorePanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        JLabel scoreLabel = new JLabel("SCORE :");
        scorePanel.add(scoreLabel);

        JButton reset = new JButton("RESET");
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(reset, BorderLayout.EAST);
        scorePanel.add(bottomPanel, BorderLayout.PAGE_END);
    }

    //Create a status Label to be display the Game Status - WIN/LOSE
    public void gameStatus()
    {
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 30));
        JLabel statusLabel = new JLabel("Status");
        statusPanel.add(statusLabel);
        //statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //statusLabel.setVerticalAlignment(SwingConstants.CENTER);
        frame.setVisible(true);
    }
}
