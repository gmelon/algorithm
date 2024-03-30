package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Y수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int asc = 0;
        int desc = 0;

        // 증가 수열 확인
        boolean reversed = false;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (reversed) {
                    asc = Integer.MAX_VALUE;
                    break;
                }
                reversed = true;
                asc = i + 1;
            }
        }

        if (arr[0] < arr[N - 1]) {
            asc = Integer.MAX_VALUE;
        }

        // 감소 수열 확인
        reversed = false;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (reversed) {
                    desc = Integer.MAX_VALUE;
                    break;
                }
                reversed = true;
                desc = i + 1;
            }
        }

        if (arr[0] > arr[N - 1]) {
            desc = Integer.MAX_VALUE;
        }

        if (asc == desc && asc == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(asc, desc));
        }
    }

}
