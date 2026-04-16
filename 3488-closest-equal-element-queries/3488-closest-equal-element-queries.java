class Solution {
    //Brute Force
    // public List<Integer> solveQueries(int[] nums, int[] queries) {
    //     List<Integer> result = new ArrayList<>();
    //     for(int i=0;i<queries.length;i++){
    //         int index = queries[i];
    //         int value = nums[index];
    //         result.add(search(nums,index,value));
    //     }
    //     return result;
    // }
    // private static int search(int[] nums, int index, int value){
    //   int n = nums.length;
    //   int minDist = Integer.MAX_VALUE;

    //   for(int j=0;j<n;j++){
    //     if(j==index) continue;
 
    //     if(nums[j]==value){
    //         int diff = Math.abs(index - j);
    //         int circularDist = Math.min(diff,n-diff);

    //         minDist = Math.min(minDist,circularDist);
    //     }
    //   }
      
    // return minDist== Integer.MAX_VALUE?-1:minDist;                                                                                                                       
    // }
 public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int index : queries) {
            int value = nums[index];
            List<Integer> list = map.get(value);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, index);
            int minDist = Integer.MAX_VALUE;

            // left neighbor
            if (pos > 0) {
                int left = list.get(pos - 1);
                minDist = Math.min(minDist, getDist(index, left, n));
            }

            // right neighbor
            if (pos < list.size() - 1) {
                int right = list.get(pos + 1);
                minDist = Math.min(minDist, getDist(index, right, n));
            }

            // circular previous (last element)
            int last = list.get(list.size() - 1);
            if (last != index) {
                minDist = Math.min(minDist, getDist(index, last, n));
            }

            // circular next (first element)
            int first = list.get(0);
            if (first != index) {
                minDist = Math.min(minDist, getDist(index, first, n));
            }

            result.add(minDist);
        }

        return result;
    }

    private int getDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }

    
}