package main;

public class GameBoard {
  private int gameBoardSize;
  private String[][] gameboardContent;
  private static GameBoard gameboard;

  private GameBoard (int gameBoardSize) {
    this.gameBoardSize = gameBoardSize;
    this.gameboardContent = new String[gameBoardSize][gameBoardSize];
  }

  public static GameBoard getInstance(int gameBoardSize) {
    if (gameboard == null) {
      gameboard = new GameBoard(gameBoardSize);
      System.out.println("Create success: gameBoardSize = " + gameBoardSize);
      return gameboard;
    }
    System.out.println("Create failed: You already had a gameBoard instance");
    return null;
  }

  private void fillGameBoardContent(int[] newMoveCoordinate, int newMovePlayerNo) {
    String sign = newMovePlayerNo == 1 ? "X" : "O";
    this.gameboardContent[newMoveCoordinate[0]][newMoveCoordinate[1]] = sign;
  }

  public void initiateGameBoard() {
    for (int rowIdx = 0; rowIdx < this.gameBoardSize; rowIdx++) {
      System.out.print(" | ");
      for (int columnIdx = 0; columnIdx < this.gameBoardSize; columnIdx++) {
        System.out.print(" ");
        System.out.print(" | ");
      }
      System.out.println();
    }
  }

  public void printGameBoard(int[] newMoveCoordinate, int newMovePlayerNo) {

    fillGameBoardContent(newMoveCoordinate, newMovePlayerNo);

    for (int rowIdx = 0; rowIdx < this.gameBoardSize; rowIdx++) {
      System.out.print(" | ");
      for (int columnIdx = 0; columnIdx < this.gameBoardSize; columnIdx++) {
        if (this.gameboardContent[rowIdx][columnIdx] == null) {
          System.out.print(" ");
        } else {
          System.out.print(this.gameboardContent[rowIdx][columnIdx]);
        }
        System.out.print(" | ");
      }
      System.out.println();
    }
  }

}
