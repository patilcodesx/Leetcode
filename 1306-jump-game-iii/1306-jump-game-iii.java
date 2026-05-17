class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            // Found an index with value 0
            if (arr[idx] == 0) {
                return true;
            }

            int forward = idx + arr[idx];
            int backward = idx - arr[idx];

            // Jump forward
            if (forward >= 0 && forward < n && !visited[forward]) {
                visited[forward] = true;
                queue.offer(forward);
            }

            // Jump backward
            if (backward >= 0 && backward < n && !visited[backward]) {
                visited[backward] = true;
                queue.offer(backward);
            }
        }

        return false;
    }
}