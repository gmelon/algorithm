package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_02 {

    public static int solution(int n, int[] intList) {
        int answer = 0;
        int curMax = 0; // 현재까지 가장 키가 큰 학생의 키
        for (int i : intList) {
            if (i > curMax) {
                answer++;
                curMax = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // nextLine()을 받아 split하여 String 배열 생성 후 int[]로 mapping
        int[] intList = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(n, intList));
    }

}
