package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_10 {

    public static int solution(int n, int c, int[] arr) {
        // c 마리의 말이 있을 때
        // arr를 좌표로 갖는 마구간에 말을 배치
        // 가장 가까운 두 말의 최대 거리는?
        Arrays.sort(arr);

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }
}