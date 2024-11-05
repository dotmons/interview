package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MeetingRoom {

    /*
    * Given an array of meeting time intervals consisting of start and end times
    * [(s1,e1),(s2,e2),...] (si < ei), determine if a person could attend all meetings.
    *
    * Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation:
(0,30), (5,10) and (0,30),(15,20) will conflict
*
*
* Input: intervals = [(5,8),(9,15)]
Output: true
Explanation:
Two times will not conflict
*
* */



    public MeetingRoom() {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(15,20));
        intervals.add(new Interval(5,10));
        System.out.println(canAttendMeetings(intervals));

    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        //int min = 0;
        intervals.sort((a,b) -> a.start - b.start);

        if (intervals.size() < 2) {
            return false;
        }
        boolean isFirst = false;
        int max = intervals.get(0).end;
        int last = 0;
        for (Interval inter : intervals) {
            if (isFirst) {
                last = Math.max(inter.start, max);
                if ((last - max) > 0) {
                    max = last;
                } else {
                    return false;
                }
            }
            isFirst = true;
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRoom solution = new MeetingRoom();
    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
