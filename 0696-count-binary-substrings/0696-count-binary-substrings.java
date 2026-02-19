class Solution {
    public int countBinarySubstrings(String s) {
       int count =0;
       int preGroup = 0;
       int currGroup = 1;

       for(int i=1;i<s.length();i++){
         if(s.charAt(i)==s.charAt(i-1)){
            currGroup++;
         }
         else{
            count += Math.min(preGroup,currGroup);
            preGroup = currGroup;
            currGroup = 1;
         }
       }

       count += Math.min(preGroup,currGroup);

       return count;
    }
}