class QuickSort{

	/*int[] array;
	
	public QuickSort(int[] array)
	{
		for(int i = 0;i < array.length;i++)
		{
			this.array[i] = array[i];
		}
		quicksort(this.array,0,this.array.length-1);
	}
*/
	public static void main(String args[]){
		int[] ar = {8,2,89,3,5};
		quicksort(ar,0,4);
		for(int i = 0;i <= 4;i++)
		{
			System.out.print(ar[i]);
			System.out.print(" ");
		}
		System.out.println(" ");
	}

	private static int partition(int array[],int left,int right)
	{
		int i = left, j = right;
		int index = (left + right)/2;
		int temp;
		int pivot = array[index];

		while(i <= j)//the "=" can't note be eliminated, otherwise there is a loop
		{
			while(pivot > array[i])
				i++;
			while(pivot < array[j])
				j--;
			if(i <= j)
			{
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	private static void quicksort(int[] array,int left,int right)
	{
		int index = partition(array,left,right);
		
		if(index < right)
			quicksort(array,index,right);
		if(left < index - 1)
			quicksort(array,left,index-1);
		
	}
}
			
