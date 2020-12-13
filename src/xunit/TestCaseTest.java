package xunit;

public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning(){
        WasRun wasRun = new WasRun("testMethod");
        Assert.assertEquals(wasRun.wasRun, false);
        wasRun.run();
        Assert.assertEquals(wasRun.wasRun, true);
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
}
