package observer.impl;


import by.epam.shape.action.ShapeOperation;
import by.epam.shape.entity.TetragonParameters;
import by.epam.shape.entity.Warehouse;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;


public class TetragonObserver implements Observer {
    @Override
    public void actionPerformed(Tetragon tetragon) throws ShapeException {
        Warehouse warehouse = Warehouse.getInstance();
        TetragonParameters tetragonParameters = warehouse.get(tetragon.getTetragonId());
        ShapeOperation shapeOperation = new ShapeOperation();
        List<Double> sides = shapeOperation.calculateSideOfTetragon(tetragon);
        tetragonParameters.setPerimeterOfTetragon(shapeOperation.calculatePerimeter(sides, buildCoordinates(tetragon)));
        tetragonParameters.setAreaOfTetragon(shapeOperation.calculateArea(sides, buildCoordinates(tetragon)));
        warehouse.put(tetragon.getTetragonId(), tetragonParameters);
    }

    private List<Double> buildCoordinates(Tetragon tetragon) {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(tetragon.getPointA().getValueX());
        coordinates.add(tetragon.getPointA().getValueY());
        coordinates.add(tetragon.getPointB().getValueX());
        coordinates.add(tetragon.getPointB().getValueY());
        coordinates.add(tetragon.getPointC().getValueX());
        coordinates.add(tetragon.getPointC().getValueY());
        coordinates.add(tetragon.getPointD().getValueX());
        coordinates.add(tetragon.getPointD().getValueY());
        return coordinates;
    }
}
