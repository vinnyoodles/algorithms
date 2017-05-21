public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if( strs.length == 0) return ""; 
    StringBuilder res = new StringBuilder(); 
    int i = 0; 

    // get the length of the shortest string
    int shortestString = getShortestString(strs);

    while (i < shortestString) {
      char c = strs[0].charAt(i); 
      for ( int j = 0; j < strs.length;  j++) {
        if(c != strs[j].charAt(i)){  
          return res.toString();
        }
      }
      i++;
      res.append(c);

    }
    return res.toString();
  }


  public int getShortestString(String[] strings) {
    int minHeight = Integer.MAX_VALUE; 
    for(int i = 0; i < strings.length; i++) {
      minHeight = Math.min(minHeight, strings[i].length());
    }
    return minHeight;
  }
}
