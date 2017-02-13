import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final int n;
  private int numOpenSites;
  private boolean[] open;
  private boolean percolates;
  private WeightedQuickUnionUF ufTop;
  private WeightedQuickUnionUF ufBottom;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }

    this.n = n;
    this.numOpenSites = 0;
    this.open = new boolean[n*n+1];
    this.percolates = false;

    this.ufTop = new WeightedQuickUnionUF(n*n+1);
    this.ufBottom = new WeightedQuickUnionUF(n*n+1);
  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (validSite(row, col)) {
      throw new IndexOutOfBoundsException();
    }
    numOpenSites += 1;
    open[site(row, col)] = true;

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

    return (this.isOpen(row, col) && this.openPathToTop(row, col));
  }

  private boolean openPathToTop(int row, int col) {
    // int site = site(row, col);
    return ufTop.connected(site(row, col), 0);
  }

  private int site(int row, int col) {
    return ((row-1) * n + col);
  }

  // number of open sites
  public int numberOfOpenSites() {
    return numOpenSites;
  }

  // does the system percolate?
  public boolean percolates() {
    return percolates;
  }

  private void show() {
    for (int r=1; r<=n; r++) {
      for (int c=1; c<=n; c++) {
        int s = site(r,c);
        if (open[s]) {System.out.print('X');}
        else {System.out.print('-');}
      }
      System.out.println();
    }
  }

  // test client (optional)
  public static void main(String[] args) {
    Percolation p = new Percolation(3);
    p.open(1,1);
    p.show();
  }
}