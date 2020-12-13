package xunit;

public class Main {
    public static void main(String[] args) {
        WasRun wasRun = new WasRun("testMethod");
        System.out.println(wasRun.wasRun); // false;
        wasRun.run();
        System.out.println(wasRun.wasRun); // true;
    }
}
