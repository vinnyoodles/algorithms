/**
 *Now you are given a string S, which represents a software license key which we would like to format. 
 *The string S is composed of alphanumerical characters and dashes. The dashes split the alphanumerical 
 *characters within the string into groups. 
 *(i.e. if there are M dashes, the string is split into M+1 groups). The dashes in the given string are possibly misplaced.
 * K is the size of the groups that we want to form.
 * 
 * Input: S = "2-4A0r7-4k", K = 4
 * Output: "24A0-R74K" 
 * Complexity: time is O(n), space is O(n)
 */

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> s = new Stack<Character>(); 
        int s_Size = S.length() - 1; 
        int split_Count = 0;
        while ( s_Size >= 0) {
            if (S.charAt(s_Size) == '-') {
                s_Size--;
            } else {
                if (split_Count != K) {
                    s.push(S.charAt(s_Size));
                    split_Count++;
                    s_Size--;
                } else {
                    s.push('-');
                    split_Count = 0;
                }
            }
            
        }
        StringBuilder res = new StringBuilder();
        while(!s.isEmpty()) {
        
            res.append(s.pop());
        }
        return res.toString().toUpperCase();
        
    }
}
