package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Y수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean fixed = false; // 방향이 정해졌는가?

        int ascK = 0; // 최초로 방향이 바뀌는 시점까지의 값
        boolean ascCrossed = false; // 최초 한번 방향이 바뀌었는가?
        int descK = 0; // 최초로 방향이 바뀌는 시점까지의 값
        boolean descCrossed = false; // 최초 한번 방향이 바뀌었는가?

        boolean asc = false; // 최초에 두 숫자가 오림차순인지 여부
        boolean desc = false; // 최초에 두 숫자가 내림차순인지 여부
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int first = prev; // 최초의 숫자
        for (int i = 1; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (!ascCrossed) {
                ascK++;
            }
            if (!descCrossed) {
                descK++;
            }

            if (prev == current) {
                continue; // 같으면 영향 X
            }

            if (prev > current) {
                desc = true;
            } else {
                asc = true;
            }

            if ((desc && prev < current)) {
                if (descCrossed) {
                    System.out.println(-1);
                    return;
                } else {
                    descCrossed = true;
                }
            }

            if ((asc && prev > current)) {
                if (ascCrossed) {
                    System.out.println(-1);
                    return;
                } else {
                    ascCrossed = true;
                }
            }

            if (descCrossed) {
                if (first > current) {
                    System.out.println(-1);
                    return;
                }
            }

            if (ascCrossed) {
                if (first < current) {
                    System.out.println(-1);
                    return;
                }
            }

            prev = current;
        }

        if (ascCrossed || descCrossed) {
            System.out.println(Math.min(ascK, descK));
        } else {
            System.out.println(0);
        }
    }

}
