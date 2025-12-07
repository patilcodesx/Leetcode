class Solution {
    public int countOdds(int low, int high) {
        // int count=0;
        // for(int i=low;i<=high;){
        //     if(i%2==1){
        //         count++;
        //         i+=2;
        //     }else{
        //         i++;
        //     }
        // }
        // return count;

        int range = high -low+1;
        if(low%2==1 && high%2==1){
            return (range/2)+1;
        }
        return range/2;


    }
}