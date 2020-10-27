package ru.vsu.cs.roschupkin_ya_a;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        Point point1 = createPoint(1);
        Point point2 = createPoint(2);
        Point point3 = createPoint(3);

        Triangle triangle = new Triangle(new Line(point1, point2),
                new Line(point2, point3), new Line(point3, point1));

        printTriangleQuarters(triangle.inWhichQuartersTriangleIs());
    }

    static Point createPoint(int ordinal)
    {
        System.out.printf("%nEnter coordinates of %s point %n", createOrdinal(ordinal));
        return new Point(readCoordinate('X'), readCoordinate('Y'));
    }

    static String createOrdinal(int ordinal)
    {
        return switch (ordinal)
                {
                    case (1) -> "1st";
                    case (2) -> "2nd";
                    case (3) -> "3rd";
                    default -> (ordinal + "th");
                };
    }

    static double readCoordinate(char coordinateName)
    {
        System.out.printf("Input %c: ", coordinateName);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    static void printTriangleQuarters(Quarter[] triangleQuarters)
    {
        int printed = 0;

        System.out.print("\nThe triangle is in");

        for (Quarter triangleQuarter : triangleQuarters)
        {
            for (Quarter quarter : Quarter.values())
            {
                if (triangleQuarter == quarter)
                {
                    if (printed > 0)
                    {
                        System.out.print(',');
                    }
                    printed++;

                    System.out.print(' ' + createOrdinal(quarter.ordinal() + 1));
                }
            }
        }

        if (printed > 1)
        {
            System.out.print(" quarters.");
        }
        else
        {
            System.out.println(" quarter.");
        }
    }
}
