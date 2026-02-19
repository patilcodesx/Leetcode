class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        int[] flags = new int[strs.length];

       for(int i=0;i<strs.length;i++){
          if(flags[i]==1) continue;

          List<String> list = new ArrayList<>();
          list.add(strs[i]);
          flags[i] = 1;

        for(int j=i+1;j<strs.length;j++){
               if(flags[j]==0 && isAnagram(strs[i],strs[j])){
                list.add(strs[j]);
                flags[j] =1;
               }
          }
          result.add(list);
       }
       return result;
    }

    private boolean isAnagram(String s1, String s2){
        if(s1.length()!= s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}