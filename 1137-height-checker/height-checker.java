class Solution {
    public int heightChecker(int[] heights) {

    
        int[] expected = heights.clone();

        for (int i = 0; i < expected.length; i++) {

            boolean swap = false;

            for (int j = 1; j < expected.length - i; j++) {

                if (expected[j] < expected[j - 1]) {

                    int temp = expected[j - 1];
                    expected[j - 1] = expected[j];
                    expected[j] = temp;

                    swap = true;
                }
            }

       
            if (!swap) {
                break;
            }
        }


        int count = 0;

        for (int i = 0; i < heights.length; i++) {

            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }
}