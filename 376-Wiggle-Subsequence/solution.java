public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int k = 1;
        while(k<nums.length && nums[k] == nums[k-1]) k++;
        if(k == nums.length)
            return 1;
        int count = 2;
        boolean increasing = nums[k]<nums[k-1];
        for(int i=k; i<nums.length; i++) {
            if((increasing && nums[i]>nums[i-1]) ||(!increasing && nums[i]<nums[i-1])) {
                increasing = !increasing;
                count++;
            }
        }
        return count;
    }
}