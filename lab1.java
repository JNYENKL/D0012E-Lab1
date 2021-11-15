/*Lab 1


#Function insertion_sort(array unsorted list), returns array sorted list:
# Make copy of unsorted list
# For-loop trough list from index 0 to end
# 	get key of current element
#   save index of current element - 1
#	while-loop while j >=0 and j:th of unsorted list copy is larger than key
#		set (list current index+1) to (list current index)
#		decrease current index by 1
#	set set (list current index+1) to key
#return copy of list, now sorted*/
		
public int[] insertion_sort(int[] unsorted_list) {
	
	int[] copy_list = unsorted_list;
	
	for(int i = 0; i< unsorted_list.length();i++) {
		int key = copy_list[i];
		int j = i-1;
		while(j>=0 && copy_list[j]>key) {
			copy_list[i+1] = copy_list[i];
			j = j-1;
		}
		copy_list[j+1] = key;
	}
	
	return copy_list;
}

/*
#Function bSort(array unsorted list), returns array sorted list:
# Make copy of unsorted list
# For-loop trough list from index 0 to end
#	get key of current element
#	save lowest index (0) in var 'low'
#   save highest index (current index) in var 'high'
#	while-loop on condition (low < high)
#		Get middle of list by floor of (high+low)/2, save in 'middle'
#		if 'middle' is larger or equal to key, 'middle' is the new 'high'
#		Otherwise, 'low' is 'middle' + 1
#	pop current index from copied list
#	insert 'high' and key into copied list
# return copied list, now sorted
*/

public int[] bSort(int[] unsorted_list) {
	
	int[] copy_list = unsorted_list;
	
	for(int i = 0; i< unsorted_list.length();i++) {
		
		int key = copy_list[i];
		int low = 0;
		int high = i;
		
		while(low<high) {
			int middle = Integer.floor((high+low)/2);
			if(middle >= key) {high = middle;}
			else {low = middle+1;}
		}
		copy_list.pop(i);
		copy_list[high] = key;
	}
	
	return copy_list;
	
}

/*Pseudocode for the first part of mergeSort, that is, to split the dataSet into k parts.
//the indexing is probably a bit off but the math should be correct which is what I struggled with first.

mergeSort(dataSet, k)
        n = length of dataSet
        splittedArray = array[];
        splittedarrayPos = 0;
        chunkSize = 0;
        
        //splitting the dataSet into k parts and storing in splittedArray
        if (n is evenly divideable by k)
        chunkSize = n / k;
            for loop (i=0 to k-1)
                splittedArray[i] = dataSet[splittedArrayPos to chunkSize - 1];
                splittedArrayPos = splittedArrayPos + chunkSize;

        else
	//This part is for when we're unable to split all subArrays into equal parts.
            tempK = k;
            for loop (i=0 to k-1)
                splittedArray[i] = dataSet[splittedArrayPos to (splittedArrayPos + ceiling(n - splittedArrayPos) / tempk) - 1]
                tempK = tempK - 1;
                splittedArrayPos = (splittedArrayPos + ceiling(n - splittedArrayPos) / tempk);
*/

