# Fifty Shades of Multi-threading

Java provides various ways to set up a parallel program using multi-threading. Yet, multi-threading is not easy: partitioning a problem into smaller pieces, making separate threads solve them, and recombining the partial results into a final goal. 

This projects both helps you to understand this process and provides you with various techniques to code it in Java, based on the simple problem of calculating the sum of the elements of a large array. 

Finding the sum here is like a big job that will handled by a group of workers and, of course, a foreman. 

While workers are to solve a given sub task, a forman is reponsbile of 4 important activities:
<ol>
  <li>Decompsing the problem into smaller parts or sub tasks
  <li>Allocating sub tasks to workers
  <li>Obseerving workers' progress, if necessary
  <li>After workers complete their parts, recombining the sub solutions coming from the workers into a final solution. 
<ol>

In the implementation, the distinction will come from the partitionning of the problem (it may be iterative or recursive), the definitions of workers and forman, and the recombination of sub solutions. 

Java provides a large variety of means for multi-threading. In this project, you'll find (for now) implemenations including Thread, Runnable, Callable, Future and ExecutorService, being applyed to the same problem. Thusi you will be alble to see the differences.
  
The project's workers (called summers) are SummerThread, SummerRunnable and SummerCallable. While SummerThread extends the Thread class,  others implements Runnable and Callable interfaces, respectively. Each summer is intented to calculate the sum of the given part of an array. 

ParalleSummer classes are formans of the Project. Each ParallelSummer uses a group of Summers to calculate the overall sum, either using Java ExecutorService or more conventinal means to manage the muli-threading process. 



