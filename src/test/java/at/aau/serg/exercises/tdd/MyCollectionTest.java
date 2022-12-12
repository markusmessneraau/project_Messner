package at.aau.serg.exercises.tdd;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitPlatform.class)
public class MyCollectionTest {

    @Test
    public void testRemove(){

        MyCollection x = new MyCollection(4);

        ArrayList<String> a = new ArrayList<>();



        x.add("VW");
        x.add("BMX");
        x.add("Audi");
        x.add("Fiat");

        x.remove("VW");


        for (int  i = 0;  i < x.size()-1;  i++) {

            a.add(x.getElement(i));

        }

        Assertions.assertFalse(a.contains("VW"));



    }





    @Test
    public void testRemoveExeption(){

        MyCollection x = new MyCollection(4);


        Assertions.assertThrows(IllegalArgumentException.class, () -> {


            x.remove("Dell");

        });
    }


    @Test
    public void testEmpty(){

        MyCollection x = new MyCollection(4);

        ArrayList<String> a = new ArrayList<>();



        x.add("VW");
        x.add("BMX");
        x.add("Audi");
        x.add("Fiat");

        x.empty();

        for (int  i = 0;  i < x.size()-1;  i++) {

            a.add(x.getElement(i));

        }

        boolean z;

        for (int i = 0; i < a.size(); i++) {

            if(a.get(i) == null){

                 z = true;
            }else{

                 z = false;
            }

            Assertions.assertTrue(z);


        }



    }

}
