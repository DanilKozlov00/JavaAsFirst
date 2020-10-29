package Lesson1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class task1Test {

    task1 task1 = new task1();

    @Test
    @Tag("Example")
    void sqr() {
        assertEquals(0, task1.sqr(0));
        assertEquals(4, task1.sqr(2));
        assertEquals(9, task1.sqr(-3));
    }

    @Test
    @Tag("Example")
    void sqrDouble() {
        assertEquals(0.0, task1.sqrDouble(0.0), 1e-13);
        assertEquals(4.0, task1.sqrDouble(2.0), 1e-13);
        assertEquals(9.0, task1.sqrDouble(-3.0), 1e-13);
    }

    @Test
    @Tag("Example")
    void discriminant() {
        assertEquals(0.0, task1.discriminant(0.0, 0.0, 0.0), 1e-13);
        assertEquals(0.0, task1.discriminant(1.0, -2.0, 1.0), 1e-13);
        assertEquals(1.0, task1.discriminant(1.0, 3.0, 2.0), 1e-13);
    }

    @Test
    @Tag("Example")
    void quadraticEquationRoot() {
        assertEquals(1.0, task1.quadraticEquationRoot(1.0, -2.0, 1.0), 1e-13);
        assertEquals(9.0, task1.quadraticEquationRoot(1.0, 6.0, 9.0), 1e-13);
        assertEquals(2.0, task1.quadraticEquationRoot(1.0, 3.0, 2.0), 1e-13);
    }

    @Test
    @Tag("Example")
    void quadraticRootProduct() {
        assertEquals(1.0, task1.quadraticRootProduct(1.0, -2.0, 1.0), 1e-13);
        assertEquals(9.0, task1.quadraticRootProduct(1.0, 6.0, 9.0), 1e-13);
        assertEquals(2.0, task1.quadraticRootProduct(1.0, 3.0, 2.0), 1e-13);
    }

    @Test
    @Tag("Trivial")
    void seconds() {
        assertEquals(30035, task1.seconds(8, 20, 35));
        assertEquals(86400, task1.seconds(24, 0, 0));
        assertEquals(13, task1.seconds(0, 0, 13));
    }

    @Test
    @Tag("Trivial")
    void lengthInMeters() {
        assertEquals(18.98, task1.lengthInMeters(8, 2, 11), 1e-2);
        assertEquals(2.13, task1.lengthInMeters(1, 0, 0), 1e-2);
    }

    @Test
    @Tag("Trivial")
    void angleInRadian() {
        assertEquals(0.63256, task1.angleInRadian(36, 14, 35), 1e-5);
        assertEquals(PI / 2.0, task1.angleInRadian(90, 0, 0), 1e-5);
    }

    @Test
    @Tag("Trivial")
    void trackLength() {
        assertEquals(5.0, task1.trackLength(3.0, 0.0, 0.0, 4.0), 1e-5);
        assertEquals(1.0, task1.trackLength(0.0, 1.0, -1.0, 1.0), 1e-5);
        assertEquals(1.41, task1.trackLength(1.0, 1.0, 2.0, 2.0), 1e-2);
    }

    @Test
    @Tag("Easy")
    void thirdDigit() {
        assertEquals(8, task1.thirdDigit(3801));
        assertEquals(1, task1.thirdDigit(100));
        assertEquals(0, task1.thirdDigit(1000));
    }

    @Test
    @Tag("Easy")
    void travelMinutes() {
        assertEquals(216, task1.travelMinutes(9, 25, 13, 1));
        assertEquals(1, task1.travelMinutes(21, 59, 22, 0));
    }

    @Test
    @Tag("Easy")
    void accountInThreeYears() {
        assertEquals(133.1, task1.accountInThreeYears(100, 10), 1e-2);
        assertEquals(1.0, task1.accountInThreeYears(1, 0), 1e-2);
        assertEquals(104.0, task1.accountInThreeYears(13, 100), 1e-2);
    }

    @Test
    @Tag("Easy")
    void numberRevert() {
        assertEquals(874, task1.numberRevert(478));
        assertEquals(201, task1.numberRevert(102));
    }
}