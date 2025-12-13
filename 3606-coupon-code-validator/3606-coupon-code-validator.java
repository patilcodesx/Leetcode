import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<Coupon> validCoupon = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i]) continue;

            if (!priority.containsKey(businessLine[i])) continue;

            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("^[A-Za-z0-9_]+$")) continue;

            validCoupon.add(
                new Coupon(priority.get(businessLine[i]), code[i])
            );
        }

        Collections.sort(validCoupon, (a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority;
            }
            return a.code.compareTo(b.code);
        });

        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupon) {
            result.add(c.code);
        }

        return result;
    }

    static class Coupon {
        int priority;
        String code;

        Coupon(int priority, String code) {
            this.priority = priority;
            this.code = code;
        }
    }
}
