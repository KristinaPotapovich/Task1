package by.epam.shape.parsing;

import by.epam.shape.exception.ShapeException;
import by.epam.shape.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest extends Assert {
    private DataParser dataParser;
    private List<String> coordinatesFromData;


    @BeforeTest
    public void init() throws ShapeException {
        dataParser = new DataParser();
        DataReader dataReader = new DataReader();
        coordinatesFromData = dataReader.readData("init/data.txt");
    }

    @Test
    public void parseToDoubleTest() {
        List<Double> expected = new ArrayList<>();
        expected.add(2.0);
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(1.0);
        expected.add(3.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(4.0);
        expected.add(7.0);
        expected.add(4.0);
        expected.add(7.0);
        expected.add(2.0);
        List<Double> actual = dataParser.parseToDouble(coordinatesFromData);
        assertEquals(actual, expected);
    }

    @Test
    public void parseToDoubleNegativeTest() {
        List<Double> expected = new ArrayList<>();
        expected.add(2.0);
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(1.0);
        List<Double> actual = dataParser.parseToDouble(coordinatesFromData);
        assertNotEquals(actual, expected);
    }
}
