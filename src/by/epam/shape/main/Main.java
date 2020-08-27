package by.epam.shape.main;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.creator.ShapeFactory;
import by.epam.shape.creator.impl.PointCreator;
import by.epam.shape.creator.impl.TetragonCreator;
import by.epam.shape.entity.*;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.generator.IdGenerator;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import by.epam.shape.repository.Repository;
import by.epam.shape.validation.ShapeValidator;
import by.epam.shape.observer.Observer;
import by.epam.shape.observer.impl.TetragonObserver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapeException {
        DataReader dataReader = new DataReader();
        List<String> coordinatesFromData = dataReader.readData("init/data.txt");
        ShapeValidator validator = new ShapeValidator();
        List<String> filterInputData = validator.filterInputData(coordinatesFromData);
        DataParser dataParser = new DataParser();
        List<Double> coordinates = dataParser.parseToDouble(filterInputData);
        ShapeFactory<List<Point>, Double> pointCreator = new PointCreator();
        List<Point> points = pointCreator.create(coordinates);
        validator.isThreePointsOnOneLine(coordinates);
        ShapeFactory<List<Tetragon>, Point> tetragonCreator = new TetragonCreator();
        List<Tetragon> tetragons = tetragonCreator.create(points);
        ShapeOperation shapeOperation = new ShapeOperation();
        List<Double> sides;
        for (Tetragon tetragon : tetragons) {
            Observer observer = new TetragonObserver();
            tetragon.attach(observer);
            sides = shapeOperation.calculateSideOfTetragon(tetragon);
            TetragonParameters tetragonParameters = new TetragonParameters((shapeOperation.calculatePerimeter(sides, coordinates)),
                    shapeOperation.calculateArea(sides, coordinates));
            Warehouse.getInstance().put(tetragon.getTetragonId(), tetragonParameters);
            Repository.getInstance().add(tetragon);
            Point point = new Point(IdGenerator.generateId(), 25, 35);
            tetragon.setPointA(point);
        }
    }
}

