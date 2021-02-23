package test;

import main.EmptyCell;
import main.CellState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/** 
* EmptyCellStateAnalyzerTest Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 22, 2021</pre> 
* @version 1.0 
*/ 
public class EmptyCellStateAnalyzerTestTest {

    @Test
    public void testCellState() throws Exception {
        EmptyCell emptyCell = new EmptyCell(0,0);
        assertEquals(emptyCell.getCellstate(), CellState.UNSEALED);
    }

    @Test
    public void testSetCellPosition() throws Exception {
        EmptyCell emptyCell = new EmptyCell(-1,-1);
        assertEquals(emptyCell.getPositionX(), 0);
        assertEquals(emptyCell.getPositionY(), 0);
    }

    @Test
    public void testIsMined() throws Exception {
        EmptyCell emptyCell = new EmptyCell(0,0);
        assertEquals(emptyCell.isMined(), false);
    }

    @Test
    public void testGetAdjMinedCellCount() throws Exception {
        EmptyCell emptyCell = new EmptyCell(0,0);
        assertEquals(emptyCell.getAdjacentMinedCellCount(), 0);
    }

} 
