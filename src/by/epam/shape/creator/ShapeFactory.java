package by.epam.shape.creator;

import java.util.List;

public interface ShapeFactory<Z, T> {

    Z create(List<T> data);
}
