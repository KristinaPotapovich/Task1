package test.by.epam.shape.validation;


import by.epam.shape.exception.ShapeException;

import by.epam.shape.reader.DataReader;
import by.epam.shape.validation.ShapeValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeValidationTest {

    private ShapeValidator shapeValidator;
    private List<Double> coordinates;

    @BeforeTest
    public void init() {

        shapeValidator = new ShapeValidator();

        coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(1.0);
    }

    @Test
    public void filterInputData() throws ShapeException {
        ShapeValidator shapeValidator = new ShapeValidator();
        DataReader dataReader = new DataReader();
        List<String> expected = new ArrayList<>();
        expected.add("2.0 1.0");
        expected.add("2.0 3.0");
        expected.add("7.0 3.0");
        expected.add("7.0 1.0");
        List<String> actual = shapeValidator.filterInputData(dataReader.readData("init/data.txt"));

        Assert.assertEquals(actual, expected, "Test was not successful");
    }

    @Test
    public void isTetragonTestFalse() {
        boolean expected = false;

        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(-5.0);
        boolean actual = shapeValidator.isTetragon(coordinates, sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTetragonTestTrue() {
        boolean expected = true;

        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean actual = shapeValidator.isTetragon(coordinates, sides);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void isThreePointsNotOnOneLineTestFalse() throws ShapeException {
        boolean expected = false;
        boolean actual = shapeValidator.isThreePointsOnOneLine(coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void throwShapeException() throws ShapeException {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        shapeValidator.isThreePointsOnOneLine(coordinates);
    }

    @Test
    public void isSquareTestTrue() {
        List<Double> sides = new ArrayList<>();
        sides.add(5.0);
        sides.add(5.0);
        sides.add(5.0);
        sides.add(5.0);
        boolean expected = true;
        boolean actual = shapeValidator.isSquare(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isSquareTestFalse() {
        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = false;
        boolean actual = shapeValidator.isSquare(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTrapezoidTestTrue() {
        List<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = true;
        boolean actual = shapeValidator.isTrapezoid(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTrapezoidTestFalse() {
        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = false;
        boolean actual = shapeValidator.isTrapezoid(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isRectangleTestTrue() {
        List<Double> sides = new ArrayList<>();
        sides.add(2.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = true;
        boolean actual = shapeValidator.isRectangle(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isRectangleTestFalse() {
        List<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = false;
        boolean actual = shapeValidator.isRectangle(sides);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isRhombusTestTrue() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        boolean expected = true;
        boolean actual = shapeValidator.isRhombus(coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isRhombusTestFalse() {
        boolean expected = false;
        boolean actual = shapeValidator.isRhombus(coordinates);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isConvexTetragonTestTrue() {
        List<Double> sides = new ArrayList<>();
        sides.add(1.0);
        sides.add(5.0);
        sides.add(2.0);
        sides.add(5.0);
        boolean expected = true;
        boolean actual = shapeValidator.isConvexTetragon(coordinates, sides);
        Assert.assertEquals(actual, expected);
    }
}
