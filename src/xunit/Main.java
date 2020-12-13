package xunit;

public class Main {
    public static void main(String[] args) {
        TestResult result = new TestResult();
        new TestCaseTest("testTemplateMethod").run(result);
        new TestCaseTest("testAssertEqualsEquivalentValues").run(result);
        new TestCaseTest("testAssertEqualsNotEquivalentValues").run(result);
        new TestCaseTest("testResult").run(result);
        new TestCaseTest("testResultFormatting").run(result);
        new TestCaseTest("testBrokenMethod").run(result);
        new TestCaseTest("testSuite").run(result);
        System.out.println(result.summary());
    }
}
