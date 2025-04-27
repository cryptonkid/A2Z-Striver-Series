package Arrays.Hard;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutive {
    /**
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 1;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { // Only check for the start of a sequence
                // This means num is the start of a sequence
                // Initialize current number and streak length
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}