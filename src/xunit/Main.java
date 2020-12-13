package xunit;

public class Main {
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testAssertEqualsEquivalentValues").run();
        new TestCaseTest("testAssertEqualsNotEquivalentValues").run();
        new TestCaseTest("testResult").run();
    }
}
