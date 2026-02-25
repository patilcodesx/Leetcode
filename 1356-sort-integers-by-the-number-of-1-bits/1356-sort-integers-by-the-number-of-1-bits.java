class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for(int i=0;i<arr.length;i++){
            nums[i] = arr[i];
        } 

        Arrays.sort(nums,(a,b)->{
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if(bitA == bitB){
               return a-b;
            }

            return bitA-bitB;
        });

        for(int i=0;i<arr.length;i++){
            arr[i] = nums[i];
        }

        return arr;

        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         int a = Integer.bitCount(arr[i]);
        //         int b = Integer.bitCount(arr[j]);

        //         if(b<a || (b==a && arr[j]<arr[i])){
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }

        // return arr;
    }
}