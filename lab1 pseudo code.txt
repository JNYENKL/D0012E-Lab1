In the main class. {

    //Data set creation
        for loop {
            
            Creates the random dataset with changeable size

        }

    //Prints out the unsorted data set.
        print the unsorted data set

    //Prints the result of the data sorted by insertionSort
        print the data set sorted by insertionSort
    
    //Prints the result of the data sorted by bSort
        print the data set sorted by bSort

    //Prints from mergeSort and time performance

    //Insertion sort prints
        starts counting the time
        makes the sorting happen with insertionSort
        store a copy of the result
        stops counting the time
        print "Time for mergeSort with insertionSort:" and the time the sorting took
        print "Merge sorted:" with the data set sorted by insertionSort

    //bSort prints
        starts counting the time
        makes the sorting happen with insertionSort
        store a copy of the result
        stops counting the time
        print "Time for mergeSort with insertionSort:" and the time the sorting took
        print "Merge sorted:" with the data set sorted by insertionSort

    
    //The insertion sort function
    function insertionSort(list, list length) {

        //base case
            if list length <= 1{
                return list
            }

        //Having the function call itself to reach the base case
            call insertinoSort with the same arguments but with list length - 1

            save the element at the end of the list as Last
            save the list length - 2 as J

        //Move element Last to its correct position via a while-loop
            while (J >= 0) and (List[j] > Last) {

                moves the element at position J in the list back one index

            }

            move Last to its correct position at index J + 1
            return List
    }

    //The bSort function
    function bSort(List) {

        for i = 0 to the length of List, i++ {

            store the value at position i in List as Key
            store i as High
            store 0 as Low

            store where to put the current key by binary search as J
            using the BinarySearch function below.

            store Key at its correct index and shift every other element behind it back one step

            return List 

        }

    //Binary search function to find the correct index for Key in bSort
    function Binarysearch(List, Key, Low, High) {

        create an empty variable to store the sought after index called Index 

        while Low <= High {

            store Low + (High - Low) / 2 as Middle

            if the element at position Middle in List < Key {

                set Low to Middle + 1

            }
            else if the element at position Middle in List > Key {

                set High to Middle - 1

            }
            else if the element at position Middle in List = Key{

                set Index to Middle
                end the loop

            }
            return Index

        }
    }

    //MergeSort function to first split the input data set into sub-sists.
    //Then sorting these sub-lists with insertionSort or bSort.
    //Lastly merging these lists together correctly sorted.
    function mergeSort(List, K) {

        store the length of the List as N
        create an empty lists to store the sorted end product as Result

        //Size of the sub-lists called chunks
        store the sub-list size N / K as chunkSize
        
        if chunkSize <= 0 {

            return null

        }

        //To account for uneven divisions for N / K
        through division with rest, store the rest from N / chunkSize as Rest

        store the number of sub-lists, N / chunkSize + (if Rest > 0 then 1, else 0), as numberOfChunks

        //Store the chunks in a 2D-list, a list of lists
        create list containing the sub-lists called splittedLists
        
        for i = 0 to i < (if rest > 0 then numberOfChunks - 1, else numberOfChunks), i++ {

            set the list at index i in splittedLists to the elements in List at range ((numberOfChunks - 1)*chunkSize)
            (numberOfChunks -1)*chunkSize + rest)

        }

        //Sort each sub-list with the sorting function of choice
        for i = 0 to i < numberOfChunks, i++ {

            put the sub-list at index i in splittedLists through either insertinoSort or bSort
            and replace its unsorted version in splittedLists

        }

        //Final merging of the sub-lists
        for i = 0 to i < numberOfChunks, i++ {

            for j = 0 to j < the length of the sub-list at index i in splittedLists, j++ {

                set the elemnt at index j in List to the element at index [i][j] in splittedLists

            }

        }
        return List

    }
    }

}