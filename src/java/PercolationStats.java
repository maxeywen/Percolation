import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private final int n;
  private final int numTrials;
  private double[] results;
  private double mean;
  private double stddev;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    // The constructor should throw a java.lang.IllegalArgumentException if
    // either n ≤ 0 or trials ≤ 0
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }

    this.n = n;
    this.numTrials = trials;
    results = new double[numTrials];

    for (int trial = 0; trial < numTrials; trial++) {
      results[trial] = runTrial();
    }
  }

  private void printResults() {
    mean = mean();
    System.out.println("mean                    = " + mean);
    stddev = stddev();
    System.out.println("stddev                  = " + stddev);

    double x1 = confidenceLo();
    double x2 = confidenceHi();
    System.out.println("95% confidence interval = [" + x1 + ", " + x2 + "]");
  }

  private double runTrial() {

    Percolation p = new Percolation(n);
    while (!p.percolates()) {
      int rand1 = StdRandom.uniform(1, n + 1);
      int rand2 = StdRandom.uniform(1, n + 1);
      p.open(rand1, rand2);
    }

    double x = 1.0 * p.numberOfOpenSites() / (n * n);

    // System.out.println(x);
    return x;
  }

  // sample mean of percolation threshold
  public double mean() { return StdStats.mean(results); }

  // sample standard deviation of percolation threshold
  public double stddev() { return StdStats.stddev(results); }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() {
    double lo = mean - (1.96 * stddev)/Math.sqrt(numTrials);
    return lo;
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    double hi = mean + (1.96 * stddev)/Math.sqrt(numTrials);
    return hi;
  }

  // test client (described below)
  public static void main(String[] args) {
    PercolationStats ps = new PercolationStats(10,10);
    ps.printResults();
  }
}