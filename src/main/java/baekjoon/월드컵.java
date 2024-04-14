package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {

    // 각 나라별 승, 무, 패 기록
    static int[][] results = new int[6][3];
    static int[][][] inputs;
    static boolean[] answers = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = new int[4][6][3];

        for (int input = 0; input < 4; input++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int country = 0; country < 6; country++) {
                for (int result = 0; result < 3; result++) {
                    inputs[input][country][result] = Integer.parseInt(st.nextToken());
                }
            }
        }
        br.close();

        // 경기의 모든 경우의 수 구하기
        play(0, 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(answers[i] ? "1" : "0").append(" ");
        }
        System.out.println(sb);
    }

    static void play(int curCountry, int targetCountry, int index) {
        if (index >= 1) {
            boolean possible = false;
            test: for (int input = 0; input < 4; input++) {
                if (answers[input]) {
                    continue;
                }

                // 아직 확정되지 않은 입력만 확인
                for (int i = 0; i <= index; i++) {
                    if (inputs[input][i / 3][i % 3] != results[i / 3][i % 3]) {
                        continue test;
                    }
                }

                // 현재까지 가능한 입력이 최소 하나 이상 존재, 계속해서 진행
                possible = true;
                break;
            }

            if (!possible) {
                // 가지치기
                return;
            }
        }

        if (curCountry == 5) {
            // 예제 입력과 결과 비교
            test: for (int input = 0; input < 4; input++) {
                if (answers[input]) {
                    continue;
                }

                for (int country = 0; country < 6; country++) {
                    for (int result = 0; result < 3; result++) {
                        if (inputs[input][country][result] != results[country][result]) {
                            continue test;
                        }
                    }
                }

                answers[input] = true;
            }
            return;
        }

        // 숭, 무 패
        for (int i = 0; i < 3; i++) {
            results[curCountry][i]++;
            results[targetCountry][2 - i]++;

            if (targetCountry == 5) {
                play(curCountry + 1, 0, index + 1);
            } else {
                play(curCountry, targetCountry + 1, index + 1);
            }

            results[curCountry][i]--;
            results[targetCountry][2 - i]--;
        }
    }
}
