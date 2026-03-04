class Solution {
    public int majorityElement(int[] nums) {
    //     int candidate = nums[0];
    //     int count =1;
 
    //  for(int i=1;i<nums.length;i++){
    //     if(count==0){
    //         candidate = nums[i];
    //         count =1;
    //     }else if(nums[i] == candidate){
    //         count++;
    //     }else{
    //         count--;
    //     }

    //  }
    //  return candidate;

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int num : nums){
        map.put(num,map.getOrDefault(num,0)+1);
        if(map.get(num) > nums.length/2){
            return num;
        }
    }
    return -1;


    }
}