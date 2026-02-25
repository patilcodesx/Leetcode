class Solution {
    public int[] sortByBits(int[] arr) {
        

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = Integer.bitCount(arr[i]);
                int b = Integer.bitCount(arr[j]);

                if(b<a || (b==a && arr[j]<arr[i])){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}