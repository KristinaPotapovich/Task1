package by.epam.shape.entity.impl;

import by.epam.shape.entity.Shape;


public class Tetragon implements Shape {
    private long tetragonId;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

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

    public void setTetragonId(long tetragonId) {
        this.tetragonId = tetragonId;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
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
}
