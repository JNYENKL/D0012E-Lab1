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
        System.out.print("] \n\n");
		
        
      //===========MergeSort #1=========================
        long t1 = System.nanoTime();
        int [] outArray1 = mergeSort_1(datSet, 5);
        long t2 = System.nanoTime();
        long performance1 = t2-t1;
        System.out.println("Time for mergeSort with insertionSort:" + performance1 + "ns");
        
        
        System.out.print("Merge Sorted: [");
        for(int i = 0; i<datSet.length;i++) {
        	System.out.print(outArray1[i] + ",");
        }
        System.out.print("] \n");
        
        //==========MergeSort #2========================
        long t3 = System.nanoTime();
        int [] outArray2 = mergeSort_2(datSet, 5);
        long t4 = System.nanoTime();
        long performance2 = t4-t3;
        System.out.println("Time for mergeSort with bSort:" + performance2 + "ns");
        
        
        System.out.print("bMerge Sorted: [");
        for(int i = 0; i<datSet.length;i++) {
        	System.out.print(outArray2[i] + ",");
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
	 
	static int BinarySearch(int[] array, int key, int lo, int hi) {
			    
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
	
	
	static int[] mergeSort_1(int[] array, int k) {
		
		
		int n = array.length;
		
		int[] result = new int[n];
		
		//Size of chunks that will be sorted
		int chunkSize = Math.floorDiv(n, k);
		
		
		
		if(chunkSize <= 0) {
			return null;
		}
		
		int rest = n % chunkSize;
		
		int numberOfChunks = n / chunkSize + (rest > 0 ? 1 : 0);
		
		//Hold chunks in a 2D-array
		int [][] splittedArrays = new int[numberOfChunks][];
		
		//Traverse array chunk by chunk and assign each chunk an index in the splitted array
		for(int i = 0; i< (rest > 0 ? numberOfChunks -1 : numberOfChunks); i++) {
			splittedArrays[i] = Arrays.copyOfRange(array, (numberOfChunks -1)*chunkSize,(numberOfChunks -1)*chunkSize + rest);
		}
		
		//Time to do the sorting on each block
		for(int i = 0; i<numberOfChunks; i++) {
			splittedArrays[i] = insertionSort(splittedArrays[i], splittedArrays[i].length);
			
		}
		
		//The merging
		for(int i = 0; i<numberOfChunks; i++) {
			for(int j=0;j<splittedArrays[i].length;j++) {
				array[j] = splittedArrays[i][j];
			}
			
			
		}
		
		
		return array;
	}
	
static int[] mergeSort_2(int[] array, int k) {
		
		
		int n = array.length;
		
		int[] result = new int[n];
		
		//Size of chunks that will be sorted
		int chunkSize = Math.floorDiv(n, k);
		
		
		
		if(chunkSize <= 0) {
			return null;
		}
		
		int rest = n % chunkSize;
		
		int numberOfChunks = n / chunkSize + (rest > 0 ? 1 : 0);
		
		//Hold chunks in a 2D-array
		int [][] splittedArrays = new int[numberOfChunks][];
		
		//Traverse array chunk by chunk and assign each chunk an index in the splitted array
		for(int i = 0; i< (rest > 0 ? numberOfChunks -1 : numberOfChunks); i++) {
			splittedArrays[i] = Arrays.copyOfRange(array, (numberOfChunks -1)*chunkSize,(numberOfChunks -1)*chunkSize + rest);
		}
		
		//Time to do the sorting on each block
		for(int i = 0; i<numberOfChunks; i++) {
			splittedArrays[i] = bSort(splittedArrays[i]);
			
		}
		
		//The merging
		for(int i = 0; i<numberOfChunks; i++) {
			for(int j=0;j<splittedArrays[i].length;j++) {
				array[j] = splittedArrays[i][j];
			}
			
			
		}
		
		
		return array;
	}

	
}
