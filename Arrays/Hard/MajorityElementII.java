package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * Find the majority element which is present more than n/3 times in an array.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;

        // First pass: Find the two candidates
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        if (count1 > nums.length / 3) result.add(cand1);
        if (count2 > nums.length / 3) result.add(cand2);

        return result;
    }
}
/**
 * Generalization for ⌊n/k⌋ Times
To find elements appearing more than ⌊n/k⌋ times, we can track k−1 candidates (since at most k−1 such elements can exist).

Pseudocode:
function majorityElements(nums, k):
    candidates = new HashMap<integer, integer>(k-1)  // Store candidates and counts
    for num in nums:
        if num is in candidates:
            candidates[num]++
        else if candidates has less than k-1 entries:
            candidates[num] = 1
        else:
            decrement all counts in candidates
            remove entries where count == 0

    // Verification pass
    reset all counts in candidates to 0
    for num in nums:
        if num is in candidates:
            candidates[num]++

    result = []
    for (num, count) in candidates:
        if count > nums.length / k:
            result.append(num)
    return result
 */