package misc;

/* asked in roblox phone screen
// You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

// Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

// Write a function that takes a list of (prerequisite, course) pairs,
and returns the name of the course that the student will be taking when they are halfway
through their program. (If a track has an even number of courses,
and therefore has two "middle" courses, you should return the first one.)

// Sample input 1: (arbitrarily ordered)
// prereqs_courses1 = [
// 	["Data Structures", "Algorithms"],
// 	["Foundations of Computer Science", "Operating Systems"],
// 	["Computer Networks", "Computer Architecture"],
// 	["Algorithms", "Foundations of Computer Science"],
// 	["Computer Architecture", "Data Structures"],
// 	["Software Design", "Computer Networks"]
// ]

// In this case, the order of the courses in the program is:
// 	Software Design
// 	Computer Networks
// 	Computer Architecture
// 	Data Structures
// 	Algorithms
// 	Foundations of Computer Science
// 	Operating Systems

// Sample output 1:
// 	"Data Structures"
 */

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class preReqCourses {

    public static void main(String[] argv) {

        String[][] prereqsCourses1 = {
                {"Data Structures", "Algorithms"},
                {"Foundations of Computer Science", "Operating Systems"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        String[][] prereqsCourses2 = {
                // preReq : course
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        String midCourse = getHalfWayCourse(prereqsCourses1);
        System.out.println(midCourse);
    }

    // optimize more, queue and map is not required
    private static String getHalfWayCourse(String[][] prereqsCourses){

        Map<String, Integer> indgree = new HashMap<>();
        List<String> course = new ArrayList<>();
        for(String[] cou : prereqsCourses){
            if (!course.contains(cou[0])){
                course.add(cou[0]);
            }
            if (!course.contains(cou[1])){
                course.add(cou[1]);
            }
            indgree.put(cou[1], indgree.getOrDefault(cou[1], 0)+1);
        }

        Queue<String> queue = new LinkedList<>();
        for (String cou : course){
            if (!indgree.containsKey(cou)){
                queue.add(cou);
            }
        }

        List<String> result = new ArrayList<>();
        boolean isEven = (course.size()%2) == 0;
        while(!queue.isEmpty()){
            String c = queue.poll();
            result.add(c);

            if (isEven){
                if (course.size()/2 == result.size()){
                    return result.get(result.size()-1);
                }
            }else{
                if (course.size()/2 + 1 == result.size()){
                    return result.get(result.size()-1);
                }
            }


            for(String[] pre : prereqsCourses){
                if (c == pre[0]){
                    queue.add(pre[1]);
                }
            }
        }
        return "";
    }
}
