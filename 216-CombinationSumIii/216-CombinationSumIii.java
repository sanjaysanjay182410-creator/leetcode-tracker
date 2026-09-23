// Last updated: 9/23/2026, 2:48:56 PM
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return ans;
    }

    private void backtrack(int start, int k, int target, List<Integer> current) {

        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {

            if (i > target) {
                break;
            }

            current.add(i);

            backtrack(i + 1, k - 1, target - i, current);

            current.remove(current.size() - 1);
        }
    }
}
