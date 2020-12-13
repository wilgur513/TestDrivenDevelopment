package xunit;

public class Assert {
    public static void assertEquals(Object actual, Object expected){
        if(!actual.equals(expected))
            throw new RuntimeException("fail! actual : " + actual + ", expected : " + expected);
    }
}
