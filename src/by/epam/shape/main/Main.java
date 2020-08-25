package by.epam.shape.main;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.creator.ShapeFactory;
import by.epam.shape.creator.impl.PointCreator;
import by.epam.shape.creator.impl.TetragonCreator;
import by.epam.shape.entity.impl.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import by.epam.shape.validation.ShapeValidator;

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
        ShapeFactory<Tetragon, Point> tetragonCreator = new TetragonCreator();
        Tetragon tetragon = tetragonCreator.create(points);
        ShapeOperation shapeOperation = new ShapeOperation();
        List<Double> sides = shapeOperation.findSideOfTetragon(tetragon);
        shapeOperation.calculateArea(sides, coordinates);
        shapeOperation.calculatePerimeter(sides, coordinates);
    }
}

