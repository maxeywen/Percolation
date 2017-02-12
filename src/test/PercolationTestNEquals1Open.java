import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTestNEquals1Open {

  private Percolation p;

  /**
   * Create object with n=1 and open it
   */
  @Before
  public void createObject() {
    p = new Percolation(1);
    p.open(1,1);
  }

  @After
  public void clearObject() {
    p = null;
  }

  @Test
  public void testIsOpen() {
    assertTrue(p.isOpen(1,1));
  }

  @Test
  public void testIsFull() {
    assertTrue(p.isFull(1,1));
  }

  @Test
  public void testNumberOpenSites() {
    assertEquals(1, p.numberOfOpenSites());
  }

  @Test
  public void testPercolates() { assertTrue(p.percolates()); }

}
