package main;

import javax.swing.*;

public abstract class JCellsButton extends JButton{

    CellState cellstate;
    int positionX;
    int positionY;
    int adjacentMinedCellCount;
    boolean isMined;

    JCellsButton(int x, int y)
    {
        setCellstate(CellState.UNSEALED);
        setPositionX(x);
        setPositionY(y);
        setAdjacentMinedCellCount(0);
        setMined(false);
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX < 0 ? 0 : positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY < 0 ? 0 : positionY;
    }

    public int getAdjacentMinedCellCount() {
        return adjacentMinedCellCount;
    }

    public void setAdjacentMinedCellCount(int adjacentMinedCellCount) {
        this.adjacentMinedCellCount = adjacentMinedCellCount;
    }

    public boolean isMined() {
        return isMined;
    }

    public void setMined(boolean mined) {
        isMined = mined;
    }
}
