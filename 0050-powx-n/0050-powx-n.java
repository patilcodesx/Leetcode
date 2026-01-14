class Solution {
    public double myPow(double x, int n) {
       long N=n;
        if(N<0){
            x =1/x;
            N = -N;
           
        }
      return Pow(x,N);  
       
    }
    private double Pow(double x,long n){
        if(n==0){
            return 1.0;
        }

        if(n==1){
            return x;
        }

       if(n%2==0){
         return Pow(x*x,n/2);
       }
         return x * Pow(x,n-1);
    }
}