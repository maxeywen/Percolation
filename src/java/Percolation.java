public class Percolation {

  private final int n;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    this.n = n;
  }
//  public    void open(int row, int col)    // open site (row, col) if it is not open already
//  public boolean isOpen(int row, int col)  // is site (row, col) open?
//  public boolean isFull(int row, int col)  // is site (row, col) full?
//  public     int numberOfOpenSites()       // number of open sites
//  public boolean percolates()              // does the system percolate?

  // test client (optional)
//  public static void main(String[] args) {
//    System.out.println("hi");
//  }

  public int getN() {
    return n;
  }
}