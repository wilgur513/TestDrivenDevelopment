package xunit;

public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning(){
        WasRun wasRun = new WasRun("testMethod");
        System.out.println(wasRun.wasRun); // false;
        wasRun.run();
        System.out.println(wasRun.wasRun); // true;
    }

    public void testAssertEqualsEquivalentValues(){
        Assert.assertEquals(true, true);
    }

    public void testAssertEqualsNotEquivalentValues(){
        try {
            Assert.assertEquals(true, false);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("test failed");
    }
}
