class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {

        int xor2 = 0;
        for (int num : arr2) {
            xor2 ^= num;
        }

        int ans = 0;
        for (int num : arr1) {
            ans ^= (num & xor2);
        }

        return ans;
    }
}