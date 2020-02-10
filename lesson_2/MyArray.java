package ru.geekbrains.lesson_02;
import java.util.Date;
import java.util.Random;

public class MyArray {
    private int[] arr;
    private int len;

    public MyArray(int len){
        this.arr = new int[len];
        this.len = len;
    }

    public void print(int count){
        System.out.printf("Первые %d элементов:\n",count);
        for (int i=0; i<count; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void add(int index, int val){
        int[] newArr = new int[len + 1];
        for (int i=0; i<index; i++){
            newArr[i] = arr[i];
        }
        newArr[index] = val;
        for (int i=index; i<len; i++){
            newArr[i+1] = arr[i];
        }

        len++;
        arr = newArr;
    }

    public void del(int index){
        int[] newArr = new int[len - 1];
        for (int i=0; i<index; i++){
            newArr[i] = arr[i];
        }
        for (int i=index+1; i<arr.length; i++){
            newArr[i-1] = arr[i];
        }
        len--;
        arr = newArr;
    }

    public int length(){
        return len;
    }

    public void set(int index, int val){
        arr[index] = val;
    }

    public int get(int index){
        return arr[index];
    }

    public int found(int val){
        int i;
        for (i=0; i<len; i++){
            if (arr[i] == val){
                break;
            }
        }
        if (i == len) i = -1;
        return i;
    }

    public void shuffle(){
        System.out.println("\nПеремешаем элементы.");
        int[] newArr = new int[len];
        int newLen = len;
        for (int i=0; i<newLen; i++){
            Random rand = new Random();
            int index = rand.nextInt(len);
            newArr[i] = arr[index];
            del(index);
        }
        arr = newArr;
        len = newLen;
    }

    public void swap(int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public void bubbleSort(){
        long start = System.currentTimeMillis();
        long count = 0;
        long swapCount = 0;
        for (int i=len-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (arr[j] > arr[j+1]){
                    swap(j,j+1);
                    swapCount++;
                }
                count++;
            }
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.printf("\nСортировка пузырьком. Количество итераций: %d; Количество операций перемещения элементов: %d. Продолжительность выполнения: %d мс\n", count, swapCount, timeWorkCode);
    }

    public void selectionSort(){
        long start = System.currentTimeMillis();
        long count = 0;
        long swapCount = 0;
        for (int i=0; i<len; i++){
            int minIx = i;
            for (int j=i+1; j<len; j++){
                if (arr[j]<arr[minIx]){
                    minIx = j;
                    swapCount++;
                }
                count++;
            }
            swap(i,minIx);
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.printf("\nСортировка пузырьком. Количество итераций: %d; Количество операций перемещения элементов: %d. Продолжительность выполнения: %d мс\n", count, swapCount, timeWorkCode);
    }

    public void insertionSort(){
        long start = System.currentTimeMillis();
        long count = 0;
        long swapCount = 0;
        for (int i=1; i<len; i++){
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
                swapCount++;
                count++;
            }
            count++;
            arr[j] = tmp;
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.printf("\nСортировка пузырьком. Количество итераций: %d; Количество операций перемещения элементов: %d. Продолжительность выполнения: %d мс\n", count, swapCount, timeWorkCode);
    }

    public void mergeSort(){
        long start = System.currentTimeMillis();
        int[] tmp = new int[len];
        mergeSortInt(arr, tmp, 0, len - 1);
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.printf("\nСортировка слиянием. Продолжительность выполнения: %d мс\n", timeWorkCode);
    }

    private static void mergeSortInt(int[] arr, int[] tmp, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int mid = (hi + lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid+1, hi);
        merge(arr,tmp,lo,mid,hi);
    }

    private static void merge(int[] arr, int[] tmp, int lo, int mid, int hi){
        for (int i=lo; i<=hi; i++){
            tmp[i] = arr[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k<= hi; k++ ){
            if (i > mid){
                arr[k] = tmp[j++];
            } else if (j>hi){
                arr[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]){
                arr[k] = tmp[j++];
            } else {
                arr[k] = tmp[i++];
            }
        }
    }
}
