package misc;

public class DrawGraph {

    public static void main(String[] args) {
        int maxX  = 15, maxY = 20;
        int[][] points = {{1,1}, {2,1}, {3,1}, {4,1},{5,1}, {6,1}};
        drawGraph(maxX, maxY, points);
    }

    private static void drawGraph(int maxX, int maxY, int[][] points){

        printXBound(maxX, points.length);

        StringBuilder sb;
        for(int i=maxY; i>0; i--){
            sb = new StringBuilder();

            for(int j=0; j<maxX; j++){
                for(int[] point : points){
                    if (point[0] == j && point[1] == i){
                        sb.append("*");
                    }else {
                            sb.append(" ");

                    }
                }
            }

            for(int z=0; z<maxX-1; z++)
                sb.append(" ");

            sb.insert(0, "+");
            sb.append("+");
            System.out.println(sb.toString());

        }
        printXBound(maxX, points.length);

    }

    private static void printXBound(int maxX, int numPoints){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxX; i++){
            sb.append("+");
            for(int j=0; j<numPoints; j++){
                sb.append("-");
            }
        }
        sb.append("+");
        System.out.println(sb.toString());

    }
}
