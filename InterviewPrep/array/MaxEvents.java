Class MaxEvents {

  /* Asked in JP morgan teliphonic screen


     * Complete the 'getMaxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */
  
  
   /*
            arrival:  5, 1,  1, 1, 1, 4
            duration: 5, 10, 3, 6, 4, 2
            
            output should be: 2
            
            create 2D arraylist [5, 10] [1, 11] [1, 4] [1, 7] [1, 5] [4, 6]
            
            sort 2D arry/list on second element [[1,4] [1, 5] [4, 6] [1,7] [5, 10] [1, 11]]
            
    */

// Time  C: O(nlogn)
// Space C: O(n)

    public static int getMaxEvents(List<Integer> arrival, List<Integer> duration) {
        int n = arrival.size();
    
    List<List<Integer>> intervals = new ArrayList();
    
    int i=0;
    for(int arrv : arrival){
     List<Integer> tempList = new ArrayList();
     tempList.add(arrv);
     tempList.add(arrv + duration.get(i++));
     intervals.add(tempList);   
    }
    
    Collections.sort(intervals, new Comparator<List<Integer>>(){
        public int compare(List<Integer> l1, List<Integer> l2){
            return l1.get(1) - l2.get(1);
        }
    });
   
    
    int currEndTime = intervals.get(0).get(1);
    int done=1;
    for(i=1; i< n ; i++){
        List<Integer> temp = intervals.get(i);
        if (temp.get(0) >= currEndTime){
            done++;
            currEndTime = temp.get(1);
        }
    }

    return done;
    }

}
