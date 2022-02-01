package com.company;

import java.util.Stack;

public class Main {
    public static double [] Least_Squares_Method(Stack U, Stack I, int N) {

        double sum_x2, sum_x, sum_y, sum_xy;
        double a, b, d, da, db;
        int i;
        sum_x2 = sum_x = sum_y = sum_xy = 0.0;

        // нахождение нужных сумм
        for (i=0; i<N; i++)
        {
            sum_x += (double) U.get(i);
            sum_y += (double) I.get(i);
            sum_x2 += (double) U.get(i) * (double) U.get(i);
            sum_xy += (double) U.get(i) * (double) I.get(i);
        }

        // использование формул
        d = ((double) N)*sum_x2 - sum_x*sum_x;
        da = ((double) N)*sum_xy - sum_x*sum_y;
        db = sum_x2*sum_y - sum_x*sum_xy;
        a = da/d;
        b = db/d;

        // результаты
        double [] result = new double[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
    public static void main(String[] args) {

        // число измерений
        int N = 10;

        // I - ток, U - напряжение
        Stack I = new Stack();
        Stack U = new Stack();

        // заполнение стеков
        double c = 0.0;
        for (int i=0; i<N; i++)
        {
            U.push(c+=1.0);
        }
        I.push(0.5);
        I.push(1.1);
        I.push(1.45);
        I.push(2.0);
        I.push(2.51);
        I.push(3.01);
        I.push(3.55);
        I.push(4.1);
        I.push(4.5);
        I.push(4.95);

        // вывод таблицы
        System.out.println(" U  |  I");
        System.out.println("__________");
        for (int i=0; i<N; i++)
        {
            System.out.println(U.get(i)+" | "+I.get(i));
        }
        System.out.println("__________");

        // применение метода наименьших квадратов
        double LSM[] = Least_Squares_Method(U, I, 10);

        System.out.println("Вычисленное сопротивление после метода наименьших квадратов для тока и напряжения:");
        // формула для нахождения R = U/I ;
        // формула из МНК (исколючая b как погрешность) I = aU >> U/I = 1/a (a - коэффицент из формулы)
        System.out.println("R = примерно " + 1.0/LSM[0]);

    }
}