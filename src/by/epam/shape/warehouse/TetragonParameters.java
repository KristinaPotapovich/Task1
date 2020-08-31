package by.epam.shape.warehouse;

public class TetragonParameters {
    private double perimeterOfTetragon;
    private double areaOfTetragon;

    public TetragonParameters(double perimeterOfTetragon, double areaOfTetragon) {
        this.perimeterOfTetragon = perimeterOfTetragon;
        this.areaOfTetragon = areaOfTetragon;
    }

    public double getPerimeterOfTetragon() {
        return perimeterOfTetragon;
    }

    public void setPerimeterOfTetragon(double perimeterOfTetragon) {
        this.perimeterOfTetragon = perimeterOfTetragon;
    }

    public double getAreaOfTetragon() {
        return areaOfTetragon;
    }

    public void setAreaOfTetragon(double areaOfTetragon) {
        this.areaOfTetragon = areaOfTetragon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TetragonParameters that = (TetragonParameters) o;

        if (Double.compare(that.perimeterOfTetragon, perimeterOfTetragon) != 0) return false;
        return Double.compare(that.areaOfTetragon, areaOfTetragon) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeterOfTetragon);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(areaOfTetragon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TetragonParametres{").append("perimeterOfTetragon=").append(perimeterOfTetragon).
                append(", areaOfTetragon=").append(areaOfTetragon).append('}').toString();
    }
}
