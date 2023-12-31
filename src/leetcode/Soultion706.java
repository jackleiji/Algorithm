package leetcode;

import java.util.*;

public class Soultion706 {

}

class MyHashMap {
    private class Pair{
        private int key;
        private int value;
        public Pair(int key,int value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int Base = 769;
    private LinkedList<Pair>[] data;

    public MyHashMap() {
        data = new LinkedList[Base];
        for(int i=0;i<Base;i++){
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                data[h].remove(pair);
                return;
            }
        }
    }
    private static int hash(int key) {
        return key % Base;
    }
}

