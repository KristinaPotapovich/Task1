package test.by.epam.shape.reader;


import by.epam.shape.exception.ShapeException;
import by.epam.shape.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {
    DataReader dataReader = new DataReader();

    @Test
    public void readDataTest() throws ShapeException {

        List<String> expected = new ArrayList<>();
        expected.add("2.0 1.0");
        expected.add("1a.0 2.0");
        expected.add("2.0 3.0");
        expected.add("3.0");
        expected.add("7.0 3.0");
        expected.add("7y.0");
        expected.add("7.0 1.0");
        List<String> actual = dataReader.readData("init/data.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void trowShapeException() throws ShapeException {
        dataReader.readData("/init/data.txt");
    }
}
