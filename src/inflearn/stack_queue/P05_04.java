package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_04 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) stack.push(Character.getNumericValue(c));
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                if (c == '+') {
                    stack.push(operand2 + operand1);
                } else if (c == '-') {
                    stack.push(operand2 - operand1);
                } else if (c == '*') {
                    stack.push(operand2 * operand1);
                } else if (c == '/') {
                    stack.push(operand2 / operand1);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
