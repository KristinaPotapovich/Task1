package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;

public class IdMoreMinIdSpecification implements TetragonSpecification {
    private long minId;

    public IdMoreMinIdSpecification(long minId) {
        this.minId = minId;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getTetragonId() > minId;
    }
}
