class Robot {

    int width, height;
    int x = 0, y = 0;
    int dir = 0; // 0=East, 1=North, 2=West, 3=South
    
    String[] dirs = {"East", "North", "West", "South"};
    int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    int cycle;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.cycle = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        num %= cycle;
        
        // Important edge case
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; // South
            }
            return;
        }

        while (num > 0) {
            int nx = x + moves[dir][0];
            int ny = y + moves[dir][1];
            
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4; // turn counterclockwise
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}