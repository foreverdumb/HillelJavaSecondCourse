import com.hillel.homework_11.ArrStrListUtilsClass;
import org.junit.Assert;
import org.junit.Test;

public class ArrStrListUtilsTest {

    @Test
    public void testIncreaseSize() {

        Object[] expected = new Object[20];

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();
        String[] result = arrStrListUtilsClass.increaseSize();
        Assert.assertArrayEquals(expected, result);
    }


    //if the test is passed this means INDEX IS OUT OF BOUNDS
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsIndexOutOfRange() {

        int index = 9;
        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        for (int i = 0; i < index; i++) {
            arrStrListUtilsClass.add("1");
        }

        arrStrListUtilsClass.isIndexOutOfRange(9);
    }

    @Test
    public void testIndexOf() {

        String Element = "Oleg";
        Object expected = 9;
        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();


        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);
        arrStrListUtilsClass.add(Element);

        arrStrListUtilsClass.add("Natasha");

        Object actual = arrStrListUtilsClass.indexOf("Natasha");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAdd_1() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        Object actual = arrStrListUtilsClass.add("1");
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAdd_2() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");

        Object actual = arrStrListUtilsClass.add(3, "Mike");
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");

        Object actual = arrStrListUtilsClass.delete("1");
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("2");
        arrStrListUtilsClass.add("3");
        arrStrListUtilsClass.add("4");

        Object actual = arrStrListUtilsClass.contains("4");
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();
        String[] strArr = new String[10];

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");

        strArr[0] = "1";
        strArr[1] = "1";
        strArr[2] = "1";
        strArr[3] = "1";
        strArr[4] = "1";
        strArr[5] = "1";
        strArr[6] = "1";
        strArr[7] = "1";
        strArr[8] = "1";
        strArr[9] = null;

        Object actual = arrStrListUtilsClass.equals(strArr);
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testClear() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");

        Object actual = arrStrListUtilsClass.clear();
        Object expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("1");

        Object actual = arrStrListUtilsClass.size();
        Object expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet() {

        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass();

        arrStrListUtilsClass.add("1");
        arrStrListUtilsClass.add("2");
        arrStrListUtilsClass.add("3");
        arrStrListUtilsClass.add("4");
        arrStrListUtilsClass.add("5");

        Object actual = arrStrListUtilsClass.get(3);
        Object expected = "4";

        Assert.assertEquals(expected, actual);
    }


    //if the test is passed this means that the SIZE IS EQUALS TO OR LESS THEN 0 and IllegalStateException thrown
    @Test(expected = IllegalStateException.class)
    public void testArrStrUtilClass() {
        ArrStrListUtilsClass arrStrListUtilsClass = new ArrStrListUtilsClass(0);
    }
}
