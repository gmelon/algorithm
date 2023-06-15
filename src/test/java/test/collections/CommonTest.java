package test.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public class CommonTest {

    @Test
    void equals() {
        MyClass obj = new SubClass();
        MyClass obj2 = new MyClass();

        System.out.println(obj instanceof MyClass);
        System.out.println(obj instanceof SubClass);
        System.out.println(obj2 instanceof MyClass);
        System.out.println(obj2 instanceof SubClass);


    }

    static class MyClass {

    }

    static class SubClass extends MyClass {

    }


}
