package nadongbin.implementation.n7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N7_문자열재정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();

        System.out.println(solution(S));
    }

    public static String solution(final String S) {
        PriorityQueue<Character> characters = new PriorityQueue<>();
        int sum = 0;

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += (c - '0');
            } else {
                characters.add(c);
            }
        }

        int size = characters.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(characters.poll());
        }
        return sb.toString() + sum;
    }

}
