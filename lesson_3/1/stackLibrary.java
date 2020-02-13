package ru.geekbrains.lesson_03;

import com.sun.javaws.exceptions.ErrorCodeResponseException;

class Stack{
    private int maxSize;
    private int[] stack;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int value){
        if (top == maxSize-1){
            for (int i=0; i<maxSize-1; i++){
                stack[i] = stack[i+1];
            }
            top--;
        }
        stack[++top] = value;
    }

    public int pop(){
        if (top<0){
            throw new Error("Стек пуст");
        }
        return stack[top--];
    }

    public int peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }
}

class Queue{
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s){
        maxSize = s;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }
    public void insert(int value){
        if(rear == maxSize-1)
            rear = -1;
        queue[++rear] = value;
        items++;
    }

    public int remove(){
        int temp = queue[front++];
        if(front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public int peek(){
        return queue[front];
    }
    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}

class PriorityQueue{
    private int maxSize;
    private int[] queueArray;
    private int items;

    public PriorityQueue(int value){
        maxSize = value;
        queueArray = new int[maxSize];
        items = 0;
    }
    public void insert(int item){
        int i;
        if(items==0)
            queueArray[items++] = item;
        else{
            for(i=items-1; i>=0; i--){
                if( item > queueArray[i] )
                    queueArray[i+1] = queueArray[i];
                else
                    break;
            }
            queueArray[i+1] = item; // Вставка элемента
            items++;
        }
    }
    public int remove(){
        return queueArray[--items];
    }
    public long peek(){
        return queueArray[items-1];
    }

    public boolean isEmpty(){
        return (items==0);
    }
    public boolean isFull(){
        return (items == maxSize);
    }
}

class Deque{
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Deque(int s){
        maxSize = s*2;
        queue = new int[maxSize];
        front = s-1;
        rear = s-1;
        items = 0;
    }
    public void insertLeft(int value){
        front--;
        if (front < 0){
            for (int i=maxSize-1; i>0; i--){
                queue[i] = queue[i-1];
            }
            front = 0;
            if (rear<maxSize/2-1){
                rear++;
            }
            items--;
        }
        queue[front] = value;
        items++;
    }
    public void insertRight(int value){
        rear++;
        if (rear == maxSize-1){
            for (int i=0; i<maxSize-1; i++){
                queue[i] = queue[i+1];
            }
            if (front > maxSize/2 - 1) {
                front--;
            }
            rear--;
            items--;
        }
        queue[rear] = value;
        items++;
    }
    public int removeLeft(){
        if (front == maxSize) {
            front = maxSize / 2 - 1;
            rear = front;
        }
        int temp = queue[front++];
        items--;
        return temp;
    }
    public int removeRight(){
        if (rear < 0) {
            front = maxSize / 2 - 1;
            rear = front;
        }
        int temp = queue[rear--];
        items--;
        return temp;
    }
    public int peekLeft(){
        return queue[front];
    }
    public int peekRight(){
        return queue[rear];
    }
    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }
}



