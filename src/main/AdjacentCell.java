package main;

public class AdjacentCell extends JCellsButton {

    AdjacentCell(int x, int y) {
        super(x, y);
    }

    private boolean isValidMinedCell(JCellsButton cell) {
        return cell.isMined;
    }

    public void getAdjacentMinedCells(JCellsButton[][] cellArray, JCellsButton cell) {
        int x = cell.positionX;
        int y = cell.positionY;
        int count = cell.adjacentMinedCellCount;
        for(int i=-1; i<2; ++i) {
            for (int j = -1; j < 2; ++j){
                if(isValidMinedCell(cellArray[x+i][y+j])){
                    count = count+1;
                }
            }
        }
        cell.adjacentMinedCellCount = count;
    }
}
