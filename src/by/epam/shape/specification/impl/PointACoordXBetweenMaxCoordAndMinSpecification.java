package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;

public class PointACoordXBetweenMaxCoordAndMinSpecification implements Specification {
    private double minPoint;
    private double maxPoint;

    public PointACoordXBetweenMaxCoordAndMinSpecification(double minPoint, double maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        boolean result = tetragon.getPointA().getValueX() < maxPoint && tetragon.getPointA().getValueX() > minPoint;
        return result;
    }
}
