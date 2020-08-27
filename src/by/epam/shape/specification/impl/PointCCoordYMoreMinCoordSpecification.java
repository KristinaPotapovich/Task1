package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;

public class PointCCoordYMoreMinCoordSpecification implements Specification {
    private double min;

    public PointCCoordYMoreMinCoordSpecification(double min) {
        this.min = min;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getPointC().getValueY() > min;
    }
}
