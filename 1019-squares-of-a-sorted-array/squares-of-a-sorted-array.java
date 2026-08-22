class Solution {
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }


        for (int i = 0; i < nums.length; i++) {

            boolean swap = false;

            for (int j = 1; j < nums.length - i; j++) {

                if (nums[j] < nums[j - 1]) {

                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;

                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        return nums;
    }
}