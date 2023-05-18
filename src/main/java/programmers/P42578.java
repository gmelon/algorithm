package programmers;

import java.util.*;

class P42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }

    public int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
