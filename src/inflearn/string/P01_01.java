package inflearn.string;

import java.util.Scanner;

public class P01_01 {

    // 프로그래머스 채점 방식
    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char c : str.toCharArray()) {
            if (c == t)
                answer += 1;
        }
        return answer;
    }

    // 백준 채점 방식
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(solution(str, c));

    }

}
