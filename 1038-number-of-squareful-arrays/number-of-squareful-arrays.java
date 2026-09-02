import java.util.*;

class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, -1, 0);
    }

    private int backtrack(int[] nums, boolean[] used, int prev, int count) {
        if (count == nums.length) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            if (prev != -1 && !isSquare((long) prev + nums[i]))
                continue;

            used[i] = true;

            ans += backtrack(nums, used, nums[i], count + 1);

            used[i] = false;
        }

        return ans;
    }

    private boolean isSquare(long n) {
        long root = (long) Math.sqrt(n);
        return root * root == n;
    }
}