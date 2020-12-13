package xunit;

public class WasRun extends TestCase{
    boolean wasRun;

    public WasRun(String name){
        super(name);
    }

    public void testMethod(){
        wasRun = true;
    }
}
