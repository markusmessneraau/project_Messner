package at.aau.serg.exercises.shapetesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RectangularShapeFactoryTest {

    private static RectangularShapeFactory x;


    @BeforeAll
    static public void setup() {

        x = new RectangularShapeFactory();

    }

    @Test
    public void testSquare(){


        Square s = (Square) x.create(3,3);


        Assertions.assertTrue(s.isEquilateral());

    }

    @Test
    public void testRectangel(){



        RectangularShape r = x.create(3,2);


        Assertions.assertFalse(r.isEquilateral());


    }

    @Test
    public void squareEqual(){

        Square s1 = (Square) x.create(3,3);
        Square s2 = (Square) x.create(3,3);
        Square s3 = (Square) x.create(5,5);





        Assertions.assertEquals(s1.getWidth(), s2.getWidth());
        Assertions.assertNotEquals(s1.getWidth(), s3.getWidth());
    }

    @Test
    public void rectangleEqual(){



        RectangularShape r1 = x.create(2,4);
        RectangularShape r2 = x.create(2,4);
        RectangularShape r3 = x.create(4,6);

        Assertions.assertEquals(r1.getWidth(), r2.getWidth());
        Assertions.assertEquals(r1.getHeight(), r2.getHeight());

        Assertions.assertNotEquals(r1.getHeight(), r3.getHeight());
        Assertions.assertNotEquals(r1.getWidth(), r3.getWidth());
    }

    @Test
    public void throwsExeption(){



        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            x.create(-1, 5);

        });
    }

    @Test
    public void testSides (){

        Rectangle r1 = new Rectangle(2,3);

        int w = 2;
        int h = 3;


        Assertions.assertEquals(r1.getSides().get(0).getLength(), h);
        Assertions.assertEquals(r1.getSides().get(1).getLength(), w);
        Assertions.assertEquals(r1.getSides().get(2).getLength(), h);
        Assertions.assertEquals(r1.getSides().get(3).getLength(), w);

        Square s1 = new Square(4);

        int l = 4;

        Assertions.assertEquals(s1.getSides().get(0).getLength(), l);
        Assertions.assertEquals(s1.getSides().get(1).getLength(), l);
        Assertions.assertEquals(s1.getSides().get(2).getLength(), l);
        Assertions.assertEquals(s1.getSides().get(3).getLength(), l);

    }

    @ParameterizedTest
    @ValueSource( ints = {1,2,3,4})
    public void testSquare(int side){

        RectangularShapeFactory x1 = new RectangularShapeFactory();

        Square s = (Square) x1.create(side,side);


        Assertions.assertTrue(s.isEquilateral());

    }


}