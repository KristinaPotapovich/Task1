package by.epam.shape.creator;

import by.epam.shape.creator.impl.PointCreator;
import by.epam.shape.creator.impl.TetragonCreator;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetragonCreatorTest {
    private TetragonCreator tetragonCreator;
    private List<Point> points;
    List<Tetragon> expected;

    @BeforeTest
    public void init() {
        tetragonCreator = new TetragonCreator();
        PointCreator pointCreator = new PointCreator();
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(2.0);
        coordinates.add(1.0);
        coordinates.add(2.0);
        coordinates.add(3.0);
        coordinates.add(7.0);
        coordinates.add(3.0);
        coordinates.add(2.0);
        coordinates.add(1.0);
        points = pointCreator.create(coordinates);
        Point point1 = new Point(1, 2.0, 1.0);
        Point point2 = new Point(2, 2.0, 3.0);
        Point point3 = new Point(3, 7.0, 3.0);
        Point point4 = new Point(4, 2.0, 1.0);
        expected = new ArrayList<>();
        expected.add(0, new Tetragon(5, point1, point2, point3, point4));
    }

    @Test
    public void create() {
        List<Tetragon> actual = tetragonCreator.create(points);
        Assert.assertEquals(actual, expected);
    }
}
