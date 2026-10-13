
import java.util.*;

class Solution {
    public void helper(int n, int l, int r, String s, List<String> ans) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (l < n) {
            helper(n, l + 1, r, s + "(", ans);
        }

        if (r < l) {
            helper(n, l, r + 1, s + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, "", ans);
        return ans;
    }
}
