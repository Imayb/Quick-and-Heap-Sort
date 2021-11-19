/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16_sorting;

import java.util.Random;

/**
 * Lab 7 over chapter 16 quick and heap sort. Ivana Mayberry. 10/26/2020
 * @author monic
 */
public class CH16_Sorting {

    
    public static void main(String[] args) {
       
        int[] intArray = new int[20];
        
        randomArrayGen(intArray);
        System.out.println("Before quick sort");
        printArray(intArray);
        quickSort(intArray, 0, 19);
        System.out.println("\n\nAfter quick sort");
        printArray(intArray);
        
        randomArrayGen(intArray);
        System.out.println("\n\nBefore heap sort");
        printArray(intArray);
        System.out.println("\n\nAfter heap sort");
        printArray(intArray);
        
        
    }
    
public static void randomArrayGen(int[] randomArray) {
    Random rand = new Random();
    int randNumber = rand.nextInt(20) +1;
    for(int i = 0; i < randomArray.length; i++) {
        randomArray[i] = rand.nextInt(100) +1;
    }
}

public static void printArray(int[] arr) {
    for(int num: arr) {
        System.out.print(num + " ");
    }
}
    
public static void quickSort(int[] list, int first, int last) {
    if(last> first) {
        int pivotIndex = partition(list, first, last);
        quickSort(list, first, pivotIndex -1);
        quickSort(list, pivotIndex +1, last);
    }
}

public static int partition(int[] list, int first, int last) {
    int pivot = list[first];
    int low = first + 1;
    int high = last;
    
    while ( high > low) {
        while (low <= high && list[low] <= pivot)
            low++;
        
        while ( low <= high && list[high] > pivot)
            high--;
        
        if (high > low) {
            int temp = list[high];
            list[high] = list[low];
            list[low] = temp;
        }
    }

    while (high > first && list[high] >= pivot)
    high--;
    
     if (pivot > list[high]) {
        list[first] = list[high];
        list[high] = pivot;
        return high;
    }
    else {
        return first;
    }
} 

      public static void heapify(int arr[], int n, int i)
      {
          int largest = i;
          int left = 2*i + 1;
          int right = 2*i + 2;
          
          
          if(left < n && arr[left] > arr[largest])
              largest = left;
          
          if ( right < n && arr[right] > arr[largest])
              largest = right;
          
          if (largest !=i)
          {
              int swap = arr[i];
              arr[i] = arr[largest];
              arr[largest] = swap;
              
              heapify(arr, n, largest);
          }
      }

public static void heapsort(int arr[])
{
   int n = arr.length;
   
   for ( int i = n / 2 - 1; i >=0; i--)
       heapify(arr, n, i);
   
   for (int i=n-1; i>=0; i--)
   {
       int temp = arr[0];
       arr[0] = arr[i];
       arr[i] = temp;
       
       heapify(arr, i, 0);
   }
}
}
