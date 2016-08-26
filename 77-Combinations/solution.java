public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    private void helper(List<Integer> cur, int begin, int n, int k) {
        if(k==0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=begin; i<=n; i++) {
            cur.add(i);
            helper(cur, i+1, n, k-1);
            cur.remove(cur.size()-1);
        }
    }
}