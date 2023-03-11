package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_03 {

    public static String solution(int n, int[] arr) {
        /*
         * [삽입 정렬]
         * 선택 정렬과 마찬가지로 앞에서 부터 정렬해 나간다
         * 다만, i가 증가하면서 j는 i-1~0까지 감소하며 순회하다가 arr[i]보다 작은 값이 발견되면 arr[j+1]에 원소를 '삽입'한다는 것이 차이점
         * arr[0]까지 arr[i]보다 작은 값이 없으면 내부 for-loop 종료 후 arr[j+1(=0)]에 기존 arr[i](tmp에 유지)를 저장 - 이 경우 맨 앞에 '삽입'된다.
         * 시간 복잡도 : O(n^2)
         */

        for (int i = 1; i < n; i++) {   // j가 i-1부터 감소하므로 i는 1부터 시작 (최초엔 2개 원소 비교)
            int tmp = arr[i];   // 현재의 i 번째 원소를 저장
            int j = i - 1;
            for (; j > -1; j--) {  // break 없이 반복 종료 시 j = -1
                if (arr[j] > tmp) arr[j + 1] = arr[j];  // 한 칸 뒤로 미룸
                else break;  // tmp보다 작은 수가 발견되면 break
            }
            arr[j + 1] = tmp;   // 마지막 j 위치 다음 index에 tmp를 '삽입'한다.
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
