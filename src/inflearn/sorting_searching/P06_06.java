package inflearn.sorting_searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class P06_06 {

    public static String solution(int n, int[] arr) {
        int[] arrClone = arr.clone();
        Arrays.sort(arrClone);

        int idx = 0;
        int[] answer = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arrClone[i] != arr[i]) {
                answer[idx++] = i+1;
            }
        }
        return answer[0] + " " + answer[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 날리기
        int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(n, arr));
    }
}