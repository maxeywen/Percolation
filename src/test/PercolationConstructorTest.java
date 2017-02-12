import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationConstructorTest {

  /**
   * The constructor should throw a java.lang.IllegalArgumentException if n <= 0.
   */
  @Test(expected=IllegalArgumentException.class)
  public void testNCantBeLessThan1() {
    Percolation p = new Percolation(-1);
  }

  /**
   * Test to make sure constructor returns an object
   */
  @Test
  public void testConstructorReturnsObject() {
    Percolation p = new Percolation(1);
    assertNotNull(p);
  }

}
