class Solution {
    public int countTriples(int n) {
        int count =0;
        for(int i=1;i<n-1;i++){
          
            for(int j=i+1;j<=n;j++){
               
                int req = (int)Math.sqrt(i*i + j*j);
                if((req*req) == (i*i + j*j) && req<=n){
                    count+=2;
                }
            }

        }
        return count;
    }
}