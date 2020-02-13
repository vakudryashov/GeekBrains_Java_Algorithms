package ru.geekbrains.lesson_03;

public class Main {

    public static void main(String[] args) {
        Targets tar = new Targets(100);
        RandomInt rand = new RandomInt();
        while (tar.add(rand.get(-10,10), rand.get(-10,10)) < 2);
        tar.sort();
        MyArray counters = new MyArray(100);
        double val = -360;
        int counter = 0;
        int j = 0;
        for (int i=0; i<100; i++){
            if (tar.getAngles()[i] != val){
                j++;
                val = tar.getAngles()[i];
                counter = 0;
            }
            counters.set(j,++counter);
        }
        counters.insertionSort();
        System.out.println("Максимальное количество целей, которые можно поразить одним выстрелом: "+counters.get(99));
    }
}
