package sorting;

public class selectionSort {
    public static void main(String[] args) {
        selectionSort test = new selectionSort();
        int[] a = {1,1,1,1,1,2,2,2};
        int[] b = {1,7,9,4,6,2,10};
        test.sort(a);
        test.sort(b);
        for (int as : a) {
            System.out.println(as);
        }
        for (int bs : b) {
            System.out.println(bs);
        }
    }
    public void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i , min);
        }
   }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
