package inflearn.twopointers_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_02 {

    public static String solution(int n, int[] arrA, int m, int[] arrB) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrA[p1] == arrB[p2]) {
                answer.add(arrA[p1++]);
                // 값이 일치하면 동시에 증가시켜줘도 됨
                p2++;
            }
            // 두 값이 같지 않으면 두 배열 원소 중 값이 작은 쪽의 pointer만 이동시켜줌
            else if (arrA[p1] < arrB[p2]) p1++;
            else p2++;
        }
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