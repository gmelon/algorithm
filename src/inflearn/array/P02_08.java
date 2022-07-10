package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P02_08 {

    public static String solution(int n, int[] intList) {
        int[] answer = new int[n];

        int rank;
        for (int i = 0; i < intList.length; i++) {
            rank = 1; // 항상 초기값은 1
            for (int j = 0; j < intList.length; j++) {
                // 자신보다 큰 점수가 있을 때 마다 등수를 하나씩 줄인다.
                // 이렇게 하면 자신 무시 + 동점자는 같은 등수 (높은 등수) 처리가 동시에 해결된다.
                if (intList[j] > intList[i]) rank++;
            }
            answer[i] = rank;
        }
        return Arrays.toString(answer).replaceAll("[^0-9 ]", "");
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
