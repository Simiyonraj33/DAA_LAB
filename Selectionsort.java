import java.util.*;
class Selectionsort{
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
		    int min = i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[min]>arr[j])
				{
					min =j;
					
				}
		    }
            if(min != i)
            {
                int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
            }
        }
        	for(int i=0;i<n;i++)
		{
        System.out.println(arr[i] +" ");
        }

    }
}			
            				
