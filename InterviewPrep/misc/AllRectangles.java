package misc;
import java.io.*;
import java.util.*;

/* asked in roblox

Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1's. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,0],[2,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left-x-y and width/height):
  [
    [[0,0],[1,1]],
    [[0,2],[1,1]],
    [[3,2],[3,2]],
    [[1,3],[1,3]],
    [[3,5],[2,2]],
    [[6,7],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left-x-y and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

image4 = [
  [1, 1, 1, 1, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1],
]

findRectangles(image4) =>
  // (using top-left-row-column and bottom-right or top-left-x-y and width/height):
  [
    [[1,1],[3,3]],
  ]

n: number of rows in the input image
m: number of columns in the input image

*/

public class AllRectangles {

    public static void main(String[] argv) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };


        List<List<int[]>> res = findAll(image1);
        for (List<int[]> lv: res) {
            for (int[] vertex : lv) {
                System.out.print(vertex[0] + "," + vertex[1] + " ");
            }
            System.out.println("");
        }
    }

    private static List<List<int[]>> findAll(int[][] image){

        int r = image.length;
        int c = image[0].length;

        List<List<int[]>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (image[i][j] == 0 && !visited.contains(i+","+j)){
                    helper(image, i ,j, visited, res);
                }
            }
        }
        return res;

    }

    private static void helper(int[][] image, int i , int j, Set<String> visited, List<List<int[]>> res){
        int[] start = new int[2];
        int[] end = new int[2];
        start[0] = i;
        start[1] = j;
        end[0] = i;
        end[1] = j;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int[][] dirs = {{1,0}, {0, 1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            visited.add(curr[0]+","+curr[1]);
            end[0] = curr[0];
            end[1] = curr[1];

            for (int[] dir : dirs){
                int newi = curr[0] + dir[0];
                int newj = curr[1] + dir[1];

                if (newi >=0 && newi < image.length && newj >=0 && newj < image[0].length && image[newi][newj] == 0){
                    queue.add(new int[]{newi, newj});
                }
            }

        }
        List<int[]> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        res.add(temp);

    }
}
