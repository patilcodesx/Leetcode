class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] start = Arrays.copyOf(events,n);
        int[][] end = Arrays.copyOf(events,n);

        Arrays.sort(start, (a,b)->a[0]-b[0]);
        Arrays.sort(end, (a,b)->a[1]-b[1]);

        int j=0;
        int max =0,ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int stime = start[i][0], currval = start[i][2];
            while(j<n && end[j][1]<stime){
                max = Math.max(max,end[j][2]);
                j++;
            }
            ans = Math.max(ans,max+currval);

        }
        return ans;

    }
}