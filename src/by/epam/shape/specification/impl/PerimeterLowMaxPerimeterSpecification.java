package by.epam.shape.specification.impl;


import by.epam.shape.action.ShapeOperation;
import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;

public class PerimeterLowMaxPerimeterSpecification implements TetragonSpecification {
    private double maxPerimeter;

    public PerimeterLowMaxPerimeterSpecification(double maxPerimeter) {
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        ShapeOperation shapeOperation=new ShapeOperation();
        double perimeterOfTetragon = shapeOperation.calculatePerimeter(tetragon);
        return perimeterOfTetragon < maxPerimeter;
    }
}
