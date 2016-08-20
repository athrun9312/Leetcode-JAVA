public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 10;
        int availableNumber = 9;
        int uniqueDigit = 9;
        if(n==0)    return 1;
        while(n-- > 1 && availableNumber >0) {
            uniqueDigit = uniqueDigit * availableNumber;
            res += uniqueDigit;
            availableNumber--;
        }
        return res;
    }
}