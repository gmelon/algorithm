package baekjoon;

import java.util.Scanner;

public class 선물전달 {
    static int N;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        visited = new boolean[N];
        find(0);
        System.out.println(count);
    }

    static void find(int giver) {
        if (giver == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && i != giver) {
                visited[i] = true;
                find(giver + 1);
                visited[i] = false;
            }
        }


    }



}
