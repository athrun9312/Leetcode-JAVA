public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> res = new HashSet(); 
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num))
                res.add(num);
        }
        int[] ans = new int[res.size()];
        int count = 0;
        for(int num:res)
            ans[count++]=num;
        return ans;
    }
}