package inflearn.string;

import java.util.Scanner;

public class P01_08 {

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
        // StringBuilder.reverse()로 뒤집은 후 바로 equals로 비교하는 것도 가능
        // String객체.equalsIgnoreCase()는 대소문자 무시하고 같은지 비교
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

}
