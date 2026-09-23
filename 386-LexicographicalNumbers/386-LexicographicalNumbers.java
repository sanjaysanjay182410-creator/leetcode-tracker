// Last updated: 9/23/2026, 2:46:27 PM
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    private void dfs(int num, int n, List<Integer> result) {

        if (num > n) {
            return;
        }

        result.add(num);

        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;

            if (next > n) {
                break;
            }

            dfs(next, n, result);
        }
    }
}