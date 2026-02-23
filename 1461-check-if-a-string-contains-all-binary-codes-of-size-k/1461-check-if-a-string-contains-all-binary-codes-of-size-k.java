class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        int needed = 1 << k;
        
        for(int i=k;i<=s.length();i++){
           
            set.add(s.substring(i-k,i));
             if(needed==set.size()){
                return true;
            }
            System.out.println(s.substring(i-k,i));
        }
          System.out.println(2*k+" "+set.size());
        return needed==set.size();


    }
}