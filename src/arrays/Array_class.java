package arrays;

import java.util.Random; //for generating random integers

import java.util.Arrays;
//Arrays class contains some static methods that are used with arrays.arrays and help in
//- sorting
//- searching
//- comparing
//- filling
//- returing a string representation of an array


public class Array_class {

    public static void main(String args[])
    {
        //sort the whole array
        //if we write our own class then it must have CompareTo method in it for the sort method to work
        int[] myArray=getRandomArray(10);
        printArray(myArray);
        Arrays.sort(myArray);
        printArray(myArray);
        System.out.println();


        //sort some part of the array
        myArray=getRandomArray(10);
        printArray(myArray);
        Arrays.sort(myArray,5,10);  //fromIndex to toIndex-1
        printArray(myArray);
        System.out.println();

        //searching using binary search
        //the array need to be sorted
        Arrays.sort(myArray);
        System.out.println(Arrays.binarySearch(myArray,5)); //if found, it will return the index of the element
        //if not found it will return -(insertion index +1) i.e insertion index means the index where
        //it is supposed to be inserted in sorted format




        //comparing two arrays.arrays
        //this method returns true or false based on the values we compare

        int[] arr1={1,2,3,4};
        int[] arr2={1,2,3,4};

        System.out.println(Arrays.equals(arr1,arr2));



        //filling the arry with the same numbers
        int[] arr3=new int[10];
        Arrays.fill(arr3,2,4,9); //fromIndex to toIndex-1
        printArray(arr3);


        //string representation of an array
        //no need to use a loop
        System.out.println(Arrays.toString(arr3));
    }


    public static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static int[] getRandomArray(int sizeOfArray)
    {
        int[] arr=new int[sizeOfArray];
        Random rd=new Random();
        for(int i=0;i<sizeOfArray;i++)
        {
            arr[i]=rd.nextInt()%10;
        }

        return arr;
    }
}
