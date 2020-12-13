package xunit;

public class Main {
    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testAssertEqualsEquivalentValues").run();
        new TestCaseTest("testAssertEqualsNotEquivalentValues").run();
    }
}
