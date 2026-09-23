// Last updated: 9/23/2026, 2:52:51 PM
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] chars = curr.toCharArray();
                
                for (int j = 0; j < curr.length(); j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String next = new String(chars);
                        
                        if (next.equals(endWord)) return level + 1;
                        
                        if (wordSet.contains(next)) {
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        
        return 0;
    }
}