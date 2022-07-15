package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_04 {

    public static String solution(int s, int n, int[] arr) {
        int[] cache = new int[s];

        for (int i = 0; i < n; i++) {   // 작업 개수만큼 반복
            // cache miss || hit 판별
            int c = 0;
            for (; c < s; c++) {
                if (cache[c] == arr[i]) {   // cache hit 시
                    break;
                }
            }
            if (c == s) c--;     // cache miss 시 c를 마지막 원소의 index로 옮겨줌
            // c부터 0까지 cache를 뒤로 미루고 맨 앞에 arr[i]를 넣음
            for (int j = c; j > 0 ; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = arr[i];
        }

        return Arrays.toString(cache).replaceAll("[^0-9 ]", "");
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();   // 캐시 크기
            int n = sc.nextInt();   // 작업 개수
            sc.nextLine(); // buffer clear
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(s, n, arr));
    }
}