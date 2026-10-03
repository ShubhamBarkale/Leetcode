class Solution {
    public int countLargestGroup(int n) {

        int[] count = new int[37];

        // Find digit sum for every number
        for (int i = 1; i <= n; i++) {

            int num = i;
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            count[sum]++;
        }

        // Find the largest group size
        int max = 0;

        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        // Count how many groups have the largest size
        int answer = 0;

        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                answer++;
            }
        }

        return answer;
    }
}
