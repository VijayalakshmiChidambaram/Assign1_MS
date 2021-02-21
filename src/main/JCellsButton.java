package main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JCellsButton extends JButton implements MouseListener {
    CellState cellstate;
    int positionX;
    int positionY;
    int adjacentMinedCellCount;
    boolean isMined;
    private boolean pressed = false;

    JCellsButton(int x, int y)
    {
        this.cellstate = CellState.UNSEALED;
        this.positionX = x;
        this.positionY = y;
        this.adjacentMinedCellCount = 0;
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
            JCellsButton btn = (JCellsButton) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                if (btn.cellstate == CellState.UNSEALED) {
                    btn.cellstate = CellState.SEALED;
                    btn.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/sealedflag.jpg"));
                    btn.setSize(30,30);
                    btn.disable();
                } else {
                    btn.cellstate = CellState.UNSEALED;
                    btn.enable();
                    btn.setIcon(null);
                }
            } else {
                //Add event to expose the cells
                if (btn.cellstate == CellState.SEALED)
                    btn.disable();
                else {
                    btn.enable();
                    btn.cellstate = CellState.EXPOSED;
                    if (btn.isMined) {
                        btn.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/mines.jpg"));
                        btn.setSize(30,30);
                    }
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
