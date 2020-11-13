package test;

import main.PlayerInput;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerInputTest {

  @Test
  public void getMoveCoordinateTest() {
    PlayerInput playerInput = new PlayerInput();
    int[] coordinate = playerInput.getMoveCoordinate(1);
    assertArrayEquals(new int[]{1, 2}, coordinate);
  }
}