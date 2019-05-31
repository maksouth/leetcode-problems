package exam_room_855;

import java.util.PriorityQueue;

class ExamRoom {

    private final PriorityQueue<Interval> distanceQueue;
    private final int totalSeats;

    public ExamRoom(int N) {

        totalSeats = N;

        distanceQueue = new PriorityQueue<>((i1, i2) -> {
            if (i1.distance > i2.distance)
                return -1;
            if (i1.distance == i2.distance && i1.start < i2.start)
                return -1;
            return 1;
        });

        Interval interval = new Interval(0, N, N);
        distanceQueue.add(interval);
    }

    public int seat() {
        Interval interval = distanceQueue.poll();

        int seat;

        if (interval.isSide()) {

            int newStart = interval.start;
            int newEnd = interval.end;

            if (interval.start == 0) {
                seat = 0;
                newStart = seat + 1;
            } else {
                seat = interval.end - 1;
                newEnd = interval.end - 1;
            }

            int newDistance = calculateDistance(newStart, newEnd);
            if (newStart == 0 || newEnd == totalSeats)
                newDistance = newEnd - newStart;

            Interval newInterval = new Interval(newStart, newEnd, newDistance);
            distanceQueue.add(newInterval);

        } else {
            seat = interval.start + interval.distance;

            int leftDistance = calculateDistance(interval.start, seat);
            int rightDistance = calculateDistance(seat+1, interval.end);

            if (interval.start != seat) {
                Interval newLeft = new Interval(interval.start, seat, leftDistance);
                distanceQueue.add(newLeft);
            }

            if (seat + 1 != interval.end) {
                Interval newRight = new Interval(seat + 1, interval.end, rightDistance);
                distanceQueue.add(newRight);
            }
        }

        return seat;
    }

    private int calculateDistance(int start, int end) {
        int distance = end - start;
        distance -= (distance-1) % 2;
        distance /= 2;
        return distance;
    }

    public void leave(int p) {
        Interval leftInterval = findWithEnd(p);
        Interval rightInterval = findWithStart(p+1);

        int mergedStart = leftInterval.start;
        int mergedEnd = rightInterval.end;
        int mergedDistance = calculateDistance(mergedStart, mergedEnd);
        if (mergedEnd == totalSeats || mergedStart == 0)
            mergedDistance = mergedEnd - mergedStart;

        Interval mergedInterval = new Interval(mergedStart, mergedEnd, mergedDistance);

        distanceQueue.remove(leftInterval);
        distanceQueue.remove(rightInterval);
        distanceQueue.add(mergedInterval);
    }

    private Interval findWithStart(int start) {
        for (Interval interval: distanceQueue)
            if (interval.start == start)
                return interval;
        return new Interval(start, totalSeats, totalSeats - start);
    }

    private Interval findWithEnd(int end) {
        for (Interval interval: distanceQueue)
            if (interval.end == end)
                return interval;
        return new Interval(0, end, end);
    }

    private static class Interval {
        final int start;
        final int end;
        final int distance;

        public Interval(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        boolean isSide() {
            return distance == end - start;
        }
    }
}
