package Lesson3;

import Lesson1.task1;

public class loop {

    task1 task1 = new task1();

    /**
     * Пример
     * <p>
     * Вычисление факториала
     */
    double factorial(int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= i;// Please do not fix in master
        }
        return result;
    }


    /**
     * Пример
     * <p>
     * Проверка числа на простоту -- результат true, если число простое
     */
    boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int m = 3; m <= Math.sqrt(n); m+=2) {
            if (n % m == 0) return false;
        }
        return true;
    }


    /**
     * Пример
     * <p>
     * Проверка числа на совершенность -- результат true, если число совершенное
     */
    boolean isPerfect(int n) {
        int sum = 1;
        for (int m = 2; m < n; n /= 2) {
            if (n % m > 0) continue;
            sum += m;
            m++;
        }
        return sum == n;
    }


    /**
     * Пример
     * <p>
     * Найти число вхождений цифры m в число n
     */
    int digitCountInNumber(int n, int m) {
        if (n == m) return 1;
        else if (n < 10) return 0;
        else return digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m);
    }


    /**
     * Простая
     * <p>
     * Найти количество цифр в заданном числе n.
     * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
     * <p>
     * Использовать операции со строками в этой задаче запрещается.
     */
    int digitNumber(int n) {
        int digit = n;
        int k = 0;
        if (digit == 0) {
            return 1;
        } else {
            while (digit != 0) {
                digit /= 10;
                k++;
            }
            return k;
        }
    }


    /**
     * Простая
     * <p>
     * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
     * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
     */
    int fib(int n) {
        int fib_n = 1;
        int fib_n1 = 1;
        int fib_n2 = 0;
        if (n >= 1 && n <= 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            fib_n2 = fib_n + fib_n1;
            fib_n = fib_n1;
            fib_n1 = fib_n2;
        }
        return fib_n2;
    }


    /**
     * Простая
     * <p>
     * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
     * минимальное число k, которое делится и на m и на n без остатка
     */
    int lcm(int m, int n) {
        int num_m = m;
        int num_n = n;
        int multiplication = (num_m * num_n);
        while ((num_m != 0) && (num_n != 0)) {
            if (num_m > num_n) num_m %= num_n;
            else num_n %= num_m;
        }
        int count = num_m + num_n;
        return multiplication / count;
    }


    /**
     * Простая
     * <p>
     * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
     */
    int minDivisor(int n) {
        int k = 2;
        while (n % k != 0) {
            k++;
        }
        return k;
    }


    /**
     * Простая
     * <p>
     * Для заданного числа n > 1 найти максимальный делитель, меньший n
     */
    int maxDivisor(int n) {
        int k = n - 1;
        while (n % k != 0) {
            k--;
        }
        return k;
    }


    /**
     * Простая
     * <p>
     * Определить, являются ли два заданных числа m и n взаимно простыми.
     * Взаимно простые числа не имеют общих делителей, кроме 1.
     * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
     */
    boolean isCoPrime(int m, int n) {
        int del = 2;
        int count = 1;
        int max = Math.max(m, n);

        while (count == 1 && del < max) {
            if (m % del == 0 && n % del == 0) {
                count++;
            }
            del++;
        }
        return count == 1;
    }


    /**
     * Простая
     * <p>
     * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
     * то есть, существует ли такое целое k, что m <= k*k <= n.
     * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
     */
    boolean squareBetweenExists(int m, int n) {
        int left = (int) Math.sqrt(m);
        int right = (int) Math.sqrt(n);
        for (int i = left; i <= right; i++) {
            if (task1.sqr(i) >= m && task1.sqr(i) <= n) {
                return true;
            }
        }
        return false;
    }


    /**
     * Средняя
     * <p>
     * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
     * <p>
     * ЕСЛИ (X четное)
     * Xслед = X /2
     * ИНАЧЕ
     * Xслед = 3 * X + 1
     * <p>
     * например
     * 15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
     * Данная последовательность рано или поздно встречает X == 1.
     * Написать функцию, которая находит, сколько шагов требуется для
     * этого для какого-либо начального X > 0.
     */
    int collatzSteps(int x) {
        int digit = x;
        int steps = 0;
        while (digit != 1) {
            if (digit % 2 == 0) {
                digit /= 2;
                steps++;
            } else {
                digit = 3 * digit + 1;
                steps++;
            }
        }
        return steps;
    }


    /**
     * Средняя
     * <p>
     * Для заданного x рассчитать с заданной точностью eps
     * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
     * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
     * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
     */
    double sin(double x, double eps) {
        int number = 1;
        int digit = 3;
        double xx = (x % (2 * Math.PI));
        double absEps = Math.abs(eps);
        double sin = xx;
        double currentExp = xx;
        double part = xx;
        while (Math.abs(part) >= absEps) {
            currentExp *= xx * xx;
            if (number % 2 != 0) part = (-1 * currentExp / factorial(digit));
            else part = (currentExp / factorial(digit));
            sin += part;
            number += 1;
            digit += 2;
        }
        return sin;
    }


    /**
     * Средняя
     * <p>
     * Для заданного x рассчитать с заданной точностью eps
     * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
     * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
     */
    double cos(double x, double eps) {
        double cos = 1.0;
        double part;
        int number = 1;
        int digit = 2;
        double xx = x % (2 * Math.PI);
        double absEps = Math.abs(eps);
        double currentExp = 1.0;
        do {
            currentExp *= xx * xx;
            if (number % 2 != 0) part = -1 * currentExp / factorial(digit);
            else part = currentExp / factorial(digit);
            cos += part;
            number += 1;
            digit += 2;
        } while (Math.abs(part) >= absEps);
        return cos;
    }


    /**
     * Средняя
     * <p>
     * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
     * <p>
     * Использовать операции со строками в этой задаче запрещается.
     */
    int revert(int n) {
        int revert = 0;
        int temp = n;
        if (n < 0) {
            temp *= -1;
        }
        while (temp > 0) {
            revert = revert * 10 + temp % 10;
            temp /= 10;
        }
        if (n < 0)
            return revert * -1;
        else return revert;
    }


    /**
     * Средняя
     *
     * Проверить, является ли заданное число n палиндромом:
     * первая цифра равна последней, вторая -- предпоследней и так далее.
     * 15751 -- палиндром, 3653 -- нет.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    boolean isPalindrome(int n) { return n>=0 && n == revert(n);}



    /**
     * Средняя
     *
     * Для заданного числа n определить, содержит ли оно различающиеся цифры.
     * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    boolean hasDifferentDigits(int n) {
        int lastDigit = n % 10;
        int digit = (n - lastDigit) / 10;
        if (n>=-9&&n<=9) {
            return false;
        }
        if (n < 0) {
            return true;
        }
        if (digitNumber(n) == 2) {
            return lastDigit != digit;
        } else {
            int penultimateDigit = digit % 10;
            digit = (digit - penultimateDigit) / 10;
            while (digit != 0) {
                if (lastDigit != penultimateDigit) {
                    return true;
                }
                penultimateDigit = digit % 10;
                digit = (digit - penultimateDigit) / 10;
            }
        }
        return false;
    }


    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из квадратов целых чисел:
     * 149162536496481100121144...
     * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    int squareSequenceDigit(int n) {
        int digit = 0;
        int number = 1;
        int square = 1;
        while (digit != n) {
            square = number * number;
            digit += digitNumber(square);
            while (n < digit) {
                square /= 10;
                digit--;
            }
            number++;
        }
        return square % 10;
    }


    /**
     * Сложная
     *
     * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
     * 1123581321345589144...
     * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
     *
     * Использовать операции со строками в этой задаче запрещается.
     */
    int fibSequenceDigit(int n) {
        int digit = 0;
        int number = 1;
        int fib = 1;
        while (n != digit) {
            fib = fib(number);
            digit += digitNumber(fib);
            while (n < digit) {
                fib /= 10;
                digit--;
            }
            number++;
        }
        return fib % 10;
    }
}




