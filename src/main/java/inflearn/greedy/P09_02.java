package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P09_02 {

    public static class Meeting implements Comparable<Meeting>{

        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo( Meeting o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }
    }

    public static int solution(int n, List<Meeting> meetingList) {
        int meetingCount = 0;

        Collections.sort(meetingList);

        int recentEndTime = 0;

        for (Meeting meeting : meetingList) {
            if (meeting.startTime >= recentEndTime) {
                meetingCount++;
                recentEndTime = meeting.endTime;
            }
        }
        return meetingCount;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetingList.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(n, meetingList));
    }
}