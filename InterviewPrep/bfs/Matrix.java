package bfs;

import java.util.LinkedList;
import java.util.Queue;


/*
You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall.
Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start.
If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls.
You cannot wrap around the edges of the board.

For example, given the following board:
[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]

and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
 since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
* */

public class Matrix {

    public static void main(String[] args){
        boolean[][] matrix = {
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };
        int[] start = {3, 0}, end = {0, 0};

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(start);

        int result =Integer.MAX_VALUE;
        int count=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] || visited[x][y]) {
                        continue;
                    }

                    if (x == end[0] && y == end[1]){
                        count++;
                        result = Math.min(count, result);
                        continue;
                    }

                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
            count++;

        }

        if (result == Integer.MAX_VALUE){
            System.out.println("null");
        } else {
            System.out.println(result);
        }
    }
}
