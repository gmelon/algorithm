package test.collections;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CommonTest {

    @Test
    void name() {

        method1(new ArrayList<String>(), new ArrayList<Integer>());

    }

    public int method1(List<?> list1, List<?> list2) {
        return list1.size() + list2.size();
    }

    // 한정적 와일드카드
    public void method2(List<? extends String> list) {

    }
}
