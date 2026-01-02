class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

      
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>=n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}