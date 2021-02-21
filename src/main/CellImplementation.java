package main;

public interface CellImplementation {
    void setCellState(CellState cellstate);
    CellState getCellState();

    void getCellPositon(int x, int y);
}
