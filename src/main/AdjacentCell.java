package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdjacentCell extends JCellsButton  implements MouseListener {

    private boolean pressed = false;

    public AdjacentCell(int x, int y) {
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
            AdjacentCell adjacentCell = (AdjacentCell) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                if (adjacentCell.cellstate == CellState.UNSEALED) {
                    adjacentCell.cellstate = CellState.SEALED;
                    adjacentCell.setIcon(new ImageIcon("/Users/ruchishah/Downloads/sd_svn/assign1/Assign1_MS/images/sealedflag.jpg"));
                    adjacentCell.setSize(30,30);
                } else {
                    adjacentCell.cellstate = CellState.UNSEALED;
                    adjacentCell.setEnabled(true);
                    adjacentCell.setIcon(null);
                }
            }
            else {
                //Add event to expose the cells
                if (adjacentCell.cellstate == CellState.SEALED)
                    adjacentCell.setEnabled(false);
                else {
                    adjacentCell.cellstate = CellState.EXPOSED;
                    adjacentCell.setForeground(Color.BLUE);
                    adjacentCell.setFont(adjacentCell.getFont().deriveFont(Font.BOLD));
                    adjacentCell.setText(String.valueOf(adjacentCell.adjacentMinedCellCount));
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
