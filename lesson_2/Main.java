package ru.geekbrains.lesson_02;

import java.util.Random;
import ru.geekbrains.lesson_02.MyArray;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(100000);
        int printCount = 20;
        int maxRandomNumber = arr.length();
	    System.out.printf("Создан массив длиной %d элементов\n",arr.length());

	    for (int i=0; i<arr.length(); i++){
            Random rand = new Random();
            arr.set(i,rand.nextInt(maxRandomNumber));
        }
        System.out.println("Массив заполнен случайными числами.");

        arr.print(printCount);

        Random rand = new Random();
        int index = rand.nextInt(arr.length());
        System.out.printf("\nУдалим случайный элемент в позиции %d:",index);
        arr.del(index);
        System.out.printf("\nНовая длина массива: %d элементов\n",arr.length());

        int val = rand.nextInt(maxRandomNumber);
        index = rand.nextInt(arr.length());

        System.out.printf("\nВставим случайное число (%d) в случайной позиции (%d):",val,index);
        arr.add(index,val);
        System.out.printf("\nНовая длина массива: %d элементов\n",arr.length());

        val = rand.nextInt(150);
        System.out.printf("\nПоиск первого вхождения случайного числа (%d) в массиве:",val);
        index = arr.found(val);
        if (index>-1){
            System.out.printf("\nЭлемент найден на позиции %d\n",index);
        }else{
            System.out.printf("\nЭлемент не найден\n");
        }
        arr.bubbleSort();
        arr.print(printCount);

        arr.shuffle();
        arr.print(printCount);

        arr.selectionSort();
        arr.print(printCount);

        arr.shuffle();
        arr.print(printCount);

        arr.insertionSort();
        arr.print(printCount);

        arr.shuffle();
        arr.print(printCount);
        arr.mergeSort();
        arr.print(printCount);
    }

}
