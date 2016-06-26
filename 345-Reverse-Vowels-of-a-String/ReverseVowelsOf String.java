public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        int head=0, tail=s.length()-1;
        char[] ch = s.toCharArray();
        while(tail >= head){
            if(!vowelSet.contains(s.charAt(head))){
                head ++;
                continue;
            }
            if(!vowelSet.contains(s.charAt(tail))){
                tail ++;
                continue;
            }
            char tmp = ch[head];
            ch[head] = ch[tail];
            ch[tail] = tmp;
            head++;
            tail--;
        }
        return new String(ch);
    }
}