package Lesson3;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class loopTest {

    loop loop = new loop();

    @Test
    @Tag("Example")
    void factorial() {
        assertEquals(1.0, loop.factorial(0), 1e-5);
        assertEquals(1.0, loop.factorial(1), 1e-5);
        assertEquals(6.0, loop.factorial(3), 1e-5);
        assertEquals(120.0, loop.factorial(5), 1e-5);
        assertEquals(3628800.0, loop.factorial(10), 1e-5);
        assertEquals(2.43290200817664E18, loop.factorial(20), 1E10);
    }

    @Test
    @Tag("Example")
    void isPrime() {
        assertFalse(loop.isPrime(1));
        assertTrue(loop.isPrime(2));
        assertTrue(loop.isPrime(5));
        assertTrue(loop.isPrime(11));
        assertFalse(loop.isPrime(4));
        assertFalse(loop.isPrime(9));
        assertFalse(loop.isPrime(15));
        int count = 0;
        for (int n = 2; n <= 7919; n++) {
            if (loop.isPrime(n)) {
                count++;
            }
        }
        assertEquals(1000, count);
        count = 0;
        for (int n = 2; n <= 1000000; n++) {
            if (loop.isPrime(n)) {
                count++;
            }
        }
        assertEquals(78498, count);
    }

    @Test
    @Tag("Example")
    void isPerfect() {
        assertTrue(loop.isPerfect(6));
        assertTrue(loop.isPerfect(28));
        assertFalse(loop.isPerfect(100));
    }

    @Test
    @Tag("Example")
    void digitCountInNumber() {
        assertEquals(1, loop.digitCountInNumber(0, 0));
        assertEquals(1, loop.digitCountInNumber(7, 7));
        assertEquals(0, loop.digitCountInNumber(21, 3));
        assertEquals(1, loop.digitCountInNumber(510, 5));
        assertEquals(3, loop.digitCountInNumber(4784041, 4));
        assertEquals(4, loop.digitCountInNumber(5373393, 3));
    }

    @Test
    @Tag("Easy")
    void digitNumber() {
        assertEquals(1, loop.digitNumber(0));
        assertEquals(1, loop.digitNumber(7));
        assertEquals(2, loop.digitNumber(10));
        assertEquals(2, loop.digitNumber(99));
        assertEquals(3, loop.digitNumber(123));
        assertEquals(10, loop.digitNumber(Integer.MAX_VALUE));
    }

    @Test
    @Tag("Easy")
    void fib() {
        assertEquals(1, loop.fib(1));
        assertEquals(1, loop.fib(2));
        assertEquals(2, loop.fib(3));
        assertEquals(5, loop.fib(5));
        assertEquals(21, loop.fib(8));
        assertEquals(102334155, loop.fib(40));
        assertEquals(1134903170, loop.fib(45));
        assertEquals(1836311903, loop.fib(46));
    }

    @Test
    @Tag("Easy")
    void lcm() {
        assertEquals(13, loop.lcm(13, 13));
        assertEquals(8, loop.lcm(2, 8));
        assertEquals(24, loop.lcm(6, 8));
        assertEquals(975, loop.lcm(39, 75));
        assertEquals(13384091, loop.lcm(1357, 9863));
        assertEquals(1339310349, loop.lcm(13579, 98631));
        assertEquals(2089830349, loop.lcm(23579, 88631));
        assertEquals(2022222222, loop.lcm(2, 1011111111));
        assertEquals(2022222222, loop.lcm(1011111111, 2));
    }

    @Test
    @Tag("Easy")
    void minDivisor() {
        assertEquals(2, loop.minDivisor(2));
        assertEquals(3, loop.minDivisor(75));
        assertEquals(5, loop.minDivisor(75 / 3));
        assertEquals(97, loop.minDivisor(97));
        assertEquals(7, loop.minDivisor(49));
        assertEquals(17, loop.minDivisor(8653));
        assertEquals(2124679, loop.minDivisor(2124679));
        assertEquals(1073676287, loop.minDivisor(1073676287));
        assertEquals(Integer.MAX_VALUE, loop.minDivisor(Integer.MAX_VALUE));
    }

    @Test
    @Tag("Easy")
    void maxDivisor() {
        assertEquals(1, loop.maxDivisor(17));
        assertEquals(12, loop.maxDivisor(24));
        assertEquals(59, loop.maxDivisor(177));
        assertEquals(17, loop.maxDivisor(34));
        assertEquals(7, loop.maxDivisor(49));
        assertEquals(509, loop.maxDivisor(8653));
        assertEquals(1, loop.maxDivisor(2124679));
        assertEquals(1, loop.maxDivisor(1073676287));
        assertEquals(1, loop.maxDivisor(Integer.MAX_VALUE));
    }

    @Test
    @Tag("Easy")
    void isCoPrime() {
        assertTrue(loop.isCoPrime(25, 49));
        assertFalse(loop.isCoPrime(6, 8));
        assertTrue(loop.isCoPrime(17, 97));
        assertFalse(loop.isCoPrime(37, 111));
        assertTrue(loop.isCoPrime(1234567890, 908765431));
        assertTrue(loop.isCoPrime(2109876543, 1234567891));
    }

    @Test
    @Tag("Easy")
    void squareBetweenExists() {
        assertTrue(loop.squareBetweenExists(1, 1));
        assertTrue(loop.squareBetweenExists(21, 28));
        assertTrue(loop.squareBetweenExists(36, 48));
        assertTrue(loop.squareBetweenExists(50, 64));
        assertFalse(loop.squareBetweenExists(51, 61));
        assertFalse(loop.squareBetweenExists(999, 1001));
        assertTrue(loop.squareBetweenExists(152374337, 152423715));
        assertFalse(loop.squareBetweenExists(2147395601, Integer.MAX_VALUE));
    }

    @Test
    @Tag("Normal")
    void collatzSteps() {
        assertEquals(0, loop.collatzSteps(1));
        assertEquals(1, loop.collatzSteps(2));
        assertEquals(7, loop.collatzSteps(3));
        assertEquals(5, loop.collatzSteps(5));
        assertEquals(6, loop.collatzSteps(10));
        assertEquals(7, loop.collatzSteps(20));
        assertEquals(6, loop.collatzSteps(64));
        assertEquals(25, loop.collatzSteps(100));
        assertEquals(7, loop.collatzSteps(128));
        assertEquals(111, loop.collatzSteps(1000));
        assertEquals(128, loop.collatzSteps(100000));
    }

    @Test
    @Tag("Normal")
    void sin() {
        assertEquals(0.0, loop.sin(0.0, 1e-5), 1e-5);
        assertEquals(1.0, loop.sin(Math.PI / 2.0, 1e-5), 1e-5);
        assertEquals(0.0, loop.sin(Math.PI, 1e-5), 1e-5);
        assertEquals(-1.0, loop.sin(3.0 * Math.PI / 2.0, 1e-5), 1e-5);
        assertEquals(0.0, loop.sin(100 * Math.PI, 1e-5), 1e-5);
        assertNotEquals(Math.sin(1.0), loop.sin(1.0, 1.0));
        assertNotEquals(Math.sin(-0.5), loop.sin(-0.5, 1.0));
    }

    @Test
    @Tag("Normal")
    void cos() {
        assertEquals(1.0, loop.cos(0.0, 1e-5), 1e-5);
        assertEquals(0.0, loop.cos(Math.PI / 2.0, 1e-5), 1e-5);
        assertEquals(-1.0, loop.cos(Math.PI, 1e-5), 1e-5);
        assertEquals(0.0, loop.cos(3.0 * Math.PI / 2.0, 1e-5), 1e-5);
        assertEquals(1.0, loop.cos(100 * Math.PI, 1e-5), 1e-5);
        assertNotEquals(Math.cos(1.0), loop.cos(1.0, 1.0));
        assertNotEquals(Math.cos(0.5), loop.cos(-0.5, 1.0));
    }

    @Test
    @Tag("Normal")
    void revert() {
        assertEquals(87431, loop.revert(13478));
        assertEquals(0, loop.revert(0));
        assertEquals(-87431, loop.revert(-13478));
        assertEquals(3, loop.revert(3));
        assertEquals(111, loop.revert(111));
        assertEquals(17571, loop.revert(17571));
        assertEquals(123456789, loop.revert(987654321));
    }

    @Test
    @Tag("Normal")
    void isPalindrome() {
        assertTrue(loop.isPalindrome(3));
        assertTrue(loop.isPalindrome(0));
        assertFalse(loop.isPalindrome(-1551));
        assertFalse(loop.isPalindrome(3653));
        assertFalse(loop.isPalindrome(-3653));
        assertTrue(loop.isPalindrome(15751));
        assertTrue(loop.isPalindrome(24688642));
    }

    @Test
    @Tag("Normal")
    void hasDifferentDigits() {
        assertTrue(loop.hasDifferentDigits(323));
        assertTrue(loop.hasDifferentDigits(54));
        assertFalse(loop.hasDifferentDigits(55));
        assertTrue(loop.hasDifferentDigits(222266666));
        assertFalse(loop.hasDifferentDigits(0));
        assertFalse(loop.hasDifferentDigits(777));
        assertTrue(loop.hasDifferentDigits(-777));
        assertFalse(loop.hasDifferentDigits(677));
        assertTrue(loop.hasDifferentDigits(31122));
    }

    @Test
    @Tag("Hard")
    void squareSequenceDigit() {
        assertEquals(1, loop.squareSequenceDigit(1));
        assertEquals(4, loop.squareSequenceDigit(2));
        assertEquals(5, loop.squareSequenceDigit(7));
        assertEquals(6, loop.squareSequenceDigit(12));
        assertEquals(0, loop.squareSequenceDigit(17));
        assertEquals(9, loop.squareSequenceDigit(27));
    }

    @Test
    @Tag("Hard")
    void fibSequenceDigit() {
        assertEquals(1, loop.fibSequenceDigit(1));
        assertEquals(1, loop.fibSequenceDigit(2));
        assertEquals(3, loop.fibSequenceDigit(4));
        assertEquals(2, loop.fibSequenceDigit(9));
        assertEquals(5, loop.fibSequenceDigit(14));
        assertEquals(2, loop.fibSequenceDigit(20));
    }
}