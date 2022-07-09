package inflearn.twopointers_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_01 {

    public static String solution(int n, int[] arrA, int m, int[] arrB) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrA[p1] < arrB[p2]) answer.add(arrA[p1++]);
            else answer.add(arrB[p2++]);
        }
        // arrA 혹은 arrB의 원소가 남아있는 상태
        while(p1 < n) answer.add(arrA[p1++]);
        while(p2 < m) answer.add(arrB[p2++]);

        return answer.toString().replaceAll("[^0-9 ]", "");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [] arrA = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(sc.nextLine());
        int[] arrB = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(n, arrA, m, arrB));
    }

}
