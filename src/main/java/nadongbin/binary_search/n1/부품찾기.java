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
            int result = recursiveBinarySearch(arrN, m, 0, arrN.length - 1);
            if (result >= 0) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return recursiveBinarySearch(arr, target, mid + 1, end);
        } else {
            return recursiveBinarySearch(arr, target, start, mid - 1);
        }
    }

}
