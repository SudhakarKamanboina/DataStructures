package meeting_overlap_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//write a function that calculates the minimum number of meeting rooms that can accommodate given schedules
public class Solution {

	private static final EventType BEGIN = null;

	public static void main(String[] args) {
		List<Meeting> lst = new ArrayList<Meeting>();
		Meeting obj = new Meeting();
		obj.setStartTime(900);
		obj.setEndTime(910);
		lst.add(obj);
		
		obj = new Meeting();
		obj.setStartTime(940);
		obj.setEndTime(1200);
		lst.add(obj);
		
		obj = new Meeting();
		obj.setStartTime(950);
		obj.setEndTime(1120);
		lst.add(obj);
		
		obj = new Meeting();
		obj.setStartTime(1100);
		obj.setEndTime(1130);
		lst.add(obj);
		
		obj = new Meeting();
		obj.setStartTime(1500);
		obj.setEndTime(1900);
		lst.add(obj);
		
		obj = new Meeting();
		obj.setStartTime(1800);
		obj.setEndTime(2000);
		lst.add(obj);
		
		System.out.println("output "+getMinimumRooms(lst));
		
	}

	public static int getMinimumRooms(List<Meeting> slots){
	    if(slots == null || slots.size() <1){
	        return 0;
	    }
	    List<Event> events = new ArrayList<Event>();
	    for(Meeting interval:slots){
	        events.add(new Event(interval.getStartTime(), EventType.BEGIN));
	        events.add(new Event(interval.getEndTime(), EventType.END));
	        
	    }
	    Collections.sort(events,new Comparator<Event>(){
	                                    public int compare(Event one , Event two){
	                                        if(one.time == two.time){
	                                            return one.type.cardinality - two.type.cardinality;
	                                        }
	                                        return one.time - two. time;
	                                    }});
	    for(Event eve:events)
	    	System.out.println("Output1  "+eve.time);
	    int roomCount = 0; 
	    int max =0;                        
	    for(Event anEvent:events){
	        if(anEvent.type == EventType.BEGIN){
	            ++roomCount;         
	        }else{
	            --roomCount;
	        }
	        if(max<roomCount){
	            max = roomCount;
	        }
	    }          
	    return max;
	                      
	}
	
}

class Event{
	int time;
	EventType type;
	
	Event(int time, EventType type){
		this.time = time;
		this.type = type;
	}
}

enum EventType{
	BEGIN(1), END(0);
	
	int cardinality;
	EventType(int cardinality){
		this.cardinality = cardinality;
	}
}
