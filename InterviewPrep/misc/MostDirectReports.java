/*

https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/

Find number of Employees Under every Employee
Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.
{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" }

In this example C is manager of A,
C is also manager of B, F is manager
of C and so on.

 */

package misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{


    static Map<String, Integer> empToReports = new HashMap<>();

    public static void main(String[] args) {

        Map<String, String> empToMgr = new HashMap<>();
        empToMgr.put("A", "C");
        empToMgr.put("B", "C");
        empToMgr.put("C", "F");
        empToMgr.put("D", "E");
        empToMgr.put("E", "F");
        empToMgr.put("F", "F");

        getReportingEmployee(empToMgr);

    }


    public static void getReportingEmployee(Map<String, String> dataSet){
        Map<String, List<String>> mgrToEmp = new HashMap<>();

        for(Map.Entry<String, String> entry : dataSet.entrySet()){

            if(!entry.getValue().equals(entry.getKey())) {
                if (!mgrToEmp.containsKey(entry.getValue())) {
                    mgrToEmp.put(entry.getValue(), new ArrayList<>());
                }
                mgrToEmp.get(entry.getValue()).add(entry.getKey());
            }
        }

        for(String mgr : mgrToEmp.keySet()){
            System.out.println(mgr + " -> "+mgrToEmp.get(mgr));
        }

        for(String emp: dataSet.keySet()){
            populateResult(emp, mgrToEmp);
        }

        String maxReportEmp="";
        int count=0;
        for(String mgr : empToReports.keySet()){
            if (empToReports.get(mgr) > count){
                count = empToReports.get(mgr);
                maxReportEmp = mgr;
            }
        }
        System.out.println("Employee with maximum people under him: "+maxReportEmp + " "+count);
    }


    public static int populateResult(String emp, Map<String, List<String>> mgrToEmp){

        int count = 0;
        if(!mgrToEmp.containsKey(emp)){
            empToReports.put(emp, 0);

        }else if (empToReports.containsKey(emp)){
            count = empToReports.get(emp);
        }else {
            List<String> reports = mgrToEmp.get(emp);
            count = reports.size();
            for (String eachReport : reports) {
                count += populateResult(eachReport, mgrToEmp);
            }
            empToReports.put(emp, count);
        }
        return count;
    }
}