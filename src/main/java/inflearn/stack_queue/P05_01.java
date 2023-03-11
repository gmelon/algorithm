package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_01 {
    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        // 반복 종료 이후에 stack은 empty 여야 함
        if (!stack.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));

    }
}
