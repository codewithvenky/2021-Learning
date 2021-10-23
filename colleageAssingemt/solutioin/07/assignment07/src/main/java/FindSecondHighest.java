
public class FindSecondHighest {
	public static void main (String args[])
	{
		
		int arr[] = {9,3,5,8,4,7,8};
		int shotest =Integer.MAX_VALUE;
		int secodShotest= Integer.MAX_VALUE;
		for (int i =0; i <arr.length;i++)
		{
			if (arr[i] < shotest)
			{
				shotest=arr[i];
			}
			else if (arr[i] > shotest  && arr[i] <secodShotest)
			{
				secodShotest= arr[i];
			}
			
			
		}
		
		System.out.println(secodShotest);
		
		
	}

}
