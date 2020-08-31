package by.epam.shape.creator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.impl.Tetragon;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetragonCreatorTest extends Assert {
    private TetragonCreator tetragonCreator;
    private List<Point> points;
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

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
        point1 = new Point(1, 2.0, 1.0);
        point2 = new Point(2, 2.0, 3.0);
        point3 = new Point(3, 7.0, 3.0);
        point4 = new Point(4, 2.0, 1.0);

    }

    @Test
    public void createTest() {
        List<Tetragon> expected = new ArrayList<>();
        expected.add(new Tetragon(5, point1, point2, point3, point4));
        List<Tetragon> actual = tetragonCreator.create(points);
        assertEquals(actual, expected);
    }

    @Test
    public void CreateNegativeTest() {
        point1 = new Point(1, -2.0, 1.0);
        point2 = new Point(2, 2.0, 3.0);
        point3 = new Point(3, 7.0, 3.0);
        point4 = new Point(4, 2.0, 1.0);
        List<Tetragon> expected = new ArrayList<>();
        expected.add(0, new Tetragon(5, point1, point2, point3, point4));
        List<Tetragon> actual = tetragonCreator.create(points);
        assertNotEquals(actual, expected);
    }
}
