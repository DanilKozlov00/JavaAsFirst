package Lesson2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class logicalTest {

    Logical logical = new Logical();

    @Test
    @Tag("Example")
    void leanpointInsideCircle() {
        // (1, 1) inside circle: center = (0, 0), r = 2
        assertTrue(logical.pointInsideCircle(1.0, 1.0, 0.0, 0.0, 2.0));
        // (2, 2) NOT inside circle: center = (0, 0), r = 2
        assertFalse(logical.pointInsideCircle(2.0, 2.0, 0.0, 0.0, 2.0));
    }

    @Test
    @Tag("Easy")
    void isNumberHappy() {
        assertTrue(logical.isNumberHappy(1533));
        assertTrue(logical.isNumberHappy(9009));
        assertFalse(logical.isNumberHappy(3644));
    }

    @Test
    @Tag("Easy")
    void queenThreatens() {
        assertTrue(logical.queenThreatens(3, 6, 7, 6));
        assertTrue(logical.queenThreatens(3, 5, 3, 6));
        assertTrue(logical.queenThreatens(8, 1, 1, 8));
        assertFalse(logical.queenThreatens(7, 6, 5, 7));
    }

    @Test
    @Tag("Easy")
    void daysInMonth() {
        assertEquals(31,logical. daysInMonth(1, 1990));
        assertEquals(28,logical. daysInMonth(2, 1990));
        assertEquals(31,logical. daysInMonth(3, 1990));
        assertEquals(30,logical. daysInMonth(4, 1990));
        assertEquals(31,logical. daysInMonth(5, 1990));
        assertEquals(30,logical. daysInMonth(6, 1990));
        assertEquals(31,logical. daysInMonth(7, 1990));
        assertEquals(31,logical. daysInMonth(8, 1990));
        assertEquals(29,logical. daysInMonth(2, 1992));
        assertEquals(29,logical. daysInMonth(2, 1996));
        assertEquals(28,logical. daysInMonth(2, 1900));
        assertEquals(29,logical. daysInMonth(2, 2000));
        assertEquals(30,logical. daysInMonth(9, 2000));
        assertEquals(31,logical. daysInMonth(10, 2000));
        assertEquals(30,logical. daysInMonth(11, 2000));
        assertEquals(31,logical. daysInMonth(12, 2000));
        assertEquals(-1,logical. daysInMonth(13, 2000));
    }

    @Test
    @Tag("Normal")
    void circleInside() {
        assertFalse(logical.circleInside(0.0, 0.0, 6.0, 0.0, 0.0, 5.0));
        assertFalse(logical.circleInside(0.0, 0.0, 1.0, 10.0, 10.0, 9.0));
        assertTrue(logical.circleInside(2.0, 2.0, 2.0, 2.0, 2.0, 2.0));
        assertTrue(logical.circleInside(-2.0, 3.0, 2.0, -2.0, 0.0, 5.0));
        assertFalse(logical.circleInside(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
    }

    @Test
    @Tag("Normal")
    void brickPasses() {
        assertTrue(logical.brickPasses(2, 10, 5, 6, 3));
        assertTrue(logical.brickPasses(4, 4, 4, 4, 4));
        assertFalse(logical.brickPasses(6, 5, 4, 3, 6));
        assertTrue(logical.brickPasses(3, 2, 1, 1, 2));
    }
}