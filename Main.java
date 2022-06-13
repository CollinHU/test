import Package.mergeSort;

public class Main {
    public static void main(String[] args) {
        double a[] = new double[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        double b[] = {10, 29, 3, 6, 9};
        mergeSort mySort = new mergeSort(b);
        mySort.sort();
        
        System.out.println("after sort");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
