class TreeAncestor {

    int LOG;
    int[][] up;

    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = up[i][j - 1];

                if (mid == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[mid][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int bit = 0;

        while (k > 0 && node != -1) {
            if ((k & 1) == 1) {
                node = up[node][bit];
            }

            k >>= 1;
            bit++;
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */