package by.epam.shape.creator.impl;

import by.epam.shape.creator.ShapeFactory;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class PointCreator implements ShapeFactory<List<Point>, Double> {

    public List<Point> create(List<Double> coordinates) {
        List<Point> points = new ArrayList<>();
        Point point;
        for (int i = 1; i < coordinates.size(); i += 2) {
            point = new Point(IdGenerator.generateId(), coordinates.get(i - 1), coordinates.get(i));
            points.add(point);
        }
        return points;
    }
}
