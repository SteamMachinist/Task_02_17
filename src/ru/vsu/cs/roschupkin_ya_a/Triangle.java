package ru.vsu.cs.roschupkin_ya_a;

public class Triangle
{

    Line line1;
    Line line2;
    Line line3;

    public Triangle(Line line1, Line line2, Line line3)
    {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    Quarter[] inWhichQuartersTriangleIs()
    {
        Quarter[] triangleQuarters = new Quarter[4];

        int triangleQuarterNumber = 0;
        for (Quarter quarter : Quarter.values())
        {
            if (isTriangleInSomeQuarter(quarter))
            {
                triangleQuarters[triangleQuarterNumber] = quarter;
                triangleQuarterNumber++;
            }
        }
        return triangleQuarters;
    }

    boolean isTriangleInSomeQuarter(Quarter someQuarter)
    {
        Quarter[] line1Quarters = line1.inWhichQuartersLineIs();
        Quarter[] line2Quarters = line2.inWhichQuartersLineIs();
        Quarter[] line3Quarters = line3.inWhichQuartersLineIs();

        for (int quarterSlotOrdinal = 0; quarterSlotOrdinal < 3; quarterSlotOrdinal++)
        {
            if  ((line1Quarters[quarterSlotOrdinal] == someQuarter)
                 || (line2Quarters[quarterSlotOrdinal] == someQuarter)
                 || (line3Quarters[quarterSlotOrdinal] == someQuarter))
            {
                return true;
            }
        }
        return false;
    }

}
