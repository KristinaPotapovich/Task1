package by.epam.shape.creator;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Tetragon;
import by.epam.shape.generator.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class ShapeCreator {
    public List<Point> createPoint(List<Double> coordinates) {
        List<Point> points = new ArrayList<>();
        Point point;
        for (int i = 1; i < coordinates.size(); i += 2) {
            point = new Point(IdGenerator.generateId(), coordinates.get(i - 1), coordinates.get(i));
            points.add(point);
        }
        return points;
    }
    public Tetragon createTetragon(List<Point> points) {
        String nameOfTetragon = "Tetragon";
        return new Tetragon(nameOfTetragon, points.get(0), points.get(1), points.get(2), points.get(3));
    }
}



