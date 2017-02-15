import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTestNEquals3 {

  private Percolation p;
  private int n = 3;

  /**
   * Create object with n=1 and open it
   */
  @Before
  public void createObject() {
    p = new Percolation(n);
    p.open(2,2);
  }

  @After
  public void clearObject() {
    p = null;
  }

  @Test
  public void testIsOpen() {
    assertTrue(p.isOpen(2,2));
  }

  @Test
  public void testNumberOpenSitesEq1() { assertEquals(1, p.numberOfOpenSites()); }

  @Test
  public void testIsFull() {
    assertFalse(p.isFull(2,2));
  }

  @Test
  public void testPercolates() { assertFalse(p.percolates()); }

  @Test
  public void testFullAfterOpeningTopSite() {
    p.open(1,2);
    assertTrue(p.isFull(2,2));
  }



}
