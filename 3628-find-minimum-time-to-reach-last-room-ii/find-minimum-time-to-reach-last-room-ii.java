import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        long INF = Long.MAX_VALUE / 4;
        long[][][] dist = new long[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        dist[0][0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a.time)
        );

        pq.offer(new Node(0, 0, 0, 0));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            long time = cur.time;
            int r = cur.r;
            int c = cur.c;
            int state = cur.state;

            if (time != dist[r][c][state])
                continue;

            if (r == n - 1 && c == m - 1)
                return (int) time;

            int cost = state == 0 ? 1 : 2;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                long startTime = Math.max(
                    time,
                    (long) moveTime[nr][nc]
                );

                long newTime = startTime + cost;
                int nextState = 1 - state;

                if (newTime < dist[nr][nc][nextState]) {
                    dist[nr][nc][nextState] = newTime;
                    pq.offer(new Node(newTime, nr, nc, nextState));
                }
            }
        }

        return -1;
    }

    static class Node {
        long time;
        int r, c, state;

        Node(long time, int r, int c, int state) {
            this.time = time;
            this.r = r;
            this.c = c;
            this.state = state;
        }
    }
}