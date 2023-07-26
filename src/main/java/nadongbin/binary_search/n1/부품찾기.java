package nadongbin.binary_search.n1;

import java.util.Arrays;
import java.util.Scanner;

public class 부품찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }

        // 풀이 시작
        Arrays.sort(arrN); // 오름차순 정렬

        for (int m : arrM) {
            int result = Arrays.binarySearch(arrN, m);
            if (result >= 0) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

}
