class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        int[] flag = new int[strs.length];

        for(int i=0;i<strs.length;i++){
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
              if(flag[i]==1) continue;

            for(int j=i+1;j<strs.length;j++){
               if(flag[j]==0 && isAnagrams(strs[i],strs[j])){
                   list.add(strs[j]);
                   flag[j] =1;
               }
            }
            result.add(list);
        }
        return result;
    }

    private boolean isAnagrams(String a, String b){
         if(a.length() != b.length()){
            return false;
         }

           char[] a1 = a.toCharArray();
           char[] b1 = b.toCharArray();

         Arrays.sort(a1);
         Arrays.sort(b1);

         return Arrays.equals(a1,b1);
    }
}