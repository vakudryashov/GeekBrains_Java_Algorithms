package ru.geekbrains.lesson_03;

import java.lang.reflect.Array;
import java.util.Random;

class RandomInt{
    public int get(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
class Targets{
    private MyArray posX;
    private MyArray posY;
    private MyArray xy;
    private double[] angles;
    private double[] links;
    public Targets(int count){
        this.posX = new MyArray(count);
        this.posY = new MyArray(count);
        this.angles = new double[count];
        this.links = new double[count];
    }
    public int add(int x, int y){
        int ix = posX.find(x);
        int iy = posY.find(y);
        int result = 1;
        if (posX.last() == posX.length()-1){
            result = 2;
        }else if (ix > -1 && iy == ix || x == y && x == 0){
            result = 0;
        }else{
            posX.push(x);
            posY.push(y);
            double arksin = Math.asin(y / Math.sqrt(x * x + y * y));
            double rad = 180/Math.PI;
            int index = posX.last();
            if (x>0) angles[index] = arksin*rad;
            else if (x<0) angles[index] = (Math.PI - arksin)*rad;
            links[index] = angles[index];
        }
        return result;
    }
    public int getX(int ix){
        return posX.get(ix);
    }
    public int getY(int iy){
        return posY.get(iy);
    }
    public double[] getAngles(){
        return angles;
    }
    public void sort(){
        for (int i=1; i<angles.length; i++){
            double tmp = angles[i];
            int j = i;
            while (j>0 && angles[j-1] > tmp) {
                angles[j] = angles[j - 1];
                j--;
            }
            angles[j] = tmp;
        }
    }
    public int getLink(double value){
        for (int i=0; i<links.length; i++){
            if (links[i] == value){
                return i;
            }
        }
        return -1;
    }
}
