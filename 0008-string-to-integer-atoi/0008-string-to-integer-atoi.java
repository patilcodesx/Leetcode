class Solution {
    public int myAtoi(String input) {
        int i=0;
        int n = input.length();

        long result =0;
        //remove white spaces
        while(i<n && input.charAt(i)==' '){
            i++;
        }

        int sign =1;
        if(i<n &&(input.charAt(i)=='+' || input.charAt(i)=='-')){
            if(input.charAt(i)=='-'){
                sign = -1;
            }
            i++;
        }

        while(i<n && input.charAt(i)>='0' && input.charAt(i)<='9'){
            int digit = input.charAt(i)-'0';

            result = result*10+digit;
            i++;

            long signedValue = sign * result;
            if(signedValue >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(signedValue <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
      return (int) (sign*result);
    }
}