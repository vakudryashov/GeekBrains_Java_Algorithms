package ru.geekbrains.lesson_03;

public class Main {

    public static void main(String[] args) {
        Targets targets = new Targets(50);
        targets.init(20);
        targets.locate(0,0);
        targets.sort();
        System.out.println("");
        targets.print(targets.targetCount);
        int max = targets.findMaxFrag();
        System.out.printf("%nМакимально возможное количество фрагов за один выстрел: %d%n",max);
        if (max>1) {
            System.out.println("Список целей:");
            targets.printMaxFrag(max);
        }else{
            System.out.println("Можно целиться в любую цель");
        }
    }
}
