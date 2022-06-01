package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_07 {

    public static int solution(int n, int[] intList) {
        int answer = 0;
        int accScore = 0;

        for (int i : intList) {
            if (i == 1) { // 답을 맞춘 경우
                accScore++;
                answer += accScore;
            }
            else {
                accScore = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] intList = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(n, intList));
    }

}
