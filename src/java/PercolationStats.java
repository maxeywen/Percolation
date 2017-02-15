import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  int n;
  int numTrials;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    this.n = n;
    this.numTrials = trials;
  }

  // sample mean of percolation threshold
  public double mean() { return -1.0; }

  // sample standard deviation of percolation threshold
  public double stddev() { return -1.0; }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() { return -1.0; }

  // high endpoint of 95% confidence interval
  public double confidenceHi() { return -1.0; }

  // test client (described below)
  public static void main(String[] args) {
    PercolationStats ps = new PercolationStats(1,1);
  }
}