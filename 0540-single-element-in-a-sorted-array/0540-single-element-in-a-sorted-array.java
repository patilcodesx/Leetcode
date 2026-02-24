class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int xor=0;
        // for(int i=0;i<nums.length;i++){
        //    xor ^= nums[i];
        // }
        // return xor;

        int left =0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;

            //make mid is even
            if(mid%2==1){
                mid--;
            }

            if(nums[mid]==nums[mid+1]){
                left = mid+2;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}