package by.epam.shape.comparator;

import by.epam.shape.entity.impl.Tetragon;

import java.util.Comparator;

public class TetragonComparatorByPointACoordX implements Comparator<Tetragon> {
    @Override
    public int compare(Tetragon tetragon1, Tetragon tetragon2) {
        return Double.compare(tetragon1.getPointA().getValueX(), tetragon2.getPointA().getValueX());
    }
}
