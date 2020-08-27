package by.epam.shape.action;


import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.validation.ShapeValidator;


import java.util.ArrayList;
import java.util.List;

public class ShapeOperation {
    ShapeValidator shapeValidator = new ShapeValidator();

    public double calculateSideFormula(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getValueX() - point1.getValueX(), 2) +
                Math.pow(point2.getValueY() - point1.getValueY(), 2));
    }

    public List<Double> calculateSideOfTetragon(Tetragon tetragon) {
        List<Double> sides = new ArrayList<>();
        sides.add(calculateSideFormula(tetragon.getPointA(), tetragon.getPointB()));
        sides.add(calculateSideFormula(tetragon.getPointB(), tetragon.getPointC()));
        sides.add(calculateSideFormula(tetragon.getPointC(), tetragon.getPointD()));
        sides.add(calculateSideFormula(tetragon.getPointD(), tetragon.getPointA()));
        return sides;
    }

    public double calculatePerimeter(List<Double> sides, List<Double> coordinates) throws ShapeException {
        double perimeter = 0;
        double sideAB = sides.get(0);
        double sideBC = sides.get(1);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        if (!shapeValidator.isTetragon(coordinates, sides)) {
            throw new ShapeException("This shape is not a tetragon");
        }
        if (shapeValidator.isTetragon(coordinates, sides)) {

            perimeter = sideAB + sideBC + sideCD + sideDA;
        }
        return perimeter;
    }

    public double calculateArea(List<Double> sides, List<Double> coordinates) throws ShapeException {
        double area = 0;
        double coordPoint1X = coordinates.get(0);
        double coordPoint1Y = coordinates.get(1);
        double coordPoint2X = coordinates.get(2);
        double coordPoint2Y = coordinates.get(3);
        double coordPoint3X = coordinates.get(4);
        double coordPoint3Y = coordinates.get(5);
        double coordPoint4X = coordinates.get(6);
        double coordPoint4Y = coordinates.get(7);
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        double firstDiagonal = coordPoint1X + coordPoint3X + coordPoint2X + coordPoint4X;
        double secondDiagonal = coordPoint1Y + coordPoint3Y + coordPoint2Y + coordPoint4Y;
        if (!shapeValidator.isTetragon(coordinates, sides)) {
            throw new ShapeException("This shape is not a tetragon");
        }
        if (!shapeValidator.isConvexTetragon(coordinates, sides)) {
            throw new ShapeException("This shape is not a ConvexTetragon");
        }

        if (shapeValidator.isSquare(sides)) {
            area = Math.pow(sideAB, 2);
        } else if (shapeValidator.isRectangle(sides)) {
            area = sideAB * sideDA;
        } else if (shapeValidator.isTrapezoid(sides)) {
            area = (sideAB + sideCD) * (Math.sqrt(Math.pow(sideDA, 2) - (Math.pow((Math.pow((sideAB - sideCD), 2) +
                    Math.pow(sideDA, 2) - Math.pow(sideAB, 2)) / (2 * (sideAB - sideCD)), 2))));
        } else if (shapeValidator.isRhombus(coordinates)) {
            area = (firstDiagonal * secondDiagonal) / 2;
        }
        return area;
    }
}
