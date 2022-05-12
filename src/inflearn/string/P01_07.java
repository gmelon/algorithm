package inflearn.string;

import java.util.Scanner;

public class P01_07 {

    public static String solution(String input) {
        // 대소문자 구별 X
        input = input.toLowerCase();
        int lt = 0;
        int rt = input.length() - 1;

        while (lt < rt) {
            if (input.charAt(lt) != input.charAt(rt)) return "NO";
            lt++;
            rt--;
        }
        return "YES";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
