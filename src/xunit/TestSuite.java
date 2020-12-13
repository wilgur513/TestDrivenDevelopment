package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    List<TestCase> tests = new ArrayList<>();

    public void add(TestCase test){
        tests.add(test);
    }

    public TestResult run(){
        TestResult result = new TestResult();

        for(TestCase test : tests)
            test.run(result);

        return result;
    }
}
