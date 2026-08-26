class Solution {
    public int thirdMax(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        int count = 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] != nums[i + 1]) {
                count++;

                if (count == 3) {
                    return nums[i];
                }
            }
        }

        return nums[nums.length - 1];
    }
}



