package test;

import main.CellState;
import main.MinedCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* MinedCellStateAnalyzer Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 22, 2021</pre> 
* @version 1.0 
*/
public class MinedCellStateAnalyzerTest {

    @Test
    public void testCellState() throws Exception {
        MinedCell minedCell = new MinedCell(0,0);
        assertEquals(minedCell.getCellstate(), CellState.UNSEALED);
    }

    @Test
    public void testSetCellPosition() throws Exception {
        MinedCell minedCell = new MinedCell(-1,-1);
        assertEquals(minedCell.getPositionX(), 0);
        assertEquals(minedCell.getPositionY(), 0);
    }

    @Test
    public void testIsMined() throws Exception {
        MinedCell minedCell = new MinedCell(0,0);
        assertEquals(minedCell.isMined(), true);
    }

    @Test
    public void testGetAdjMinedCellCount() throws Exception {
        MinedCell minedCell = new MinedCell(0,0);
        assertEquals(minedCell.getAdjacentMinedCellCount(), 0);
    }
}
