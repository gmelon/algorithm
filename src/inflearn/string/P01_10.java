package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01_10 {

    public static String solution(String s, char c) {
        // 각 원소의 c와의 거리를 계산해서 저장할 배열
        int[] distance = new int[s.length()]; // String이면 length(), Array면 length 사용
        // 먼저 s에서 c의 위치들을 구해놓은 배열을 생성
        List<Integer> charIndex = new ArrayList<>();
        int tmpPosition;
        for (int i = 0; i < s.length(); i++) {
            tmpPosition = s.indexOf(c, i); // i = 0 ~ length-1
            if (!charIndex.contains(tmpPosition)) {
                charIndex.add(tmpPosition);
            }
        }
        // 이제 distance에 각 index별로 charIndex의 원소와 가장 가까운 수를 계산해 넣는다.
        int tmpDistance = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (Integer j : charIndex) {
                if (Math.abs(j - i) < tmpDistance) tmpDistance = Math.abs(j - i);
            }
            distance[i] = tmpDistance;
            tmpDistance = Integer.MAX_VALUE;
        }
        // 공백과 숫자를 제외하고 모두 replace 한다. 즉, '[', ']', ',' 가 ""로 replace 됨.
        return Arrays.toString(distance).replaceAll("[^0-9 ]", "");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        System.out.println(solution(input[0], input[1].charAt(0)));
    }


}
