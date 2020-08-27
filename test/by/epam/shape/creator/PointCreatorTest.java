package by.epam.shape.creator;

import by.epam.shape.creator.impl.PointCreator;
import by.epam.shape.entity.impl.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PointCreatorTest {
    private PointCreator pointCreator;
    private List<Double> coordinates;
    private List<Point> expected;

    @BeforeTest
    public void init() {
        pointCreator = new PointCreator();
        coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(1.0);
        Point point1 = new Point(1, 2.0, 1.0);
        Point point2 = new Point(2, 2.0, 3.0);
        Point point3 = new Point(3, 7.0, 3.0);
        Point point4 = new Point(4, 7.0, 1.0);
        expected = new ArrayList<>();
        expected.add(0, point1);
        expected.add(1, point2);
        expected.add(2, point3);
        expected.add(3, point4);
    }

    @Test
    public void create() {

        List<Point> actual = pointCreator.create(coordinates);
        Assert.assertEquals(actual, expected, "Test was not successful");
    }
}
