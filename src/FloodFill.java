import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/flood-fill
    Algorithm: Depth First Search, Breadth First Search
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int colorToChange) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != colorToChange) {
            return;
        }
        image[i][j] = color;
        dfs(image, i - 1, j, color, colorToChange);
        dfs(image, i + 1, j, color, colorToChange);
        dfs(image, i, j - 1, color, colorToChange);
        dfs(image, i, j + 1, color, colorToChange);
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int initColor = image[sr][sc];
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.push(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();
            int i = elem[0];
            int j = elem[1];
            if (image[i][j] == initColor) {
                image[i][j] = color;
                if (i - 1 >= 0) {
                    queue.push(new int[]{i - 1, j});
                }
                if (i + 1 < image.length) {
                    queue.push(new int[]{i + 1, j});
                }
                if (j - 1 >= 0) {
                    queue.push(new int[]{i, j - 1});
                }
                if (j + 1 < image[0].length) {
                    queue.push(new int[]{i, j + 1});
                }
            }
        }
        return image;
    }
}
