package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_05 {

    public static String solution(int n, int[] arr) {

        // hashmap으로 O(n)에 풀이할 수도 있음

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j > -1; j--) {
                if (arr[j] > tmp) arr[j + 1] = arr[j];
                else if (arr[j] == tmp) return "D";
                else break; // arr[j] < tmp, 중간에 삽입 수행
            }
            arr[j + 1] = tmp;
        }
        return "U";
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine(); // buffer clear
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(n, arr));
    }
}