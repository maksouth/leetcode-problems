package number_recent_calls_933;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> stack = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        stack.offer(t);
        int lastTime = t - 3000;
        System.out.println("Last time");
        while (stack.peek() < lastTime)
            stack.poll();

        return stack.size();
    }
}
