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
  public void testIsNotFull() {
    assertFalse(p.isFull(2,1));
  }

  @Test
  public void testNotPercolates() { assertFalse(p.percolates()); }

  // ==================================================================
  // open site (1,2), should be full but not percolate
  @Test
  public void testSecondSiteIsOpen() {
    p.open(1,2);
    assertTrue(p.isOpen(2,1));
  }

  @Test
  public void testNumberOpenSitesEq2() {
    p.open(1,2);
    assertEquals(2, p.numberOfOpenSites());
  }

  @Test
  public void testSecondSiteIsFull() {
    p.open(1,2);
    assertTrue(p.isFull(1,2));
  }

  @Test
  public void testNotPercolatesWith2OpenSites() { assertFalse(p.percolates()); }

  // ==================================================================
  // open (1,1) should percolate now
  @Test
  public void testThirdSiteIsOpen() {
    p.open(1,2);
    p.open(1,1);
    assertTrue(p.isOpen(1,1));
  }

  @Test
  public void testNumberOpenSitesEq3() {
    p.open(1,2);
    p.open(1,1);
    assertEquals(3, p.numberOfOpenSites());
  }

  @Test
  public void testThirdSiteIsFull() {
    p.open(1,2);
    p.open(1,1);
    assertTrue(p.isFull(1,1));
  }

  @Test
  public void testFirstSiteIsNowFull() {
    p.open(1,2);
    p.open(1,1);
    assertTrue(p.isFull(2,1));
  }


  @Test
  public void testPercolatesWith3OpenSites() {
    p.open(1,2);
    p.open(1,1);
    assertTrue(p.percolates());
  }






}
