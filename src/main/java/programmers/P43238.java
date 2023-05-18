package programmers;

public class P43238 {

    public long solution(int n, int[] times) {
        long start = 0L;
        long end = 1_000_000_000L * n;

        long answer = 0L;
        while (start <= end) {
            long mid = (start + end) / 2;
            long availableNumber = currentAvailableNumber(times, mid);

            if (availableNumber >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public long currentAvailableNumber(final int[] times, long currentTime) {
        long availableNumber = 0L;
        for (int time : times) {
            availableNumber += (currentTime / time);
        }
        return availableNumber;
    }
}
