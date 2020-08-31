package by.epam.shape.creator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.generator.IdGenerator;
import by.epam.shape.validation.ShapeValidator;

import java.util.ArrayList;
import java.util.List;

public class TetragonCreator {
    public List<Tetragon> create(List<Point> points) {
        List<Tetragon> tetragons = new ArrayList<>();
        int countPoint = 4;
        for (int i = 0; i < points.size(); i += countPoint) {
            Tetragon tetragon = new Tetragon(IdGenerator.generateId(), points.get(i), points.get(i + 1)
                    , points.get(i + 2), points.get(i + 3));
            if (ShapeValidator.getInstance().isTetragonValid(tetragon)) {
                tetragons.add(tetragon);
            }
        }
        return tetragons;
    }
}



