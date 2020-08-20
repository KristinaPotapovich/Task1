package by.epam.shape.action;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Tetragon;
import by.epam.shape.entity.TetragonParameters;
import by.epam.shape.exception.ShapeException;

import java.util.Arrays;

public class ShapeOperation {

    public double calculateSideOfTetragon(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getValueX() - point1.getValueX(), 2) +
                Math.pow(point2.getValueY() - point1.getValueY(), 2));
    }

    public TetragonParameters findSideOfTetragon(Tetragon tetragon) {
        double[] sides = new double[4];
        sides[0] = (calculateSideOfTetragon(tetragon.getPointA(), tetragon.getPointB()));
        sides[1] = (calculateSideOfTetragon(tetragon.getPointB(), tetragon.getPointC()));
        sides[2] = (calculateSideOfTetragon(tetragon.getPointC(), tetragon.getPointD()));
        sides[3] = (calculateSideOfTetragon(tetragon.getPointD(), tetragon.getPointA()));
        Arrays.sort(sides);
        return new TetragonParameters(sides[0], sides[1], sides[2], sides[3]);
    }

    public boolean isTetragon(TetragonParameters tetragonParameters) {
        boolean b = false;
         {
            b = true;
        }
        return b;
    }

    public boolean isSquare(TetragonParameters tetragonParameters) {
        boolean b = false;
        if (tetragonParameters.getSideAB() == tetragonParameters.getSideBC() &&
                tetragonParameters.getSideBC() == tetragonParameters.getSideCD() &&
                tetragonParameters.getSideCD() == tetragonParameters.getSideDA() &&
                tetragonParameters.getSideDA() == tetragonParameters.getSideAB()) {
            b = true;
        }
        return b;
    }

    public boolean isTrapezoid(TetragonParameters tetragonParameters) {
        boolean b = false;
        if (tetragonParameters.getSideAB() != tetragonParameters.getSideCD()) {
            b = true;
        }
        return b;
    }

    public boolean isRectangle(TetragonParameters tetragonParameters) {
        boolean b = false;
        if (tetragonParameters.getSideAB() == tetragonParameters.getSideCD()) {
            b = true;
        }
        return b;
    }


    public boolean isConvexTetragon(TetragonParameters tetragonParameters) {
        int sumOfAngles = 360;
        int countOfSidesOfTetragon = 0;
        boolean b = false;
        if (isTetragon(tetragonParameters)) {
            countOfSidesOfTetragon = 4;
        }
        if (sumOfAngles == ((countOfSidesOfTetragon - 2) * 180)) {
            b = true;
        }
        return b;
    }

    public double findPerimeter(TetragonParameters tetragonParameters) throws ShapeException {
        double perimeter = 0;
        if (!isTetragon(tetragonParameters)) {
            throw new ShapeException();
        }
        if (isTetragon(tetragonParameters)) {
            perimeter = tetragonParameters.getSideAB() + tetragonParameters.getSideBC() +
                    tetragonParameters.getSideCD() + tetragonParameters.getSideDA();

        }
        return perimeter;
    }
}
