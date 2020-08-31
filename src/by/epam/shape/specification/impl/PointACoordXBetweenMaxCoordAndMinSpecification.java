package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;

public class PointACoordXBetweenMaxCoordAndMinSpecification implements TetragonSpecification {
    private double minPoint;
    private double maxPoint;

    public PointACoordXBetweenMaxCoordAndMinSpecification(double minPoint, double maxPoint) {
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getPointA().getValueX() < maxPoint && tetragon.getPointA().getValueX() > minPoint;
    }
}
