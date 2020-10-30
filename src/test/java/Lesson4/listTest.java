package Lesson4;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class listTest {

    list list = new list();

    @Test
    @Tag("Example")
    void sqRoots() {
        LinkedList<Double> testList = new LinkedList<>();

        assertEquals(testList, list.sqRoots(-1.0));

        testList.add(0.0);
        assertEquals(testList, list.sqRoots(0.0));

        testList.clear();
        testList.add(-5.0);
        testList.add(5.0);
        assertEquals(testList, list.sqRoots(25.0));
    }


    @Test
    @Tag("Example")
    void biRoots() {
        LinkedList<Double> testList = new LinkedList<>();


        assertEquals(testList, list.biRoots(0.0, 0.0, 1.0));
        assertEquals(testList, list.biRoots(0.0, 1.0, 2.0));

        testList.add(-2.0);
        testList.add(2.0);
        assertEquals(testList, list.biRoots(0.0, 1.0, -4.0));

        testList.clear();
        assertEquals(testList, list.biRoots(1.0, -2.0, 4.0));

        testList.add(-1.0);
        testList.add(1.0);
        assertEquals(testList, list.biRoots(1.0, -2.0, 1.0));

        testList.clear();
        testList.add(-1.0);
        testList.add(1.0);
        testList.add(-0.5);
        testList.add(0.5);
        assertEquals(testList, list.biRoots(4.0, -5.0, 1.0));
    }

    @Test
    @Tag("Example")
    void negativeList() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();

        actualList.add(1);
        actualList.add(2);
        actualList.add(3);
        assertEquals(testList, list.negativeList(actualList));


        actualList.clear();
        actualList.add(-1);
        actualList.add(2);
        actualList.add(4);
        actualList.add(-5);
        testList.add(-1);
        testList.add(-5);
        assertEquals(testList, list.negativeList(actualList));
    }

    @Test
    @Tag("Example")
    void invertPositives() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();


        actualList.add(-1);
        actualList.add(-2);
        actualList.add(-3);
        assertEquals(actualList, list.invertPositives(actualList));

        actualList.clear();
        testList.add(-1);
        testList.add(-5);
        testList.add(-2);
        testList.add(-4);
        actualList.add(-1);
        actualList.add(-5);
        actualList.add(2);
        actualList.add(4);
        assertEquals(testList, list.invertPositives(actualList));
    }

    @Test
    @Tag("Example")
    void squares() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();

        testList.add(0);
        actualList.add(0);
        assertEquals(testList, list.squares(actualList));


        testList.clear();
        actualList.clear();
        testList.add(1);
        testList.add(4);
        testList.add(9);
        actualList.add(1);
        actualList.add(2);
        actualList.add(-3);
        assertEquals(testList, list.squares(actualList));
    }

    @Test
    @Tag("Example")
    void testSquares() {
        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(0);
        assertEquals(testList, list.squares(0));

        testList.clear();
        testList.add(1);
        testList.add(4);
        testList.add(9);
        assertEquals(testList, list.squares(1, 2, -3));
    }

    @Test
    @Tag("Example")
    void isPalindrome() {
        assertFalse(list.isPalindrome("Барабан"));
        assertTrue(list.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(list.isPalindrome("Шалаш"));
    }

    @Test
    @Tag("Example")
    void buildSumExample() {
        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(42);
        assertEquals("42 = 42 ", list.buildSumExample(testList));

        testList.clear();
        testList.add(3);
        testList.add(6);
        testList.add(5);
        testList.add(4);
        testList.add(9);
        assertEquals("3 + 6 + 5 + 4 + 9 = 27 ", list.buildSumExample(testList));
    }

    @Test
    @Tag("Easy")
    void abs() {
        Vector<Double> testList = new Vector<>();

        assertEquals(0.0, list.abs(testList), 1e-15);

        testList.add(3.0);
        assertEquals(3.0, list.abs(testList), 1e-15);

        testList.add(-4.0);
        assertEquals(5.0, list.abs(testList), 1e-5);

        testList.clear();
        testList.add(4.0);
        testList.add(-5.0);
        testList.add(6.0);
        assertEquals(8.774964, list.abs(testList), 1e-5);
    }

    @Test
    @Tag("Easy")
    void mean() {
        LinkedList<Double> testList = new LinkedList<>();

        assertEquals(0.0, list.mean(testList), 1e-5);

        testList.add(1.0);
        assertEquals(1.0, list.mean(testList), 1e-5);

        testList.clear();
        testList.add(3.0);
        testList.add(1.0);
        testList.add(2.0);
        assertEquals(2.0, list.mean(testList), 1e-5);

        testList.clear();
        testList.add(0.0);
        testList.add(2.0);
        testList.add(7.0);
        testList.add(8.0);
        testList.add(-2.0);
        assertEquals(3.0, list.mean(testList), 1e-5);
    }

    @Test
    @Tag("Normal")
    void center() {
        LinkedList<Double> testList = new LinkedList<>();
        LinkedList<Double> actualList = new LinkedList<>();

        assertEquals(testList, list.center(actualList));


        testList.add(0.0);
        actualList.add(3.14);
        assertEquals(testList, list.center(actualList));

        testList.clear();
        actualList.clear();
        testList.add(1.0);
        testList.add(-1.0);
        testList.add(0.0);
        actualList.add(3.0);
        actualList.add(1.0);
        actualList.add(2.0);
        assertEquals(testList, list.center(actualList));

        testList.clear();
        actualList.clear();
        testList.add(-3.0);
        testList.add(-1.0);
        testList.add(4.0);
        testList.add(5.0);
        testList.add(-5.0);
        actualList.add(0.0);
        actualList.add(2.0);
        actualList.add(7.0);
        actualList.add(8.0);
        actualList.add(-2.0);
        assertEquals(testList, list.center(actualList));

    }

    @Test
    @Tag("Normal")
    void times() {
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> actualList = new ArrayList<>();


        assertEquals(0, list.times(testList, actualList));

        testList.add(1);
        testList.add(-4);
        actualList.add(3);
        actualList.add(2);
        assertEquals(-5, list.times(testList, actualList));

        testList.clear();
        actualList.clear();
        testList.add(-1);
        testList.add(2);
        testList.add(-3);
        actualList.add(3);
        actualList.add(-2);
        actualList.add(4);
        assertEquals(-19, list.times(testList, actualList));
    }

    @Test
    @Tag("Normal")
    void polynom() {
        ArrayList<Integer> actualList = new ArrayList<>();


        assertEquals(0, list.polynom(actualList, 1000));

        actualList.add(42);
        assertEquals(42, list.polynom(actualList, -1000));

        actualList.clear();
        actualList.add(3);
        actualList.add(2);
        assertEquals(13, list.polynom(actualList, 5));

        actualList.clear();
        actualList.add(2);
        actualList.add(-3);
        actualList.add(1);
        assertEquals(0, list.polynom(actualList, 1));

        actualList.clear();
        actualList.add(-7);
        actualList.add(6);
        actualList.add(4);
        actualList.add(-4);
        actualList.add(1);
        assertEquals(45, list.polynom(actualList, -2));
    }

    @Test
    @Tag("Normal")
    void accumulate() {
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> actualList = new ArrayList<>();

        assertEquals(testList, list.accumulate(actualList));

        testList.add(3);
        actualList.add(3);
        assertEquals(testList, list.accumulate(actualList));

        testList.clear();
        actualList.clear();
        testList.add(1);
        testList.add(3);
        testList.add(6);
        testList.add(10);
        actualList.add(1);
        actualList.add(2);
        actualList.add(3);
        actualList.add(4);
        assertEquals(testList, list.accumulate(actualList));
    }

    @Test
    @Tag("Normal")
    void factorize() {
        ArrayList<Integer> testList = new ArrayList<>();

        testList.add(2);
        assertEquals(testList, list.factorize(2));

        testList.clear();
        testList.add(3);
        testList.add(5);
        testList.add(5);
        assertEquals(testList, list.factorize(75));

        testList.clear();
        testList.add(2);
        testList.add(3);
        testList.add(3);
        testList.add(19);
        assertEquals(testList, list.factorize(342));
    }

    @Test
    @Tag("Hard")
    void factorizeToString() {
        assertEquals("2", list.factorizeToString(2));
        assertEquals("3*5*5", list.factorizeToString(75));
        assertEquals("2*3*3*19", list.factorizeToString(342));
        assertEquals("7*7*31*31*151*151", list.factorizeToString(1073676289));
        assertEquals("1073676287", list.factorizeToString(1073676287));

        // pass, but so slow :)
        //assertEquals(String.valueOf(Integer.MAX_VALUE), list.factorizeToString(Integer.MAX_VALUE));
    }

    @Test
    @Tag("Normal")
    void convert() {
        ArrayList<Integer> testList = new ArrayList<>();

        testList.add(1);
        assertEquals(testList, list.convert(1, 2));

        testList.add(2);
        testList.add(1);
        testList.add(0);
        assertEquals(testList, list.convert(100, 4));

        testList.clear();
        testList.add(1);
        testList.add(3);
        testList.add(12);
        assertEquals(testList, list.convert(250, 14));

        testList.clear();
        testList.add(2);
        testList.add(14);
        testList.add(12);
        assertEquals(testList, list.convert(1000, 19));
    }

    @Test
    @Tag("Hard")
    void convertToString() {
        assertEquals("1", list.convertToString(1, 2));
        assertEquals("1210", list.convertToString(100, 4));
        assertEquals("13c", list.convertToString(250, 14));
        assertEquals("2ec", list.convertToString(1000, 19));
        assertEquals("z", list.convertToString(35, 36));
        assertEquals("a02220281", list.convertToString(Integer.MAX_VALUE, 11));
    }

    @Test
    @Tag("Normal")
    void decimal() {
        ArrayList<Integer> actualList = new ArrayList<>();
        
        actualList.add(1);
        assertEquals(1, list.decimal(actualList,2));

        actualList.add(2);
        actualList.add(1);
        actualList.add(0);
        assertEquals(100, list.decimal(actualList, 4));
        
        actualList.clear();
        actualList.add(1);
        actualList.add(3);
        actualList.add(12);
        assertEquals(250, list.decimal(actualList, 14));
        
        actualList.clear();
        actualList.add(2);
        actualList.add(14);
        actualList.add(12);
        assertEquals(1000, list.decimal(actualList, 19));
    }

    @Test
    @Tag("Hard")
    void decimalFromString() {
        assertEquals(1, list.decimalFromString("1", 2));
        assertEquals(47, list.decimalFromString("57", 8));
        assertEquals(100, list.decimalFromString("1210", 4));
        assertEquals(250, list.decimalFromString("13c", 14));
        assertEquals(1000, list.decimalFromString("2ec", 19));
        assertEquals(35, list.decimalFromString("z", 36));
        assertEquals(Integer.MAX_VALUE, list.decimalFromString("a02220281", 11));
    }


    @Test
    @Tag("Hard")
    void roman() {
        assertEquals("I", list.roman(1));
        assertEquals("M", list.roman(1000));
        assertEquals("X", list.roman(10));
        assertEquals("MMM", list.roman(3000));
        assertEquals("MCMLXXVIII", list.roman(1978));
        assertEquals("DCXCIV", list.roman(694));
        assertEquals("XLIX", list.roman(49));
    }


    @Test
    @Tag("Impossible")
    void russian() {
        assertEquals("сто пятьдесят", list.russian(150));
        assertEquals("сорок восемь", list.russian(48));
        assertEquals("одна тысяча сто пять", list.russian(1105));
        assertEquals("триста семьдесят пять", list.russian(375));
        assertEquals("тридцать три тысячи триста тридцать три", list.russian(33333));
        assertEquals("четыре тысячи семьдесят пять", list.russian(4075));
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", list.russian(22964));
        assertEquals("сто девятнадцать тысяч пятьсот восемь", list.russian(119508));
        assertEquals("две тысячи три", list.russian(2003));
        assertEquals("двести тысяч два", list.russian(200002));
        assertEquals("девятьсот тысяч", list.russian(900000));
        assertEquals("двенадцать", list.russian(12));
    }
}