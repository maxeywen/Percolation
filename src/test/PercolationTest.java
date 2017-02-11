import org.junit.Test;

import static org.junit.Assert.*;


public class PercolationTest {
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
  public void testConstructor() {
    Percolation p = new Percolation(1);
    assertNotEquals(null, p);
  }

  /**
   * throw java.lang.IndexOutOfBoundsException if index out of range
   */
  @Test(expected=IndexOutOfBoundsException.class)
  public void testOpenIndexOutOfRange() {
    Percolation p = new Percolation(1);
    p.isOpen(-2,2);
  }

  /**
   * throw java.lang.IndexOutOfBoundsException if index out of range
   */
  @Test(expected=IndexOutOfBoundsException.class)
  public void testIsOpenIndexOutOfRange() {
    Percolation p = new Percolation(1);
    p.isOpen(2,2);
  }

  /**
   * throw java.lang.IndexOutOfBoundsException if index out of range
   */
  @Test(expected=IndexOutOfBoundsException.class)
  public void testIsFullIndexOutOfRange() {
    Percolation p = new Percolation(1);
    p.isOpen(2,-2);
  }

  /**
   * beginning number of open sites = 0
   */
  @Test
  public void testInitialNumberOpenSites() {
    Percolation p = new Percolation(1);
    assertEquals(0, p.numberOfOpenSites());
  }

  @Test
  public void testInitialDoesNotPercolate() {
    Percolation p = new Percolation(1);
    assertEquals(false, p.percolates());
  }

}