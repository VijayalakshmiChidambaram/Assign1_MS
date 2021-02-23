package test;

import main.CellState;
import main.AdjacentCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* AdjacentCellStateAnalyzer Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 22, 2021</pre> 
* @version 1.0 
*/ 
public class AdjacentCellStateAnalyzerTest {

    @Test
    public void testCellState() throws Exception {
        AdjacentCell adjacentCell = new AdjacentCell(0,0);
        assertEquals(adjacentCell.getCellstate(), CellState.UNSEALED);
    }

    @Test
    public void testSetCellPosition() throws Exception {
        AdjacentCell adjacentCell = new AdjacentCell(-1,-1);
        assertEquals(adjacentCell.getPositionX(), 0);
        assertEquals(adjacentCell.getPositionY(), 0);
    }

    @Test
    public void testIsMined() throws Exception {
        AdjacentCell adjacentCell = new AdjacentCell(0,0);
        assertEquals(adjacentCell.isMined(), false);
    }

    @Test
    public void testGetAdjMinedCellCount() throws Exception {
        AdjacentCell adjacentCell = new AdjacentCell(0,0);
        assertEquals(adjacentCell.getAdjacentMinedCellCount(), 0);
    }
} 
