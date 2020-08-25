package test.by.epam.shape.parsing;

import by.epam.shape.exception.ShapeException;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import by.epam.shape.validation.ShapeValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    @Test
    public void parseToDouble() throws ShapeException {
        DataParser dataParser = new DataParser();
        ShapeValidator shapeValidator = new ShapeValidator();
        DataReader dataReader = new DataReader();
        List<Double> expected = new ArrayList<>();
        expected.add(2.0);
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(3.0);
        expected.add(7.0);
        expected.add(1.0);
        List<String> coordinatesFromData = dataReader.readData("init/data.txt");
        List<Double> actual = dataParser.parseToDouble(shapeValidator.filterInputData(coordinatesFromData));
        Assert.assertEquals(actual, expected, "Test was not successful");
    }
}
