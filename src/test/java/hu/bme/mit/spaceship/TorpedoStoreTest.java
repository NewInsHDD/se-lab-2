package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {
  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  void exceptionTest_1() {
      TorpedoStore torpedoStore = new TorpedoStore(1);
      assertThrowsExactly(IllegalArgumentException.class, () -> torpedoStore.fire(-1));
  }

  @Test
  void exceptionTest_2() {
      TorpedoStore torpedoStore = new TorpedoStore(1);
      assertThrowsExactly(IllegalArgumentException.class, () -> torpedoStore.fire(2));
  }

  @Test
  void zeroFailureTest() {
    TorpedoStore torpedoStore = new TorpedoStore(1, 0.0);
    assertEquals(true, torpedoStore.fire(1));
  }

  @Test
  void multipleShotTest() {
      TorpedoStore torpedoStore = new TorpedoStore(5, 0.0);
      torpedoStore.fire(4);
      assertEquals(1, torpedoStore.getTorpedoCount());
  }

  @Test
  void failureTest() {
      TorpedoStore torpedoStore = new TorpedoStore(5, 1.0);
      assertEquals(false, torpedoStore.fire(4));
  }

  @Test
  void isEmptyTest() {
      TorpedoStore torpedoStore = new TorpedoStore(1, 0.0);
      torpedoStore.fire(1);
      assertEquals(true, torpedoStore.isEmpty());
  }
}
