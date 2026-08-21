class Solution {
    public int countDigitOne(int n) {

        int count = 0;

        for (int digit = 1; digit <= n; digit *= 10) {

            int high = n / (digit * 10);
            int cur = (n / digit) % 10;
            int low = n % digit;

            if (cur == 0) {
                count += high * digit;
            }
            else if (cur == 1) {
                count += high * digit + low + 1;
            }
            else {
                count += (high + 1) * digit;
            }
        }

        return count;
    }
}