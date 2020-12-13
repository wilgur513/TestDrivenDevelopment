package xunit;

public class WasRun extends TestCase{
    boolean wasSetUp;
    boolean wasRun;

    public WasRun(String name){
        super(name);
    }

    public void testMethod(){
        wasRun = true;
    }

    public void setUp(){
        wasSetUp = true;
    }
}
