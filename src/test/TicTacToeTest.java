package test;

import main.TicTacToe;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

  @Test
  public void movePlayerOneWinTest() {
    TicTacToe newGame = new TicTacToe(3);
    assertEquals(0, newGame.move(1, 0, 0));
    assertEquals(0, newGame.move(1, 1, 1));
    assertEquals(1, newGame.move(1, 2, 2));
  }

  @Test
  public void movePlayerTwoWinTest() {
    TicTacToe newGame = new TicTacToe(3);
    assertEquals(0, newGame.move(2, 0, 0));
    assertEquals(0, newGame.move(2, 1, 1));
    assertEquals(1, newGame.move(2, 2, 2));
  }

  @Test
  public void moveDrawTest() {
    TicTacToe newGame = new TicTacToe(3);
    assertEquals(0, newGame.move(1, 0, 0));
    assertEquals(0, newGame.move(2, 1, 1));
    assertEquals(0, newGame.move(1, 2, 2));
    assertEquals(0, newGame.move(2, 1, 2));
    assertEquals(0, newGame.move(1, 1, 0));
    assertEquals(0, newGame.move(2, 2, 0));
    assertEquals(0, newGame.move(1, 0, 2));
    assertEquals(0, newGame.move(2, 0, 1));
    assertEquals(4, newGame.move(1, 2, 1));
  }

  @Test
  public void startGameTest() {
    TicTacToe newGame = new TicTacToe(3);
    newGame.startGame();
  }
}