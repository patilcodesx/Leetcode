class Solution {
    int M = 1_000_000_007;;
    public int concatenatedBinary(int n) {
        long result =0;
        int digits = 0;

        for(int num=1;num<=n;num++){
            if((num & (num-1))==0){
                digits++;
             }
                result =((result << digits) + num)%M;
            
        }

        return (int)result;
    }
}