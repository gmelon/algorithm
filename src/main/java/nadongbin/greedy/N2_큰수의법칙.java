package nadongbin.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class N2_큰수의법칙 {

    public static void main(String[] args) {
        System.out.println(solution(8, 3, new int[]{2, 4, 5, 4, 6}));
    }

    public static int solution(final int M, final int K, final int[] arr) {
        int[] sortedArr = Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

//        int sum = 0;
//        int continuousCount = 0;
//        for (int i = 0; i < M; i++) {
//            if (continuousCount == K) {
//                sum += sortedArr[1];
//                continuousCount = 0;
//            } else {
//                sum += sortedArr[0];
//                continuousCount++;
//            }
//        }

        int firstValueAddCount = (M / (K + 1)) * K;
        firstValueAddCount += M % (K + 1);

        int sum = sortedArr[0] * firstValueAddCount;
        sum += sortedArr[1] * (M - firstValueAddCount);

        return sum;
    }
}
