import java.util.Scanner;
public class MergeSort
{
  private int[] array;
  private int[] tempArray;
  private int length;

  public static void main(String a[])
  {
    Scanner input = new Scanner(System.in);
    int num;
    System.out.printf("please type in the number: ");
    num = input.nextInt();

    int[] inputArray = new int[num];

   for(int i = 0;i < inputArray.length;i++)
    {
      System.out.printf("please %d-th interge :",i+1);
      inputArray[i] = input.nextInt();
    }

    MergeSort objA= new MergeSort();
    objA.sort(inputArray);

    for(int i:inputArray)
    {
      System.out.print(i);
      System.out.print(" ");
    }
    System.out.println(" ");

  }

  public void sort(int inputArray[])
  {
    this.array = inputArray;
    this.length = inputArray.length;
    this.tempArray = new int[length];
    doMergeSort(0,length-1);
  }

  private void doMergeSort(int lowIndex, int highIndex)
  {
    if(lowIndex < highIndex)
    {
      int middle = lowIndex + (highIndex - lowIndex)/2;

      doMergeSort(lowIndex,middle);
      doMergeSort(middle+1,highIndex);
      merge(lowIndex,middle,highIndex);
    }
  }

  private void merge(int lowIndex,int middle,int highIndex)
  {
    for(int i = lowIndex;i <= highIndex;i++)
    {
      tempArray[i] = array[i];
    }

    int i = lowIndex;
    int j = middle + 1;
    int k = lowIndex;

    while(i <= middle && j <= highIndex)
    {
      if(tempArray[i] < tempArray[j])
      {
        array[k] = tempArray[i];
        i++;
      }
      else
      {
        array[k] = tempArray[j];
        j++;
      }
      k++;
    }
    while(i <= middle)
    {
      array[k] = tempArray[i];
      i++;
      k++;
    }
  }
}
