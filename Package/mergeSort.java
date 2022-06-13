package  Package;

public class mergeSort
{
  private double[] array;
  private double[] tempArray;
  private int length;

  public mergeSort(double inputArray []){
    this.array = inputArray;
    this.length = inputArray.length;
    this.tempArray = new double[this.length];
  }

  public void sort()
  {
    doMergeSort(0,this.length-1);
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
      this.tempArray[i] = this.array[i];
    }

    int i = lowIndex;
    int j = middle + 1;
    int k = lowIndex;

    while(i <= middle && j <= highIndex)
    {
      if(this.tempArray[i] < this.tempArray[j])
      {
        this.array[k] = this.tempArray[i];
        i++;
      }
      else
      {
        this.array[k] = this.tempArray[j];
        j++;
      }
      k++;
    }
    while(i <= middle)
    {
      this.array[k] = this.tempArray[i];
      i++;
      k++;
    }
  }
}
