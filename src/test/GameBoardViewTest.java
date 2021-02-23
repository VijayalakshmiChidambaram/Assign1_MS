package test;

import main.GameBoardView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* GameBoardViewTest Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 23, 2021</pre> 
* @version 1.0 
*/ 
public class GameBoardViewTest {

@Test
public void checkBoardDimensions() throws Exception {
    GameBoardView view = new GameBoardView();
    //Test for lower limit on board dimensions
    assertEquals(view.isValidCellPosition(-1,0), false);
    assertEquals(view.isValidCellPosition(-1,-1), false);
    assertEquals(view.isValidCellPosition(0,-1), false);
    assertEquals(view.isValidCellPosition(0,0), true);

    //Test for upper limit on board dimensions
    assertEquals(view.isValidCellPosition(10,9), false);
    assertEquals(view.isValidCellPosition(10,10), false);
    assertEquals(view.isValidCellPosition(9,10), false);
    assertEquals(view.isValidCellPosition(9,9), true);
} 

} 
