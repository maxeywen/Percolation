import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class PercolationTestNEquals1 {


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

  @Ignore
  @Test
  public void testOpenSiteisOpen() {
    Percolation p = new Percolation(1);
    p.open(1,1);
    assertEquals(true, p.isOpen(1,1));
  }

}