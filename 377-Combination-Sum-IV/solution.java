public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        memo[0] = 1;
        Arrays.sort(nums);
        for(int i=1; i<=target; i++) {
            for(int num:nums) {
                if(i>=num)
                    memo[i] += memo[i-num];
            }
        }
        return memo[target];
    }
}