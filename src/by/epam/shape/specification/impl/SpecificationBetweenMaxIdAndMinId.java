package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;

public class SpecificationBetweenMaxIdAndMinId implements Specification {
    private long minId;
    private long maxId;

    public SpecificationBetweenMaxIdAndMinId(long minId, long maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return maxId >= tetragon.getTetragonId() && tetragon.getTetragonId() > minId;
    }
}
