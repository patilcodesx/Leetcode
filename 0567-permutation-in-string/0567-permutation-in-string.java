class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(char c: s1.toCharArray()){
            count1[c-'a']++;
        }

        for(int i=0;i<s2.length();i++){
             count2[s2.charAt(i)-'a']++;

             if(i>=s1.length()){
                count2[s2.charAt(i- s1.length())-'a']--;
             }

             if(matches(count1,count2)){
                return true;
             }
        }
        return false;
    }

    private boolean matches(int[] count1,int[] count2){
      for(int i=0;i<26;i++){
        if(count1[i]!=count2[i]){
            return false;
        }
      }
      return true;
    }
}