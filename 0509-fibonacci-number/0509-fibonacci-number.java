class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int fib(int n) {
        //Base case
        if(n==0) return 0;
        if(n==1) return 1;

        // //Recursive call
        // return fib(n-1) + fib(n-2);

        // //Memoization
        // if(memo.containsKey(n)) return memo.get(n);

        // int result = fib(n-1) + fib(n-2);
        // memo.put(n,result);

        // return result;


        int prev2 = 0 ;//F(n-2)
        int prev1 = 1; //F(n-1)
        int current = 0;

        for(int i=2;i<=n;i++){
            current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;

    }
}