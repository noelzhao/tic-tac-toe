package test;

import main.GameBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {

  @Test
  public void getInstanceTest() {
    GameBoard gameBoard1 = GameBoard.getInstance(5);
    GameBoard gameBoard2 = GameBoard.getInstance(4);
    assertNotNull(gameBoard1);
    assertNull(gameBoard2);
  }

  @Test
  public void printGameBoardTest() {
    GameBoard gameBoard = GameBoard.getInstance(3);
    gameBoard.printGameBoard(new int[]{0, 0}, 1);
    gameBoard.printGameBoard(new int[]{2, 0}, 2);
    gameBoard.printGameBoard(new int[]{1, 1}, 1);
  }

}