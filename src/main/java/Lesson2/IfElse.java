package Lesson2;

import Lesson1.Task1;

import static java.lang.StrictMath.max;
import static java.lang.StrictMath.sqrt;


public class IfElse {

    Task1 task1 = new Task1();

    /**
     * Пример
     * <p>
     * Найти число корней квадратного уравнения ax^2 + bx + c = 0
     */
    int quadraticRootNumber(double a, double b, double c) {
        double discriminant = task1.discriminant(a, b, c);
        if (discriminant > 0.0) return 2;
        else if (discriminant == 0) return 1;
        else return 0;
    }


    /**
     * Пример
     * <p>
     * Получить строковую нотацию для оценки по пятибалльной системе
     */
    String gradeNotation(int grade) {
        if (grade == 5) return "отлично";
        else if (grade == 4) return "хорошо";
        else if (grade == 3) return "удовлетворительно";
        else if (grade == 2) return "неудовлетворительно";
        else return "несуществующая оценка " + grade;
    }


    /**
     * Пример
     * <p>
     * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
     */
    double minBiRoot(double a, double b, double c) {
        // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
        if (a == 0.0) {
            if (b == 0.0) return Double.NaN; // ... и ничего больше не делать
            double bc = -c / b;
            if (bc < 0.0) return Double.NaN;// ... и ничего больше не делать
            return -sqrt(bc);
            // Дальше функция при a == 0.0 не идёт
        }
        double d = task1.discriminant(a, b, c);   // 2
        if (d < 0.0) return Double.NaN;  // 3
        // 4
        double y1 = (-b + sqrt(d)) / (2 * a);
        double y2 = (-b - sqrt(d)) / (2 * a);
        double y3 = max(y1, y2);      // 5
        if (y3 < 0.0) return Double.NaN; // 6
        return -sqrt(y3);          // 7
    }

    /**
     * Простая
     * <p>
     * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
     * вернуть строку вида: «21 год», «32 года», «12 лет».
     */
    String ageDescription(int age) {
        if (age % 100 >= 11 && age % 100 <= 14) return age + " лет";
        else if (age % 10 == 1) return age + " год";
        else if (age % 10 >= 2 && age % 10 <= 4) return age + " года";
        else return age + " лет";
    }


    /**
     * Простая
     * <p>
     * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
     * и t3 часов — со скоростью v3 км/час.
     * Определить, за какое время он одолел первую половину пути?
     */
    double timeForHalfWay(
            double t1, double v1,
            double t2, double v2,
            double t3, double v3
    ) {
        double HalfWay = (t1 * v1 + t2 * v2 + t3 * v3) / 2;
        if (HalfWay / v1 <= t1) {
            return HalfWay / v1;
        }
        if ((HalfWay - t1 * v1) / v2 <= t2) {
            return t1 + (HalfWay - t1 * v1) / v2;
        }
        return t1 + t2 + ((HalfWay - t1 * v1 - t2 * v2) / v3);
    }


    /**
     * Простая
     * <p>
     * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
     * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
     * и 3, если угроза от обеих ладей.
     * Считать, что ладьи не могут загораживать друг друга
     */
    int whichRookThreatens(
            int kingX, int kingY,
            int rookX1, int rookY1,
            int rookX2, int rookY2
    ) {
        if ((kingX == rookX1 || kingX == rookX2) && (kingY == rookY1 || kingY == rookY2)) {
            return 3;
        } else if (kingX == rookX1 || kingY == rookY1) {
            return 1;
        } else if (kingX == rookX2 || kingY == rookY2) {
            return 2;
        } else return 0;
    }


    /**
     * Простая
     * <p>
     * На шахматной доске стоят черный король и белые ладья и слон
     * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
     * Проверить, есть ли угроза королю и если есть, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
     * и 3, если угроза есть и от ладьи и от слона.
     * Считать, что ладья и слон не могут загораживать друг друга.
     */
    int rookOrBishopThreatens(
            int kingX, int kingY,
            int rookX, int rookY,
            int bishopX, int bishopY
    ) {
        if ((kingX == rookX || kingY == rookY) && (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY))) {
            return 3;
        } else if (kingX == rookX || kingY == rookY) {
            return 1;
        } else if (Math.abs((kingX - bishopX)) == Math.abs(kingY - bishopY)) {
            return 2;
        } else return 0;
    }


    /**
     * Простая
     * <p>
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    int triangleKind(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {

            String flag;

            if (max(max(a, b), c) == a) {
                flag = "a";
            } else if (max(max(a, b), c) == b) {
                flag = "b";
            } else flag = "c";

            if (flag.equals("a")) {
                if (a * a == b * b + c * c) {
                    return 1;
                } else if (a * a < b * b + c * c) {
                    return 0;
                } else return 2;

            } else if (flag.equals("b")) {
                if (b * b == a * a + c * c) {
                    return 1;
                } else if (b * b < a * a + c * c) {
                    return 0;
                } else return 2;

            } else {
                if (c * c == a * a + b * b) {
                    return 1;
                } else if (c * c < a * a + b * b) {
                    return 0;
                } else return 2;
            }
        }
        return -1;
    }


    /**
     * Средняя
     * <p>
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     */
    int segmentLength(int a, int b, int c, int d) {
        if ((c >= a && c <= b) || (d >= a && d <= b)) {
            if (c >= a && c <= b && d >= a && d <= b) {
                return d - c;
            } else if (c >= a && c <= b) {
                return b - c;
            } else  {
                return d - a;
            }
        } else if (a >= c && b <= d) {
            return b - a;
        } else return -1;
    }
}
