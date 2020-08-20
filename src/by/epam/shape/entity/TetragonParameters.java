package by.epam.shape.entity;

public class TetragonParameters {
    private double sideAB;
    private double sideBC;
    private double sideCD;
    private double sideDA;

    public TetragonParameters(double sideAB, double sideBC, double sideCD, double sideDA) {
        this.sideAB = sideAB;
        this.sideBC = sideBC;
        this.sideCD = sideCD;
        this.sideDA = sideDA;
    }

    public double getSideAB() {
        return sideAB;
    }

    public void setSideAB(double sideAB) {
        this.sideAB = sideAB;
    }

    public double getSideBC() {
        return sideBC;
    }

    public void setSideBC(double sideBC) {
        this.sideBC = sideBC;
    }

    public double getSideCD() {
        return sideCD;
    }

    public void setSideCD(double sideCD) {
        this.sideCD = sideCD;
    }

    public double getSideDA() {
        return sideDA;
    }

    public void setSideDA(double sideDA) {
        this.sideDA = sideDA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TetragonParameters that = (TetragonParameters) o;

        if (Double.compare(that.sideAB, sideAB) != 0) return false;
        if (Double.compare(that.sideBC, sideBC) != 0) return false;
        if (Double.compare(that.sideCD, sideCD) != 0) return false;
        return Double.compare(that.sideDA, sideDA) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideAB);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideBC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideCD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideDA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TetragonSides{" +
                "sideAB=" + sideAB +
                ", sideBC=" + sideBC +
                ", sideCD=" + sideCD +
                ", sideDA=" + sideDA +
                '}';
    }
}
