package inflearn.string;

import java.util.Scanner;

public class P01_12 {

    public static String solution(int num, String input) {
        String result = "";
        for (int i = 0; i < num; i++) {
            // 각각의 알파벳 (암호 상태)
            String tmp = input.substring(i * 7, i * 7 + 7); // endIndex는 exclusive
            tmp = tmp.replace('#', '1').replace('*', '0'); // replace도 모든 occurunce를 변경한다!
            // 10 진수로 변환 후 해당 값을 아스키코드로 사용
            char tmpChar = (char) Integer.parseInt(tmp, 2); // 주어진 String이 binary라고 가정하고 int로 파싱한다. (string -> int)
            result += tmpChar;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        System.out.println(solution(num, input));
    }


}
