package test.by.epam.shape.action;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.generator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeOperationTest {

    private ShapeOperation shapeOperation;
    private List<Double> coordinates;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    @BeforeTest
    public void init() {
        shapeOperation = new ShapeOperation();

        coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(1.0);

        firstPoint = new Point(IdGenerator.generateId(), coordinates.get(0), coordinates.get(1));
        secondPoint = new Point(IdGenerator.generateId(), coordinates.get(2), coordinates.get(3));
        thirdPoint = new Point(IdGenerator.generateId(), coordinates.get(4), coordinates.get(5));
        fourthPoint = new Point(IdGenerator.generateId(), coordinates.get(6), coordinates.get(7));
    }

    @Test
    public void calculateSideOfTetragonTest() {
        double expected = 2.0;
        double actual = shapeOperation.calculateSideOfTetragon(firstPoint, secondPoint);
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void findSideOfTetragonTest() {

        List<Double> expected = new ArrayList<>();
        expected.add(2.0);
        expected.add(5.0);
        expected.add(2.0);
        expected.add(5.0);

        List<Double> actual = new ArrayList<>();
        actual.add(shapeOperation.calculateSideOfTetragon(firstPoint, secondPoint));
        actual.add(shapeOperation.calculateSideOfTetragon(secondPoint, thirdPoint));
        actual.add(shapeOperation.calculateSideOfTetragon(thirdPoint, fourthPoint));
        actual.add(shapeOperation.calculateSideOfTetragon(fourthPoint, firstPoint));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculatePerimeter() throws ShapeException {
        List<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        double expected = 13.0;
        double actual = shapeOperation.calculatePerimeter(sides, coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void trowShapeExceptionForPerimeter() throws ShapeException {
        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        shapeOperation.calculatePerimeter(sides, coordinates);
    }

    @Test
    public void calculateArea() throws ShapeException {
        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        double expected = 10;
        double actual = shapeOperation.calculateArea(sides, coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void trowShapeExceptionForArea() throws ShapeException {
        List<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(1.0);
        sides.add(1.0);
        sides.add(5.0);
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        shapeOperation.calculateArea(sides, coordinates);
    }
}
