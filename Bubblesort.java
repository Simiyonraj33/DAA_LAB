



import java.util.*;
class Bubblesort{
	public static void main(String[] args)
	{
		int arr[],n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  no of elements:");
		
		n = sc.nextInt();
		
		arr = new int[n];
		System.out.println("Elements:");
		
		for(int i =0;i<n;i++)
		{
			arr[i] =sc.nextInt();
			
	    }
		System.out.println("Sorting ..");
		for(int i=0;i<n-1;i++)
		{
		    boolean swapped = false;
			for(int j =0;j<n-i-1;j++)
				
			{
				if(arr[j] > arr[j+1])
				{	
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				swapped = true;
				}
		    }
            if(swapped = false)
            {
				return;
		    }
        }
		
		for(int i=0;i<n;i++)
		{
        System.out.println(arr[i] +" ");
        }

    }
}	
				
				
				
				
				
				
				
				
