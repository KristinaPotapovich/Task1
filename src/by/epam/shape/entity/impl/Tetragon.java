package by.epam.shape.entity.impl;

import by.epam.shape.entity.Observable;
import by.epam.shape.observer.Observer;
import by.epam.shape.entity.Shape;
import by.epam.shape.exception.ShapeException;

import java.util.ArrayList;
import java.util.List;


public class Tetragon implements Shape, Observable {
    private long tetragonId;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    List<Observer> observers = new ArrayList<>();

    public Tetragon(long tetragonId, Point pointA, Point pointB, Point pointC, Point pointD) {
        this.tetragonId = tetragonId;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public long getTetragonId() {

        return tetragonId;
    }

    public void setTetragonId(long tetragonId) throws ShapeException {

        this.tetragonId = tetragonId;
        notifyObservers();
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) throws ShapeException {
        this.pointA = pointA;
        notifyObservers();
    }

    public Point getPointB() {

        return pointB;
    }

    public void setPointB(Point pointB) throws ShapeException {

        this.pointB = pointB;
        notifyObservers();
    }

    public Point getPointC() {

        return pointC;
    }

    public void setPointC(Point pointC) throws ShapeException {

        this.pointC = pointC;
        notifyObservers();
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) throws ShapeException {
        this.pointD = pointD;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tetragon tetragon = (Tetragon) o;

        if (tetragonId != tetragon.tetragonId) return false;
        if (pointA != null ? !pointA.equals(tetragon.pointA) : tetragon.pointA != null) return false;
        if (pointB != null ? !pointB.equals(tetragon.pointB) : tetragon.pointB != null) return false;
        if (pointC != null ? !pointC.equals(tetragon.pointC) : tetragon.pointC != null) return false;
        return pointD != null ? pointD.equals(tetragon.pointD) : tetragon.pointD == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (tetragonId ^ (tetragonId >>> 32));
        result = 31 * result + (pointA != null ? pointA.hashCode() : 0);
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        result = 31 * result + (pointC != null ? pointC.hashCode() : 0);
        result = 31 * result + (pointD != null ? pointD.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Tetragon{").append("id='").append(tetragonId).append('\'').append(", pointA=").
                append(pointA).append(", pointB=").append(pointB).append(", pointC=").
                append(pointC).append(", pointD=").append(pointD).append('}').toString();
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);

    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObservers() throws ShapeException {
        for (Observer observer : observers) {
            observer.actionPerformed(this);
        }

    }


}
