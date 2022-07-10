package inflearn.string;

import java.util.Scanner;

public class P01_10 {

    public static int[] solution(String s, char c) {

        /* char의 위치를 미리 구해놓고 2중 for-loop을 사용하는 방식

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
         */

        // p의 값을 저장하면서 현재 원소가 char과 일치하면 0, 일치하지 않으면 1 증가시킨 값을 answer 배열에 넣는다.
        int[] answer = new int[s.length()];
        int p = 1000; // 문자열의 최대 길이가 100이므로 char과의 최대 길이보다 큰 수를 가정하여 1000을 사용
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) { // 원소가 char인 경우
                p = 0;
                answer[i] = p;
            } else {
                answer[i] = ++p;
            }
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                // 좌측의 char과의 거리보다 우측에서의 char과의 거리가 더 작을 경우에만 answer의 값을 교체
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        for (int i : solution(input[0], input[1].charAt(0))) {
            System.out.println(i + " ");
        }
    }


}
