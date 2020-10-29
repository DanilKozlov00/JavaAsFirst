package Lesson2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IfElseTest {

    IfElse ifElse = new IfElse();

    @Test
    @Tag("Example")
    void quadraticRootNumber() {
        assertEquals(1, ifElse.quadraticRootNumber(1.0, 2.0, 1.0));
        assertEquals(2, ifElse.quadraticRootNumber(1.0, 3.0, 2.0));
        assertEquals(0, ifElse.quadraticRootNumber(1.0, 4.0, 10.0));
    }

    @Test
    @Tag("Example")
    void gradeNotation() {
        assertEquals("отлично", ifElse.gradeNotation(5));
        assertEquals("хорошо", ifElse.gradeNotation(4));
        assertEquals("удовлетворительно", ifElse.gradeNotation(3));
        assertEquals("неудовлетворительно", ifElse.gradeNotation(2));
        assertEquals("несуществующая оценка 0", ifElse.gradeNotation(0));
    }

    @Test
    @Tag("Example")
    void minBiRoot() {
        assertEquals(Double.NaN, ifElse.minBiRoot(0.0, 0.0, 1.0), 1e-2);
        assertEquals(Double.NaN, ifElse.minBiRoot(0.0, 1.0, 2.0), 1e-2);
        assertEquals(-2.0, ifElse.minBiRoot(0.0, 1.0, -4.0), 1e-10);
        assertEquals(Double.NaN, ifElse.minBiRoot(1.0, -2.0, 4.0), 1e-2);
        assertEquals(Double.NaN, ifElse.minBiRoot(1.0, 3.0, 2.0), 1e-2);
        assertEquals(-1.41, ifElse.minBiRoot(1.0, -3.0, 2.0), 1e-2);
    }

    @Test
    @Tag("Easy")
    void ageDescription() {
        assertEquals("1 год", ifElse.ageDescription(1));
        assertEquals("21 год", ifElse.ageDescription(21));
        assertEquals("132 года", ifElse.ageDescription(132));
        assertEquals("4 года", ifElse.ageDescription(4));
        assertEquals("3 года", ifElse.ageDescription(3));
        assertEquals("2 года", ifElse.ageDescription(2));
        assertEquals("12 лет", ifElse.ageDescription(12));
        assertEquals("111 лет", ifElse.ageDescription(111));
        assertEquals("199 лет", ifElse.ageDescription(199));
    }

    @Test
    @Tag("Easy")
    void timeForHalfWay() {
        assertEquals(2.5, ifElse.timeForHalfWay(1.0, 5.0, 2.0, 4.0, 3.0, 3.0), 1e-2);
        assertEquals(3.67, ifElse.timeForHalfWay(4.0, 3.0, 1.0, 4.0, 1.0, 6.0), 1e-2);
        assertEquals(4.4, ifElse.timeForHalfWay(3.0, 0.0, 1.0, 6.0, 2.0, 5.0), 1e-2);
    }

    @Test
    @Tag("Easy")
    void whichRookThreatens() {
        assertEquals(0, ifElse.whichRookThreatens(1, 2, 3, 4, 5, 6));

        assertEquals(1, ifElse.whichRookThreatens(5, 3, 7, 3, 4, 8));
        assertEquals(1, ifElse.whichRookThreatens(5, 3, 5, 4, 3, 8));

        assertEquals(2, ifElse.whichRookThreatens(6, 8, 8, 6, 6, 3));
        assertEquals(2, ifElse.whichRookThreatens(2, 8, 8, 6, 6, 8));
        assertEquals(2, ifElse.whichRookThreatens(3, 5, 8, 7, 5, 5));

        assertEquals(3, ifElse.whichRookThreatens(5, 3, 5, 3, 4, 8));
        assertEquals(3, ifElse.whichRookThreatens(5, 3, 4, 8, 5, 3));
        assertEquals(3, ifElse.whichRookThreatens(3, 7, 8, 7, 3, 5));
    }

    @Test
    @Tag("Easy")
    void rookOrBishopThreatens() {
        assertEquals(0, ifElse.rookOrBishopThreatens(4, 5, 5, 7, 8, 8));

        assertEquals(1, ifElse.rookOrBishopThreatens(2, 8, 6, 8, 1, 6));
        assertEquals(1, ifElse.rookOrBishopThreatens(6, 7, 6, 8, 1, 6));

        assertEquals(2, ifElse.rookOrBishopThreatens(5, 4, 3, 7, 1, 8));

        assertEquals(3, ifElse.rookOrBishopThreatens(1, 6, 7, 6, 3, 8));
        assertEquals(3, ifElse.rookOrBishopThreatens(4, 7, 4, 6, 3, 8));
    }

    @Test
    @Tag("Easy")
    void triangleKind() {
        assertEquals(-1, ifElse.triangleKind(3.0, 7.5, 4.0));
        assertEquals(-1, ifElse.triangleKind(7.5, 3.0, 4.0));
        assertEquals(-1, ifElse.triangleKind(4.0, 7.5, 3.0));
        assertEquals(-1, ifElse.triangleKind(2.0, 0.5, 3.0));

        assertEquals(0, ifElse.triangleKind(1.0, 1.5, 1.5));
        assertEquals(0, ifElse.triangleKind(1.0, 1.5, 1.6));
        assertEquals(0, ifElse.triangleKind(1.5, 1.0, 1.5));
        assertEquals(0, ifElse.triangleKind(1.5, 1.5, 1.0));

        assertEquals(1, ifElse.triangleKind(4.0, 3.0, 5.0));
        assertEquals(1, ifElse.triangleKind(5.0, 3.0, 4.0));
        assertEquals(1, ifElse.triangleKind(3.0, 5.0, 4.0));
        assertEquals(1, ifElse.triangleKind(3.0, 4.0, 5.0));

        assertEquals(2, ifElse.triangleKind(4.0, 6.0, 8.0));
        assertEquals(2, ifElse.triangleKind(4.0, 8.0, 6.0));
        assertEquals(2, ifElse.triangleKind(6.0, 4.0, 8.0));
        assertEquals(2, ifElse.triangleKind(8.0, 6.0, 4.0));
    }

    @Test
    @Tag("Normal")
    void segmentLength() {
        assertEquals(-1, ifElse.segmentLength(1, 2, 3, 4));
        assertEquals(-1, ifElse.segmentLength(5, 7, 1, 3));
        assertEquals(-1, ifElse.segmentLength(4, 8, 5, 4));

        assertEquals(0, ifElse.segmentLength(4, 8, 5, 5));
        assertEquals(0, ifElse.segmentLength(1, 2, 2, 4));
        assertEquals(0, ifElse.segmentLength(1, 1, 1, 4));

        assertEquals(1, ifElse.segmentLength(3, 6, 1, 4));
        assertEquals(1, ifElse.segmentLength(3, 6, 2, 4));

        assertEquals(2, ifElse.segmentLength(2, 5, 3, 9));

        assertEquals(3, ifElse.segmentLength(3, 6, 0, 9));

        assertEquals(4, ifElse.segmentLength(1, 15, 10, 14));
    }
}