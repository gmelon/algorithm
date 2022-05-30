package inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_01 {

    public static String solution(int n, int[] intList) {
        List<Integer> answer = new ArrayList<>();
        answer.add(intList[0]); // 맨 앞수는 무조건 출력
        for (int i = 1; i < intList.length; i++) {
            if (intList[i - 1] < intList[i]) {
                answer.add(intList[i]);
            }
        }
        // ArrayList를 toString() 하면 "[1, 2, ...]"의 형태로 변환되므로
        // 숫자와 공백을 제외하고 ""로 replace함
        return answer.toString().replaceAll("[^0-9 ]", "");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] intList = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, intList));
    }

}
