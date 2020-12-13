package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test{
    List<Test> tests = new ArrayList<>();

    public void add(Test test){
        tests.add(test);
    }

    public void run(TestResult result){
        for(Test test : tests)
            test.run(result);
    }
}
