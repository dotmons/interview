package leetcode;

/*
* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)

Input: intervals = [(2,7)]
Output: 1
Explanation:
Only need one meeting room

* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomTwo {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Edge case: If no meetings, no rooms are required
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> resList = new ArrayList<>();


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int current = 0;
        int room = 0;

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                while (!minHeap.isEmpty()) {
                    System.out.println("Poller >>> "+minHeap.poll());
                }
                minHeap.poll();
                room--;
            }
            minHeap.add(interval.end);
            resList.add(new Interval(current, room));
            current++;
            room++;

        }

        System.out.println("Room intervals: "+resList);
        //[[0, 0], [1, 1], [2, 1]]
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomTwo solution = new MeetingRoomTwo();

        // Test case 1:
        List<Interval> intervals1 = Arrays.asList(
                solution.new Interval(0, 30),
                solution.new Interval(5, 10),
                solution.new Interval(15, 20)
        );
        System.out.println(solution.minMeetingRooms(intervals1)); // Output: 2

        // Test case 2:
        List<Interval> intervals2 = Arrays.asList(
                solution.new Interval(4,8),     //0,0
                solution.new Interval(5, 10),   //1,1
                solution.new Interval(6,8),     //2,2
                solution.new Interval(9,16),    //3,0
                solution.new Interval(15, 20)   //4,1
                //[4, 8], [5, 10], [6, 8], [9, 16], [15, 20]
        );
        System.out.println(solution.minMeetingRooms(intervals2)); // Output: 1

    }

}
