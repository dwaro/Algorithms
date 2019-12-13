/*

Given a two-dimensional array of integers, return the flattened version of the
array with all the integers in the sorted (ascending) order.

Example:

Given [[3, 2, 1], [4, 6, 5], [], [9, 7, 8]], your function should return [1, 2,
3, 4, 5, 6, 7, 8, 9].

*/

import java.util.Arrays;
import java.io.*;
import java.util.*;

public class Kata {
	
	public static int[] flattenAndSort(int[][] array) {
    		ArrayList<Integer> tracker = new ArrayList<Integer>();
    		for (int[] list: array) {
      			for (int num: list) {
       				tracker.add(num);
      			}
    		}
    		int[] sorted = new int[tracker.size()];
    		for (int i=0; i < sorted.length; i++) {
        		sorted[i] = tracker.get(i).intValue();
   		}
    		Arrays.sort(sorted);
		return sorted;
	}
}

/*
Tests

import org.junit.Test;
import org.junit.Assert;

public class SolutionTest {

    @Test
    public void exampleTest() {
    	Assert.assertArrayEquals(new int[]{}, Kata.flattenAndSort(new int[][]{}));
    	Assert.assertArrayEquals(new int[]{1}, Kata.flattenAndSort(new int[][]{{}, {1}}));
    	Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, Kata.flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}));
    	Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 100}, Kata.flattenAndSort(new int[][]{{1, 3, 5} ,{100}, {2, 4, 6}}));
    	Assert.assertArrayEquals(new int[]{111, 222, 333, 444, 555, 666, 777, 888, 999}, Kata.flattenAndSort(new int[][] {{111, 999}, {222}, {333}, {444}, {888}, {777}, {666}, {555}}));
    }
}
*/
