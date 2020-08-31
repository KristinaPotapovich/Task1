package by.epam.shape.validation;


import by.epam.shape.creator.PointCreator;
import by.epam.shape.creator.TetragonCreator;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;

import by.epam.shape.generator.IdGenerator;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

public class ShapeValidationTest extends Assert {

    private List<Tetragon> tetragons;

    @BeforeTest
    public void init() throws ShapeException {
        TetragonCreator tetragonCreator = new TetragonCreator();
        PointCreator pointCreator = new PointCreator();
        DataParser dataParser = new DataParser();
        DataReader dataReader = new DataReader();
        tetragons = tetragonCreator.create(pointCreator.create(dataParser.parseToDouble
                (dataReader.readData("init/data.txt"))));
    }


    @Test
    public void isTetragonValidTestFalse() {
        Point point1 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point2 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point3 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point4 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Tetragon tetragon = new Tetragon(IdGenerator.generateId(), point1, point2, point3, point4);
        boolean actual = ShapeValidator.getInstance().isTetragonValid(tetragon);
        assertFalse(actual);
    }

    @Test
    public void isTetragonValidTestTrue() {
        boolean actual = false;
        for (Tetragon tetragon : tetragons) {
            actual = ShapeValidator.getInstance().isTetragonValid(tetragon);
        }
        assertTrue(actual);
    }

    @Test
    public void isSquareTestTrue() {
        Point point1 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point2 = new Point(IdGenerator.generateId(), 2, 15.0);
        Point point3 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point4 = new Point(IdGenerator.generateId(), 2, 15.0);
        Tetragon tetragon = new Tetragon(IdGenerator.generateId(), point1, point2, point3, point4);
        boolean actual = ShapeValidator.getInstance().isSquare(tetragon);
        assertTrue(actual);
    }

    @Test
    public void isSquareTestFalse() {
        boolean actual = false;
        for (Tetragon tetragon : tetragons) {
            actual = ShapeValidator.getInstance().isSquare(tetragon);
        }
        assertFalse(actual);
    }

    @Test
    public void isTrapezoidTestTrue() {
        Point point1 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point2 = new Point(IdGenerator.generateId(), 2, 15.0);
        Point point3 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point4 = new Point(IdGenerator.generateId(), 3, 15.0);
        Tetragon tetragon = new Tetragon(IdGenerator.generateId(), point1, point2, point3, point4);
        boolean actual = ShapeValidator.getInstance().isTrapezoid(tetragon);
        assertTrue(actual);
    }

    @Test
    public void isTrapezoidTestFalse() {
        boolean actual = false;
        for (Tetragon tetragon : tetragons) {
            actual = ShapeValidator.getInstance().isTrapezoid(tetragon);
        }
        assertFalse(actual);
    }

    @Test
    public void isRectangleTestTrue() {
        boolean actual = false;
        for (Tetragon tetragon : tetragons) {
            actual = ShapeValidator.getInstance().isRectangle(tetragon);
        }
        assertTrue(actual);
    }

    @Test
    public void isRectangleTestFalse() {
        Point point1 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point2 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point3 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point4 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Tetragon tetragon = new Tetragon(IdGenerator.generateId(), point1, point2, point3, point4);
        boolean actual = ShapeValidator.getInstance().isTrapezoid(tetragon);
        assertFalse(actual);
    }

    @Test
    public void isRhombusTestTrue() {
        Point point1 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point2 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point3 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Point point4 = new Point(IdGenerator.generateId(), 1.5, 15.0);
        Tetragon tetragon = new Tetragon(IdGenerator.generateId(), point1, point2, point3, point4);
        boolean actual = ShapeValidator.getInstance().isRhombus(tetragon);
        assertTrue(actual);
    }

    @Test
    public void isRhombusTestFalse() {
        boolean actual = false;
        for (Tetragon tetragon : tetragons) {
            actual = ShapeValidator.getInstance().isRhombus(tetragon);
        }
        assertFalse(actual);
    }
}
