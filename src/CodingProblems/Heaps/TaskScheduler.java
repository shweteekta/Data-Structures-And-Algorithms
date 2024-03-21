package Heaps;

import java.util.*;

public class TaskScheduler {
//    Input: tasks = ["A","A","A","B","B","B"], n = 2
//    Output: 8
//    Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
//    After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
//
//    1. Put the frequencies in priority queue and create a queue of frequency and time when they will be available again and insert it into pq from q
    // https://leetcode.com/problems/task-scheduler/solutions/4816379/java-easy-solution-using-priority-queue-queue/
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Character, Integer> count = new HashMap<>();
        int interval = 0;

        for (Character task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        pq.addAll(count.values());

        while (!pq.isEmpty() || !queue.isEmpty()) {
            interval++;
            if (!pq.isEmpty()) {
                int frequency = pq.poll() - 1;
                if (frequency > 0) {
                    queue.offer(new Pair(frequency, interval + n));
                }
            }
            while (!queue.isEmpty() && queue.peek().idleTime == interval) {
                pq.offer(queue.poll().frequency);
            }
        }

        return interval;
    }

    class Pair {
        int frequency;
        int idleTime;

        Pair(int frequency, int idleTime) {
            this.frequency = frequency;
            this.idleTime = idleTime;
        }
    }
}
