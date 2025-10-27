import java.math.BigInteger;
class Solution {
     public int numberOfBeams(String[] bank) {

        
    //      int n = bank.length;
    // //     int m = bank[0].length();
    // //     int[][] floor = new int[n][m];
    //      int[] count = new int[n];
    // //    // System.out.println(n+" "+m);

    //    for(int i=0;i<count.length;i++){
    //     count[i] =  new BigInteger(bank[i],2).bitCount();
    //    }

    // //     for(int i=0;i<n;i++){
    // //         String b = bank[i];
    // //         for(int j=0;j<m;j++){
    // //             int temp = b.charAt(j)-'0';
    // //            // System.out.println(temp);
    // //             if(temp==1){
    // //              floor[i][j] = 1;
    // //              count[i]++;
    // //             }
    // //         }
    // //     }
    // //   System.out.println(Arrays.toString(count));
      
    //   int count2 = 0;
    //   int j=0;
    //   for(int i=0;i<count.length;i++){
    //     if(count[i]!=0){
    //         count[j++] = count[i]; 
    //     }
    //   }
    //   count = Arrays.copyOf(count,j);


    //    for(int i=0;i<count.length-1;i++){
    //     count2 += count[i]*count[i+1];
    //    }
       

    //   //  System.out.println(Arrays.deepToString(floor));

    //     return count2;
    int prev =0;
    int result =0;
    for(String row: bank){
        int curr = countOne(row);
        if(curr>0){
           result += prev * curr;
             prev = curr;
        }
    }
    return result;
    }

    private int countOne(String s){
        int count =0;
        for(char c : s.toCharArray()){
            if(c=='1') count++;
        }
        return count;
    }
}