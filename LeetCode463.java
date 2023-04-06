public class LeetCode463 {

    private static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] grid, final int y, final int x) {
        grid[y][x] = 2;
        int perimeter = 4;

        for (int[] move : moves) {
            int ny = y + move[0];
            int nx = x + move[1];

            if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[ny].length || grid[ny][nx] == 0) {
                continue;
            }

            --perimeter;
            if (grid[ny][nx] == 1) {
                perimeter += dfs(grid, ny, nx);
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int result = 0;

        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                if (grid[y][x] == 1) {
                    result = dfs(grid, y, x);
                }
            }
        }

        System.out.println(result);
    }
}


