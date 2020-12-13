package xunit;

public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod(){
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run();
        Assert.assertEquals(wasRun.log, "setUp testMethod tearDown");
    }

    public void testAssertEqualsEquivalentValues(){
        Assert.assertEquals(true, true);
    }

    public void testAssertEqualsNotEquivalentValues(){
        try {
            Assert.assertEquals(true, false);
        }catch(Exception e){
            Assert.assertEquals(e.getMessage(), "fail! actual : true, expected : false");
        }
    }

    public void testResult(){
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = wasRun.run();
        Assert.assertEquals(result.summary(), "1 run, 0 failed");
    }

    public void testBrokenMethod(){
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = wasRun.run();
        Assert.assertEquals(result.summary(), "1 run, 1 failed");
    }

    public void testResultFormatting(){
        TestResult result = new TestResult();
        result.testStarted();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals(result.summary(), "2 run, 1 failed");
    }

    public void testSuite(){
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        TestResult result = suite.run();
        Assert.assertEquals(result.summary(), "2 run, 1 failed");
    }
}
