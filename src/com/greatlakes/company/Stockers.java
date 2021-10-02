package com.greatlakes.company;

import java.util.Scanner;

class MergeSortImplementation
{
	void merge(double arr[], int left, int mid, int right) 
	{
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts array[left...right] using merge()
	public void sort(double[] notes, int left, int right)
      {
		      if (left < right)
           {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(notes, left, mid);
			sort(notes, mid + 1, right);

			// Merge the sorted halves
			merge(notes, left, mid, right); 
		  
	     }
	
    }
	void binarySearch(double arr[],double key) 
	{
		
		int start=0;
		int end=arr.length-1;
		int mid;
	     while(start<=end) 
	      {
	    	mid=(start+end)/2;
            if(arr[mid]==key) 
            {
      	     System.out.print("Stock of value "+key+" is present ");
              break;
            }
            else if(key>=arr[mid]) 
            {
            	start=mid+1;
            }  
            else 
            	end=mid-1;
            if(mid==0||mid==end)
            {
            System.out.print("Value not found ");
            break;
            }
	     }
	}
}


public class Stockers 
{

	public static void main(String[]args) 
	{
		MergeSortImplementation m=new MergeSortImplementation();
		System.out.println("Enter numbers of Companies");
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		double share[]=new double[N];
		boolean shareStatus;
		int countTrue=0;
		int countFalse=0;
		for(int i=0;i<N;i++) 
		{
			System.out.println("Enter current stock price of the company "+(i+1));
			share[i]=sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			shareStatus=sc.nextBoolean();
			if(shareStatus==true) 
			{
				countTrue++;
			}
			else if(shareStatus==false)
			{
				countFalse++;
			}
		}
		
		
		for(int j=0;j<100;j++) 
		{
			System.out.println("\n");
			System.out.println("Enter the operation that you want to perform\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n"
					+ "6. press 0 to exit");
			int ch;
			ch=sc.nextInt();
			int breakloop=0;
			switch(ch) 
			{
			case 1:m.sort(share,0,N-1);
			         for(int i=share.length-1;i>=0;i--)	
	                  {
	                 	 System.out.print(" "+share[i]);
	                  }
			          break;
			case 2:m.sort(share,0,N-1);
		         	for(int i=0;i<=share.length-1;i++)	
	                {
	             	 System.out.print(" "+share[i]);
	                }
			        break;
			case 3:System.out.println(countTrue);
			       break;
			case 4:System.out.println(countFalse);
			       break;
			case 5:System.out.println("Enter the key value");
			       double key= sc.nextDouble();
			     m.sort(share,0,N-1);
			     m.binarySearch(share,key);
			       break;
			case 6:System.out.println("Exited successfully"); 
			       breakloop=1;
			       break;
			}
			if(breakloop==1) 
			{
				break;
			}
		}
	}
}
