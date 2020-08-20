package by.epam.shape.entity;

public class Tetragon {
    private String name;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Tetragon(String name, Point pointA, Point pointB, Point pointC, Point pointD) {
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        if (name != null ? !name.equals(tetragon.name) : tetragon.name != null) return false;
        if (pointA != null ? !pointA.equals(tetragon.pointA) : tetragon.pointA != null) return false;
        if (pointB != null ? !pointB.equals(tetragon.pointB) : tetragon.pointB != null) return false;
        if (pointC != null ? !pointC.equals(tetragon.pointC) : tetragon.pointC != null) return false;
        return pointD != null ? pointD.equals(tetragon.pointD) : tetragon.pointD == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pointA != null ? pointA.hashCode() : 0);
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        result = 31 * result + (pointC != null ? pointC.hashCode() : 0);
        result = 31 * result + (pointD != null ? pointD.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tetragon{" +
                "name='" + name + '\'' +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }
}
