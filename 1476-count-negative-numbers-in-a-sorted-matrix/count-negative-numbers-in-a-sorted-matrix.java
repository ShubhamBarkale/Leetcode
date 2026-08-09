class Solution {
    public int countNegatives(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0) {

            if (grid[i][j] < 0) {

                count += rows - i;
                j--;

            } else {

                i++;
            }
        }

        return count;
    }
}