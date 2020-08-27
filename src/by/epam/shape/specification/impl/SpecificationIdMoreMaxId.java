package by.epam.shape.specification.impl;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.specification.Specification;


public class SpecificationIdMoreMaxId implements Specification {
    private long maxId;

    public SpecificationIdMoreMaxId(long maxId) {
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Tetragon tetragon) {
        return tetragon.getTetragonId() > maxId;
    }


}
