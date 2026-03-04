class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];

        answers[0] =1;
        for(int i=1;i<nums.length;i++){
            answers[i] = answers[i-1] * nums[i-1];
        }

        int rightproducts = 1;
        for(int i=n-1;i>=0;i--){
            answers[i] = answers[i] * rightproducts;
            rightproducts *= nums[i];
        }

        return answers;
    }
}