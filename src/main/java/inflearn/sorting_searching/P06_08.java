package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_08 {

    public static int solution(int n, int m, int[] arr) {
        // 배열 정렬
        Arrays.sort(arr);

        // 이분 검색 시작
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) { // m을 찾거나 범위내에 없을 경우 lt == rt
            int mid = (lt + rt) / 2;
            // mid == m 일 경우 계속 이분탐색 진행하지 않고 바로 리턴하도록하여 효율 증가
            if (arr[mid] == m) {
                lt = mid;
                break;
            }
            if (m < arr[mid]) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
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