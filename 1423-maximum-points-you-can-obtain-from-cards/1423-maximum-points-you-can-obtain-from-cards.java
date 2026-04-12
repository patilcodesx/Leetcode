class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int total = 0;

        for(int i=0;i<k;i++){
            total += cardPoints[i];
        }

        int maxPoints = total;
        for(int i=0;i<k;i++){
            total -= cardPoints[k-1-i];

            total += cardPoints[n-1-i];

            maxPoints = Math.max(maxPoints,total);
        }
        return maxPoints;
        //Brute Force
        // int n = cardPoints.length;
        // int maxsum = 0;

        // for(int i=0;i<=k;i++){
        //   int tempsum =0;

        //   for(int j=0;j<i;j++){
        //     tempsum+= cardPoints[j];
        //   }

        //   for(int j=0;j<k-i;j++){
        //     tempsum += cardPoints[n-1-j];
        //   }

        //   maxsum = Math.max(maxsum,tempsum);
        // }
        // return maxsum;
    }
}