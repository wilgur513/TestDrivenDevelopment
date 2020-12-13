package xunit;

import java.lang.reflect.Method;

public class WasRun {
    private String name;
    boolean wasRun;

    public WasRun(String name){
        this.name = name;
    }

    public void testMethod(){
        wasRun = true;
    }

    public void run(){
        try{
            Method method = getClass().getMethod(name);
            method.invoke(this);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
