package main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MinedCell extends JCellsButton  implements MouseListener {

    private boolean pressed = false;

    public MinedCell(int x, int y) {
        super(x, y);
        this.cellstate = CellState.UNSEALED;
        this.isMined = true;
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
            MinedCell minedCell = (MinedCell) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                if (minedCell.cellstate == CellState.UNSEALED) {
                    minedCell.cellstate = CellState.SEALED;
                    minedCell.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/sealedflag.jpg"));
                    minedCell.setSize(30,30);
                } else {
                    minedCell.cellstate = CellState.UNSEALED;
                    minedCell.setEnabled(true);
                    minedCell.setIcon(null);
                }
            }
            else {
                //Add event to expose the cells
                if (minedCell.cellstate == CellState.SEALED)
                    minedCell.setEnabled(false);
                else {
                    minedCell.setEnabled(true);
                    minedCell.cellstate = CellState.EXPOSED;
                    minedCell.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/mines.jpg"));
                    minedCell.setSize(30,30);
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
