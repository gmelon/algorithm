package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 신기한_키보드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        List<Character> letters = new ArrayList<>();
        for (char s : S.toCharArray()) {
            letters.add(s);
        }

        List<Character> sortedLetters = letters.stream()
            .sorted()
            .collect(Collectors.toList());

        int index = 0;
        int count = 0;
        for (Character current : sortedLetters) {
            int nearestIndex = findNearestIndex(letters, current, index);
            count += (Math.abs(index - nearestIndex) + 1);
            index = nearestIndex;
        }

        System.out.println(count);
    }

    static int findNearestIndex(List<Character> letters, char target, int currentIndex) {
        int left = currentIndex;
        int right = currentIndex;

        while (left >= 0 || right < letters.size()) {
            if (left >= 0 && letters.get(left) == target) {
                letters.set(left, ' ');
                return left;
            }
            if (right < letters.size() && letters.get(right) == target) {
                letters.set(right, ' ');
                return right;
            }
            left--;
            right++;
        }
        throw new IllegalStateException();
    }

}
