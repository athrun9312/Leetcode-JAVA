public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            if(i<=n) {
                helper(res, n, i);
            }
        }
        return res;
    }
    private void helper(List<Integer> res, int n, int last) {
        if(last>n) 
            return;
        else 
            res.add(last);
            
        for(int i=0; i<=9; i++) {
            helper(res, n, last*10+i);
        }
    }
}