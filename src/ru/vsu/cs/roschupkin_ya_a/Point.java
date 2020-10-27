package ru.vsu.cs.roschupkin_ya_a;

public class Point
{
    double x;
    double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    double getX()
    {
        return x;
    }

    double getY()
    {
        return y;
    }

    Quarter inWhichQuarterPointIs()
    {
        if (x > 0 && y > 0) return Quarter.QUARTER1;
        if (x < 0 && y > 0) return Quarter.QUARTER2;
        if (x < 0 && y < 0) return Quarter.QUARTER3;
        if (x > 0 && y < 0) return Quarter.QUARTER4;
        return null;
    }
}
