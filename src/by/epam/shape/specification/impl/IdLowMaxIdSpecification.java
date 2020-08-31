package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.TetragonSpecification;


public class IdLowMaxIdSpecification implements TetragonSpecification {
    private long maxId;

    public IdLowMaxIdSpecification(long maxId) {
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getTetragonId() < maxId;
    }


}
