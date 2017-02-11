import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final int n;
  private int numOpenSites;
  private boolean percolates;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }

    this.n = n;
    this.numOpenSites = 0;
    this.percolates = false;
  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (validSite(row, col)) {
      throw new IndexOutOfBoundsException();
    }

  }


  // is site (row, col) open?
   public boolean isOpen(int row, int col) {
     if (validSite(row, col)) {
       throw new IndexOutOfBoundsException();
     }

    return true;
  }

  private boolean validSite(int row, int col) {
    return row < 0 || row > n || col < 0 || col > n;
  }

  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    if (validSite(row, col)) {
      throw new IndexOutOfBoundsException();
    }

    return true;
  }

  // number of open sites
  public int numberOfOpenSites() {
    return numOpenSites;
  }

  // does the system percolate?
  public boolean percolates() {
    return percolates;
  }

  // test client (optional)
  //  public static void main(String[] args) {
  //    System.out.println("hi");
  //  }
}