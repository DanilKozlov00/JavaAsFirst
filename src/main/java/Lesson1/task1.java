package Lesson1;

import static java.lang.Math.PI;
import static java.lang.StrictMath.sqrt;

public class task1 {

    /*
     * Пример
     *
     * Вычисление квадрата целого числа
     */
    int sqr(int x) {
        return x * x;
    }


    /*
     * Пример
     *
     * Вычисление квадрата вещественного числа
     */
    public double sqrDouble(double x) {
        return x * x;
    }


    /*
     * Пример
     *
     * Вычисление дискриминанта квадратного уравнения
     */
    public double  discriminant(double a, double b, double c) {
        return (sqrDouble(b) - 4 * a * c);
    }


    /*
     * Пример
     *
     * Поиск одного из корней квадратного уравнения
     */
    double quadraticEquationRoot(double a, double b, double c) {
        return (-b + sqrt(discriminant(a, b, c))) / (2 * a);
    }


    /*
     * Пример
     *
     * Поиск произведения корней квадратного уравнения
     */
    double quadraticRootProduct(double a, double b, double c) {
        double sd = sqrt(discriminant(a, b, c));
        double x1 = (-b + sd) / (2 * a);
        double x2 = (-b - sd) / (2 * a);
        return x1 * x2;
    }


    /*
     * Тривиальная
     *
     * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
     * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
     */
    int seconds(int hours, int minutes, int seconds) {
        return hours * 60 * 60 + minutes * 60 + seconds;
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
     * Определить длину того же отрезка в метрах (в данном случае 18.98).
     * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
     */
    double lengthInMeters(int sagenes, int arshins, int vershoks) {
        return (vershoks * 4.445 + arshins * (16 * 4.445) + sagenes * (48 * 4.445)) / 100;
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
     * Вывести значение того же угла в радианах (например, 0.63256).
     */
    double angleInRadian(int deg, int min, int sec) {
        return (deg * (PI / 180)) + (min * (PI / (180 * 60))) + (sec * (PI / (180 * 60 * 60)));
    }


    /**
     * Тривиальная
     * <p>
     * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
     * Например, расстояние между (3, 0) и (0, 4) равно 5
     */
    double trackLength(double x1, double y1, double x2, double y2) {
        return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое число, большее 100 (например, 3801).
     * Определить третью цифру справа в этом числе (в данном случае 8).
     */
    int thirdDigit(int number) {
        int digit = number;
        digit = digit / 100;
        while (digit >= 10) {
            digit %= 10;
        }
        return digit;
    }


    /**
     * Простая
     * <p>
     * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
     * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
     * Определите время поезда в пути в минутах (в данном случае 216).
     */
    int travelMinutes(int hoursDepart, int minutesDepart, int hoursArrive, int minutesArrive) {
        return (hoursArrive * 60 + minutesArrive) - (hoursDepart * 60 + minutesDepart);
    }


    /**
     * Простая
     * <p>
     * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
     * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
     * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
     */
    double accountInThreeYears(int initial, int percent) {
        double Money = initial;
        for (int i = 0; i < 3; i++) {
            Money += Money / 100 * percent;
        }
        return Money;
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое трехзначное число (например, 478).
     * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
     */
    int numberRevert(int number) {
        int units = number % 10;
        int hundreds = number / 100;
        int dozens = number - (hundreds * 100 + units);
        return units * 100 + dozens + hundreds;
    }

}
