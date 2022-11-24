package Homework.modelelements;

public class Vector3D {
    private Point3D point;

    public Point3D getPoint() {
        return point;
    }

    public void setPoint(Point3D point) {
        this.point = point;
    }

    public Vector3D(Point3D point) {
        this.point = point;
    }
}
