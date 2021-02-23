package main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmptyCell extends JCellsButton  implements MouseListener {

    private boolean pressed = false;

    public EmptyCell(int x, int y) {
        super(x, y);
        this.cellstate = CellState.UNSEALED;
        this.isMined = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.getModel().setPressed(true);
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.getModel().setPressed(false);
        if (pressed) {
            EmptyCell emptyCell = (EmptyCell) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                if (emptyCell.cellstate == CellState.UNSEALED) {
                    emptyCell.cellstate = CellState.SEALED;
                    emptyCell.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/sealedflag.jpg"));
                    emptyCell.setSize(30,30);
                } else {
                    emptyCell.cellstate = CellState.UNSEALED;
                    emptyCell.setEnabled(true);
                    emptyCell.setIcon(null);
                }
            }
            else {
                //Add event to expose the cells
                if (emptyCell.cellstate == CellState.SEALED)
                    emptyCell.setEnabled(false);
                else {
                    emptyCell.cellstate = CellState.EXPOSED;
                    emptyCell.setEnabled(false);
                }
            }
        }
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        pressed = false;
    }

}
