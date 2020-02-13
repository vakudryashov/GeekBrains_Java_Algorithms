package ru.geekbrains.lesson_03;

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
class Target{
    public int x;
    public int y;
    public double azimuth;
    public int counter = 0;
    public Target(int x, int y){
        this.x = x;
        this.y = y;
    }
    public double getAzimuth(int xo, int yo){
        int dx = x - xo;
        int dy = y - yo;
        double arksin = Math.asin( dy / Math.sqrt(dx*dx +dy*dy));
        double rad = 180/Math.PI;
        azimuth = arksin*rad;
        if (dx < 0) {
            azimuth = (Math.PI - arksin) * rad;
        }
        return azimuth;
    }
}
class Targets{
    private Target[] targetArr;
    public int targetCount;
    public Targets(int count){
        this.targetArr = new Target[count];
        this.targetCount = count;
    }
    public void init(int radius){
        RandomInt rand = new RandomInt();
        for (int i=0; i<targetCount; i++){
            while (true) {
                int xt = rand.get(-radius, radius);
                int yt = rand.get(-radius, radius);
                int flag = 1;
                for (int j = 0; j < i; j++) {
                    if (targetArr[j].x == xt && targetArr[j].y == yt) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    targetArr[i] = new Target(xt, yt);
                    break;
                }
            }
        }
    }
    public void locate(int xo, int yo){
        for (int i=0; i<targetCount; i++){
            targetArr[i].getAzimuth(xo,yo);
        }
    }
    public void sort(){
        for (int i=1; i<targetCount; i++){
            Target tmp = targetArr[i];
            int j = i;
            while (j>0 && targetArr[j-1].azimuth > tmp.azimuth) {
                targetArr[j] = targetArr[j - 1];
                j--;
            }
            targetArr[j] = tmp;
        }
    }
    public int findMaxFrag(){
        double last = targetArr[0].azimuth;
        int count = 1;
        for (int i=1; i<targetCount; i++){
            if (targetArr[i].azimuth != last){
                targetArr[i-1].counter = count;
                count = 1;
                last = targetArr[i].azimuth;
            }else{
                count++;
            }
        }
        count = 0;
        for (int i=0; i<targetCount; i++){
            if (targetArr[i].counter > count){
                count = targetArr[i].counter;
            }
        }
        return count;
    }
    public void print(int max){
        for (int i=0; i<targetCount; i++){
            Target target = targetArr[i];
            System.out.printf("x: %d, y: %d, a: %f%n",target.x, target.y, target.azimuth);
        }
    }
    public void printMaxFrag(int count){
        for (int i=0; i<targetCount; i++){
            Target target = targetArr[i];
            if (target.counter == count){
                double azimuth = target.azimuth;
                for (int j=0; j<targetCount; j++){
                    Target tar = targetArr[j];
                    if (tar.azimuth == azimuth){
                        System.out.printf("x: %d, y: %d, a: %f%n",tar.x, tar.y, tar.azimuth);
                    }
                }
                System.out.println("");
            }
        }
    }
}
