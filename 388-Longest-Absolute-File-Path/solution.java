public class Solution {
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int max = 0;
        int curLen = 0;
        Stack<Integer> lengthStack = new Stack<>();
        
        for(String s:tokens) {
            int level = countLevel(s);
            while(lengthStack.size() > level) {
                curLen -= lengthStack.pop();
            }
            int len = s.replaceAll("\t", "").length()+1;
            curLen +=len;
            if(s.contains(".")) {
                max = curLen-1 > max ? curLen-1 : max;
            }
            lengthStack.add(len);
        }
        return max;
    }
    private int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length()-cur.length();
    }
}