package Lesson4;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class listTest {

    TaskList taskList = new TaskList();

    @Test
    @Tag("Example")
    void sqRoots() {
        LinkedList<Double> testList = new LinkedList<>();

        assertEquals(testList, taskList.sqRoots(-1.0));

        testList.add(0.0);
        assertEquals(testList, taskList.sqRoots(0.0));

        testList.clear();
        testList.add(-5.0);
        testList.add(5.0);
        assertEquals(testList, taskList.sqRoots(25.0));
    }


    @Test
    @Tag("Example")
    void biRoots() {
        LinkedList<Double> testList = new LinkedList<>();


        assertEquals(testList, taskList.biRoots(0.0, 0.0, 1.0));
        assertEquals(testList, taskList.biRoots(0.0, 1.0, 2.0));

        testList.add(-2.0);
        testList.add(2.0);
        assertEquals(testList, taskList.biRoots(0.0, 1.0, -4.0));

        testList.clear();
        assertEquals(testList, taskList.biRoots(1.0, -2.0, 4.0));

        testList.add(-1.0);
        testList.add(1.0);
        assertEquals(testList, taskList.biRoots(1.0, -2.0, 1.0));

        testList.clear();
        testList.add(-1.0);
        testList.add(1.0);
        testList.add(-0.5);
        testList.add(0.5);
        assertEquals(testList, taskList.biRoots(4.0, -5.0, 1.0));
    }

    @Test
    @Tag("Example")
    void negativeList() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();

        actualList.add(1);
        actualList.add(2);
        actualList.add(3);
        assertEquals(testList, taskList.negativeList(actualList));


        actualList.clear();
        actualList.add(-1);
        actualList.add(2);
        actualList.add(4);
        actualList.add(-5);
        testList.add(-1);
        testList.add(-5);
        assertEquals(testList, taskList.negativeList(actualList));
    }

    @Test
    @Tag("Example")
    void invertPositives() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();


        actualList.add(-1);
        actualList.add(-2);
        actualList.add(-3);
        assertEquals(actualList, taskList.invertPositives(actualList));

        actualList.clear();
        testList.add(-1);
        testList.add(-5);
        testList.add(-2);
        testList.add(-4);
        actualList.add(-1);
        actualList.add(-5);
        actualList.add(2);
        actualList.add(4);
        assertEquals(testList, taskList.invertPositives(actualList));
    }

    @Test
    @Tag("Example")
    void squares() {
        LinkedList<Integer> testList = new LinkedList<>();
        LinkedList<Integer> actualList = new LinkedList<>();

        testList.add(0);
        actualList.add(0);
        assertEquals(testList, taskList.squares(actualList));


        testList.clear();
        actualList.clear();
        testList.add(1);
        testList.add(4);
        testList.add(9);
        actualList.add(1);
        actualList.add(2);
        actualList.add(-3);
        assertEquals(testList, taskList.squares(actualList));
    }

    @Test
    @Tag("Example")
    void testSquares() {
        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(0);
        assertEquals(testList, taskList.squares(0));

        testList.clear();
        testList.add(1);
        testList.add(4);
        testList.add(9);
        assertEquals(testList, taskList.squares(1, 2, -3));
    }

    @Test
    @Tag("Example")
    void isPalindrome() {
        assertFalse(taskList.isPalindrome("Барабан"));
        assertTrue(taskList.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(taskList.isPalindrome("Шалаш"));
    }

    @Test
    @Tag("Example")
    void buildSumExample() {
        LinkedList<Integer> testList = new LinkedList<>();

        testList.add(42);
        assertEquals("42 = 42 ", taskList.buildSumExample(testList));

        testList.clear();
        testList.add(3);
        testList.add(6);
        testList.add(5);
        testList.add(4);
        testList.add(9);
        assertEquals("3 + 6 + 5 + 4 + 9 = 27 ", taskList.buildSumExample(testList));
    }

    @Test
    @Tag("Easy")
    void abs() {
        Vector<Double> testList = new Vector<>();

        assertEquals(0.0, taskList.abs(testList), 1e-15);

        testList.add(3.0);
        assertEquals(3.0, taskList.abs(testList), 1e-15);

        testList.add(-4.0);
        assertEquals(5.0, taskList.abs(testList), 1e-5);

        testList.clear();
        testList.add(4.0);
        testList.add(-5.0);
        testList.add(6.0);
        assertEquals(8.774964, taskList.abs(testList), 1e-5);
    }

    @Test
    @Tag("Easy")
    void mean() {
        LinkedList<Double> testList = new LinkedList<>();

        assertEquals(0.0, taskList.mean(testList), 1e-5);

        testList.add(1.0);
        assertEquals(1.0, taskList.mean(testList), 1e-5);

        testList.clear();
        testList.add(3.0);
        testList.add(1.0);
        testList.add(2.0);
        assertEquals(2.0, taskList.mean(testList), 1e-5);

        testList.clear();
        testList.add(0.0);
        testList.add(2.0);
        testList.add(7.0);
        testList.add(8.0);
        testList.add(-2.0);
        assertEquals(3.0, taskList.mean(testList), 1e-5);
    }

    @Test
    @Tag("Normal")
    void center() {
        LinkedList<Double> testList = new LinkedList<>();
        LinkedList<Double> actualList = new LinkedList<>();

        assertEquals(testList, taskList.center(actualList));


        testList.add(0.0);
        actualList.add(3.14);
        assertEquals(testList, taskList.center(actualList));

        testList.clear();
        actualList.clear();
        testList.add(1.0);
        testList.add(-1.0);
        testList.add(0.0);
        actualList.add(3.0);
        actualList.add(1.0);
        actualList.add(2.0);
        assertEquals(testList, taskList.center(actualList));

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
        assertEquals(testList, taskList.center(actualList));

    }

    @Test
    @Tag("Normal")
    void times() {
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> actualList = new ArrayList<>();


        assertEquals(0, taskList.times(testList, actualList));

        testList.add(1);
        testList.add(-4);
        actualList.add(3);
        actualList.add(2);
        assertEquals(-5, taskList.times(testList, actualList));

        testList.clear();
        actualList.clear();
        testList.add(-1);
        testList.add(2);
        testList.add(-3);
        actualList.add(3);
        actualList.add(-2);
        actualList.add(4);
        assertEquals(-19, taskList.times(testList, actualList));
    }

    @Test
    @Tag("Normal")
    void polynom() {
        ArrayList<Integer> actualList = new ArrayList<>();


        assertEquals(0, taskList.polynom(actualList, 1000));

        actualList.add(42);
        assertEquals(42, taskList.polynom(actualList, -1000));

        actualList.clear();
        actualList.add(3);
        actualList.add(2);
        assertEquals(13, taskList.polynom(actualList, 5));

        actualList.clear();
        actualList.add(2);
        actualList.add(-3);
        actualList.add(1);
        assertEquals(0, taskList.polynom(actualList, 1));

        actualList.clear();
        actualList.add(-7);
        actualList.add(6);
        actualList.add(4);
        actualList.add(-4);
        actualList.add(1);
        assertEquals(45, taskList.polynom(actualList, -2));
    }

    @Test
    @Tag("Normal")
    void accumulate() {
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> actualList = new ArrayList<>();

        assertEquals(testList, taskList.accumulate(actualList));

        testList.add(3);
        actualList.add(3);
        assertEquals(testList, taskList.accumulate(actualList));

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
        assertEquals(testList, taskList.accumulate(actualList));
    }

    @Test
    @Tag("Normal")
    void factorize() {
        ArrayList<Integer> testList = new ArrayList<>();

        testList.add(2);
        assertEquals(testList, taskList.factorize(2));

        testList.clear();
        testList.add(3);
        testList.add(5);
        testList.add(5);
        assertEquals(testList, taskList.factorize(75));

        testList.clear();
        testList.add(2);
        testList.add(3);
        testList.add(3);
        testList.add(19);
        assertEquals(testList, taskList.factorize(342));
    }

    @Test
    @Tag("Hard")
    void factorizeToString() {
        assertEquals("2", taskList.factorizeToString(2));
        assertEquals("3*5*5", taskList.factorizeToString(75));
        assertEquals("2*3*3*19", taskList.factorizeToString(342));
        assertEquals("7*7*31*31*151*151", taskList.factorizeToString(1073676289));
        assertEquals("1073676287", taskList.factorizeToString(1073676287));

        // pass, but so slow :)
        //assertEquals(String.valueOf(Integer.MAX_VALUE), TaskList.factorizeToString(Integer.MAX_VALUE));
    }

    @Test
    @Tag("Normal")
    void convert() {
        ArrayList<Integer> testList = new ArrayList<>();

        testList.add(1);
        assertEquals(testList, taskList.convert(1, 2));

        testList.add(2);
        testList.add(1);
        testList.add(0);
        assertEquals(testList, taskList.convert(100, 4));

        testList.clear();
        testList.add(1);
        testList.add(3);
        testList.add(12);
        assertEquals(testList, taskList.convert(250, 14));

        testList.clear();
        testList.add(2);
        testList.add(14);
        testList.add(12);
        assertEquals(testList, taskList.convert(1000, 19));
    }

    @Test
    @Tag("Hard")
    void convertToString() {
        assertEquals("1", taskList.convertToString(1, 2));
        assertEquals("1210", taskList.convertToString(100, 4));
        assertEquals("13c", taskList.convertToString(250, 14));
        assertEquals("2ec", taskList.convertToString(1000, 19));
        assertEquals("z", taskList.convertToString(35, 36));
        assertEquals("a02220281", taskList.convertToString(Integer.MAX_VALUE, 11));
    }

    @Test
    @Tag("Normal")
    void decimal() {
        ArrayList<Integer> actualList = new ArrayList<>();
        
        actualList.add(1);
        assertEquals(1, taskList.decimal(actualList,2));

        actualList.add(2);
        actualList.add(1);
        actualList.add(0);
        assertEquals(100, taskList.decimal(actualList, 4));
        
        actualList.clear();
        actualList.add(1);
        actualList.add(3);
        actualList.add(12);
        assertEquals(250, taskList.decimal(actualList, 14));
        
        actualList.clear();
        actualList.add(2);
        actualList.add(14);
        actualList.add(12);
        assertEquals(1000, taskList.decimal(actualList, 19));
    }

    @Test
    @Tag("Hard")
    void decimalFromString() {
        assertEquals(1, taskList.decimalFromString("1", 2));
        assertEquals(47, taskList.decimalFromString("57", 8));
        assertEquals(100, taskList.decimalFromString("1210", 4));
        assertEquals(250, taskList.decimalFromString("13c", 14));
        assertEquals(1000, taskList.decimalFromString("2ec", 19));
        assertEquals(35, taskList.decimalFromString("z", 36));
        assertEquals(Integer.MAX_VALUE, taskList.decimalFromString("a02220281", 11));
    }


    @Test
    @Tag("Hard")
    void roman() {
        assertEquals("I", taskList.roman(1));
        assertEquals("M", taskList.roman(1000));
        assertEquals("X", taskList.roman(10));
        assertEquals("MMM", taskList.roman(3000));
        assertEquals("MCMLXXVIII", taskList.roman(1978));
        assertEquals("DCXCIV", taskList.roman(694));
        assertEquals("XLIX", taskList.roman(49));
    }


    @Test
    @Tag("Impossible")
    void russian() {
        assertEquals("сто пятьдесят", taskList.russian(150));
        assertEquals("сорок восемь", taskList.russian(48));
        assertEquals("одна тысяча сто пять", taskList.russian(1105));
        assertEquals("триста семьдесят пять", taskList.russian(375));
        assertEquals("тридцать три тысячи триста тридцать три", taskList.russian(33333));
        assertEquals("четыре тысячи семьдесят пять", taskList.russian(4075));
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", taskList.russian(22964));
        assertEquals("сто девятнадцать тысяч пятьсот восемь", taskList.russian(119508));
        assertEquals("две тысячи три", taskList.russian(2003));
        assertEquals("двести тысяч два", taskList.russian(200002));
        assertEquals("девятьсот тысяч", taskList.russian(900000));
        assertEquals("двенадцать", taskList.russian(12));
    }
}