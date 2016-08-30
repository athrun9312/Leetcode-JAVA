public class Solution {
    public int getMoneyAmount(int n) {
        int[][] cost = new int[n+1][n+1];
        return helper(cost, 1, n);
    }
    private int helper(int[][] cost, int begin, int end) {
        if(begin>=end) return 0;
        if(cost[begin][end]!=0)
            return cost[begin][end];
        int res = Integer.MAX_VALUE;
        for(int i = begin; i<=end; i++) {
            int cur = i + Math.max(helper(cost,begin,i-1),helper(cost,i+1,end));
            res = Math.min(cur, res);
        }
        cost[begin][end] = res;
        return res;
    }
}