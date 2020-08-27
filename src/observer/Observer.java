package observer;

import by.epam.shape.entity.impl.Tetragon;
import by.epam.shape.exception.ShapeException;

public interface Observer {
    void actionPerformed(Tetragon tetragon) throws ShapeException;
}
