import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    PercolationConstructorTest.class,
    PercolationTestNEquals1.class
    // MySecondClassTest.class
    })

public class PercolationTestSuite {

}