package by.epam.shape.creator.impl;

import by.epam.shape.creator.ShapeFactory;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.generator.IdGenerator;

import java.util.List;

public class TetragonCreator implements ShapeFactory<Tetragon, Point> {

    public Tetragon create(List<Point> points) {
        return new Tetragon(IdGenerator.generateId(), points.get(0), points.get(1), points.get(2), points.get(3));
    }
}



