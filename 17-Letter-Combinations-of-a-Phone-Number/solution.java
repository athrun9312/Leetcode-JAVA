public class Solution {
    List<String> res = new ArrayList<String>();
    String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)
            return res;
        helper("", digits, 0);
        return res;
    }
    private void helper(String prefix, String digits, int begin) {
        if(begin>=digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = map[digits.charAt(begin) - '0'];
        for(int i=0; i<letters.length(); i++) 
            helper(prefix+letters.charAt(i), digits, begin+1);
    }
}