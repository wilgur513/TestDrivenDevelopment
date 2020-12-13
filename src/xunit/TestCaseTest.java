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
}
