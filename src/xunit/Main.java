package xunit;

public class Main {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testAssertEqualsEquivalentValues"));
        suite.add(new TestCaseTest("testAssertEqualsNotEquivalentValues"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testResultFormatting"));
        suite.add(new TestCaseTest("testBrokenMethod"));
        suite.add(new TestCaseTest("testSuite"));
        TestResult result = suite.run();
        System.out.println(result.summary());
    }
}
