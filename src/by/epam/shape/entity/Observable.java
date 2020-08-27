package by.epam.shape.entity;

import by.epam.shape.exception.ShapeException;
import by.epam.shape.observer.Observer;

public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers() throws ShapeException;
}
