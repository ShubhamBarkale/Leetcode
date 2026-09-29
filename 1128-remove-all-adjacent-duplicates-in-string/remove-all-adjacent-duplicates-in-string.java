class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int n = stack.length();

            if (n > 0 && stack.charAt(n - 1) == ch) {
                stack.deleteCharAt(n - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}