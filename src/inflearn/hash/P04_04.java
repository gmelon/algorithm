package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_04 {

    public static int solution(String s, String t) {

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int answer = 0;

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        // init mapT
        for (int i = 0; i < arrT.length; i++) mapT.put(arrT[i], mapT.getOrDefault(arrT[i], 0) + 1);

        // init mapS
        for (int i = 0; i < arrT.length - 1; i++) mapS.put(arrS[i], mapS.getOrDefault(arrS[i], 0) + 1);

        int lt = 0;
        for (int rt = arrT.length - 1; rt < arrS.length; rt++) {
            // rt 갱신
            mapS.put(arrS[rt], mapS.getOrDefault(arrS[rt], 0) + 1);
            // rt 갱신 후 answer 계산
            if (mapS.equals(mapT)) answer++;
            // lf 갱신
            mapS.put(arrS[lt], mapS.get(arrS[lt]) - 1);
            if (mapS.get(arrS[lt]) == 0) mapS.remove(arrS[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(solution(s, t));
    }
}