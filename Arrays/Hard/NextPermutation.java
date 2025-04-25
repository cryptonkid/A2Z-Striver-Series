package Arrays.Hard;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        // Step 1: Find the first decreasing element from the end
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index >= 0){
            // Step 2: Find the smallest element greater than nums[index] from the end
            for(int i = n-1; i > index; i--){ //note:: (i > index)
                if(nums[i] > nums[index]){
                    swap(i, index, nums);
                    break;  // Important: break after the first swap
                }
            }
        }
        // Step 3: Reverse the suffix
        reverse(nums, index+1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(i, j,nums);
            i++;
            j--;
        }
    }
    
    private void swap(int i, int j,int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
