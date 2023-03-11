package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class P08_09 {

    private static int[] result;

    public static void solution(int n, int r) {
        result = new int[r];
        combi(0, 1, n, r);
    }

    public static void combi(int resultIndex, int value, int valueLimit, int combiAmount) {
        if (resultIndex == combiAmount) {
            System.out.println(Arrays.toString(result));
        }
        else {
            for (int i = value ; i <= valueLimit; i++) {
                result[resultIndex] = i;
                combi(resultIndex + 1, i + 1, valueLimit, combiAmount);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        solution(n, r);
    }
}