class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long two =6;
        long three =6;

        for(int i=2;i<=n;i++){
           long newTwo = (2*two + 2*three)%MOD;
           long newThree = (2*two + 3*three)%MOD;

           two = newTwo;
           three = newThree;
        } 
        return (int) ((two+three)% MOD);

    }
}