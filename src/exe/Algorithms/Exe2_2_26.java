package exe.Algorithms;

import algorithms.sort.SortCompare;
import edu.princeton.cs.introcs.StdOut;

public class Exe2_2_26 {
	public static void main(String[] args) {
		double time1 = SortCompare.timeSortedInput("MergeInside", 1000, 100);   // Total for alg1. 
        double time2 = SortCompare.timeSortedInput("Merge", 1000, 100);   // Total for alg2. 
        StdOut.printf("For %d random Doubles\n    %s is", 1000, "Merge"); 
        StdOut.printf(" %.1f times faster than %s\n", time1/time2, "MergeInside");  
	}
}
