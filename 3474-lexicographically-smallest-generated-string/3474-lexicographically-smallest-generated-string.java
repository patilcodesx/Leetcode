class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int total = n + m - 1;

        char[] word    = new char[total];
        boolean[] forced = new boolean[total];

        Arrays.fill(word, 'a');

        // ── Step 1: Place str2 at every T position ──
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    char ch = str2.charAt(j);
                    if (forced[i + j] && word[i + j] != ch) {
                        return "";  // conflict
                    }
                    word[i + j]   = ch;
                    forced[i + j] = true;
                }
            }
        }

        // ── Step 2: Handle F positions ──
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                // Check if window matches str2
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    // Find rightmost NON-forced position in window
                    // to change (keeps prefix lex smallest)
                    int changePos = -1;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!forced[i + j]) {
                            changePos = i + j;
                            break;
                        }
                    }

                    if (changePos == -1) {
                        return "";  // all positions forced, can't change
                    }

                    // Change to smallest char != str2[changePos - i]
                    char need = str2.charAt(changePos - i);
                    word[changePos] = (need != 'a') ? 'a' : 'b';
                }
            }
        }

        return new String(word);
    }
}