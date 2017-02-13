import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTestNEquals2 {

  private Percolation p;

  /**
   * Create object with n=1 and open it
   */
  @Before
  public void createObject() {
    p = new Percolation(2);
    p.open(2,1);
  }

  @After
  public void clearObject() {
    p = null;
  }

  @Test
  public void testIsOpen() {
    assertTrue(p.isOpen(2,1));
  }

  @Test
  public void testNumberOpenSitesEq1() { assertEquals(1, p.numberOfOpenSites()); }

  @Test
  public void testIsFull() {
    assertFalse(p.isFull(2,1));
  }

  @Test
  public void testPercolates() { assertFalse(p.percolates()); }



}
