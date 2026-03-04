class Solution {
    int start =0;
    int maxlen = 1;

    private void expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length()  && s.charAt(left)==s.charAt(right)){

            if(right-left+1 > maxlen){
                start = left;
                maxlen = right - left+1;
            }
            left--;
            right++;
        }

    }
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        for(int i=0;i<s.length();i++){

            expandAroundCenter(s,i,i);

            expandAroundCenter(s,i,i+1);
        }

        return s.substring(start,start+maxlen);
    }
}