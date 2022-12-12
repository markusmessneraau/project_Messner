package at.aau.serg.exercises.tdd;

import java.util.ArrayList;

public class MyCollection {
    private String[] list;
    private int cursor=0;

    public MyCollection(int capacity){
        list = new String[capacity];
        cursor=0;
    }

    /**
     * Returns the size of the collection
     * @return The number of instances in the collection
     */
    public int size() {
        return cursor;
    }

    /**
     * Adds the String from to list. If the list is full it throws an IllegalArgumentException
     * @param s String to remove
     */
    public void add(String s) {
        list[cursor++]=s;
    }

    /**
     * Removes the String from the list. If the String is not in the list it throws an
     * IllegalArgumentException. If the list is empty it throws an IllegalArgumentException
     * @param s String to remove
     */
    public void remove(String s) throws IllegalArgumentException{

        ArrayList<String> a = new ArrayList<>();

        String [] b = new String[list.length-1];

        for (int i = 0; i < list.length-1; i++) {
            a.add(list[i]);
        }



        if(a.contains(s)){

            a.remove(s);


        }else{

            throw new IllegalArgumentException("Value not in the collection");
        }

        for (int i = 0; i < a.size()-1; i++) {

            b[i] = a.get(i);

        }


        list = b;




    }

    /**
     * Removes all items from the list and initializes a new list
     */
    public void empty() {

    }

    public String getElement (int x){

        return list[x];
    }

}