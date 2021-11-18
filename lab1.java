package lab1;

import java.util.*;

public class lab1 {

	public static void main(String[] args) {
		/*
		Random rand = new Random();
		int[] datSet = new int[12000];
		for (int i = 0; i < datSet.length; i++) {
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
		
        System.out.println("Input Length:"+ datSet.length);
        
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
        */
        
        //Get averages for each input size
        int inputSize = 1000; //Define input size here
        long time_ns = 0;
        int numberOfMeasurements = 100000;
        int k = 3;
        
        for(int i=0;i<numberOfMeasurements;i++) {
        	//Generate a random sequence of numbers
        	Random rand2 = new Random();
    		int[] dataSet = new int[inputSize];
    		for (int j = 0; j < dataSet.length; j++) {
    			dataSet[j] = rand2.nextInt(100);
    			//System.out.print(" " + datSet[i]);
    		}
    		
    		//Do the measurements and save the time in time_ns
    		long t1 = System.nanoTime();
            int [] outArray1 = mergeSort_2(dataSet, k);
            long t2 = System.nanoTime();
            time_ns += t2-t1;
            //System.out.println("Time for mergeSort with insertionSort:" + performance1 + "ns");
        }
        
        //Print out the average time
        System.out.println("Time for mergeSort:" + time_ns/numberOfMeasurements + "ns");
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
			    
				//Loop trough part of array to narrow down indexes
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
	
	//Mergesort using insertionSort
	static int[] mergeSort_1(int[] array, int k) {
		//Cannot divide by 0
		if(k <= 0) {
			return null; 
		}
		
		int n = array.length;
		
		int rest = n % k;
		
		//Get number of sub-sets to create and add 1 if there's a rest in n/k
		int numberOfChunks = n / k + (rest > 0 ? 1 : 0);
		
		//Hold chunks in a 2D-array
		int [][] splittedArrays = new int[numberOfChunks][];
		
		//Traverse array chunk by chunk and assign each chunk an index in the splitted array
		for(int i = 0; i< (rest > 0 ? numberOfChunks -1 : numberOfChunks); i++) {
			splittedArrays[i] = Arrays.copyOfRange(array, (numberOfChunks -1)*k,(numberOfChunks -1)*k + rest);
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
	
		//mergeSort using bSort
     static int[] mergeSort_2(int[] array, int k) {
 		if(k <= 0) {
			return null; //null causes error when reading array.length in bSort
		}
		
		int n = array.length;
		
		int rest = n % k;
		
		
		//Get number of sub-sets to create and add 1 if there's a rest in n/k
		int numberOfChunks = (n / k) + (rest > 0 ? 1 : 0);
		
		//Hold chunks in a 2D-array
		int [][] splittedArrays = new int[numberOfChunks][];
		
		//Traverse array chunk by chunk and assign each chunk an index in the splitted array
		for(int i = 0; i< (rest > 0 ? numberOfChunks-1 : numberOfChunks); i++) {
			splittedArrays[i] = Arrays.copyOfRange(array, (numberOfChunks -1)*k,(numberOfChunks -1)*k + rest);
		}
		
		//Do the sorting on each block/sub-array
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
