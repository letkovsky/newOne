package Test;
import java.util.NoSuchElementException;
import java.util.Objects;

import static Test.Tools.readInt;
import static Test.Tools.readDouble;
import static Test.Tools.Writer;


public class TestOne {

    private int x;
    private String s;

    public void go(){
        Writer("Hello, enter the number");
        try {
            double v = readDouble();
            Writer("Number:" + v);
        }
        catch (Exception e){
            Writer("Invalid input: use ,");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestOne testOne = (TestOne) o;
        return x == testOne.x && Objects.equals(s, testOne.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, s);
    }
}
