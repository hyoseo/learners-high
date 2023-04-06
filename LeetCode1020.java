public class LeetCode1020 {

    private static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] grid, final int y, final int x) {
        grid[y][x] = 2;
        int enclaves = 1;

        for (int[] move : moves) {
            int ny = y + move[0];
            int nx = x + move[1];

            if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[y].length) {
                enclaves = 0;
                continue;
            }

            if (grid[ny][nx] == 1) {
                int ret = dfs(grid, ny, nx);
                if (ret == 0 || enclaves == 0) {
                    enclaves = 0;
                } else {
                    enclaves += ret;
                }
            }
        }

        return enclaves;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

        int enclaves = 0;

        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                if (grid[y][x] == 1) {
                    enclaves += dfs(grid, y, x);
                }
            }
        }

        System.out.println(enclaves);
    }
}


