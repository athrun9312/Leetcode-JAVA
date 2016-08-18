public class Solution {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new LinkedList<Integer>(), k, n, 1);
        return res;
    }
    public void helper(List<Integer> list, int k, int target, int begin) {
        if(k==0 && target==0) {
            res.add(new LinkedList<Integer>(list));            
        }
        else {
            for (int i=begin; i<=9 && k>0 && target>0;i++) {
                list.add(i);
                helper(list, k-1, target-i, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}