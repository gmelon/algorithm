package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_08 {

    public static int solution(int n, int m, int[] arr) {
        // 배열 정렬
        Arrays.sort(arr);

        // 이분 검색 시작
        int lt = 0, rt = arr.length - 1;
        while (lt != rt) {
            int tmp = (lt + rt) / 2;
            if (m <= arr[tmp]) {
                rt = tmp;
            } else {
                lt = tmp + 1;
            }
        }
        return lt + 1; // 문제의 idx가 1부터 시작
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}