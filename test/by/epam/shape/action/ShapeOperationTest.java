package by.epam.shape.action;

import by.epam.shape.creator.PointCreator;
import by.epam.shape.creator.TetragonCreator;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeOperationTest extends Assert {

    private ShapeOperation shapeOperation;
    private List<Tetragon> tetragons;


    @BeforeTest
    public void init() throws ShapeException {
        TetragonCreator tetragonCreator = new TetragonCreator();
        PointCreator pointCreator = new PointCreator();
        DataParser dataParser = new DataParser();
        DataReader dataReader = new DataReader();
        tetragons = tetragonCreator.create(pointCreator.create(dataParser.parseToDouble
                (dataReader.readData("init/data.txt"))));
        shapeOperation = new ShapeOperation();
    }

    @Test
    public void calculateSideOfTetragonTest() {
        List<Double> expected = new ArrayList<>();
        expected.add(2.0);
        expected.add(4.0);
        expected.add(2.0);
        expected.add(4.0);
        List<Double> actual = new ArrayList<>();
        for (Tetragon tetragon : tetragons) {
            actual = ShapeOperation.calculateSidesOfTetragon(tetragon);
        }
        assertEquals(actual,expected);
    }

    @Test
    public void calculatePerimeterTest() {
        double expected = 12.0;
        double actual = 0;
        for (Tetragon tetragon : tetragons) {
            actual = shapeOperation.calculatePerimeter(tetragon);
        }
        assertEquals(actual,expected,0.0001);
    }

    @Test
    public void calculateAreaTest(){
        double expected = 8;
        double actual = 0;
        for (Tetragon tetragon : tetragons) {
            actual = shapeOperation.calculateArea(tetragon);
        }
        assertEquals(actual,expected,0.0001);
    }
}
