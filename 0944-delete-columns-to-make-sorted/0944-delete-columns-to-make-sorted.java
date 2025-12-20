class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int rows = strs.length;
        int count=0;

        for(int i=0;i<cols;i++){
           for(int j=0;j<rows-1;j++){
              if(strs[j].charAt(i) > strs[j+1].charAt(i) ){
                count++;
                break;
              }
           }
        }
       return count;
    }
}