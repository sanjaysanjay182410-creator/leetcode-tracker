// Last updated: 9/23/2026, 2:44:23 PM
import java.util.*;

class Solution {

    private int[] stones;
    private Map<Integer, Set<Integer>> map;

    public boolean canCross(int[] stones) {

        this.stones = stones;
        map = new HashMap<>();

        // Store all possible jump sizes for each stone
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // First jump must be 1
        map.get(0).add(0);

        for (int stone : stones) {

            for (int lastJump : map.get(stone)) {

                for (int jump = lastJump - 1;
                     jump <= lastJump + 1;
                     jump++) {

                    if (jump <= 0) {
                        continue;
                    }

                    int nextStone = stone + jump;

                    if (map.containsKey(nextStone)) {
                        map.get(nextStone).add(jump);
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}