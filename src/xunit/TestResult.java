package xunit;

public class TestResult {
    private int runCount = 0;

    public void testStarted(){
        runCount++;
    }

    public String summary(){
        return runCount + " run, 0 failed";
    }
}
