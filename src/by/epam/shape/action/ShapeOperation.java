package by.epam.shape.action;


import by.epam.shape.entity.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.validation.ShapeValidator;

import java.util.ArrayList;
import java.util.List;

public class ShapeOperation {

    private static double calculateSideFormula(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getValueX() - point1.getValueX(), 2) +
                Math.pow(point2.getValueY() - point1.getValueY(), 2));
    }

    public static List<Double> calculateSidesOfTetragon(Tetragon tetragon) {
        List<Double> sides = new ArrayList<>();
        sides.add(calculateSideFormula(tetragon.getPointA(), tetragon.getPointB()));
        sides.add(calculateSideFormula(tetragon.getPointB(), tetragon.getPointC()));
        sides.add(calculateSideFormula(tetragon.getPointC(), tetragon.getPointD()));
        sides.add(calculateSideFormula(tetragon.getPointD(), tetragon.getPointA()));
        return sides;
    }

    public static List<Double> calculateCoordinatesOfTetragon(Tetragon tetragon) {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(tetragon.getPointA().getValueX());
        coordinates.add(tetragon.getPointA().getValueY());
        coordinates.add(tetragon.getPointB().getValueX());
        coordinates.add(tetragon.getPointB().getValueY());
        coordinates.add(tetragon.getPointC().getValueX());
        coordinates.add(tetragon.getPointC().getValueY());
        coordinates.add(tetragon.getPointD().getValueX());
        coordinates.add(tetragon.getPointD().getValueY());
        return coordinates;
    }

    public double calculatePerimeter(Tetragon tetragon) {
        List<Double> sides = calculateSidesOfTetragon(tetragon);
        double sideAB = sides.get(0);
        double sideBC = sides.get(1);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        return sideAB + sideBC + sideCD + sideDA;
    }

    public double calculateArea(Tetragon tetragon) {
        ShapeValidator shapeValidator = ShapeValidator.getInstance();
        double area = 0;
        double coordPoint1X = tetragon.getPointA().getValueX();
        double coordPoint1Y = tetragon.getPointA().getValueY();
        double coordPoint2X = tetragon.getPointB().getValueX();
        double coordPoint2Y = tetragon.getPointB().getValueY();
        double coordPoint3X = tetragon.getPointC().getValueX();
        double coordPoint3Y = tetragon.getPointC().getValueY();
        double coordPoint4X = tetragon.getPointD().getValueX();
        double coordPoint4Y = tetragon.getPointD().getValueY();
        List<Double> sides = calculateSidesOfTetragon(tetragon);
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        double firstDiagonal = coordPoint1X + coordPoint3X + coordPoint2X + coordPoint4X;
        double secondDiagonal = coordPoint1Y + coordPoint3Y + coordPoint2Y + coordPoint4Y;
        if (shapeValidator.isSquare(tetragon)) {
            area = Math.pow(sideAB, 2);
        } else if (shapeValidator.isRectangle(tetragon)) {
            area = sideAB * sideDA;
        } else if (shapeValidator.isTrapezoid(tetragon)) {
            area = (sideAB + sideCD) * (Math.sqrt(Math.pow(sideDA, 2) - (Math.pow((Math.pow((sideAB - sideCD), 2) +
                    Math.pow(sideDA, 2) - Math.pow(sideAB, 2)) / (2 * (sideAB - sideCD)), 2))));
        } else if (shapeValidator.isRhombus(tetragon)) {
            area = (firstDiagonal * secondDiagonal) / 2;
        }
        return area;
    }
}
