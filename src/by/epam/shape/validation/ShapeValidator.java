package by.epam.shape.validation;


import by.epam.shape.exception.ShapeException;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ShapeValidator {

    public static final String REGEX = "^[\\d+].?[\\d+]? [\\d+].?[\\d+]$";
    public static final int MAX_COORDINATES = 8;

    public List<String> filterInputData(List<String> coordinatesFromData) {
        List<String> groupOfCoordinates = new ArrayList<>();
        for (String inputData : coordinatesFromData) {
            if (Pattern.matches(REGEX, inputData)) {
                groupOfCoordinates.add(inputData);
            }
        }
        return groupOfCoordinates;
    }

    public boolean isTetragon(List<Double> coordinates, List<Double> sides) {

        if (coordinates.size() != MAX_COORDINATES) {
            return false;
        }
        return isSumOfThreeSidesLessThanFourth(sides);
    }

    private boolean isSumOfThreeSidesLessThanFourth(List<Double> sides) {
        double sideAB = sides.get(0);
        double sideBC = sides.get(1);
        double sideCD = sides.get(2);
        double sideDA = sides.get(3);
        return sideAB + sideBC + sideCD > sideDA && sideAB + sideBC + sideDA > sideCD && sideAB + sideDA +
                sideCD > sideBC && sideBC + sideCD + sideDA > sideAB;
    }

    public boolean isThreePointsOnOneLine(List<Double> coordinates) throws ShapeException {
        double firstPointX = coordinates.get(0);
        double firstPointY = coordinates.get(1);
        double secondPointX = coordinates.get(2);
        double secondPointY = coordinates.get(3);
        double thirdPointX = coordinates.get(4);
        double thirdPointY = coordinates.get(5);
        double forthPointX = coordinates.get(6);
        double fourthPointY = coordinates.get(7);

        if ((firstPointX == secondPointX && secondPointX == thirdPointX && thirdPointX == forthPointX) ||
                (firstPointY == secondPointY && secondPointY == thirdPointY && thirdPointY == fourthPointY)) {
            throw new ShapeException("Three Points On One Line");
        }
        return false;
    }

    public boolean isSquare(List<Double> sides) {
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

    public boolean isTrapezoid(List<Double> sides) {
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        boolean result = false;
        if (sideAB != sideCD) {
            result = true;
        }
        return result;
    }

    public boolean isRectangle(List<Double> sides) {
        boolean result = false;
        double sideAB = sides.get(0);
        double sideCD = sides.get(2);
        if (sideAB == sideCD) {
            result = true;
        }
        return result;
    }

    public boolean isRhombus(List<Double> coordinates) {
        boolean result = false;
        double coordPoint1X = coordinates.get(0);
        double coordPoint1Y = coordinates.get(1);
        double coordPoint2X = coordinates.get(2);
        double coordPoint2Y = coordinates.get(3);
        double coordPoint3X = coordinates.get(4);
        double coordPoint3Y = coordinates.get(5);
        double coordPoint4X = coordinates.get(6);
        double coordPoint4Y = coordinates.get(7);
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


    public boolean isConvexTetragon(List<Double> coordinates, List<Double> sides) {
        int sumOfAngles = 360;
        int countOfSidesOfTetragon = 0;
        boolean b = false;
        if (isTetragon(coordinates, sides)) {
            countOfSidesOfTetragon = 4;
        }
        if (sumOfAngles == ((countOfSidesOfTetragon - 2) * 180)) {
            b = true;
        }
        return b;
    }
}
