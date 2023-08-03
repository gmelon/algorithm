package nadongbin.binary_search.n6;

import java.util.Arrays;
import java.util.Comparator;

public class 가사_검색 {

    /* https://school.programmers.co.kr/learn/courses/30/lessons/60060# */

    // 뒤에서부터 char을 비교하여 정렬하는 Comparator
    Comparator<String> reverseComparator = (s1, s2) -> {
        // 길이는 기존대로 우선 적용
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }

        // 오름차순으로 정렬하지만, 뒤에서부터 문자를 확인
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        return 0; // 서로 같음
    };

    // 와일드카드를 제외한 부분끼리 비교하는 Comparator
    Comparator<String> comparator = (words, queries) -> {
        if (queries.endsWith("?")) {
            // 뒷 부분에 와일드카드가 있는 경우
            int prevLength = queries.length();
            queries = queries.replaceAll("[?]+", "");
            int wildCardLength = prevLength - queries.length();
            words = words.substring(0, words.length() - wildCardLength);

            // 와일드카드 부분을 지운 후 동일하게 비교
            if (words.length() == 0) {
                return 0;
            }
            return words.compareTo(queries);
        } else {
            // 앞 부분에 와일드카드가 있는 경우
            int prevLength = queries.length();
            queries = queries.replaceAll("[?]+", "");
            int wildCardLength = prevLength - queries.length();
            words = words.substring(wildCardLength);

            // 와일드카드 부분을 지운 후 동일하게 비교
            if (words.length() == 0) {
                return 0;
            }
            return reverseComparator.compare(words, queries);
        }
    };

    public int[] solution(String[] words, String[] queries) {

        Arrays.sort(words);

        // 뒤에서부터 정렬하는 기준으로 정렬된 words 배열
        String[] reverseWords = words.clone();
        Arrays.sort(reverseWords, reverseComparator);

        // 모든 쿼리에 대하여 반복 수행
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            // 와일드카드의 등장 위치에 따라 이분 탐색에 다른 기준으로 정렬된 배열을 사용
            String[] targetWords = {};
            if (queries[i].endsWith("?")) {
                targetWords = words;
            } else {
                targetWords = reverseWords;
            }

            // words에서 매칭되는 시작 index 찾기
            int start = 0;
            int end = targetWords.length - 1;
            int startIndex = -1; // -1이면 존재하지 않음
            while (start <= end) {
                int mid = (start + end) / 2;
                int compareResult = comparator.compare(targetWords[mid], queries[i]);
                if (compareResult == 0) {
                    // 같을 때 마다 갱신
                    startIndex = mid;
                }
                // 양수면 words가 더 큼, 좌측으로 이동
                // 시작점을 찾을 것이므로 같아도 계속해서 좌측으로 이동
                if (compareResult >= 0) {
                    end = mid - 1;
                } else {
                    // 음수면 words가 더 작음, 우측으로 이동
                    start = mid + 1;
                }
            }

            // words에서 매칭되는 끝 index 찾기
            start = 0;
            end = targetWords.length - 1;
            int endIndex = -1; // -1이면 존재하지 않음
            while (start <= end) {
                int mid = (start + end) / 2;
                int compareResult = comparator.compare(targetWords[mid], queries[i]);
                if (compareResult == 0) {
                    // 같을 때 마다 갱신
                    endIndex = mid;
                }
                // 양수면 words가 더 큼, 좌측으로 이동
                if (compareResult > 0) {
                    end = mid - 1;
                } else {
                    // 음수면 words가 더 작음, 우측으로 이동
                    // 끝점을 찾을 것이므로 같아도 계속해서 우측으로 이동
                    start = mid + 1;
                }
            }

            if (startIndex == -1) {
                answer[i] = 0;
            } else {
                answer[i] = endIndex - startIndex + 1;
            }
        }

        return answer;
    }
}
