import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final int n;
  private int numOpenSites;
  private boolean[] open;
  private boolean percolates;
  private WeightedQuickUnionUF ufTop;
  private WeightedQuickUnionUF ufBottom;
  private final int topNode;
  private final int bottomNode;

  // ==========================================================================
  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }

    this.n = n;
    this.numOpenSites = 0;
    this.percolates = false;

    int paddedN = (n+2) * (n+2);
    this.open = new boolean[paddedN];

    this.ufTop = new WeightedQuickUnionUF(paddedN+1);
    topNode = paddedN;

    this.ufBottom = new WeightedQuickUnionUF(paddedN+1);
    bottomNode = paddedN;

    for (int row = 0; row <= n+1; row += (n+1)) {
      for (int col = 1; col <= n; col++) {
        int s = site(row, col);
        this.open[s] = true;
        if (row == 0) {
          ufTop.union(s, topNode);
        }
        if (row == n+1) {
          ufBottom.union(s, bottomNode);
        }
      }
    }
  }

  // ==========================================================================
  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (!validSite(row, col)) {
      throw new IndexOutOfBoundsException();
    }

    if (!isOpen(row, col)) {
      int s0 = site(row, col);

      open[s0] = true;
      numOpenSites += 1;

      int s1;
      s1 = site(row - 1, col);  // up
      if (open[s1]) {
        ufTop.union(s0, s1);
        ufBottom.union(s0, s1);
      }

      s1 = site(row + 1, col); // down
      if (open[s1]) {
        ufTop.union(s0, s1);
        ufBottom.union(s0, s1);
      }

      s1 = site(row, col + 1); // right
      if (open[s1]) {
        ufTop.union(s0, s1);
        ufBottom.union(s0, s1);
      }

      s1 = site(row, col - 1); // left
      if (open[s1]) {
        ufTop.union(s0, s1);
        ufBottom.union(s0, s1);
      }

      // check for percolation
      if (openPathToTop(row, col)) {
        if (ufBottom.connected(s0, bottomNode)) {
          percolates = true;
        }
      }
    }
  }

  // ==========================================================================
  // is site (row, col) open?
   public boolean isOpen(int row, int col) {
     if (!validSite(row, col)) {
       throw new IndexOutOfBoundsException();
     }
    return open[site(row, col)];
  }

  // ==========================================================================
  private boolean validSite(int row, int col) {
    return (row >= 1 && row <= n && col >= 1 && col <= n);
  }

  // ==========================================================================
  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    if (!validSite(row, col)) {
      throw new IndexOutOfBoundsException();
    }

    return (this.isOpen(row, col) && this.openPathToTop(row, col));
  }

  // ==========================================================================
  private boolean openPathToTop(int row, int col) {
    // int site = site(row, col);
    return ufTop.connected(site(row, col), topNode);
  }

  // ==========================================================================
  private int site(int row, int col) {
    return (row * (n + 2) + col);
  }

  // ==========================================================================
  // number of open sites
  public int numberOfOpenSites() {
    return numOpenSites;
  }

  // ==========================================================================
  // does the system percolate?
  public boolean percolates() {
    return percolates;
  }

  // ==========================================================================
//  private void show() {
//    for (int r=0; r<=n+1; r++) {
//      for (int c=0; c<=n+1; c++) {
//        int s = site(r,c);
//        if (open[s]) {
//          if (isFull(r,c)) System.out.print('+');
//          else System.out.print('-');
//        }
//        else {System.out.print('X');}
//        //{System.out.print(s + "\t");}
//      }
//      System.out.println();
//    }
//  }

  // ==========================================================================
  // test client (optional)
  public static void main(String[] args) {
    // Percolation p = new Percolation(10);
    // p.open(0, 6);
    // p.open(1,2);
    // p.isOpen(2,2);
    // p.show();
  }
}