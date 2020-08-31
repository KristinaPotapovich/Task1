package by.epam.shape.specification.impl;

import by.epam.shape.action.ShapeOperation;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;

public class AreaLowMaxAreaSpecification implements TetragonSpecification {
    private double maxArea;

    public AreaLowMaxAreaSpecification(double maxArea) {
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        ShapeOperation shapeOperation = new ShapeOperation();
        double areaOfTetragon = shapeOperation.calculateArea(tetragon);
        return areaOfTetragon < maxArea;
    }
}
