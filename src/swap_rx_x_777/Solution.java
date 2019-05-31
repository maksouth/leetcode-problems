package swap_rx_x_777;

class Solution {
    public boolean canTransform(String s, String e) {
        int p1 = 0;
        int p2 = 0;

        char[] start = s.toCharArray();
        char[] end = e.toCharArray();

        while (p1 < start.length && p2 < start.length) {
            while (p1 < start.length && start[p1] == 'X')
                p1++;

            while (p2 < end.length && end[p2] == 'X')
                p2++;

            if (p1 == start.length && p2 == end.length) return true;
            if (p1 == start.length || p2 == end.length) return false;

            if (start[p1] != end[p2]) return false;

            if (start[p1] == 'L' && p1 < p2) return false;
            if (start[p1] == 'R' && p1 > p2) return false;

            p1++;
            p2++;
        }

        return true;
    }
}