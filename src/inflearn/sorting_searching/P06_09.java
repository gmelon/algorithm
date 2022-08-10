package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_09 {

    public static int check(int[] arr, int limit) {
        int cnt = 1, sum = 0;
        for (int i : arr) {
            if (sum + i > limit) {
                sum = i;
                cnt++;
            } else {
                sum += i;
            }
        }
        return cnt;
    }

    public static int solution(int n, int m, int[] arr) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while (lt <= rt) { // lt==rt가 된다고 무조건 해당 값이 답이 아니기 때문에 검사가 필요, 따라서 조건에 등호가 포함됨
            // 반복이 종료되는 시점에 lt==rt가 가능한 최소 크기의 DVD 길이
            int mid = (lt + rt) / 2;
            if (check(arr, mid) <= m) {
                rt = mid-1;
                answer = mid; // 현 시점에서 가능한 가장 작은 DVD 길이
            } else {
                lt = mid+1;
            }
        }
        return answer;
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