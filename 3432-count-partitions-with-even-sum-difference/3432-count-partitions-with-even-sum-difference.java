class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            int num1 =0;
            int num2 =0;
            int diff = 0;
            for(int j=0;j<=i;j++){
                num1 += nums[j];
            }

            for(int j=i+1;j<nums.length;j++){ 
               num2 += nums[j];
            }

              diff = num1 - num2;
              if(diff%2==0){
                System.out.println(diff);
                 count++;
              }
              
        }
        return count;
    }
}