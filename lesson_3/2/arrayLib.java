package ru.geekbrains.lesson_03;
import java.util.Random;

class MyArray {
    private int[] arr;
    private int len;
    private int pos;
    public MyArray(int len){
        this.arr = new int[len];
        this.len = len;
        this.pos = 0;
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
    public void push(int val){
        arr[pos++] = val;
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

    public int find(int val){
        int i;
        for (i=0; i<len; i++){
            if (arr[i] == val){
                break;
            }
        }
        if (i == len) i = -1;
        return i;
    }
    public int last(){
        return pos;
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
        for (int i=len-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (arr[j] > arr[j+1]){
                    swap(j,j+1);
                }
            }
        }
    }

    public void selectionSort(){
        for (int i=0; i<len; i++){
            int minIx = i;
            for (int j=i+1; j<len; j++){
                if (arr[j]<arr[minIx]){
                    minIx = j;
                }
            }
            swap(i,minIx);
        }
    }

    public void insertionSort(){
        for (int i=1; i<len; i++){
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    public void mergeSort(){
        int[] tmp = new int[len];
        mergeSortInt(arr, tmp, 0, len - 1);
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
