package main;

import java.util.LinkedList;
import java.util.List;

public class TicTacToe {
  private int[] rows;
  private int[] columns;
  private int diagonal;
  private int antiDiagonal;
  private int gameBoardSize;
  private List<int[]> movesHistory;

  public TicTacToe(int gameBoardSize) {
    this.rows = new int[gameBoardSize];
    this.columns = new int[gameBoardSize];
    this.gameBoardSize = gameBoardSize;
    this.movesHistory = new LinkedList<>();
  }

  /**
   * The current player makes a move at the coordinate of
   * (currentStepRowIdx, currentStepColumnIdx)
   * @param playerNo is player's number, 1 or 2
   * @param currentMoveRowIdx is current move row index
   * @param currentMoveColumnIdx is current move column index
   * @return the game state after current move:
   *         0 - game continue
   *         1 - player 1 win
   *         2 - player 2 win
   *         4 - draw
   */
  public int move(int playerNo, int currentMoveRowIdx, int currentMoveColumnIdx) {
    this.movesHistory.add(new int[]{currentMoveRowIdx, currentMoveColumnIdx});
    int currentMoveAdd = playerNo == 1 ? 1: -1;

    this.rows[currentMoveRowIdx] += currentMoveAdd;
    this.columns[currentMoveColumnIdx] += currentMoveAdd;
    if (currentMoveRowIdx == currentMoveColumnIdx) {
      this.diagonal += currentMoveAdd;
    }
    if (currentMoveRowIdx + currentMoveColumnIdx == this.gameBoardSize - 1) {
      this.antiDiagonal += currentMoveAdd;
    }

    if (movesHistory.size() == this.gameBoardSize * this.gameBoardSize) {
      return 4;
    } else if (Math.abs(this.rows[currentMoveRowIdx]) == this.gameBoardSize
        || Math.abs(this.columns[currentMoveColumnIdx]) == this.gameBoardSize
        || Math.abs(diagonal) == this.gameBoardSize
        || Math.abs(antiDiagonal) == this.gameBoardSize
    ) {
      return playerNo;
    }
    return 0;
  }

  public void startGame() {
    GameBoard gameBoard = GameBoard.getInstance(this.gameBoardSize);
    PlayerInput playerInput = new PlayerInput();
    gameBoard.initiateGameBoard();
    boolean isPlayerOne = true;
    int gameState = 0;
    while (gameState == 0) {
      int currentPlayerNo = isPlayerOne ? 1 : 2;
      int[] currentMoveCoordinate = playerInput.getMoveCoordinate(currentPlayerNo);
      gameState = move(currentPlayerNo, currentMoveCoordinate[0], currentMoveCoordinate[1]);
      gameBoard.printGameBoard(currentMoveCoordinate, currentPlayerNo);
      isPlayerOne = !isPlayerOne;
    }
    if (gameState == 1) {
      System.out.println("Player 1 win!");
      return;
    } else if (gameState == 2) {
      System.out.println("Player 2 win!");
      return;
    }
    System.out.print("Draw, good game!");
  }
}
