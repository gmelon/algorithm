package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_02 {

    public static String solution(int n, int[] arr) {
        /*
         * [버블 정렬]
         * 선택 정렬과 반대로 우측 끝부터 고정시키는 방식으로 정렬
         * i=0부터 계속 증가시키며 이웃한 원소와 자신을 비교하여 우측 원소가 자신보다 작으면 swap (오름차순 기준)
         * 우측 끝이 한 원소 씩 고정되므로 반복 1회 수행 시 마다 끝을 1씩 줄여나가며 반복한다.
         * 시간 복잡도 : O(n^2)
         */
        for (int i = 0; i < n - 1 ; i++) {   // 전체 반복 횟수는 n-1회
            for (int j = 0; j < n - i - 1; j++) {   // 우측 원소가 고정되면 더 이상 해당 원소는 탐색할 필요 X
                // i가 1씩 증가함에 따라 (반복 횟수가 증가할 때) 탐색해야 하는 원소 수는 1씩 감소 (n - i - 1)
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
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
