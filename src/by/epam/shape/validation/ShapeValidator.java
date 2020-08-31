package by.epam.shape.validation;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.entity.impl.Tetragon;

import java.util.List;


public class ShapeValidator {
    private static ShapeValidator instance = new ShapeValidator();
    private static final int COUNT_COORDINATES = 8;
    private static final int SUM_OF_ANGLES = 360;

    private ShapeValidator() {
    }

    public static ShapeValidator getInstance() {
        if (instance == null) {
            instance = new ShapeValidator();
        }
        return instance;
    }

    public boolean isTetragonValid(Tetragon tetragon) {
        boolean result = false;
        List<Double> coordinates = ShapeOperation.calculateCoordinatesOfTetragon(tetragon);
        if (coordinates.size() % COUNT_COORDINATES == 0 && isConvexTetragon(tetragon) &&
                isSumOfThreeSidesLessThanFourth(tetragon) && !isThreePointsOnOneLine(tetragon)) {
            result = true;
        }
        return result;
    }

    private boolean isConvexTetragon(Tetragon tetragon) {
        List<Double> sides = ShapeOperation.calculateSidesOfTetragon(tetragon);
        boolean result = false;
        int countSidesOfTetragon = sides.size();
        if (SUM_OF_ANGLES == (countSidesOfTetragon - 2) * 180) {
            result = true;
        }
        return result;
    }

    private boolean isSumOfThreeSidesLessThanFourth(Tetragon tetragon) {
        List<Double> sides = ShapeOperation.calculateSidesOfTetragon(tetragon);
        double sideAB = sides.get(0);
        double sideBC = sides.get(1);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        return sideAB + sideBC + sideCD > sideDA && sideAB + sideBC + sideDA > sideCD && sideAB + sideDA +
                sideCD > sideBC && sideBC + sideCD + sideDA > sideAB;
    }

    private boolean isThreePointsOnOneLine(Tetragon tetragon) {
        double firstPointX = tetragon.getPointA().getValueX();
        double firstPointY = tetragon.getPointA().getValueY();
        double secondPointX = tetragon.getPointB().getValueX();
        double secondPointY = tetragon.getPointB().getValueY();
        double thirdPointX = tetragon.getPointC().getValueX();
        double thirdPointY = tetragon.getPointC().getValueY();
        double forthPointX = tetragon.getPointD().getValueX();
        double fourthPointY = tetragon.getPointD().getValueY();
        boolean result = false;

        if ((firstPointX == firstPointY && thirdPointX == thirdPointY && fourthPointY == forthPointX) ||
                (secondPointX == secondPointY && thirdPointX == thirdPointY && fourthPointY == forthPointX) ||
                (firstPointX == firstPointY && secondPointX == secondPointY && fourthPointY == forthPointX) ||
                (firstPointX == firstPointY && secondPointX == secondPointY && thirdPointX == thirdPointY)) {
            result = true;
        }
        return result;
    }

    public boolean isSquare(Tetragon tetragon) {
        List<Double> sides = ShapeOperation.calculateSidesOfTetragon(tetragon);
        boolean result = false;
        double sideAB = sides.get(0);
        double sideBC = sides.get(1);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        if (sideAB == sideBC && sideBC == sideCD && sideCD == sideDA) {
            result = true;
        }
        return result;
    }

    public boolean isTrapezoid(Tetragon tetragon) {
        List<Double> sides = ShapeOperation.calculateSidesOfTetragon(tetragon);
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        boolean result = false;
        if (sideAB != sideCD) {
            result = true;
        }
        return result;
    }

    public boolean isRectangle(Tetragon tetragon) {
        List<Double> sides = ShapeOperation.calculateSidesOfTetragon(tetragon);
        boolean result = false;
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        if (sideAB == sideCD) {
            result = true;
        }
        return result;
    }

    public boolean isRhombus(Tetragon tetragon) {
        boolean result = false;
        double coordPoint1X = tetragon.getPointA().getValueX();
        double coordPoint1Y = tetragon.getPointA().getValueY();
        double coordPoint2X = tetragon.getPointB().getValueX();
        double coordPoint2Y = tetragon.getPointB().getValueY();
        double coordPoint3X = tetragon.getPointC().getValueX();
        double coordPoint3Y = tetragon.getPointC().getValueY();
        double coordPoint4X = tetragon.getPointD().getValueX();
        double coordPoint4Y = tetragon.getPointD().getValueY();
        double perpendicularity = ((coordPoint1X - coordPoint3X) * (coordPoint2X - coordPoint4X)) +
                ((coordPoint1Y - coordPoint3Y) * (coordPoint2Y - coordPoint4Y));
        double onePartOfFirstDiagonal = coordPoint1X + coordPoint3X;
        double twoPartOfFirstDiagonal = coordPoint2X + coordPoint4X;
        double onePartOfSecondDiagonal = coordPoint1Y + coordPoint3Y;
        double twoPartOfSecondDiagonal = coordPoint2Y + coordPoint4Y;
        if (perpendicularity == 0 && onePartOfFirstDiagonal == twoPartOfFirstDiagonal &&
                onePartOfSecondDiagonal == twoPartOfSecondDiagonal) {
            result = true;
        }
        return result;
    }
}
