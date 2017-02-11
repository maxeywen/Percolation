import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import org.junit.Test;

import static org.junit.Assert.*;


public class PercolationTest {

  /**
   * Test to make sure constructor returns an object
   */
  @Test
  public void testConstructor() {
    Percolation p = new Percolation(1);
    assertNotEquals(null, p);
  }

  /**
   * The constructor should throw a java.lang.IllegalArgumentException if n <= 0.
   */
  @Test(expected=IllegalArgumentException.class)
  public void testNCantBeLessThan1() {
    Percolation p = new Percolation(-1);
  }


}