package xunit;

public class WasRun extends TestCase{
    String log;

    public WasRun(String name){
        super(name);
    }

    public void testMethod(){
        log += " testMethod";
    }

    public void setUp(){
        log = "setUp";
    }

    public void tearDown(){
        log += " tearDown";
    }
}
