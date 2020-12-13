package xunit;

public class Main {
    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testAssertEqualsTrueCase").run();
        new TestCaseTest("testAssertEqualsFalseCase").run();
    }
}
