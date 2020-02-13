package ru.geekbrains.lesson_03;

public class Main{
    public static void main(String[] args){
        String s = "Строка, которую надо развернуть задом наперёд";
        int size = s.length();
        Stack st = new Stack(size);
        Deque deqL = new Deque(size);
        Deque deqR = new Deque(size);
        System.out.printf("Это - \"%s\"%n%n",s);
        System.out.println("Это можно реализовать и без использования стека:");
        for (int i=0; i<size; i++){
            System.out.print(s.charAt(size-1-i));
            st.push(s.charAt(i));
            deqL.insertLeft(s.charAt(i));
            deqR.insertRight(s.charAt(i));
        }
        System.out.println("\n\nА можно и через стек:");
        for (int i=0; i<size; i++){
            System.out.print((char)st.pop());
        }
        System.out.println("\n\nИли дек (вход - выход слева):");
        for (int i=0; i<size; i++){
            System.out.print((char)deqL.removeLeft());
        }
        System.out.println("\n\nИли дек (вход - выход справа):");
        for (int i=0; i<size; i++){
            System.out.print((char)deqR.removeRight());
        }
    }
}
