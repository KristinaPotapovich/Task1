package by.epam.shape.creator.impl;

import by.epam.shape.creator.ShapeFactory;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class TetragonCreator implements ShapeFactory<List<Tetragon>, Point> {
    public List<Tetragon> create(List<Point> points) {
        int countPoint = 4;
        List<Tetragon> tetragons = new ArrayList<>();
        for (int i = 1; i < points.size(); i += countPoint) {
            tetragons.add(new Tetragon(IdGenerator.generateId(), points.get(i - 1), points.get(i),
                    points.get(i + 1), points.get(i + 2)));
        }
        return tetragons;
    }
}



