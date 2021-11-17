
package lab1;

import java.util.*;

public class lab1 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] datSet = new int[1000];
		for (int i = 0; i < 1000; i++) {
			datSet[i] = rand.nextInt(100);
			//System.out.print(" " + datSet[i]);
		}
		
		//========PRINTING===========
		//Print out the unsorted data set:
		System.out.print("Un-sorted: [");
        for(int i = 0; i<datSet.length;i++) {
        	System.out.print(datSet[i] + ",");
        }
        System.out.print("] \n");
        
        //Print out the insertionsorted data set:
		System.out.print("i Sorted: [");
        for(int i = 0; i<datSet.length;i++) {
        	System.out.print(insertionSort(datSet, datSet.length)[i] + ",");
        }
        System.out.print("] \n");
		
		
        //Print out the bsorted data set:
		System.out.print("b Sorted: [");
        for(int i = 0; i<datSet.length;i++) {
        	System.out.print(bSort(datSet)[i] + ",");
        }
        System.out.print("] \n");
		
	}
	
	static int[] insertionSort(int array[], int array_length)
    {
        // The base case
        if (array_length <= 1)
            return array;
    
        // Sort first n-1 elements
        insertionSort( array, array_length-1 );
    
        //Put last element at correct location
        int last = array[array_length-1];
        int j = array_length-2;
    
        //Move elements of array > key
        while (j >= 0 && array[j] > last)
        {
            array[j+1] = array[j];
            j--;
        }
        
        //Put the last one where it should be in array
        array[j+1] = last;
        
        return array;
    }
	
	
	static int[] bSort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int key = array[i];
 
            int hi = i;
            int lo = 0;
            
            //Find where to put the current key by binary search
            int j = Math.abs(BinarySearch(array, key, lo, hi));
            
            //Shift array right
            System.arraycopy(array, j, array, j + 1, i - j);
 
            //Assign key to the found index of array 
            array[j] = key;
        }
        
        return array;
    }
	
	
	/*
	 * This is a function that uses binary search 
	 * to find a place to put the element with value 'key'
	 * in the array and returns an index number
	 */
	 
	static int BinarySearch(
			  int[] array, int key, int lo, int hi) {
			    
				int index = Integer.MAX_VALUE;
			    
			    while (lo <= hi) {
			        int mid = lo  + ((hi - lo) / 2);
			        if (array[mid] < key) {
			            lo = mid + 1;
			        } else if (array[mid] > key) {
			            hi = mid - 1;
			        } else if (array[mid] == key) {
			            index = mid;
			            break;
			        }
			    }
			    return index;
			}
	
}

