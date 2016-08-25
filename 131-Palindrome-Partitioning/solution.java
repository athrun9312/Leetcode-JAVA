public class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> curList;
    public List<List<String>> partition(String s) {
       curList = new ArrayList<String>();
        helper(s,0);
        return res;
    }
    
    private void helper(String s, int begin) {
        if(curList.size()>0 && begin>=s.length()) {
            List<String> curCopy = (List<String>)((ArrayList<String>)curList).clone();
            res.add(curCopy);
        }
        for(int i=begin; i<s.length(); i++) {
            if(isPalindrome(s, begin, i)) {
                if(begin==i)
                    curList.add(Character.toString(s.charAt(i)));
                else
                    curList.add(s.substring(begin,i+1));
                helper(s, i+1);
                curList.remove(curList.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int begin, int end) {
        if(begin == end)
            return true;
        while(begin<end) {
            if(str.charAt(begin)!=str.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }
}