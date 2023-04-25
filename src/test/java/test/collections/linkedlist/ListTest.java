package test.collections.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListTest {

    @Test
    void name() {
        int[][] edges = {{1, 2}, {4, 3}, {2, 4}, {7, 1}, {1, 3}};

        Arrays.sort(edges, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int d : edges[0]) {
//            Integer.valueOf(10)
        }
    }
}
