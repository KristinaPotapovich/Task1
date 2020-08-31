package by.epam.shape.creator;

import by.epam.shape.entity.Point;
import by.epam.shape.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class PointCreator {

    public List<Point> create(List<Double> coordinates) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < coordinates.size(); i += 2) {
            Point point = new Point(IdGenerator.generateId(), coordinates.get(i - 1), coordinates.get(i));
            points.add(point);
        }
        return points;
    }
}
