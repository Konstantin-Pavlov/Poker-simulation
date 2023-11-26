package test;

import org.junit.*;
import poker.Greet;

public class Tests {

    @Test
    public void t0() {
        Greet greet = new Greet();
        Assert.assertEquals("hello", greet.says());
    }

    @Test
    public void t1() {
        Greet greet = new Greet();
        Assert.assertEquals("helo", greet.says());
    }
}
