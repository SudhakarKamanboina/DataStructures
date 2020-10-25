package misc;

/*
This problem was asked by Uber.

Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:

next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
has_next(): returns whether or not the iterator still has elements left.
For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.
 */

public class TwoDIterator {

    int i=0, j=0, size=0;
    int[][] twoDArr;

    public TwoDIterator(int[][] nums){
        this.twoDArr = nums;
        this.size = nums.length;
    }

    public int next(){

        while (hasNext() && j == twoDArr[i].length){
            i++;
            j=0;
        }
        if(hasNext()){
            return twoDArr[i][j++];
        } else {
            System.out.print("No more elements ");
            return -1;
        }
    }

    public boolean hasNext(){
        while ( i < size && j == twoDArr[i].length){
            i++;
            j=0;
        }
        return i < size;
    }

    public static void main(String[] args){
        int[][] temp = {{1}, {3}, {}, {}, {}};
        TwoDIterator t = new TwoDIterator(temp);

        int i=0, x=10;
        while(x >=0 ){
            System.out.println(t.hasNext());
            i = t.next();
            System.out.println(i);
            x--;
        }
    }
}
