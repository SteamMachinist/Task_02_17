package ru.vsu.cs.roschupkin_ya_a;

public class Line
{
    Point point1;
    Point point2;

    public Line(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }


    Quarter[] inWhichQuartersLineIs()
    {
        Quarter[] lineQuarters = new Quarter[3];

        int lineQuarterNumber = 0;
        for (Quarter quarter : Quarter.values())
        {
            if (isLineInSomeQuarter(quarter))
            {
                lineQuarters[lineQuarterNumber] = quarter;
                lineQuarterNumber++;
            }
        }
        return lineQuarters;
    }

    boolean isLineInSomeQuarter(Quarter someQuarter)
    {
        Point zeroCoordinatesPoint = createZeroCoordinatesPoint();

        return (point1.inWhichQuarterPointIs() == someQuarter)
                || (point2.inWhichQuarterPointIs() == someQuarter)
                || (zeroCoordinatesPoint.inWhichQuarterPointIs() == someQuarter);
    }

    Point createZeroCoordinatesPoint()
    {
        double xAtZeroY = calculateXAtCrossingWithYAxis();
        double yAtZeroX = calculateYAtCrossingWithXAxis();

        if (isZeroCoordinatePointInsideLine(xAtZeroY, yAtZeroX))
        {
            return new Point(xAtZeroY, yAtZeroX);
        }

        return new Point(0, 0);
    }

    boolean isZeroCoordinatePointInsideLine(double xAtZeroY, double yAtZeroX)
    {
        Point minPoint = sortPoints("min");
        Point maxPoint = sortPoints("max");

        return (xAtZeroY >= minPoint.getX()) && (xAtZeroY <= maxPoint.getX())
                && (yAtZeroX >= minPoint.getY()) && (yAtZeroX <= maxPoint.getY());
    }

    Point sortPoints(String minOrMax)
    {
        if (minOrMax.equals("min"))
        {
            return new Point(Math.min(point1.getX(), point2.getX()),
                    Math.min(point1.getY(), point2.getY()));
        }
        else
        {
            return new Point(Math.max(point1.getX(), point2.getX()),
                    Math.max(point1.getY(), point2.getY()));
        }
    }

    double calculateXAtCrossingWithYAxis()
    {
        return (calculateYIntercept() / (point1.getY() - point2.getY()));
    }

    double calculateYAtCrossingWithXAxis()
    {
        return (calculateYIntercept() / (point2.getX() - point1.getX()));
    }

    double calculateYIntercept()
    {
        return (point2.getX() * point1.getY() - point1.getX() * point2.getY());
    }
}
