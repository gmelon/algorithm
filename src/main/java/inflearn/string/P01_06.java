package inflearn.string;

import java.util.Scanner;

public class P01_06 {

    public static String solution(String input) {
        // indexOf(char)의 값이 자신의 index가 아니면 중복 문자로 판단
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) {
                result += input.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
