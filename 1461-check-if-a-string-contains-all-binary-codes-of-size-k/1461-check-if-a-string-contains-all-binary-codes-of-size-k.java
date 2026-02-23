class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        //int needed = (int)Math.pow(2,k);
        int needed = 1<<k;
        
        for(int i=k;i<=s.length();i++){
           
            set.add(s.substring(i-k,i));
             if(needed==set.size()){
                return true;
            }
           
        }
          
        return needed==set.size();


    }
}