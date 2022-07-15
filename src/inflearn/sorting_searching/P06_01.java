package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_01 {

    public static String solution(int n, int[] arr) {
        /*
         * [선택 정렬]
         * 2중 for-loop을 사용해 0번 index부터 n-1 index까지 매 원소를 기준으로 잡고
         * 기준 원소 우측에 남은 원소 중 가장 작은 원소를 해당 기준 원소와 swap 하며 정렬한다.
         * 시간 복잡도 : O(n^2)
         */

        int idx;    // i 고정 상태에서, i보다 우측 원소 중 가장 작은 원소의 idx를 기록

        for (int i = 0; i < n - 1; i++) {
            idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            // swap
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return Arrays.toString(arr).replaceAll("[^0-9 ]", "");
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine(); // buffer clear
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(n, arr));
    }
}
