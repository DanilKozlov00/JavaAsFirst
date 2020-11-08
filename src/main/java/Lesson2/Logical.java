package Lesson2;

import Lesson1.Task1;

public class Logical {

    Task1 task1 = new Task1();

    /**
     * Пример
     * <p>
     * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
     */
    boolean pointInsideCircle(double x, double y, double x0, double y0, double r) {
        return task1.sqrDouble(x - x0) + task1.sqrDouble(y - y0) <= task1.sqrDouble(r);
    }


    /**
     * Простая
     * <p>
     * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
     * Определить, счастливое ли заданное число, вернуть true, если это так.
     */
    boolean isNumberHappy(int number) {
        return number % 10 + ((number - (number % 10)) / 10) % 10 == (((number - (number % 10)) / 10) / 10) % 10 + (((number - (number % 10)) / 10) / 10) / 10;
    }


    /**
     * Простая
     * <p>
     * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
     * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
     * Считать, что ферзи не могут загораживать друг друга.
     */
    boolean queenThreatens(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2 || Math.abs((x1 - x2)) == Math.abs(y1 - y2);
    }


    /**
     * Простая
     * <p>
     * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
     * Вернуть число дней в этом месяце этого года по григорианскому календарю.
     */
    public int daysInMonth(int month, int year) {
        if (month == 2)
            if (year % 400 == 0) {
                return 29;
            } else if (year % 100 == 0) {
                return 28;
            } else if (year % 4 == 0) {
                return 29;
            } else {
                return 28;
            }
        else {
            switch (month) {
                case 1:
                case 5:
                case 3:
                case 8:
                case 10:
                case 7:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return -1;
            }
        }
    }


    /**
     * Средняя
     * <p>
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     * Вернуть true, если утверждение верно
     */
    boolean circleInside(
            double x1, double y1, double r1,
            double x2, double y2, double r2
    ) {
        if (r2 < r1) {
            return false;
        }
        return (task1.sqrDouble(x2 - x1) + task1.sqrDouble(y2 - y1) <= task1.sqrDouble(r2 - r1));
    }


    /**
     * Средняя
     * <p>
     * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
     * Стороны отверстия должны быть параллельны граням кирпича.
     * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
     * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
     * Вернуть true, если кирпич пройдёт
     */
    boolean brickPasses(int a, int b, int c, int r, int s) {
        return a * b <= r * s || a * c <= r * s || c * b <= r * s;
    }

}
