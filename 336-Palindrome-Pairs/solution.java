public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++)
            map.put(words[i], i);
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<=words[i].length(); j++) {
                String s1 = words[i].substring(0,j);
                String s2 = words[i].substring(j);
                if(isPalindrome(s1)) {
                    String s2rvs = new StringBuilder(s2).reverse().toString();
                    if(map.containsKey(s2rvs) && map.get(s2rvs)!=i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(s2rvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPalindrome(s2)) {
                    String s1rvs = new StringBuilder(s1).reverse().toString();
                    if(map.containsKey(s1rvs) && map.get(s1rvs)!=i  && s2.length()!=0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(s1rvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(r>=l) {
            if(s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
}