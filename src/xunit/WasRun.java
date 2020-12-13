package xunit;

public class WasRun extends TestCase{
    String log;
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
        log = "setUp";
    }
}
