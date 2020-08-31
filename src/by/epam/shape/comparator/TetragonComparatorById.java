package by.epam.shape.comparator;

import by.epam.shape.entity.impl.Tetragon;

import java.util.Comparator;

public class TetragonComparatorById implements Comparator<Tetragon> {

    @Override
    public int compare(Tetragon tetragon1, Tetragon tetragon2) {
        return Long.compare(tetragon1.getTetragonId(), tetragon2.getTetragonId());
    }
}
