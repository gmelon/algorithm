package inflearn.hash;

import java.util.*;

public class P04_05 {

    public static int solution(int n, int k, int[] arr) {

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int answer = -1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int count = 0;
        for (int i : set) {
            if (++count == k) return i;
        }
        return answer; // always -1
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
