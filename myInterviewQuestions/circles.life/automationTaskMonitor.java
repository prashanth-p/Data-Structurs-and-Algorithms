/******************************************************************
* Author: Prashanth Pradeep
* Algorithm at the Backend: MinHeap, HashSets, LinkedHashMap
* Task: Get the top-4 automation processes not currently running
* Last Modified Date: Friday, September 27, 2019 2:59:02 PM
*******************************************************************/

import java.io.*;
import java.util.*;

class AutomationTaskMonitor {
    // Queue of top 4 processes which are not running
    static PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b) -> 
            a.getValue().compareTo(b.getValue())); 
    
    // Check if it is a top 4 process and add it accordingly
    public static void queueAdd(Map.Entry<Integer, Integer> taskIDstampPair) {
        // System.out.println("Adding " + taskIDstampPair.getKey()  + " "+ taskIDstampPair.getValue() +  "....");
        if(minHeap.isEmpty())
            minHeap.add(taskIDstampPair);
        else {
            if(minHeap.size() < 4){
                minHeap.add(taskIDstampPair);
            } else {
                // printQueue();
                Map.Entry<Integer,Integer> headTask = minHeap.peek(); 
                if(taskIDstampPair.getValue()>headTask.getValue()) {
                    headTask = minHeap.poll();
                    // System.out.println("true: " + headTask.getValue());
                    // System.out.println("true: " + taskIDstampPair.getValue());
                    minHeap.add(taskIDstampPair);
                }
            }
        }
    }

    // Driver code to print the queue
    public static void printQueue() {
        System.out.println("Items in queue: ");
        Iterator itr = minHeap.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }

    // Wrapper function for the internal calls 
    public static void printRecentTasksNotExecuted(Map<Integer,Integer> bookingServiceTask, Map<Integer,Integer> faresServiceTask, HashSet<Integer> recentTasks) {
        // System.out.println("Booking Service: ");
        System.out.println("Automation Tasks currently not running: ");
        for(Map.Entry<Integer,Integer> entry : bookingServiceTask.entrySet()) {
            // System.out.print("***************************************");
            if(!(recentTasks.contains(entry.getKey()))) {
                // System.out.println(entry.getKey() + ", " + entry.getValue() + ", False");
                queueAdd(entry);
                System.out.println(entry.getKey() + ", " + entry.getValue());
                // printQueue();
            }                        
        }
        // System.out.println("Fares Service");
        for(Map.Entry<Integer,Integer> entry : faresServiceTask.entrySet()) {
            // System.out.println("***************************************");            
            if(!(recentTasks.contains(entry.getKey()))) {
                // System.out.println(entry.getKey() + ", " + entry.getValue() + ", False");
                queueAdd(entry);
                System.out.println(entry.getKey() + ", " + entry.getValue());
                // printQueue();
            }
        }
        System.out.println("Top 4 tasks not running ...");
        printQueue();
    }

    // Driver code
    
public static void main (String[] args) {
      Map<Integer,Integer> bookingServiceTask = new LinkedHashMap<Integer, Integer>();
      // Booking service  automation results:
      // List1: { [121, ts1], [122, ts2], [242, ts3] }
      // Adding automation id, time stamp results to list
      bookingServiceTask.put(121,0);
      bookingServiceTask.put(142,45);
      bookingServiceTask.put(111,15);
      bookingServiceTask.put(147,256);

      System.out.println("Booking Service Tasks Executed: \n" + bookingServiceTask);

      // Fares service automation results:
      // List2: { [111, ts4], [142, ts5], [224, ts6]   }
      Map<Integer, Integer> faresServiceTask = new LinkedHashMap<Integer, Integer>();
      faresServiceTask.put(242,60);
      faresServiceTask.put(122,30); 
      faresServiceTask.put(224,75); 
      faresServiceTask.put(358,105); 

      System.out.println("Fares Service Tasks Executed: \n" + faresServiceTask);

      // Currently executing automation ids:
      // List 3: {121, 141, 224, 100, 200, 350 }
      HashSet<Integer> currentlyExecutingTasks = new HashSet<Integer>();
      currentlyExecutingTasks.add(121);
      currentlyExecutingTasks.add(141);
      currentlyExecutingTasks.add(224);
      currentlyExecutingTasks.add(100);
      currentlyExecutingTasks.add(200);
      currentlyExecutingTasks.add(350);

      System.out.println("Currently Executing Tasks: " + currentlyExecutingTasks);

      printRecentTasksNotExecuted(bookingServiceTask, faresServiceTask, currentlyExecutingTasks);
  }
}
