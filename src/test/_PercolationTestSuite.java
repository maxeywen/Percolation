import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PercolationConstructorTest.class,
    PercolationTestNEquals1.class,
    PercolationTestNEquals1Open.class,
    PercolationTestNEquals2.class,
    PercolationTestNEquals3.class
    })

public class _PercolationTestSuite {

}