package nadongbin.sort.n3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N3_두배열의원소교체 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        sc.close();

        // A는 오름차순 정렬
        int[] sortedA = Arrays.stream(A)
            .boxed()
            .sorted()
            .mapToInt(i -> i)
            .toArray();

        // B는 내림차순 정렬
        int[] sortedB = Arrays.stream(B)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();

        for (int i = 0; i < K; i++) {
            if (sortedB[i] > sortedA[i]) {
                int temp = sortedB[i];
                sortedB[i] = sortedA[i];
                sortedA[i] = temp;
            } else {
                break;
            }
        }

        System.out.println(Arrays.stream(sortedA).sum());
    }
}
