package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_01 {

    public static char solution(int n, String str) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int curMax = 0;
        char curMaxKey = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) > curMax) {
                curMax = map.get(c);
                curMaxKey = c;
            }
        }
        return curMaxKey;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(solution(n, str));
    }
}