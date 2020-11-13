package main;

import java.util.Scanner;

public class PlayerInput {

  public PlayerInput() {

  }

  public int[] getMoveCoordinate(int playerNo) {
    System.out.println("Player " + playerNo + ": Please input your next move position(e.g. by entering 1,2 to place in row 1, column 2): ");
    Scanner in = new Scanner(System.in);
    String currentMoveCoordinate = in.nextLine();
    System.out.println("You entered position: (" + currentMoveCoordinate + ")" );
    String[] coordinates = currentMoveCoordinate.split(",");
    int[] coordinateArr = new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};
    return coordinateArr;
  }

}
