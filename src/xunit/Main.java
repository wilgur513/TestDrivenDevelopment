package xunit;

public class Main {
    public static void main(String[] args) {
        System.out.println(new TestCaseTest("testTemplateMethod").run().summary());
        System.out.println(new TestCaseTest("testAssertEqualsEquivalentValues").run().summary());
        System.out.println(new TestCaseTest("testAssertEqualsNotEquivalentValues").run().summary());
        System.out.println(new TestCaseTest("testResult").run().summary());
        System.out.println(new TestCaseTest("testResultFormatting").run().summary());
        System.out.println(new TestCaseTest("testBrokenMethod").run().summary());

    }
}
