import java.util.*;

class Solution {

    static class Event {
        double y, x1, x2;
        int type; // +1 add, -1 remove

        Event(double y, double x1, double x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            double x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, +1));
            events.add(new Event(y + l, x, x + l, -1));
        }

        events.sort(Comparator.comparingDouble(e -> e.y));

        TreeMap<Double, Integer> active = new TreeMap<>();
        double prevY = events.get(0).y;
        double totalArea = 0;

        List<double[]> slabs = new ArrayList<>();

        for (Event e : events) {
            double curY = e.y;
            double dy = curY - prevY;

            if (dy > 0 && !active.isEmpty()) {
                double width = unionWidth(active);
                double area = width * dy;
                slabs.add(new double[]{prevY, curY, area});
                totalArea += area;
            }

            active.put(e.x1, active.getOrDefault(e.x1, 0) + e.type);
            active.put(e.x2, active.getOrDefault(e.x2, 0) - e.type);

            if (active.get(e.x1) == 0) active.remove(e.x1);
            if (active.get(e.x2) == 0) active.remove(e.x2);

            prevY = curY;
        }

        double half = totalArea / 2;
        double acc = 0;

        for (double[] slab : slabs) {
            double y1 = slab[0], y2 = slab[1], area = slab[2];
            if (acc + area >= half) {
                double remaining = half - acc;
                double width = area / (y2 - y1);
                return y1 + remaining / width;
            }
            acc += area;
        }

        return prevY;
    }

    private double unionWidth(TreeMap<Double, Integer> map) {
        double width = 0;
        int count = 0;
        Double prev = null;

        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            if (count > 0) {
                width += e.getKey() - prev;
            }
            count += e.getValue();
            prev = e.getKey();
        }
        return width;
    }
}
