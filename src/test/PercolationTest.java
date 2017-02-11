import org.junit.Test;

import static org.junit.Assert.*;


public class PercolationTest {

  @Test
  public void testContructor() {
    int n = 3;
    Percolation p = new Percolation(n);

    int expected = n;
    int result = p.getN();
    assertEquals(expected, result);

  }
}