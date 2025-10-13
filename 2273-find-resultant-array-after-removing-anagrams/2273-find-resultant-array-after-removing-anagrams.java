class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            int j = i + 1;
            // move j forward while words[j] is an anagram of words[i]
            while (j < n && isAnagram(words[i], words[j])) {
                j++;
            }
            // keep words[i]
            ans.add(words[i]);
            // skip to j
            i = j;
        }
        return ans;
    }
     private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq = new int[26];
        // count a
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }
        // subtract for b
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }
        // if all zero, they're anagrams
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
}