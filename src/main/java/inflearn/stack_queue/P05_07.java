package inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P05_07 {
    public static String solution(String str1, String str2) {
        Queue<Character> Q = new LinkedList<>();
        for (char c : str1.toCharArray()) Q.offer(c);

        for (char c : str2.toCharArray()) {
            if (Q.contains(c)) {
                // (현재) c가 Q에 포함되어 있다면 무조건 맨 앞에 존재해야 함
                if (Q.poll() != c) return "NO";
            }
        }
        if (!Q.isEmpty()) return "NO";      // 필수 과목 전체를 이수하지 않음
        return "YES";
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(solution(str1, str2));
    }
}
