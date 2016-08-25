public class Solution {
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int max = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String s:tokens) {
            int level = countLevel(s);
            while(stack.size() > level) {
                curLen -= stack.pop();
            }
            int len = s.replaceAll("\t", "").length()+1;
            curLen +=len;
            if(s.contains(".")) {
                max = curLen-1 > max ? curLen-1 : max;
            }
            stack.add(len);
        }
        return max;
    }
    private int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length()-cur.length();
    }
}