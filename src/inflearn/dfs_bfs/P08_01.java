package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_01 {

    private static String answer = "NO";
    private static int total = 0;
    private static boolean flag = false;

    public static void solution(int n, int[] arr) {
        for (int i : arr) {
            total += i;
        }
        DFS(arr, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int[] arr, int index, int sum) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            // 이미 부분 집합의 합이 절반보다 커져버리면
            // 더 이상 확인할 필요가 없음
            return;
        }
        if (index >= arr.length) { // 재귀의 종료 조건
            // total을 2로 나누어 비교하면 안 됨!!!
            // 홀수의 경우 1이 버림되어 실제로는 62, 63인 경우에도 62==62로 같다고 인식해버림
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(arr, index+1, sum+arr[index]); // 현재 원소 포함
            DFS(arr, index+1, sum); // 현재 원소 포함 안 함
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
    }
}