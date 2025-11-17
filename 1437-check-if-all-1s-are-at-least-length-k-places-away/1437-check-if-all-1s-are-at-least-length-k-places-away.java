class Solution {
    public boolean kLengthApart(int[] nums, int k) {
      
        List<Integer> pos = new ArrayList<Integer>();
      
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                pos.add(i);
            }
        }
       for(int i=0;i<pos.size()-1;i++){
         System.out.println(pos.get(i+1)+" "+pos.get(i));
            if((pos.get(i+1)-pos.get(i))<=k){
                return false;
            }
           
       }
     return true;
    }
}