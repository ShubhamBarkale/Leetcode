import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            if (found && !result.contains(nums1[i])) {
                result.add(nums1[i]);
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}