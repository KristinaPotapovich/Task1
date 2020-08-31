package by.epam.shape.observer.impl;


import by.epam.shape.action.ShapeOperation;
import by.epam.shape.warehouse.TetragonParameters;
import by.epam.shape.warehouse.Warehouse;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.observer.Observer;


public class TetragonObserver implements Observer {
    @Override
    public void actionPerformed(Tetragon tetragon) {
        ShapeOperation shapeOperation = new ShapeOperation();
        Warehouse warehouse = Warehouse.getInstance();
        double perimeterOfTetragon = shapeOperation.calculatePerimeter(tetragon);
        double areaOfTetragon = shapeOperation.calculateArea(tetragon);
        TetragonParameters tetragonParameters = new TetragonParameters(perimeterOfTetragon, areaOfTetragon);
        warehouse.put(tetragon.getTetragonId(), tetragonParameters);
    }
}
