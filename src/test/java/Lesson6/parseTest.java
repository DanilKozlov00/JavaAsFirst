package Lesson6;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class parseTest {

    Parse parse = new Parse();


    @Test
    @Tag("Example")
    void timeStrToSeconds() {
        assertEquals(36000, parse.timeStrToSeconds("10:00:00"));
        assertEquals(41685, parse.timeStrToSeconds("11:34:45"));
        assertEquals(86399, parse.timeStrToSeconds("23:59:59"));
    }

    @Test
    @Tag("Example")
    void twoDigitStr() {
        assertEquals("00", parse.twoDigitStr(0));
        assertEquals("09", parse.twoDigitStr(9));
        assertEquals("10", parse.twoDigitStr(10));
        assertEquals("99", parse.twoDigitStr(99));
    }

    @Test
    @Tag("Example")
    void timeSecondsToStr() {
        assertEquals("10:00:00", parse.timeSecondsToStr(36000));
        assertEquals("11:34:45", parse.timeSecondsToStr(41685));
        assertEquals("23:59:59", parse.timeSecondsToStr(86399));
    }

    @Test
    @Tag("Normal")
    void dateStrToDigit() {
        assertEquals("15.07.2016", parse.dateStrToDigit("15 июля 2016"));
        assertEquals("", parse.dateStrToDigit("3 мартобря 1918"));
        assertEquals("18.11.2018", parse.dateStrToDigit("18 ноября 2018"));
        assertEquals("", parse.dateStrToDigit("23"));
        assertEquals("03.04.2011", parse.dateStrToDigit("3 апреля 2011"));
        assertEquals("", parse.dateStrToDigit("32 сентября 2011"));
        assertEquals("", parse.dateStrToDigit("-3 сентября 2011"));
        assertEquals("", parse.dateStrToDigit("30 сентября -2011"));
        assertEquals("", parse.dateStrToDigit("29 февраля 1993"));
    }

    @Test
    @Tag("Normal")
    void dateDigitToStr() {
        assertEquals("15 июля 2016", parse.dateDigitToStr("15.07.2016"));
        assertEquals("", parse.dateDigitToStr("01.02.20.19"));
        assertEquals("", parse.dateDigitToStr("28.00.2000"));
        assertEquals("", parse.dateDigitToStr("-28.04.2000"));
        assertEquals("", parse.dateDigitToStr("28.03.-2000"));
        assertEquals("", parse.dateDigitToStr("28.0"));
        assertEquals("3 апреля 2011", parse.dateDigitToStr("03.04.2011"));
        assertEquals("", parse.dateDigitToStr("ab.cd.ef"));
        assertEquals("", parse.dateDigitToStr("32.09.2011"));
        assertEquals("", parse.dateDigitToStr("29.02.1993"));
    }


    @Test
    @Tag("Normal")
    void flattenPhoneNumber() {
        assertEquals("+79211234567", parse.flattenPhoneNumber("+7 (921) 123-45-67"));
        assertEquals("123456798", parse.flattenPhoneNumber("12 --  34- 5 -- 67 -98"));
        assertEquals("+12345", parse.flattenPhoneNumber("+12 (3) 4-5"));
        assertEquals("+1245", parse.flattenPhoneNumber("+12 () 4-5"));
        assertEquals("+425667", parse.flattenPhoneNumber("+42 56 -- 67"));
        assertEquals("+42566789", parse.flattenPhoneNumber("+42(56 -- 67)89"));
        assertEquals("", parse.flattenPhoneNumber("ab-123"));
        assertEquals("", parse.flattenPhoneNumber("134_+874"));
    }

    @Test
    @Tag("Normal")
    void bestLongJump() {
        assertEquals(717, parse.bestLongJump("706 % - 717 - 703"));
        assertEquals(-1, parse.bestLongJump("% - - % -"));
        assertEquals(754, parse.bestLongJump("700 717 707 % 754"));
        assertEquals(-1, parse.bestLongJump("700 + 700"));
    }

    @Test
    @Tag("Hard")
    void bestHighJump() {
        assertEquals(226, parse.bestHighJump("226 +"));
        assertEquals(-1, parse.bestHighJump("ads +"));
        assertEquals(-1, parse.bestHighJump("???"));
        assertEquals(234, parse.bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"));
    }

    @Test
    @Tag("Hard")
    void plusMinus() {
        assertEquals(0, parse.plusMinus("0"));
        assertEquals(4, parse.plusMinus("2 + 2"));
        assertEquals(6, parse.plusMinus("2 + 31 - 40 + 13"));
        assertEquals(-1, parse.plusMinus("0 - 1"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("+2"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("+ 4"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("4 4"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("4 - -2"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("44 - - 12"));
        assertThrows(IllegalArgumentException.class, () -> parse.plusMinus("4 - + 12"));
    }

    @Test
    @Tag("Hard")
    void firstDuplicateIndex() {
        assertEquals(-1, parse.firstDuplicateIndex("Привет"));
        assertEquals(9, parse.firstDuplicateIndex("Он пошёл в в школу"));
        assertEquals(40, parse.firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"));
        assertEquals(9, parse.firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"));
    }

    @Test
    @Tag("Hard")
    void mostExpensive() {
        assertEquals("", parse.mostExpensive(""));
        assertEquals("Курица", parse.mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"));
        assertEquals("Вино", parse.mostExpensive("Вино 255.0"));
    }
}