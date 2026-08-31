import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {

        Arrays.sort(nums);

        int n = nums.length;
        int ans = 1;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int target : freq.keySet()) {

            int left = lowerBound(nums, target - k);
            int right = upperBound(nums, target + k);

            int totalReachable = right - left;

            int alreadyEqual = freq.get(target);

            int canChange = totalReachable - alreadyEqual;

            int current = alreadyEqual +
                    Math.min(canChange, numOperations);

            ans = Math.max(ans, current);
        }

        int left = 0;

        for (int right = 0; right < n; right++) {

            while ((long) nums[right] - nums[left] > 2L * k) {
                left++;
            }

            int total = right - left + 1;

            ans = Math.max(ans, Math.min(total, numOperations));
        }

        return ans;
    }

    private int lowerBound(int[] nums, int target) {

        int l = 0, r = nums.length;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private int upperBound(int[] nums, int target) {

        int l = 0, r = nums.length;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}