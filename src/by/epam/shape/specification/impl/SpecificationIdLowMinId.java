package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;

public class SpecificationIdLowMinId implements Specification {
    private long minId;

    public SpecificationIdLowMinId(long minId) {
        this.minId = minId;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getTetragonId() > minId;
    }
}
