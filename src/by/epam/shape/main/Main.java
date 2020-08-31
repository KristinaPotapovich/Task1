package by.epam.shape.main;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.comparator.TetragonComparatorById;
import by.epam.shape.comparator.TetragonComparatorByPointACoordX;
import by.epam.shape.comparator.TetragonComparatorByPointACoordY;
import by.epam.shape.creator.PointCreator;
import by.epam.shape.creator.TetragonCreator;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import by.epam.shape.parsing.DataParser;
import by.epam.shape.reader.DataReader;
import by.epam.shape.repository.TetragonRepository;
import by.epam.shape.specification.impl.*;
import by.epam.shape.observer.Observer;
import by.epam.shape.observer.impl.TetragonObserver;
import by.epam.shape.warehouse.TetragonParameters;
import by.epam.shape.warehouse.Warehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapeException {
        DataReader dataReader = new DataReader();
        List<String> coordinatesFromData = dataReader.readData("init/data.txt");
        DataParser dataParser = new DataParser();
        List<Double> coordinates = dataParser.parseToDouble(coordinatesFromData);
        PointCreator pointCreator = new PointCreator();
        List<Point> points = pointCreator.create(coordinates);
        TetragonCreator tetragonCreator = new TetragonCreator();
        List<Tetragon> tetragons = tetragonCreator.create(points);
        ShapeOperation shapeOperation = new ShapeOperation();
        for (Tetragon tetragon : tetragons) {
            Observer observer = new TetragonObserver();
            tetragon.attach(observer);
            TetragonParameters tetragonParameters = new TetragonParameters((shapeOperation.calculatePerimeter(tetragon)),
                    shapeOperation.calculateArea(tetragon));
            Warehouse.getInstance().put(tetragon.getTetragonId(), tetragonParameters);
            TetragonRepository.getInstance().add(tetragon);
            TetragonComparatorById tetragonComparatorById = new TetragonComparatorById();
            TetragonComparatorByPointACoordY tetragonComparatorByPointACoordY = new TetragonComparatorByPointACoordY();
            TetragonComparatorByPointACoordX tetragonComparatorByPointACoordX = new TetragonComparatorByPointACoordX();
            TetragonRepository.getInstance().sort(tetragonComparatorByPointACoordX);
        }
        PointACoordXBetweenMaxCoordAndMinSpecification pointACoordXBetweenMaxCoordAndMinSpecification =
                new PointACoordXBetweenMaxCoordAndMinSpecification(2, 9);
        AreaLowMaxAreaSpecification areaLowMaxAreaSpecification = new AreaLowMaxAreaSpecification(10.0);
        IdBetweenMaxIdAndMinIdSpecification idBetweenMaxIdAndMinIdSpecification = new IdBetweenMaxIdAndMinIdSpecification(9, 10);
        IdLowMaxIdSpecification idLowMaxIdSpecification = new IdLowMaxIdSpecification(12);
        IdMoreMinIdSpecification idMoreMinIdSpecification = new IdMoreMinIdSpecification(9);
        PointCCoordYMoreMinCoordSpecification pointCCoordYMoreMinCoordSpecification = new PointCCoordYMoreMinCoordSpecification(10);
        PerimeterLowMaxPerimeterSpecification perimeterLowMaxPerimeterSpecification = new PerimeterLowMaxPerimeterSpecification(15);
    }
}

