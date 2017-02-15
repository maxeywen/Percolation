import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  int n;
  int numTrials;
  double[] results;
  private double mean;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    // The constructor should throw a java.lang.IllegalArgumentException if
    // either n ≤ 0 or trials ≤ 0
    if (n <= 0 || trials < 0) {
      throw new IllegalArgumentException();
    }

    this.n = n;
    this.numTrials = trials;
    results = new double[numTrials];

    for (int trial = 0; trial < numTrials; trial++) {
      double x = StdRandom.uniform(0.50, 0.70);
      results[trial] = x;
      System.out.println(x);
    }

    mean = mean();
    System.out.println("mean                    = " + mean);
    double stddev = stddev();
    System.out.println("stddev                  = " + stddev);

    double x1 = confidenceLo();
    double x2 = confidenceHi();
    System.out.println("95% confidence interval = [" + x1 + ", " + x2 + "]");
  }

  // sample mean of percolation threshold
  public double mean() { return StdStats.mean(results); }

  // sample standard deviation of percolation threshold
  public double stddev() { return StdStats.stddev(results); }

  // low  endpoint of 95% confidence interval
  public double confidenceLo() {
    double lo = mean - (1.96 * StdStats.var(results))/Math.sqrt(numTrials);
    return lo;
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    double hi = mean + (1.96 * StdStats.var(results))/Math.sqrt(numTrials);
    return hi;
  }

  // test client (described below)
  public static void main(String[] args) {
    PercolationStats ps = new PercolationStats(200,100);
  }
}