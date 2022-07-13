package inflearn.hash;

import java.util.*;

public class P04_03 {

    public static String solution(int n, int k, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        // init
        for (int i = 0; i < k; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        answer.add(map.size());

        // sliding window
        for (int i = k; i < n; i++) {   // i가 뒤에서 끌고 가는 방식
            // lf 처리
            if (map.get(arr[i-k]) >= 2) map.put(arr[i - k], map.get(arr[i - k]) - 1);
            else map.remove(arr[i - k]);
            // rf 처리
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());
        }
        return answer.toString().replaceAll("[^0-9 ]", "");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // bf clear
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(n, k, arr));
    }
}