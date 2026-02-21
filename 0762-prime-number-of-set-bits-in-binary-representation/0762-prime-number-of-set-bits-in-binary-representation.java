class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count =0;
        for(int i=left;i<=right;i++){
            int temp = Integer.bitCount(i);
            System.out.print("temp:"+ temp);
            if(isPrime(temp)){
                count++;
                System.out.println(" "+count);
            }
            
        }
        return count;
    }
    private boolean isPrime(int temp){
        if(temp==0 || temp==1) return false;
        for(int i=2;i*i<=temp;i++){
            if(temp%i==0){
                return false;
            }
        }
        return true;
    }
}