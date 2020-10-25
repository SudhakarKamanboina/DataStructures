package bfs;

/*
Given a 2D matrix where some of the elements are filled with 1 and the rest of the elements are filled with X,
 except 2 elements, of which one is S (start point) and E (endpoint). Here X means you cannot traverse to that particular point.
  From a cell you can either traverse to left, right, up or down. Given two points in the matrix find the shortest path between these points.
For example, if the matrix is
1 1 1 1 1
S 1 X 1 1
1 1 1 1 1
X 1 1 E 1
1 1 1 1 X

One of the shortest paths (from E to S both exclusive) is: [(3, 2), (3, 1), (2, 1), (2, 0)]. Return null if there is no path between S and E.
 */

import java.util.*;

class ShortestPathWithObstacles {

    private static int startx = -1, starty=-1;
    private static String end = null;

    public static void main(String[] args) {
        //Test obj = new Test();
        char[][] grid = {{'1', '1', 'X', '1', '1'},
                {'S', '1', 'X', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'X', '1', '1', 'E', '1'},
                {'1', '1', '1', '1', 'X'}};

        List<int[]> path = shortestPath(grid);
        System.out.println("Path length:" + (path.size() - 1));
        path.stream().forEach(i -> {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        });
    }

    private static List<int[]> shortestPath(char[][] grid){
        if (grid == null || grid.length == 0)
            return new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;

        boolean found=false;
        for (int i=0; i<row; i++){
            if (found)
                break;
            for(int j=0; j<col; j++){
                if (grid[i][j] == 'S'){
                    startx = i;
                    starty = j;
                    found = true;
                    break;
                }
            }
        }

        // perform BFS
        Map<String, String> childToParent = bfs(grid, startx, starty);

        List<int[]> res = new LinkedList<>();
        if (end != null){
            String parent = childToParent.get(end);
            while(!parent.equals(startx+","+starty)){

                String[] points = parent.split(",");
                res.add(0, new int[]{Integer.parseInt(points[0]),
                        Integer.parseInt(points[1])});
                parent = childToParent.get(parent);
            }
        }
        return res;
    }

    private static Map<String, String> bfs(char[][] grid, int x, int y){

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{x,y});
        Map<String, String> childToParent = new HashMap<>();
        visited.add(x+","+y);

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            String parent = pos[0]+","+pos[1];

            for(int[] dir : dirs){
                int newx = pos[0] + dir[0];
                int newy = pos[1] + dir[1];

                if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length ||
                        grid[newx][newy] == 'X' || visited.contains(newx+","+newy)){
                    continue;
                }

                String child = newx+ ","+newy;

                // check if reached end
                if (grid[newx][newy] == 'E'){
                    end = newx+","+newy;
                    childToParent.put(child, parent);
                    return childToParent;
                }

                queue.add(new int[]{newx, newy});
                visited.add(newx+","+newy);
                childToParent.put(child, parent);
            }
        }
        return childToParent;
    }
}
