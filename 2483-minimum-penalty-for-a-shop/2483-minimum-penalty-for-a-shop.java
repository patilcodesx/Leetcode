class Solution {
    public int bestClosingTime(String customers) {
       int n = customers.length();
       int penalty =0;
       for(int i=0;i<n;i++){
        if(customers.charAt(i)=='Y'){
            penalty++;
        }
       }

       int minPenalty = penalty;
       int besthour =0;

       for(int j=1;j<=n;j++){
        if(customers.charAt(j-1)=='Y'){
            penalty--;
        }
        else{
            penalty++;
        }
        if(penalty < minPenalty){
           minPenalty = penalty;
           besthour = j;
        }
       }
       return besthour;
    }
}