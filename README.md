# Fifty Shades of Multi-threading

Java provides various ways to set up a parallel program using multi-threading. In this project, based on the simple problem of calculating the sum of the elements of
a large array, you can find some those ways. This project also give you an idea how to parallelize a problem.

The projects includes three worker classes to calculate the sum of the given part of a array. 

Those workers are SummerThread, SummerRunnable and SummerCallable. These summer classes is based on Thread class, Runnable interface and Callable interface respectively.

ParalleSummer classes uses these summers to calculate the sum either using Java ExecutorService or more conventinal means to manage the muli-threading process. 

