public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        return helper(s.toCharArray(),0,p.toCharArray(),0);
    }
    private boolean helper(char[] s, int i, char[] p, int j) {
        if(j==p.length)
            return i==s.length;
        if(j==p.length-1 || p[j+1] !='*') {
            if(i<s.length && (p[j]=='.' || s[i]==p[j])) {
                return helper(s, i+1, p, j+1);
            } else {
                return false;
            }
        }
        //  p[j+1] == '*'
        while(i<s.length && (p[j]=='.' || s[i]==p[j])) {
            if(helper(s,i,p,j+2))
                return true;
            i++;
        }
        return helper(s,i,p,j+2);
    }
}