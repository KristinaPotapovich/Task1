package by.epam.shape.entity;


public class Point {
    private long pointId;
    private double valueX;
    private double valueY;


    public Point(long pointId, double valueX, double valueY) {
        this.pointId = pointId;
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public long getPointId() {
        return pointId;
    }

    public double getValueX() {
        return valueX;
    }

    public double getValueY() {
        return valueY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (pointId != point.pointId) return false;
        if (Double.compare(point.valueX, valueX) != 0) return false;
        return Double.compare(point.valueY, valueY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (pointId ^ (pointId >>> 32));
        temp = Double.doubleToLongBits(valueX);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valueY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Point{").append("pointId=").append(pointId).append(", valueX=").append(valueX).
                append(", valueY=").append(valueY).append('}').toString();
    }
}
