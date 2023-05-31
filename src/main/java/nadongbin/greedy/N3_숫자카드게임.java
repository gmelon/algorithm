package nadongbin.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class N3_숫자카드게임 {

    public static void main(String[] args) {
        int[][] arr1 = {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}};
        int[][] arr2 = {{7, 3, 1, 8}, {3, 3, 3, 4}};

        System.out.println(solution(3, 3, arr1));
        System.out.println(solution(2, 4, arr2));
    }

    public static int solution(int N, int M, int[][] arr) {
        return Arrays.stream(arr)
            .map(a -> Arrays.stream(a).min().orElse(Integer.MAX_VALUE))
            .max(Comparator.naturalOrder()).get();
    }

}
