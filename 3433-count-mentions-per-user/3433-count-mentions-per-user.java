import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        // Sort by time, OFFLINE before MESSAGE at same time
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] ans = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];
        Arrays.fill(offlineUntil, -1);

        for (List<String> e : events) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(e.get(2));
                offlineUntil[user] = time + 59; // offline for 60 units
            } 
            else { // MESSAGE
                String msg = e.get(2);

                if (msg.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        ans[i]++;
                    }
                } 
                else if (msg.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (offlineUntil[i] < time) {
                            ans[i]++;
                        }
                    }
                } 
                else {
                    String[] tokens = msg.split(" ");
                    for (String t : tokens) {
                        // FIX: remove "id"
                        int id = Integer.parseInt(t.substring(2));
                        ans[id]++;
                    }
                }
            }
        }
        return ans;
    }
}
