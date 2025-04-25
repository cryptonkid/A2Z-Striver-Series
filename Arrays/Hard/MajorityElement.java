package Arrays.Hard;

/**
 * Find the majority element which is present more than n/2 times in an array.
 * 
 */
public class MajorityElement {
    /**
     * Finds the majority element in an array (appears more than n/2 times).
     * Uses the Boyer-Moore Voting Algorithm for O(n) time and O(1) space.
     * 
     * @param nums The input array of integers
     * @return The majority element
     */
    public int majorityElement(int[] nums) {
        // Initialize count and candidate for the voting algorithm
        int count = 0;
        int candidate = 0;
        
        // Iterate through each number in the array
        for (int num : nums) {
            // When count drops to zero, we choose a new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // If the current number matches our candidate, increment count
            // Otherwise, decrement count (simulating a "vote against")
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
            
            // Intuition: The majority element will survive this process because:
            // 1. It occurs more than all other elements combined
            // 2. Every other element can cancel at most one occurrence of it
            // 3. Therefore, it will remain as the candidate at the end
        }
        
        // Note: The algorithm assumes a majority element exists.
        // In problems where existence isn't guaranteed, you would need to verify:
        // int actualCount = 0;
        // for (int num : nums) if (num == candidate) actualCount++;
        // return (actualCount > nums.length/2) ? candidate : -1;
        
        return candidate;
    }
}