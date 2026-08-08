class Solution {
    public int oddCells(int m, int n, int[][] indices) {

        int[] row = new int[m];
        int[] col = new int[n];

       
        for (int i = 0; i < indices.length; i++) {

            int r = indices[i][0];
            int c = indices[i][1];

            row[r]++;
            col[c]++;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}