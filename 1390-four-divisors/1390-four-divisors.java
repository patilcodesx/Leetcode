class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalcount =0;
        for(int i=0;i<nums.length;i++){
            int count =0;
            int sum =0;
            for(int j=1;j*j<=nums[i];j++){
                 if(nums[i]%j==0){
                    int d1 = j;
                    int d2 = nums[i]/j;

                    if(d1==d2){
                        count++;
                        sum +=d1;
                    }
                    else{
                        count += 2;
                        sum += d1 + d2;
                    }

                    if(count>4) break;
                 
                 }
            }
            if(count==4){
                totalcount += sum;
            }
        }
        return totalcount;
    }
}