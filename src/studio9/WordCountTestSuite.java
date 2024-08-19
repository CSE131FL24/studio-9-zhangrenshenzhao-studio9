package studio9;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import studio9.tests.WordCountTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ WordCountTest.class })
public class WordCountTestSuite {
}
